public class DualStack {

    private Integer arr[];
    private int peek1,peek2,size;

    public DualStack(int size){
        arr = new Integer[size];
        this.size = size;
        peek1=-1;
        peek2=size;
    }
    
    public void push1(Integer value) throws Exception {
        if (peek2-peek1==1)
            throw new Exception("stack is full");
        arr[++peek1]=value;
    }

    public void push2(Integer value)  throws Exception {
        if (peek2-peek1==1)
            throw new Exception("stack is full");
        arr[--peek2]=value;
    }

    public Integer pop1() throws Exception {
        if (peek1==-1)
            throw new Exception("stack is empty");
        return arr[peek1--];
    }

    public Integer pop2() throws Exception {
        if (peek1==size)
            throw new Exception("stack is empty");
        return arr[peek2++];
    }

    public Integer peek1() {
        return arr[peek1];
    }

    public Integer peek2() {
        return arr[peek2];
    }

    public boolean empty1(){
        return peek1 == -1;
    }

    public boolean empty2(){
        return peek2 == size;
    }

    public static void main(String args[]) throws Exception{
        //comments are tests for exceptions
        DualStack dualStack = new DualStack(4);
        dualStack.push1(2);
        dualStack.push2(4);
        dualStack.push1(1);
        dualStack.push2(3);
//        dualStack.push2(5);
//        dualStack.push1(5);

        while(!dualStack.empty1())
            System.out.println(dualStack.pop1());
//        dualStack.pop1();
        while(!dualStack.empty2())
            System.out.println(dualStack.pop2());
//        dualStack.pop2();
    }
}