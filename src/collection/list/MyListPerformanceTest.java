package collection.list;

/**
 * MyList 인터페이스 구현체(MyArrayList, MyLinkedList)의 성능 비교 테스트 클래스
 * - 추가(앞/중간/뒤), 조회(인덱스), 검색(값) 연산의 시간 측정
 * - 데이터 구조별 시간 복잡도 차이를 실제 실행 시간으로 확인 가능
 */
public class MyListPerformanceTest {

    public static void main(String[] args) {
        int size = 50_000; // 테스트용 데이터 크기 (큰 데이터셋으로 성능 차이 확연히 나타내기 위함)

        // ArrayList 추가 성능 테스트 ================================
        System.out.println("==MyArrayList 추가==");
        addFirst(new MyArrayList<>(), size);    // 앞쪽 추가: O(n)
        addMid(new MyArrayList<>(), size);      // 중간 추가: O(n)
        MyArrayList<Integer> arrayList = new MyArrayList<>(); // 조회 테스트용 데이터
        addLast(arrayList, size);               // 끝쪽 추가: amortized O(1)

        // LinkedList 추가 성능 테스트 ===============================
        System.out.println("==MyLinkedList 추가==");
        addFirst(new MyLinkedList<>(), size);   // 앞쪽 추가: O(1)
        addMid(new MyLinkedList<>(), size);     // 중간 추가: O(n) (노드 탐색 시간 포함)
        MyLinkedList<Integer> linkedList = new MyLinkedList<>(); // 조회 테스트용 데이터
        addLast(linkedList, size);              // 끝쪽 추가: O(1) (tail 포인터 있을 경우)

        // 조회 성능 테스트 ==========================================
        int loop = 10000; // 반복 횟수
        System.out.println("==MyArrayList 조회==");
        getIndex(arrayList, loop, 0);      // 첫번째 요소: O(1)
        getIndex(arrayList, loop, size / 2); // 중간 요소: O(1)
        getIndex(arrayList, loop, size - 1); // 마지막 요소: O(1)

        System.out.println("==MyLinkedList 조회==");
        getIndex(linkedList, loop, 0);     // 첫번째 요소: O(1)
        getIndex(linkedList, loop, size / 2); // 중간 요소: O(n/2) → O(n)
        getIndex(linkedList, loop, size - 1); // 마지막 요소: O(n) (tail 포인터 없을 경우)

        // 검색 성능 테스트 ==========================================
        System.out.println("==MyArrayList 검색==");
        search(arrayList, loop, 0);       // 첫번째 값 검색: O(1)
        search(arrayList, loop, size / 2); // 중간 값 검색: O(n/2)
        search(arrayList, loop, size - 1); // 마지막 값 검색: O(n)

        System.out.println("==MyLinkedList 검색==");
        search(linkedList, loop, 0);      // 첫번째 값 검색: O(1)
        search(linkedList, loop, size / 2); // 중간 값 검색: O(n/2)
        search(linkedList, loop, size - 1); // 마지막 값 검색: O(n)
    }

    /**
     * 리스트 앞쪽에 요소 추가 성능 측정
     * @param list 테스트 대상 리스트
     * @size 테스트 데이터 크기
     */
    private static void addFirst(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i); // 매번 0번 인덱스에 추가 → 배열 구조에선 비효율적
        }
        long endTime = System.currentTimeMillis();
        System.out.println("앞에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    /**
     * 리스트 중간에 요소 추가 성능 측정
     * i/2 위치에 추가 → 매번 다른 위치에 삽입
     */
    private static void addMid(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i / 2, i); // 중간 삽입 시 데이터 이동량이 절반으로 줄어듦
        }
        long endTime = System.currentTimeMillis();
        System.out.println("평균 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    /**
     * 리스트 끝에 요소 추가 성능 측정
     * - ArrayList: 배열 공간 충분시 amortized O(1)
     * - LinkedList: tail 참조 있을 시 O(1)
     */
    private static void addLast(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i); // 최적화 가능한 추가 방식
        }
        long endTime = System.currentTimeMillis();
        System.out.println("뒤에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    /**
     * 인덱스 조회 성능 측정
     * @param index 측정 대상 인덱스 (처음/중간/끝)
     * @loop 작은 연산多次 반복 측정을 통한 정확도 향상
     */
    private static void getIndex(MyList<Integer> list, int loop, int index) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(index); // ArrayList: O(1), LinkedList: O(n)
        }
        long endTime = System.currentTimeMillis();
        System.out.println("index: " + index + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    /**
     * 값 검색 성능 측정 (indexOf 연산)
     * @param findValue 찾을 값 (처음/중간/끝 위치한 값)
     * - 최악의 경우 모두 O(n)이지만 캐시 지역성 차이 발생
     */
    private static void search(MyList<Integer> list, int loop, int findValue) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.indexOf(findValue); // 순차 검색 → 구조에 따른 메모리 접근 차이
        }
        long endTime = System.currentTimeMillis();
        System.out.println("findValue: " + findValue + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) + "ms");
    }
}
