package collection.array;

import java.util.Arrays;

/**
 * MyArrayListV4는 Java의 ArrayList와 유사한 기능을 제공하는
 * 제네릭 동적 배열 클래스입니다.
 *
 * @param <E> 저장할 요소의 타입
 */
public class MyArrayListV4<E> {

    // 배열의 기본 용량(초기 크기)
    private static final int DEFAULT_CAPACITY = 5;

    // 요소들을 저장할 Object 배열
    private Object[] elementData;
    // 현재 저장된 요소의 개수
    private int size = 0;

    /**
     * 기본 생성자: 기본 용량으로 배열을 초기화합니다.
     */
    public MyArrayListV4() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 초기 용량을 지정할 수 있는 생성자
     * @param initialCapacity 배열의 초기 크기
     */
    public MyArrayListV4(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    /**
     * 현재 저장된 요소의 개수를 반환합니다.
     * @return 요소 개수
     */
    public int size() {
        return size;
    }

    /**
     * 리스트의 끝에 요소를 추가합니다.
     * @param e 추가할 요소
     */
    public void add(E e) {
        // 배열이 가득 찼으면 용량을 늘림
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = e; // 마지막에 요소 추가
        size++;
    }

    /**
     * 지정한 위치에 요소를 삽입합니다.
     * @param index 삽입할 위치 (0부터 시작)
     * @param e     삽입할 요소
     */
    public void add(int index, E e) {
        // 배열이 가득 찼으면 용량을 늘림
        if (size == elementData.length) {
            grow();
        }
        // index 위치부터 오른쪽으로 요소들 이동
        shiftRightFrom(index);
        elementData[index] = e; // index 위치에 요소 삽입
        size++;
    }

    /**
     * index 위치부터 오른쪽으로 요소들을 한 칸씩 이동시킵니다.
     * @param index 이동 시작 위치
     */
    private void shiftRightFrom(int index) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    /**
     * 지정한 위치의 요소를 반환합니다.
     * @param index 조회할 위치
     * @return 해당 위치의 요소
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }

    /**
     * 지정한 위치의 요소를 새 값으로 교체하고, 이전 값을 반환합니다.
     * @param index   교체할 위치
     * @param element 새 요소
     * @return 이전 요소
     */
    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    /**
     * 지정한 위치의 요소를 삭제하고, 삭제된 요소를 반환합니다.
     * @param index 삭제할 위치
     * @return 삭제된 요소
     */
    public E remove(int index) {
        E oldValue = get(index);
        // index 위치부터 왼쪽으로 요소들 이동
        shiftLeftFrom(index);
        size--;
        elementData[size] = null; // 마지막 요소 null로 처리(메모리 누수 방지)
        return oldValue;
    }

    /**
     * index 위치부터 마지막까지 요소들을 한 칸씩 왼쪽으로 이동시킵니다.
     * @param index 이동 시작 위치
     */
    private void shiftLeftFrom(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
    }

    /**
     * 주어진 요소가 처음 등장하는 위치의 인덱스를 반환합니다.
     * @param o 찾을 요소
     * @return 요소의 인덱스, 없으면 -1
     */
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 배열의 용량을 두 배로 늘립니다.
     */
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        // 배열을 더 큰 크기로 복사
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 리스트의 요소, 크기, 용량 정보를 문자열로 반환합니다.
     * @return 리스트 정보 문자열
     */
    @Override
    public String toString() {
        // 실제 요소만 복사해서 출력
        return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" + size + ", capacity=" + elementData.length;
    }

}
