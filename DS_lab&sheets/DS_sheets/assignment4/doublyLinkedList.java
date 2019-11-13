package app;

public class doublyLinkedList {
    private dllLink first,last;
    
    public boolean isEmpty(){
        return (first==null);                   //list is empty when first refers to null
    }
    
    public void addFirst(double data){
        dllLink newNode = new dllLink(data);
        if(isEmpty())                           //if list is empty set last to the new node
            last=newNode;
        else
            first.setPrev(newNode);
        newNode.setNext(first);
        first=newNode;
    }
    
    public dllLink removeFirst() throws Exception{
        if(isEmpty())                             //if list is empty throw exception
            throw new Exception("list is empty");
        dllLink temp=first;
        if(first.getNext()==null)           //if only one element set last to null
            last=null;
        else
            first.getNext().setPrev(null);
        first=first.getNext();              //move first reference to the next element
        return temp;
    }
    
    public void addLast(double data){
        dllLink newNode = new dllLink(data);
        if(isEmpty())
            first=newNode;
        else{
            last.setNext(newNode);
            newNode.setPrev(last);
        }
        last=newNode;
    }
    
    public dllLink removeLast()throws Exception{
        if(isEmpty())                             //if list is empty throw exception
            throw new Exception("list is empty");
        dllLink temp=last;
        if(last.getPrev()==null)
            first=null;
        else
            last.getPrev().setNext(null);
        last=last.getPrev();
        return temp;
    }
    
    public boolean addAfter(int key,double data){
        dllLink newNode=new dllLink(data);
        dllLink current=first;
        while(current.getData()!=key){
            if(current==null)
                return false;
            current=current.getNext();
        }
        if(current==last)
            last=newNode;
        else
            current.getNext().setPrev(newNode);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        newNode.setPrev(current);
        return true;
    }
    
    public dllLink removeKey(int key){
        dllLink current=first;
        while(current.getData()!=key){
            if(current==null)
                return null;
            current=current.getNext();
        }
        if(current==first)
            first=first.getNext();
        else
            current.getPrev().setNext(current.getNext());
        if(current==last)
            last=last.getPrev();
        else
            current.getNext().setPrev(current.getPrev());
        return current;
    }
    
    public void displayForward(){
        dllLink current=first;
        System.out.print("{");
        while(current!=null){
            System.out.print(current);
            if(current.getNext()!=null)
                System.out.print("->");
            current=current.getNext();
        }
        System.out.println("}");
    }
    public void displayBackward(){
        dllLink current=last;
        System.out.print("{");
        while(current!=null){
            System.out.print(current);
            if(current.getPrev()!=null)
                System.out.print("<-");
            current=current.getPrev();
        }
        System.out.println("}");
    }
}

class dllLink {
    private double data;
    private dllLink next;
    private dllLink prev;
    public dllLink(double data){
        this.data=data;
    }
    @Override
    public String toString(){
        return ""+data;
    }
    public void setData(double data){
        this.data=data;
    }
    public double getData(){
        return data;
    }
    public void setNext(dllLink next){
        this.next=next;
    }
    public dllLink getNext(){
        return next;
    }
    public void setPrev(dllLink prev){
        this.prev=prev;
    }
    public dllLink getPrev(){
        return prev;
    }
}