package generic.test.ex1;

public class Container<T> {

    private T value;


    public boolean isEmpty() {
        if(value == null){
            return false;
        }
        return true;
    }

    public T getItem() {
        return this.value;
    }
    public void setItem(T value) {
        this.value = value;
    }
}
