import java.util.Arrays;

public class MargeSort {

    private static void marge(int array[], int start, int end, int mid){
        int leftArray[] = new int[mid - start + 1];
        int rightArray[] = new int [end - mid];

        for(int i = 0; i<leftArray.length; i++)
            leftArray[i] = array[start + i];

        for(int i = 0; i<rightArray.length; i++)
            rightArray[i] = array[mid + 1 + i];
        int i = 0, j = 0, k = start;
        while(i < leftArray.length && j < rightArray.length){
            if(leftArray[i]<=rightArray[j])
                array[k++] = leftArray[i++];
            else
                array[k++] = rightArray[j++];
        }

        while(i < leftArray.length)
            array[k++] = leftArray[i++];

        while(j < rightArray.length)
            array[k++] = rightArray[j++];
    }

    private static void recrsiveMargeSort(int array[], int start, int end){
        if (start == end)
            return;
        int mid = (start + end)/2;

        recrsiveMargeSort(array,start,mid);
        recrsiveMargeSort(array,mid + 1,end);

        marge(array,start,end,mid);
    }

    private static void margeSort(int array[]){
        recrsiveMargeSort(array,0,array.length-1);
    }

    public static void main(String []args){
        int array[] = {1,5,6,7,2,3,4};
        margeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
