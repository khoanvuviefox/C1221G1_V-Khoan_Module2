package ss12_java_collection_framework.baitap.product_java_collection_frameword;

import java.util.Comparator;

public class PriceSortDESC implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o2.getPrice() - o1.getPrice());
    }
}
