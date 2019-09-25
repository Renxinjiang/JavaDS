package renxin;

import java.util.Arrays;
import java.util.Random;

/**
 * @PackageName: renxin
 * @ClassName: SelectSort
 * @Description: 选择排序
 * 每一次从无序区间选出最大（或最小）的一个元素，
 * 存放在无序区间的最后（或最前），直到全部待排序的数据元素排完 。
 * @author: 呆呆
 * @date: 2019/9/25
 */
public class SelectSort {
    /**
     * 时间复杂度：
     * O(n^2)，数据不敏感
     * 空间复杂度
     * O(1)，原地排序
     * 不稳定（因为交换的时候不知道被交换的数是否存在值一样的数）
     */

    //找最大值往后放
    //无序区间：[0,array.length-i)
    //有序区间：[array.length-i,array.length)
    public static void selectSort1(int[] array){
        for (int i = 0;i < array.length - 1;i++){
            int maxIndex = 0;
            for (int j = 1;j < array.length - i;j++){
                if (array[j] > array[maxIndex]){
                    maxIndex = j;
                }
            }
            swap(array,maxIndex,array.length-i-1);
        }
    }
    //找最小值往前放
    //无序区间：[i,array.length)
    //有序区间：[0,i)
    public static void selectSort2(int[] array){
        for (int i = 0;i < array.length -1 ;i++){
            int minIndex = i;
            for (int j = i + 1;j < array.length ;j++){
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array,minIndex,i);
        }
    }

    // 双向选择排序
    // 每一次从无序区间选出最小 + 最大的元素，
    // 存放在无序区间的最前和最后，直到全部待排序的数据元素排完。
    public static void selectSort3(int[] array){
        //无序区间：[begin,end]
        for (int i = 0;i < array.length - 1;i++){
            int begin = 0;
            int end = array.length - 1;
            while (begin < end){
                int minIndex = begin;
                int maxIndex = begin;
                for (int j = begin + 1;j <= end;j++){
                    if (array[j] < array[minIndex]){
                        minIndex = j;
                    }
                    if (array[j] > array[maxIndex]){
                        maxIndex = j;
                    }
                }
                swap(array,minIndex,begin);
                if (maxIndex == begin){
                    maxIndex = minIndex;
                }
                swap(array,maxIndex,end);
                begin++;
                end--;
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

        selectSort3(a);
        System.out.println(Arrays.toString(a));

        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        System.out.println(Arrays.equals(a,b));
        System.out.println("=====================================");

        System.out.print("选择排序：");
        testSpeed();
    }
    //测速
    public static void testSpeed(){
        Random random = new Random(20190925);
        int[] a = new int[10*300];
        for (int i = 0;i < 10 *300;i++){
            a[i] = random.nextInt(10*10000);
        }
        long begin = System.nanoTime();//此刻时间，以纳秒为单位
        selectSort3(a);
        long end = System.nanoTime();
        double ms = (end - begin)*1.0 / 1000 /1000;  //单位换算成秒
        System.out.printf("一共耗时：%.5f毫秒%n",ms);
    }
}
