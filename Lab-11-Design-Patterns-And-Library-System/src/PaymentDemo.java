public class PaymentDemo {
    public static void main(String[] args) {
        PaymentStrategy payment;

        payment = new CashPayment();
        payment.pay(50);

        payment = new CardPayment();
        payment.pay(100);
    }
}