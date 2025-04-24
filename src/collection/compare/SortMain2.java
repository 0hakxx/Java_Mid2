package collection.compare;

import java.util.Arrays;
import java.util.Comparator;

public class SortMain2 {

    public static void main(String[] args) {
        // 1. 정수 배열 생성 및 출력
        Integer[] array = {3, 2, 1};
        System.out.println(Arrays.toString(array)); // [3, 2, 1] 출력

        System.out.println("Comparator 비교");

        // 2. 오름차순(AscComparator)으로 정렬
        Arrays.sort(array, new AscComparator());
        // AscComparator의 compare()가 호출되어 오름차순 정렬 수행
        System.out.println("AscComparator:" + Arrays.toString(array)); // [1, 2, 3] 출력

        // 3. 내림차순(DescComparator)으로 정렬
        Arrays.sort(array, new DescComparator());
        // DescComparator의 compare()가 호출되어 내림차순 정렬 수행
        System.out.println("DescComparator:" + Arrays.toString(array)); // [3, 2, 1] 출력

        // 4. AscComparator의 reversed() 메서드를 사용해 내림차순 정렬
        Arrays.sort(array, new AscComparator().reversed()); // DescComparator와 결과 동일
        System.out.println("AscComparator.reversed:" + Arrays.toString(array)); // [3, 2, 1] 출력
    }

    /**
     * 오름차순 정렬을 위한 Comparator 구현 클래스
     * - compare(o1, o2)에서 o1이 o2보다 작으면 음수(-1) 반환 → o1이 앞으로 감
     * - o1이 o2보다 크면 양수(1) 반환 → o2가 앞으로 감
     * - 같으면 0 반환
     */
    static class AscComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("o1=" + o1 + " o2=" + o2); // 비교 과정 출력
            return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
        }
    }

    /**
     * 내림차순 정렬을 위한 Comparator 구현 클래스
     * - AscComparator와 비교 결과의 부호만 반대
     * - compare(o1, o2)에서 o1이 o2보다 작으면 양수(1) 반환 → o2가 앞으로 감
     * - o1이 o2보다 크면 음수(-1) 반환 → o1이 앞으로 감
     * - 같으면 0 반환
     */
    static class DescComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("o1=" + o1 + " o2=" + o2); // 비교 과정 출력
            // AscComparator 결과에 -1을 곱해 부호를 반대로 만듦
            return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1) * -1;
            // 또는 return (o1 < o2) ? 1 : ((o1 == o2) ? 0 : -1); 로도 가능
        }
    }
}

/*
[정렬 과정 그림]
1. 초기 배열: [3, 2, 1]

2. Arrays.sort(array, new AscComparator())
   - compare(3,2) → 1 (3>2) → 2가 앞으로
   - compare(2,1) → 1 (2>1) → 1이 앞으로
   - 결과: [1, 2, 3]

3. Arrays.sort(array, new DescComparator())
   - compare(1,2) → -1 (1<2) * -1 = 1 → 2가 앞으로
   - compare(2,3) → -1 (2<3) * -1 = 1 → 3이 앞으로
   - 결과: [3, 2, 1]

4. Arrays.sort(array, new AscComparator().reversed())
   - AscComparator의 정렬 결과를 반대로 적용 → DescComparator와 동일
   - 결과: [3, 2, 1]
*/

/*
[핵심 포인트]
- Comparator는 두 객체를 비교하여 정렬 순서를 결정
- 오름차순: o1 < o2 이면 -1 반환
- 내림차순: 오름차순 결과에 -1을 곱하거나, o1 < o2 이면 1 반환
- reversed() 메서드는 Comparator의 정렬 순서를 반대로 바꿔줌
*/
