public class AppConfig {

    private static AppConfig instance;

    private AppConfig() {
        System.out.println("Configuration created.");
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }

        return instance;
    }

    public void showMessage() {
        System.out.println("Application is running.");
    }
}