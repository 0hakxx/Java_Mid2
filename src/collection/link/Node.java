package collection.link;

public class Node {

    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

/*
    //IDE 생성 toString()
    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
*/

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node x = this;
        while (x != null) {
            sb.append(x.item);
            if(x.next != null) {
                sb.append("->");
            }
            x = x.next;
        }
        return sb.toString();
    }
}
