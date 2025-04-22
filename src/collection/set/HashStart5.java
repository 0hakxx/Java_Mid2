package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * HashStart5 클래스는 해시 테이블의 기본 구현을 보여주는 예제입니다.
 * 해시 테이블은 O(1) 시간 복잡도로 데이터를 검색할 수 있는 자료구조입니다.
 * 이 구현에서는 충돌 해결 방식으로 체이닝(Chaining)을 사용합니다.
 */
public class HashStart5 {

    // 해시 테이블의 크기(버킷 배열의 길이)를 정의합니다.
    // 실제 해시 테이블에서는 성능을 위해 소수(prime number)를 사용하는 것이 좋습니다.
    static final int CAPACITY = 10;

    public static void main(String[] args) {
        // 해시 테이블의 각 버킷을 LinkedList 배열로 선언합니다.
        // 각 버킷은 해시 충돌이 발생했을 때 여러 값을 저장할 수 있는 LinkedList입니다.
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];

        // 각 버킷을 빈 LinkedList로 초기화합니다.
        // 이 초기화 과정은 NullPointerException을 방지하기 위해 필수적입니다.
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }

        // 해시 테이블에 값들을 추가합니다.
        add(buckets, 1);  // 해시값: 1 % 10 = 1, 버킷[1]에 저장
        add(buckets, 2);  // 해시값: 2 % 10 = 2, 버킷[2]에 저장
        add(buckets, 5);  // 해시값: 5 % 10 = 5, 버킷[5]에 저장
        add(buckets, 8);  // 해시값: 8 % 10 = 8, 버킷[8]에 저장
        add(buckets, 14); // 해시값: 14 % 10 = 4, 버킷[4]에 저장
        add(buckets, 99); // 해시값: 99 % 10 = 9, 버킷[9]에 저장
        add(buckets, 9);  // 해시값: 9 % 10 = 9, 버킷[9]에 저장 (99와 충돌 발생)

        // 버킷 배열의 현재 상태를 출력합니다.
        System.out.println("buckets = " + Arrays.toString(buckets));

        // 특정 값이 해시 테이블에 존재하는지 검색합니다.
        int searchValue = 9;
        boolean contains = contains(buckets, searchValue);
        System.out.println("bucket.contains(" + searchValue + ") = " + contains);
    }

    /**
     * 해시 테이블에 값을 추가하는 메서드입니다.
     * 중복된 값은 추가하지 않습니다.
     *
     * @param buckets 버킷 배열
     * @param value 추가할 값
     */
    private static void add(LinkedList<Integer>[] buckets, int value) {
        // 1. 해시 함수를 통해 저장할 버킷의 인덱스를 계산합니다.
        int hashIndex = hashIndex(value);

        // 2. 계산된 인덱스에 해당하는 버킷(LinkedList)을 가져옵니다. - O(1) 연산
        LinkedList<Integer> bucket = buckets[hashIndex];

        // 3. 버킷에 해당 값이 이미 존재하는지 확인합니다.
        // LinkedList의 contains 메서드는 모든 요소를 순회하므로 O(n) 시간 복잡도를 가집니다.
        // 여기서 n은 해당 버킷에 있는 요소의 개수입니다.
        if (!bucket.contains(value)) {
            // 4. 값이 존재하지 않으면 버킷에 값을 추가합니다.
            bucket.add(value);
        }
        // 이미 존재하는 값이면 아무 작업도 수행하지 않습니다. (중복 허용 안 함)
    }

    /**
     * 해시 테이블에서 값을 검색하는 메서드입니다.
     *
     * @param buckets 버킷 배열
     * @param searchValue 검색할 값
     * @return 값이 존재하면 true, 그렇지 않으면 false
     */
    private static boolean contains(LinkedList<Integer>[] buckets, int searchValue) {
        // 1. 해시 함수를 통해 검색할 버킷의 인덱스를 계산합니다.
        int hashIndex = hashIndex(searchValue);

        // 2. 계산된 인덱스에 해당하는 버킷을 가져옵니다. - O(1) 연산
        LinkedList<Integer> bucket = buckets[hashIndex];

        // 3. 버킷 내에서 값을 검색합니다. - O(n) 연산
        // 최악의 경우(모든 값이 같은 버킷에 해시되는 경우), O(n) 시간이 소요될 수 있습니다.
        return bucket.contains(searchValue);
    }

    /**
     * 해시 함수: 값을 버킷 인덱스로 변환합니다.
     * 이 구현에서는 간단히 값을 CAPACITY로 나눈 나머지를 사용합니다.
     *
     * @param value 해시할 값
     * @return 해시된 인덱스 (0부터 CAPACITY-1 사이의 값)
     */
    static int hashIndex(int value) {
        // 값을 CAPACITY로 나눈 나머지를 반환합니다.
        // 이렇게 하면 결과값은 항상 0부터 CAPACITY-1 사이의 값이 됩니다.
        return value % CAPACITY;
    }
}
