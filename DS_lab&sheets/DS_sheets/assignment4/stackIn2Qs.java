package app;

class stackIn2Qs<T> {
    private Queue<T> q1, q2;

    public stackIn2Qs(){
        q1 = new Queue<T>();
        q2 = new Queue<T>();
    }

    public void push(T value) {
        q1.push(value);
    }

    public T pop() {
        while(q1.size()>1){
            q2.push(q1.pop());
        }

        T temp = q1.pop();
        
        while (!q2.isEmpty()) {
            q1.push(q2.pop());
        }

        return temp;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

}
