public class Temperature {
    private final double kelvin;                     // internal representation

    private Temperature(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Below absolute zero");
        }
        this.kelvin = kelvin;
    }

    public static Temperature fromKelvin(double k)     { return new Temperature(k); }
    public static Temperature fromCelsius(double c)    { return new Temperature(c + 273.15); }
    public static Temperature fromFahrenheit(double f) { return new Temperature((f - 32) * 5 / 9 + 273.15); }

    public double getKelvin()     { return kelvin; }
    public double getCelsius()    { return kelvin - 273.15; }
    public double getFahrenheit() { return getCelsius() * 9 / 5 + 32; }

    public static void main(String[] args) {
        Temperature t = Temperature.fromCelsius(25);
        System.out.printf("%.2f C = %.2f F = %.2f K%n",
                t.getCelsius(), t.getFahrenheit(), t.getKelvin());

        try {
            Temperature.fromCelsius(-300);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}