package collection.array;

import java.util.Arrays;

public class MyArrayListV1 {
    // 기본 배열 용량 설정
    private static final int DEFAULT_CAPACITY = 5;
    // 요소를 저장할 Object 배열 선언
    private Object[] elementData;
    // 현재 저장된 요소의 개수
    private int size = 0;

    // 기본 생성자: 기본 용량으로 배열 초기화
    public MyArrayListV1() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    // 사용자 지정 용량으로 배열 초기화하는 생성자
    public MyArrayListV1(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    // 현재 저장된 요소의 개수 반환
    public int size() {
        return size;
    }
    private void shiftRightFrom(int index){
        for(int i = size; i > index; i--){
            elementData[i] = elementData[i - 1];
        }

    }

    // 배열에 새로운 요소 추가
    public void add(int index, Object e) {
        if(size == elementData.length) {
            grow();
        }
        shiftRightFrom(index);
        elementData[size] = e;
        size++;
    }

    public void grow(){
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
    // 지정된 인덱스의 요소 반환
    public Object get(int index) {
        return elementData[index];
    }

    // 지정된 인덱스의 요소를 새로운 요소로 교체하고 이전 요소 반환
    public Object set(int index, Object element) {
        Object oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    // 주어진 객체와 동일한 요소의 인덱스 반환, 없으면 -1 반환
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    // 배열의 현재 상태를 문자열로 반환
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" +
                size + ", capacity=" + elementData.length;
    }
}