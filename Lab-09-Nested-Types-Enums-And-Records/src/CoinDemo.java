enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    private final int cents;
    Coin(int cents) { this.cents = cents; }
    int cents() { return cents; }

    // Greedy: take as many of the largest coin as possible, then move down
    static void change(int amount) {
        Coin[] coins = values();
        int remaining = amount;
        int totalCoins = 0;
        for (int i = coins.length - 1; i >= 0; i--) {   // largest first
            int count = remaining / coins[i].cents;
            if (count > 0) {
                System.out.println(count + " x " + coins[i]);
                totalCoins += count;
                remaining %= coins[i].cents;
            }
        }
        System.out.println("Total coins for " + amount + "c: " + totalCoins);
    }
}

public class CoinDemo {
    public static void main(String[] args) {
        Coin.change(68);
    }
}