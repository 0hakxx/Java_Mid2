package generic.test.ex01;

public class Container<T>{
    private T value;
    public void setItem(T value)
    {
        this.value = value;
    }

    public T getItem(){
        return value;
    }

    public boolean isEmpty(){
        if(this.value == null){
            return true;
        }
        else return false;
    }
}
