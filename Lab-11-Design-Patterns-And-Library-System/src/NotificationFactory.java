public class NotificationFactory {

    public static Notification createNotification(String type) {

        if (type.equalsIgnoreCase("email")) {
            return new EmailNotification();
        }

        if (type.equalsIgnoreCase("sms")) {
            return new SMSNotification();
        }

        throw new IllegalArgumentException("Unknown notification type.");
    }
}