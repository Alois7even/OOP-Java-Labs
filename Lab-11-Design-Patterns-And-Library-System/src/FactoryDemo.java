public class FactoryDemo {
    public static void main(String[] args) {

        Notification n1 =
                NotificationFactory.createNotification("email");

        Notification n2 =
                NotificationFactory.createNotification("sms");

        n1.send();
        n2.send();
    }
}