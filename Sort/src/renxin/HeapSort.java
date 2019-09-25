package renxin;

import java.util.Arrays;
import java.util.Random;

/**
 * @PackageName: renxin
 * @ClassName: HeapSort
 * @Description: 堆排
 * 基本原理也是选择排序，
 * 只是不在使用遍历的方式查找无序区间的最大的数，而是通过堆来选择无序区间的最大的数。
 * 注意： 排升序要建大堆；排降序要建小堆。
 * @author: 呆呆
 * @date: 2019/9/25
 */

public class HeapSort {
    //向下调整成大根堆
    public static void shiftDownBig(int[] array,int size,int index){
        while(index * 2 + 1 < size){
            int max = index*2+1;
            if (max+1 < size && array[max+1] > array[max]){
                max = max+1;
            }
            if (array[index] < array[max]){
                swap(array,index,max);
                index = max;
            }else {
                break;
            }
        }
    }
    //建大根堆
    public static void creatHeapBig(int[]array){
        for (int i = (array.length-2)/2;i >= 0;i--){
            shiftDownBig(array,array.length,i);
        }
    }

    //堆排序
    public static void heapSort(int[] array){
        creatHeapBig(array);
        // 无序 [0, array.length - i)
        // 交换 array[0], array[length - i - 1]
        // 无序 [0, array.length - i - 1)
        // 无序长度 array.length - i - 1
        // 下标 0 进行向下调整
        //将堆顶与无序区间最后一个数交换，再进行一次向下调整
        for (int i = 0; i < array.length-1;i++){
            swap(array,0,array.length-i-1);
            shiftDownBig(array,array.length-i-1,0);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //测试
    public static void main(String[] args) {
        int[] a = {2,3,5,7,9,4,5,6,9,1,4,7,8};
        int[] b = a.clone();

        heapSort(a);
        System.out.println(Arrays.toString(a));

        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        System.out.println(Arrays.equals(a,b));
        System.out.println("=====================================");

        System.out.print("堆排序：");
        testSpeed();
    }
    //测速
    public static void testSpeed(){
        Random random = new Random(20190925);
        int[] a = new int[10*10000];
        for (int i = 0;i < 10 * 10000;i++){
            a[i] = random.nextInt(10*10000);
        }
        long begin = System.nanoTime();//此刻时间，以纳秒为单位
        heapSort(a);
        long end = System.nanoTime();
        double ms = (end - begin)*1.0 / 1000 /1000;  //单位换算成秒
        System.out.printf("一共耗时：%.5f毫秒%n",ms);
    }
}
