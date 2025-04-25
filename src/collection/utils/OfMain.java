package collection.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfMain {

    public static void main(String[] args) {
        // Java 9부터 제공되는 List.of(), Set.of(), Map.of()를 사용하여
        // 불변(immutable) 컬렉션을 간편하게 생성할 수 있다.

        // 불변 리스트 생성 (수정 불가)
        List<Integer> list = List.of(1, 2, 3);

        // 불변 집합(Set) 생성 (수정 불가, 중복 불가)
        Set<Integer> set = Set.of(1, 2, 3);

        // 불변 맵(Map) 생성 (수정 불가, 키 중복 불가)
        Map<Integer, String> map = Map.of(1, "one", 2, "two");

        // 각 컬렉션의 내용 출력
        System.out.println("list = " + list);
        System.out.println("set = " + set);
        System.out.println("map = " + map);

        // list 객체의 실제 클래스 이름 출력 (내부적으로 어떤 구현체인지 확인 가능)
        System.out.println("list class = " + list.getClass());

        // 아래 코드의 주석을 해제하면 UnsupportedOperationException 예외가 발생한다.
        // 불변 컬렉션이기 때문에 요소를 추가, 삭제, 변경할 수 없다.
        // list.add(4);
    }
}
