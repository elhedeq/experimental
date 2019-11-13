package app;

public class linkedList {
    link first;
    public void addFirst(Object data){
        link newNode=new link(data);
        newNode.setNext(first);     //next reference in the new node refers to the old first
        first=newNode;              //update the first reference to the new node
    }
    
    public boolean isEmpty(){
        return (first==null);   //list is empty when first refers to null
    }
    
    public link removeFirst(){
        if(isEmpty()){
            System.out.println("list is empty");
            return null;
        }
        link temp=first;
        first=first.getNext();                      //move first reference to the next element
        return temp;
    }
    
    public link find(Object data) {
        if(isEmpty()){
            System.out.println("list is empty");
            return null;
        }
        link current=first;                         //current reference to iterate through the list
        while (current!=null){                      //loop to the end
            if(current.getData()==data)               //if key is found break
                break;
            current=current.getNext();              //update current to the next
        }
        return current;
    }
    
    @Override
    public String toString(){
        String list="{";
        link current=first;
        while(current !=null){
            if(current.getNext()==null)
                list+=current;
            else
                list+=current+"->";
            current=current.getNext();
        }
        list+="}";
        return list;
    }
}

class link {
    private Object data;
    private link next;
    public link(Object data){
        this.data=data;
    }
    public void setData(Object data){
        this.data=data;
    }
    public Object getData(){
        return data;
    }
    public void setNext(link next){
        this.next=next;
    }
    public link getNext(){
        return next;
    }

    public String toString() {
        return ""+this.getData();
    }

}