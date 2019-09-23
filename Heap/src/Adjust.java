import java.util.Arrays;
import java.util.Random;

public class Adjust {
    //向下调整为小根堆
    //让根依次和左右孩子中小的交换
    public static void shiftDownSmall(int[] array,int size,int index){
        int left = 2 * index + 1;
        while (left < size){
            int right = left +1;
            int min = left;
            if (min + 1 < size && array[left] > array[right]){
                min = right;
            }
            if (array[index] > array[min]){
                swap(array,index,min);
                index = min;
                left = 2 * index + 1;
            }else{
                break;
            }
        }
    }
    //向下调整为大根堆
    //让根依次和左右孩子中大的交换
    public static void shiftDownBig(int[] array,int size,int index){
        int left = 2 * index + 1;
        while (left < size){
            int right = left +1;
            int max = left;
            if (max + 1 < size && array[left] < array[right]){
                max = right;
            }
            if (array[index] < array[max]){
                swap(array,index,max);
                index = max;
                left = 2 * index + 1;
            }else{
                break;
            }
        }
    }

    //向上调整为小根堆
    //若比双亲结点小，则交换
    public static void shiftUpSmall(int[] array,int index){
        while (index != 0){
            int parent = (index - 1) / 2;
            if (array[parent] > array[index]){
                swap(array,parent,index);
                index = parent;
            }else{
                break;
            }
        }
    }

    //向上调整为大根堆
    //若比双亲结点大，则交换
    public static void shiftUpBig(int[] array,int index){
        while (index != 0){
            int parent = (index - 1) / 2;
            if (array[parent] < array[index]){
                swap(array,parent,index);
                index = parent;
            }else{
                break;
            }
        }
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }


    public static void main(String[] args) {
        int[] a = {100,50,30,15,40,80,70,10,5,20,30,60,70,60,70,5};
        shiftDownBig(a,a.length,2);
        System.out.println(Arrays.toString(a));
        int[] b = {6,2,3,4,5,7,8,8,9};
        shiftDownSmall(b,b.length,0);
        System.out.println(Arrays.toString(b));
        int[] c = {2,3,4,5,6,7,8,1};
        shiftUpSmall(c,7);
        System.out.println(Arrays.toString(c));
        int[] d = {8,7,6,5,4,3,2,9};
        shiftUpBig(d,7);
        System.out.println(Arrays.toString(d));
    }
}
