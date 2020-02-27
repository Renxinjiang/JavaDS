package sort;

import java.util.Arrays;

/**
 * @PackageName: sort
 * @ClassName: ShellSort
 * @Description:
 * @author: 呆呆
 * @date: 2020/2/23
 */
public class ShellSort {
    // 对小组进行插入排序
    public static void insertSortWithGap(int[] array,int gap){
        for(int i = 0;i < array.length - gap;i++){
            int val = array[i + gap];
            int j;
            for(j = i;j>=0 && val < array[j];j -= gap){
                array[j+gap] = array[j];
            }
            array[j+gap] = val;
        }
    }
    public static void shellSort(int[] array){
        int gap = array.length;
        while (true) {
            gap = gap / 3 + 1;
            insertSortWithGap(array, gap);
            if (gap == 1) {
                return;
            }
        }
    }
}
