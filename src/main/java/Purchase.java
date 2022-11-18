import java.util.HashMap;
import java.util.Map;

public class Purchase {
    private HashMap<String, Integer> prices;
    private HashMap<String, Integer> purchases; //item, count

    public Purchase(HashMap<String, Integer> prices) {
        this.prices = prices;
        purchases = new HashMap<>();
        prices.forEach((itemName, price) -> purchases.put(itemName, 0));
    }

    public void addPurchase(String title, int count) {
        if (!purchases.containsKey(title) || !prices.containsKey(title)) {
            System.out.println("Нет такого товара");
            return;
        }
        purchases.put(title, purchases.get(title) + count);
    }

    public void printPurchases() {
        System.out.println("КОРЗИНА:");
        for (Map.Entry<String, Integer> purchase : purchases.entrySet()) {
            if (purchase.getValue() == 0) continue;
            long itemSum = (long) purchase.getValue() * prices.get(purchase.getKey());
            System.out.println("\t" + purchase.getKey() + " " + purchase.getValue() + " шт. в сумме "
                    + itemSum + " руб.");
        }
    }

    public long sum() {
        long sum = 0;
        for (Map.Entry<String, Integer> purchase : purchases.entrySet()) {
            if (purchase.getValue() == 0) continue;
            sum += (long) purchase.getValue() * prices.get(purchase.getKey());
        }
        return sum;
    }
}