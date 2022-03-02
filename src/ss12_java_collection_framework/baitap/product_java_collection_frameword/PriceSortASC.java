package ss12_java_collection_framework.baitap.product_java_collection_frameword;

import java.util.Comparator;

public class PriceSortASC implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}
