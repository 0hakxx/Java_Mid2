package collection.iterable;

import java.util.*;

public class JavaIterableMain {

    public static void main(String[] args) {
        // 1. List 생성 및 요소 추가
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // 2. Set 생성 및 요소 추가 (중복 허용 X, 순서 보장 X)
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println("== Iterator 직접 사용 ==");
        printAll(list.iterator()); // List의 Iterator 전달
        printAll(set.iterator());  // Set의 Iterator 전달

        // 4. Iterable을 사용하는 foreach() 메서드 호출
        System.out.println("== Iterable 사용(for-each) ==");
        foreach(list); // List는 Iterable 구현체이므로 전달 가능
        foreach(set);  // Set도 Iterable 구현체이므로 전달 가능
    }

    private static void printAll(Iterator<Integer> iterator) {
        System.out.println("iterator 클래스 타입: " + iterator.getClass().getSimpleName());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-------------------");
    }


    private static void foreach(Iterable<Integer> iterable) {
        System.out.println("iterable 클래스 타입: " + iterable.getClass().getSimpleName());
        for (Integer i : iterable) { // 내부적으로 iterator() 호출
            System.out.println(i);
        }
        System.out.println("-------------------");
    }
}
