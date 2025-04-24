package collection.iterable;

import java.util.Iterator;

/**
 *int 배열을 순회할 수 있게 해주는 Iterator 구현체
 */
public class MyArrayIterator implements Iterator<Integer> {

    // 현재 가리키고 있는 인덱스.
    // -1로 시작하여 next() 호출 시 0부터 시작하도록 설계됨
    private int currentIndex = -1;

    // 순회할 대상이 되는 int 배열
    private int[] targetArr;

    public MyArrayIterator(int[] targetArr) {
        this.targetArr = targetArr;
    }

    @Override
    public boolean hasNext() {
        // currentIndex가 배열의 마지막 인덱스보다 작으면 다음 요소가 있으면 true, 없으면 false 반환
        return currentIndex < targetArr.length - 1;
    }

    @Override
    public Integer next() {
        // currentIndex를 1 증가시켜, 다음 인덱스의 요소를 반환
        return targetArr[++currentIndex];
    }
}
/*
 * [그림으로 표현]
 *
 * targetArr: [1, 2, 3, 4]
 * currentIndex: -1 (처음)
 *
 * next() 호출 시
 *  ↓
 * currentIndex: 0 → targetArr[0] 반환 (1)
 * currentIndex: 1 → targetArr[1] 반환 (2)
 * currentIndex: 2 → targetArr[2] 반환 (3)
 * currentIndex: 3 → targetArr[3] 반환 (4)
 *
 * hasNext()는 currentIndex < 3 일 때 true
 */