package collection.array;

import java.util.Arrays;

// MyArrayListV1: 간단한 ArrayList 구현체
public class MyArrayListV1 {

    // 기본 용량(초기 배열 크기) 상수
    private static final int DEFAULT_CAPACITY = 5;

    // 실제 데이터를 저장하는 배열
    private Object[] elementData;
    // 현재 저장된 요소의 개수
    private int size = 0;

    // 기본 생성자: 기본 용량으로 배열 생성
    public MyArrayListV1() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    // 용량을 지정할 수 있는 생성자
    public MyArrayListV1(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    // 현재 저장된 요소의 개수 반환
    public int size() {
        return size;
    }

    // 요소 추가 메서드 (용량 초과 시 확장 로직이 없음에 주의)
    public void add(Object e) {
        elementData[size] = e; // 배열의 마지막에 요소 추가
        size++; // 요소 개수 증가
    }

    // 지정한 인덱스의 요소 반환
    public Object get(int index) {
        return elementData[index];
    }

    // 지정한 인덱스의 값을 새 값으로 바꾸고, 기존 값을 반환
    public Object set(int index, Object element) {
        Object oldValue = get(index); // 기존 값 저장
        elementData[index] = element; // 새 값으로 교체
        return oldValue; // 기존 값 반환
    }

    // 지정한 객체가 저장된 첫 번째 인덱스 반환 (없으면 -1)
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) { // equals로 비교
                return i; // 찾으면 인덱스 반환
            }
        }
        return -1; // 못 찾으면 -1
    }

    // 현재 저장된 요소들을 문자열로 반환 (디버깅용)
    @Override
    public String toString() {
        // 저장된 요소만 복사해서 출력, size와 전체 capacity도 함께 표시
        return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" + size + ", capacity=" + elementData.length;
    }

}
