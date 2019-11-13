package app;

class Dequeue_doublyList {
    private doublyLinkedList dlList;

    public Dequeue_doublyList() {
        dlList = new doublyLinkedList();
    }

    public void push_back(double data) {
        dlList.addLast(data);
    }

    public void push_front(double data) {
        dlList.addFirst(data);
    }
    
    public double pop_back() throws Exception {
        return dlList.removeLast().getData();
    }

    public double pop_front() throws Exception {
        return dlList.removeFirst().getData();
    }
    
    public boolean isEmpty() {
        return dlList.isEmpty();
    }

}