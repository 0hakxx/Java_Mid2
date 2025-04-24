package collection.iterable;

import java.util.Iterator; // Iterator 인터페이스 import

// MyArray 클래스는 Integer 타입의 Iterable 인터페이스를 구현
//implements Iterable<Integer>를 사용하는 핵심 이유는 해당 클래스가 iterator() 메서드를 반드시 구현하도록 강제하고,
// 이를 통해 Iterator 객체를 반환할 수 있게 하기 위함
public class MyArray implements Iterable<Integer> {

    private int[] numbers; // 내부에서 관리할 int 배열

    // 생성자: 외부에서 int 배열을 받아서 내부 변수에 저장
    public MyArray(int[] numbers) {
        this.numbers = numbers;
    }

    // Iterable 인터페이스의 iterator() 메서드 구현
    // MyArrayIterator 객체를 생성하여 반환함
    @Override
    public Iterator<Integer> iterator() {
        // MyArrayIterator에 numbers 배열을 넘겨주어
        // 해당 배열을 순회할 수 있는 Iterator를 반환
        return new MyArrayIterator(numbers);
    }

    /*
     * [그림으로 표현]
     *
     * MyArray
     * ┌────────────────────────────┐
     * │ int[] numbers              │
     * │                            │
     * │ + iterator()               │─────▶ MyArrayIterator
     * └────────────────────────────┘           ▲
     *                                          │
     *                             (numbers 배열을 넘겨줌)
     */
}
