package collection.map.test.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    // Product를 key, 수량을 value로 저장하는 장바구니 Map
    // Product를 key로 사용하려면 반드시 hashCode()와 equals()를 재정의해야 한다.
    // 그래야 동일한 상품(Product)이 key로서 정상적으로 비교 및 검색된다.
    private Map<Product, Integer> cartMap = new HashMap<>();

    /**
     * 장바구니에 상품을 추가하는 메서드
     * @param product 추가할 상품
     * @param addQuantity 추가할 수량
     */
    public void add(Product product, int addQuantity) {
        // 이미 담겨있는 상품이면 기존 수량을 가져오고, 없으면 0을 반환
        int existingQuantity = cartMap.getOrDefault(product, 0);
        // 상품의 기존 수량에 추가 수량을 더해 저장
        cartMap.put(product, existingQuantity + addQuantity);
    }

    /**
     * 장바구니에서 상품 수량을 감소시키는 메서드
     * @param product 감소시킬 상품
     * @param minusQuantity 감소시킬 수량
     */
    public void minus(Product product, int minusQuantity) {
        // 기존 수량을 가져오고, 없으면 0을 반환
        int existingQuantity = cartMap.getOrDefault(product, 0);
        int newQuantity = existingQuantity - minusQuantity;
        if (newQuantity <= 0) {
            // 수량이 0 이하가 되면 장바구니에서 해당 상품 제거
            cartMap.remove(product);
        } else {
            // 수량을 갱신하여 저장
            cartMap.put(product, newQuantity);
        }
    }

    /**
     * 장바구니에 담긴 모든 상품과 수량을 출력하는 메서드
     */
    public void printAll() {
        System.out.println("==모든 상품 출력==");
        for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
            // entry.getKey()는 상품(Product), entry.getValue()는 수량(Integer)
            System.out.println("상품: " + entry.getKey() + " 수량: " + entry.getValue());
        }
    }
}

/*
 * [중요]
 * Product를 HashMap의 key로 사용할 때는 반드시 hashCode()와 equals()를 재정의해야 한다.
 * - 그렇지 않으면, 같은 상품이라도 서로 다른 객체로 인식되어 중복 저장/검색 오류가 발생할 수 있다.
 * - 예시:
 *   class Product {
 *       private String name;
 *       private int price;
 *       // 반드시 hashCode(), equals() 재정의!
 *   }
 */
