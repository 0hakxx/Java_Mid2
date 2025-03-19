package generic.ex1;

public class RowTypeMain {

    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<Integer>();
        //GenericBox<Object> integerBox = new GenericBox<>(); // 권장
        integerBox.set(10);
        Integer result =  integerBox.get();
        System.out.println("result = " + result);
    }
}