package collection.set.javaset;

import java.util.*;

public class JavaSetMain {

    public static void main(String[] args) {
        // 다양한 Set 구현체를 사용하여 run 메서드를 호출합니다.
        run(new HashSet<>());        // HashSet은 순서를 보장하지 않습니다.
        run(new LinkedHashSet<>());  // LinkedHashSet은 입력 순서를 보장합니다.
        run(new TreeSet<>());       // TreeSet은 값의 크기 순서를 보장합니다.
    }

    /**
     * Set 인터페이스를 구현한 객체를 받아 문자열을 추가하고 출력하는 메서드입니다.
     * @param set 문자열을 저장할 Set 객체
     */
    private static void run(Set<String> set) {
        // Set의 클래스 이름을 출력합니다.
        // 이를 통해 어떤 Set 구현체가 사용되고 있는지 확인할 수 있습니다.
        System.out.println("set = " + set.getClass());

        set.add("C");
        set.add("B");
        set.add("A");
        set.add("1");
        set.add("2");

        // Set의 내용을 출력합니다.
        // Iterator를 사용하여 Set의 모든 요소를 순회합니다.
        Iterator<String> iterator = set.iterator();
        // iterator(): Set에 저장된 요소들을 순회하기 위한 Iterator 객체를 반환합니다.

        // iterator.hasNext(): Iterator가 순회할 다음 요소가 있는지 확인합니다.
        while (iterator.hasNext()) {
            // iterator.next(): Iterator의 다음 요소를 반환합니다.
            System.out.print(iterator.next() + " ");
            // iterator.next(): Set에서 다음 요소를 가져옵니다.
            // System.out.print(iterator.next() + " "): 가져온 요소를 콘솔에 출력하고 공백을 추가합니다.
        }
        System.out.println();
    }
}
