package collection.map.test.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    Map<Product, Integer> ProductMap = new HashMap<Product, Integer>();

    public void add(Product product, int addQuantity) {
        ProductMap.put(product, addQuantity);
    }

    public void printAll(){
        for (Product product : ProductMap.keySet()) {
            System.out.println(product);
        }
    }

    public void minus(Product product, int minQuantity) {
        ProductMap.remove(product);
    }
}
