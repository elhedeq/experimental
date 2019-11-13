package app;

public class dualStack{

    private long arr[];
    private int peek1,peek2,size;

    public dualStack(int size){
        arr = new long[size];
        this.size = size;
        peek1=-1;
        peek2=size;
    }
    
    public void push1(long value) throws Exception {
        if (peek2-peek1==1)
            throw new Exception("array is full");
        arr[++peek1]=value;
    }

    public void push2(long value)  throws Exception {
        if (peek2-peek1==1)
            throw new Exception("array is full");
        arr[--peek2]=value;
    }

    public long pop1() throws Exception {
        if (peek1==-1)
            throw new Exception("stack is empty");
        return arr[peek1--];
    }

    public long pop2() throws Exception {
        if (peek1==size)
            throw new Exception("stack is empty");
        return arr[peek2++];
    }

    public long peek1() {
        return arr[peek1];
    }

    public long peek2() {
        return arr[peek2];
    }
}