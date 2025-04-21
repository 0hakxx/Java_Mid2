package collection.array;

import java.util.Arrays;

/**
 * MyArrayListV3
 * - Object 배열을 이용한 ArrayList 직접 구현체
 * - 동적 배열 구조, 크기 자동 확장 지원
 */
public class MyArrayListV3 {

    // 배열의 기본 용량(초기 크기)
    private static final int DEFAULT_CAPACITY = 5;

    // 실제 데이터를 저장하는 배열
    private Object[] elementData;
    // 현재 저장된 요소의 개수
    private int size = 0;

    /**
     * 기본 생성자 - 기본 용량으로 배열 생성
     */
    public MyArrayListV3() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 초기 용량을 지정할 수 있는 생성자
     * @param initialCapacity 배열의 초기 크기
     */
    public MyArrayListV3(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    /**
     * 현재 저장된 요소의 개수 반환
     */
    public int size() {
        return size;
    }

    /**
     * 배열의 끝에 요소 추가
     * @param e 추가할 요소
     */
    public void add(Object e) {
        // 배열이 가득 찼으면 크기 2배로 확장
        if (size == elementData.length) {
            grow();
        }
        // 마지막 위치에 요소 추가
        elementData[size] = e;
        size++;
    }

    /**
     * 지정한 인덱스에 요소 추가
     * @param index 추가할 위치
     * @param e 추가할 요소
     */
    public void add(int index, Object e) {
        // 배열이 가득 찼으면 크기 2배로 확장
        if (size == elementData.length) {
            grow();
        }
        // index부터 오른쪽으로 한 칸씩 이동(비우기)
        shiftRightFrom(index);
        // index 위치에 새 요소 삽입
        elementData[index] = e;
        size++;
    }

    /**
     * 배열의 크기를 2배로 늘리는 내부 메서드
     */
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        // 기존 배열을 새 크기로 복사
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * index 위치부터 마지막 요소까지 오른쪽으로 한 칸씩 이동
     * (add(index, e)에서 사용)
     * @param index 이동 시작 위치
     */
    private void shiftRightFrom(int index) {
        // 뒤에서부터 한 칸씩 오른쪽으로 밀기
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    /**
     * 지정한 인덱스의 요소 반환
     * @param index 조회할 위치
     * @return 해당 위치의 요소
     */
    public Object get(int index) {
        return elementData[index];
    }

    /**
     * 지정한 인덱스의 요소를 새로운 값으로 변경
     * @param index 변경할 위치
     * @param element 새 값
     * @return 변경 전의 값
     */
    public Object set(int index, Object element) {
        Object oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    /**
     * 지정한 인덱스의 요소를 삭제
     * @param index 삭제할 위치
     * @return 삭제된 값
     */
    public Object remove(int index) {
        // 삭제할 값 저장
        Object oldValue = get(index);
        // index부터 왼쪽으로 한 칸씩 당김
        shiftLeftFrom(index);
        // 마지막 요소 null로 처리(메모리 누수 방지)
        size--;
        elementData[size] = null;
        return oldValue;
    }

    /**
     * index 위치부터 마지막까지 왼쪽으로 한 칸씩 이동
     * (remove(index)에서 사용)
     * @param index 이동 시작 위치
     */
    private void shiftLeftFrom(int index) {
        // 앞에서부터 한 칸씩 왼쪽으로 당기기
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
    }

    /**
     * 지정한 객체가 처음 등장하는 인덱스 반환
     * @param o 찾을 객체
     * @return 인덱스(없으면 -1)
     */
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 현재 배열의 상태를 문자열로 반환
     * (저장된 요소, size, capacity)
     */
    @Override
    public String toString() {
        // 실제 저장된 요소만 복사해서 출력
        return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" + size + ", capacity=" + elementData.length;
    }
}
