package collection.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 정렬 관련 메인 클래스.
 */
public class SortMain2 {

    public static void main(String[] args) {
        // 정렬할 정수형 배열 생성
        Integer[] array = {3, 2, 1};

        // 초기 배열 출력
        System.out.println("초기 배열: " + Arrays.toString(array));

        // Comparator를 사용한 비교 및 정렬
        System.out.println("Comparator 비교");

        // 오름차순 정렬
        Arrays.sort(array, new AscComparator());
        System.out.println("AscComparator(오름차순): " + Arrays.toString(array));

        // 내림차순 정렬
        Arrays.sort(array, new DescComparator());
        System.out.println("DescComparator(내림차순): " + Arrays.toString(array));

        // AscComparator의 reversed() 메서드를 사용하여 내림차순 정렬
        Arrays.sort(array, new AscComparator().reversed());
        System.out.println("AscComparator.reversed(내림차순): " + Arrays.toString(array));
    }

    /**
     * 오름차순 정렬을 위한 Comparator 구현 클래스.
     */
    static class AscComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            // 비교 대상 두 수를 출력
            System.out.println("o1=" + o1 + " o2=" + o2);

            // o1이 o2보다 작으면 음수, 같으면 0, 크면 양수를 반환
            return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
        }
    }

    /**
     * 내림차순 정렬을 위한 Comparator 구현 클래스.
     */
    static class DescComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            // 비교 대상 두 수를 출력
            System.out.println("o1=" + o1 + " o2=" + o2);

            // AscComparator의 compare 결과에 -1을 곱하여 내림차순으로 변환
            return ((o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1)) * -1;
        }
    }
}
