package app;


public class App {
    public static void main(String[] args) throws Exception {
        linkedList l1 = new linkedList();
        linkedList l2 = new linkedList();
        for (int i = 1; i < 11; i++) {
            l1.addFirst(i);
            l2.addFirst(i+5);
        }
        //testing union method
        linkedList result = union(l1, l2);
        System.out.println(result);
        //testing intersection method
        result = intersection(l1, l2);
        System.out.println(result);
        //testing removeLast method
        removeLast(result);
        System.out.println(result);
    }

    public static linkedList union(linkedList l1, linkedList l2) {
        linkedList result = new linkedList();
        link iterator = l1.first;
        while (iterator != null) {
            //checking if not empty to avoid error when adding the first item
            if (result.isEmpty()) {
                result.addFirst(iterator.getData());
                continue;
            }
            if (result.find(iterator.getData())==null) {
                result.addFirst(iterator.getData());
            }
            iterator = iterator.getNext();
        }
        iterator = l2.first;
        while (iterator != null) {
            if (result.find(iterator.getData())==null) {
                result.addFirst(iterator.getData());
            }
            iterator = iterator.getNext();
        }
        return result;
    }

    public static linkedList intersection(linkedList l1, linkedList l2) {
        linkedList result = new linkedList();
        link iterator = l1.first;
        while (iterator != null) {
            if (l2.find(iterator.getData())!=null) {
                result.addFirst(iterator.getData());
            }
            iterator = iterator.getNext();
        }
        return result;
    }

    public static void removeLast(linkedList list) {
        if (list.isEmpty()) {
            System.out.println("list is empty");
            return;
        } else if (list.first.getNext() == null) {  //if it has only one item 
            list.first = null;                      //remove it
            return;
        }
        link prev = null;
        link i = list.first;
        while (i.getNext() != null) {
            prev = i;
            i = i.getNext();
        }
        prev.setNext(i.getNext());
    }

}