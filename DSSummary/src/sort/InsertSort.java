package sort;

import java.util.Arrays;

/**
 * @PackageName: sort
 * @ClassName: InsertSort
 * @Description:
 * @author: 呆呆
 * @date: 2020/2/22
 */
public class InsertSort {
    public static void insertSort(int[] array){
        for(int i = 1;i < array.length;i++){
            int val = array[i];
            int j;
            for(j = i-1;j >= 0 && val < array[j];j--){
                array[j+1] = array[j];
            }
            array[j + 1] = val;
        }
        System.out.println(Arrays.toString(array));
    }
}
