package app;

public class App {
    public static void main(String[] args) throws Exception {
        //test withoutDuplicates method
        int arr[]={1,2,3,5,2,1,4,6,8,9,9};
        int a2[]=withoutDuplicates(arr);
        for (int i : a2) {
            System.out.println(i);
        }
        System.out.println("----------------------------");
        //test concatenate method
        Integer a[]={1,2,3,4,5};
        Integer b[]={6,7,8,9,10};
        Object c[]= concatenate(a,b);
        for (Object i : c) {
            System.out.println(i);
        }
        System.out.println("----------------------------");
        //test ManipulateArray class
        ManipulateArray mArr = new ManipulateArray(10);
        for (int i = 0; i < 10; i++) {
            mArr.insertElement((int)(Math.random()*100));
        }
        System.out.println(mArr);
        mArr.deleteElement(5);
        System.out.println(mArr);
        mArr.deleteElement(11);
        mArr = new ManipulateArray(a2);
        mArr.insertElement(20);
        mArr.deleteElement(5);
        System.out.println(mArr);
    }

    public static Object[] concatenate(Object[] a, Object[] b){
        int n = a.length+b.length;
        Object[] result = new Object[n];
        for (int i = 0; i < n; i++) {
            if(i<a.length)
                result[i]=a[i];
            else
                result[i]=b[i-a.length];
        }
        return result;
    }

    public static int[] withoutDuplicates(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]==a[j]){
                    shift(a,j);
                }
            }
        }
        for (int i = a.length-1; a[i]==a[i-1]; i--) {
            a[i]=0;
        }
        return a;
    }

    public static int[] shift(int[] a, int start) {
        for (int i = start; i < a.length-1; i++) {
            a[i]=a[i+1];
        }
        return a;
    }

}

class ManipulateArray {
    private int arr[];
    private int nItems;

    public ManipulateArray(int n){
        arr = new int[n];
        nItems = 0;
    }

    public ManipulateArray(int []arr){
        this.arr = arr;
        nItems = arr.length;
    }
    
    public void insertElement(int value) {
        if(isFull()){
            System.out.println("array is full");
            return;
        }
        arr[nItems++] = value;
    }
    
    public void deleteElement(int key) {
        if(isEmpty()){
            System.out.println("array is empty");
            return;
        } else if(key > nItems) {
            System.out.println("wrong key");
            return;
        }
        nItems--;
        for (int i = key; i < nItems; i++) {
            arr[i]=arr[i+1];
        }
    }
    
    private boolean isFull() {
        return nItems == arr.length;
    }

    private boolean isEmpty() {
        return nItems == 0;
    }

    private void sort() {
        for (int i = 0; i < nItems; i++) {
            for (int j = i+1; j < nItems; j++) {
                if (arr[i]>arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public String toString(){
        sort();
        String array = "[ ";
        for (int i = 0; i < nItems; i++) {
            array += arr[i]+" ";
        }
        array += "]";
        return array;
    }

}