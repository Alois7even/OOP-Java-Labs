interface Payment { double amount(); }
record CardPayment(double amount, String cardNo) implements Payment {}
record MobileMoneyPayment(double amount, String phone) implements Payment {}

class PaymentProcessorA {
    void pay(Payment p) {
        if (p instanceof CardPayment c) {
            System.out.println("Charging card " + c.cardNo() + ": " + c.amount());
        } else if (p instanceof MobileMoneyPayment m) {
            System.out.println("Mobile money from " + m.phone() + ": " + m.amount());
        } else {
            throw new IllegalArgumentException("Unsupported payment type");
        }
    }
}

public class PaymentA {
    public static void main(String[] args) {
        PaymentProcessorA proc = new PaymentProcessorA();
        proc.pay(new CardPayment(100, "1234"));
        proc.pay(new MobileMoneyPayment(40, "0771234567"));
    }
}