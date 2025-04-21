package collection.array;

import java.util.Arrays;

public class MyArrayListV2 {

    // 기본 배열 크기 설정 (초기 용량)
    private static final int DEFAULT_CAPACITY = 5;

    // 내부적으로 데이터를 저장하는 Object 배열
    private Object[] elementData;

    // 현재 리스트에 저장된 요소 개수 (배열 크기와 다름)
    private int size = 0;

    // 기본 생성자: 기본 용량 크기로 배열 생성
    public MyArrayListV2() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    // 초기 용량을 지정하는 생성자
    public MyArrayListV2(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    // 현재 리스트에 저장된 요소 개수 반환
    public int size() {
        return size;
    }

    // 리스트 끝에 새로운 요소 추가
    public void add(Object e) {
        // 배열이 꽉 찼으면 용량 확장
        if (size == elementData.length) {
            grow();
        }
        // 요소 추가 후 size 증가
        elementData[size] = e;
        size++;
    }

    // 내부 배열 용량을 2배로 확장하는 메서드
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        // 기존 배열을 복사하면서 크기 확장
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    // 지정한 인덱스의 요소 반환 (범위 체크는 생략됨)
    public Object get(int index) {
        return elementData[index];
    }

    // 지정한 인덱스의 요소를 새 값으로 교체하고, 기존 값을 반환
    public Object set(int index, Object element) {
        Object oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    // 리스트에서 특정 객체가 처음 나타나는 인덱스 반환, 없으면 -1 반환
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            // equals() 메서드로 객체 비교
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    // 리스트 내용을 문자열로 표현 (실제 저장된 요소까지만 출력, 용량과 크기 정보 포함)
    @Override
    public String toString() {
        // size까지만 배열 복사해서 출력 (불필요한 null 제외)
        return Arrays.toString(Arrays.copyOf(elementData, size))
                + " size=" + size + ", capacity=" + elementData.length;
    }
}
