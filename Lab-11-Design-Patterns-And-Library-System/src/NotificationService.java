import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<Observer> users = new ArrayList<>();

    public void addUser(Observer user) {
        users.add(user);
    }

    public void notifyUsers(String message) {
        for (Observer user : users) {
            user.update(message);
        }
    }
}