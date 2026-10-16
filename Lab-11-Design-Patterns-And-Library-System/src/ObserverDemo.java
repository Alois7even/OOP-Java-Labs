public class ObserverDemo {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        User user1 = new User("Alois");
        User user2 = new User("Miles");

        service.addUser(user1);
        service.addUser(user2);

        service.notifyUsers("A new book is available!");
    }
}