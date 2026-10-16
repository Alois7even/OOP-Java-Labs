
abstract class Account {
    private final String owner;
    private double balance;

    Account(String owner, double openingBalance) {
        this.owner = owner;
        this.balance = openingBalance;
    }

    void deposit(double amount) {                      // concrete: same for every account
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    abstract double monthlyFee();                      // each account type decides

    void applyMonthlyFee() { balance -= monthlyFee(); }

    String getOwner()   { return owner; }
    double getBalance() { return balance; }
}

class SavingsAccount extends Account {
    SavingsAccount(String owner, double opening) { super(owner, opening); }
    @Override double monthlyFee() { return 0.00; }
}

class CurrentAccount extends Account {
    CurrentAccount(String owner, double opening) { super(owner, opening); }
    @Override double monthlyFee() { return 5.00; }
}

public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = {
                new SavingsAccount("Tariro", 1000),
                new CurrentAccount("Farai", 500)
        };

        for (Account a : accounts) {
            a.deposit(100);
            a.applyMonthlyFee();
            System.out.printf("%-8s %-15s fee %.2f -> balance %.2f%n",
                    a.getOwner(), a.getClass().getSimpleName(), a.monthlyFee(), a.getBalance());
        }
    }
}