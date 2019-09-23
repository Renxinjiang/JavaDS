import java.util.Arrays;

public class HeapSort {
    /**
     *堆排（选择排序）
     * 在无序区间找一个最大的数和无序区间的最后一个数交换
     * 把整个无序区间看做一个堆
     * 不断把最大数据取出来放到最后去array.length - i(i是从1到array.length)
     * 再进行向下调整
     */

    /**
     *若建的是小堆，则不能排成升序
     *
     * 大根堆排升序
     * 小根堆排降序
     */
    public static void heapSort(int[] array){
        BuildHeap buildHeap = new BuildHeap();
        Adjust adjust = new Adjust();

        buildHeap.creatBigHeap(array,array.length);
        for (int i = 0;i < array.length - 1;i++){
            // 无序区间 [0, array.length - 1 - i]
            // 有序区间 [array.length - i, array.length-1]
            swap(array,0,array.length - 1 - i);
            // 无序区间 [0, array.length - 1 - i - 1]
            // 有序区间 [array.length - i + 1, array.length-1]
            adjust.shiftDownBig(array,array.length - 1 - i,0);
        }
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }

    public static void main(String[] args) {
        int[] a = {9,5,4,1,2,3,8,6};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
