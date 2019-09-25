package renxin;

import java.util.Arrays;
import java.util.Random;

/**
 * @PackageName: renxin
 * @ClassName: BubbleSort
 * @Description: 冒泡排序
 * 在无序区间，通过相邻数的比较，将最大的数冒泡到无序区间的最后，持续这个过程，直到数组整体有序
 * @author: 呆呆
 * @date: 2019/9/25
 */
public class BubbleSort {
    public static void bubbleSort(int[] array){
        for (int i = 0;i < array.length -1;i++){
            boolean isSort = true;
            for (int j = 0;j < array.length - i - 1;j++){
                if (array[j] > array[j+1]){
                    swap(array,j,j+1);
                    isSort = false;
                }
            }
            if (isSort){
                return;
            }
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

        bubbleSort(a);
        System.out.println(Arrays.toString(a));

        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        System.out.println(Arrays.equals(a,b));
        System.out.println("=====================================");

        System.out.print("冒泡排序：");
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
        bubbleSort(a);
        long end = System.nanoTime();
        double ms = (end - begin)*1.0 / 1000 /1000;  //单位换算成秒
        System.out.printf("一共耗时：%.5f毫秒%n",ms);
    }
}
