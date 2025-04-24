package collection.iterable;

import java.util.Iterator;

//흐름 설명
//MyArray 객체를 생성하며, 내부적으로 {1, 2, 3, 4} 배열을 저장한다.
//iterator() 메서드를 직접 호출하여 MyArrayIterator를 얻는다.while (iterator.hasNext()) 반복문을 통해 배열의 모든 요소를 순회하며 출력한다.
//for (int value : myArray) 구문을 통해 for-each 문으로도 같은 배열을 순회하며 출력(이때 내부적으로 iterator()가 자동 호출됨)

//전체 흐름 요약
//MyArray는 int 배열을 보관하고, Iterable을 구현하여 순회가 가능하도록 정의하였다.
//MyArrayIterator는 실제로 배열을 순회하는 Iterator 역할을 하게 만들었다.
//MyArrayMain에서 Iterator를 직접 사용하거나, for-each문을 통해 MyArray의 모든 요소를 출력할 수 있다.

/*
 * [전체 흐름 그림]
 *
 * main()
 *   │
 *   ├─ MyArray myArray = new MyArray([1,2,3,4])
 *   │
 *   ├─ iterator = myArray.iterator()
 *   │         │
 *   │         └─ MyArrayIterator([1,2,3,4]) 생성
 *   │
 *   ├─ while(iterator.hasNext()) {
 *   │       value = iterator.next();
 *   │       print(value)
 *   │   }
 *   │
 *   └─ for(int value : myArray) {
 *           print(value)
 *       }
 */

public class MyArrayMain {

    public static void main(String[] args) {
        // MyArray 객체 생성, 내부 배열로 {1, 2, 3, 4}를 전달
        MyArray myArray = new MyArray(new int[]{1, 2, 3, 4});

        // MyArray에서 직접 Iterator<Integer>를 얻어옴
        Iterator<Integer> iterator = myArray.iterator();
        System.out.println("iterator 사용");

        // Iterator를 사용하여 배열의 모든 값을 순회
        while (iterator.hasNext()) { // 다음 요소가 있으면 반복
            Integer value = iterator.next(); // 다음 요소를 꺼냄
            System.out.println("value = " + value); // 요소 출력
        }

        // 추가: for-each문을 사용하여 배열의 모든 값을 순회
        System.out.println("for-each 사용");
        for (int value : myArray) { // Iterable 인터페이스 구현 덕분에 for-each 사용 가능
            System.out.println("value = " + value); // 요소 출력
        }
    }

}
