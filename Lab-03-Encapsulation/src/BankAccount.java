import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        setOwnerName(ownerName);
        this.balance = openingBalance;
        history.add(String.format("OPEN %.2f", openingBalance));
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName()     { return ownerName; }
    public double getBalance()       { return balance; }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        this.ownerName = ownerName.trim();
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
        history.add(String.format("DEPOSIT %.2f", amount));
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) return false;          // failed attempts are not recorded
        balance -= amount;
        history.add(String.format("WITHDRAW %.2f", amount));
        return true;
    }

    // Unmodifiable COPY: a snapshot the caller cannot change, and that later
    // transactions do not alter
    public List<String> getHistory() {
        return List.copyOf(history);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500);
        acc.deposit(250);
        acc.withdraw(100);
        acc.withdraw(5000);                           // fails, so not in history

        List<String> snapshot = acc.getHistory();
        System.out.println(snapshot);

        acc.deposit(50);
        System.out.println("Snapshot size: " + snapshot.size());
        System.out.println("Live history size: " + acc.getHistory().size());

        try {
            snapshot.add("HACK +1000000");
        } catch (UnsupportedOperationException e) {
            System.out.println("History is read-only");
        }
    }
}