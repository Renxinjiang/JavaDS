package renxin;

import java.util.Arrays;
import java.util.Random;

/**
 * @PackageName: renxin
 * @ClassName: ShellSort
 * @Description: 希尔排序是对插排的一次优化
 * @author: 呆呆
 * @date: 2019/9/25
 */
public class ShellSort {
    /**
     * 时间复杂度：
     * 最好           平均            最坏
     * O(n)           O(n^1.3)       O(n^2)
     *数据有序                        难构造
     * 空间复杂度
     * O(1)，原地排序
     * 不稳定（因为相同的值不一定能分到同一个组）
     */

    /**
     * 第一次分组：利用gap = array.length/2或gap = array.length/3 + 1
     * 先把每一组的无序区间的第一个数进行插排
     * 再把分组减少直到只有一组，在这时数组做完了预排序
     * 一组进行插入排序
     */
    public static void shellSort(int[] array){
        int gap = array.length;
        while (true){
            gap = gap / 3 + 1;
            insertSortWithGap(array,gap);
            if (gap == 1){
                break;
            }
        }
    }

    private static void insertSortWithGap(int[] array, int gap) {
        for (int i = gap;i < array.length;i++){
            int key = array[i];
            int j;
            for (j = i - gap;j >= 0 && array[j] > key;j = j - gap){
                array[j+gap] = array[j];
            }
            array[j+gap] = key;
        }
    }

    //测试
    public static void main(String[] args) {
        int[] a = {2,3,5,7,9,4,5,6,9,1,4,7,8};
        int[] b = a.clone();

        shellSort(a);
        System.out.println(Arrays.toString(a));

        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        System.out.println(Arrays.equals(a,b));
        System.out.println("=====================================");

        System.out.print("希尔排序：");
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
        shellSort(a);
        long end = System.nanoTime();
        double ms = (end - begin)*1.0 / 1000 /1000;  //单位换算成秒
        System.out.printf("一共耗时：%.5f毫秒%n",ms);
    }
}
