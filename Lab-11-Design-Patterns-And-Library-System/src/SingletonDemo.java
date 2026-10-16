public class SingletonDemo {
    public static void main(String[] args) {

        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        config1.showMessage();

        if (config1 == config2) {
            System.out.println("Both variables refer to the same object.");
        }
    }
}