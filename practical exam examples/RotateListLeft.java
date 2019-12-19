import java.util.Arrays;
import java.util.LinkedList;

public class RotateListLeft {
    public static void rotateRight(LinkedList list){
        list.addLast(list.removeFirst());
    }
    public static void main(String args[]){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(22);
        linkedList.addLast(33);
        linkedList.addLast(44);
        linkedList.addLast(55);
        linkedList.addLast(66);
        linkedList.addLast(77);
        linkedList.addLast(88);
        linkedList.addLast(99);
        System.out.println(Arrays.toString(linkedList.toArray()));
        rotateRight(linkedList);
        System.out.println(Arrays.toString(linkedList.toArray()));
    }
}
