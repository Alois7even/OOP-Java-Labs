public class Temperature {
    private final double celsius;

    private Temperature(double celsius) {          // private: callers must use the factories
        this.celsius = celsius;
    }

    public static Temperature fromCelsius(double c) {
        return new Temperature(c);
    }

    public static Temperature fromFahrenheit(double f) {
        return new Temperature((f - 32) * 5 / 9);
    }

    public double getCelsius()    { return celsius; }
    public double getFahrenheit() { return celsius * 9 / 5 + 32; }

    public static void main(String[] args) {
        Temperature t1 = Temperature.fromCelsius(100);
        Temperature t2 = Temperature.fromFahrenheit(32);
        System.out.println(t1.getCelsius() + " C = " + t1.getFahrenheit() + " F");
        System.out.println(t2.getFahrenheit() + " F = " + t2.getCelsius() + " C");
    }
}