package renxin;

import java.util.Arrays;
import java.util.Random;

/**
 * @PackageName: renxin
 * @ClassName: InsertSort
 * @Description: 直接插入排序
 * @author: 呆呆
 * @date: 2019/9/25
 */
public class InsertSort {
    //将区间分为有序和无序
    //每次挑选无序区间第一个数在合适的位置做插入

    /**
     * 时间复杂度：
     * 最好           平均            最坏
     * O(n)            O(n^2)         O(n^2)
     *数据有序                        数据逆序
     * 空间复杂度
     * O(1)，原地排序
     * 稳定的
     */

    //普通插排
    public static void insertSort(int[] array){
        //升序
        for (int i = 1;i < array.length;i++){
            //有序区间：[0,i )
            //无序区间：[i,array.length )
            int key = array[i];
            int j;
            for (j = i - 1;j >= 0 && array[j] > key;j--){
                    array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }
    //折半插排
    public static void bsInsertSort(int[] array){
        //在有序区间选择数据应该插入的位置时，因为区间的有序性，可以利用折半查找的思想。
        for (int i = 1;i < array.length;i++){
            //区间[left,right):插入位置
            int key = array[i];
            int left = 0;
            int right = i;
            while (left < right){
                int mid = (left+right) / 2;
                if (key >= array[mid]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            //搬移：[left,i-1]都需要往后搬移一个
            int j;
            for (j = i-1;j >= left;j--){
                array[j + 1] = array[j];
            }
            array[j+1] = key;
        }
    }

    //测试
    public static void main(String[] args) {
        int[] a = {2,3,5,7,9,4,5,6,9,1,4,7,8};
        int[] b = a.clone();
        int[] c = a.clone();
        int[] d = a.clone();
        insertSort(a);
        System.out.println(Arrays.toString(a));

        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        System.out.println(Arrays.equals(a,b));
        System.out.println("=====================================");

        System.out.print("直接插排：");
        testSpeed();
        System.out.println("=====================================");
        bsInsertSort(c);
        Arrays.sort(d);
        System.out.println(Arrays.equals(c,d));

    }
    //测速
    public static void testSpeed(){
        Random random = new Random(20190925);
        int[] a = new int[10*10000];
        for (int i = 0;i < 10 * 10000;i++){
            a[i] = random.nextInt(10*10000);
        }
        long begin = System.nanoTime();//此刻时间，以纳秒为单位
        insertSort(a);
        long end = System.nanoTime();
        double ms = (end - begin)*1.0 / 1000 /1000;  //单位换算成秒
        System.out.printf("一共耗时：%.5f毫秒%n",ms);
    }
}
