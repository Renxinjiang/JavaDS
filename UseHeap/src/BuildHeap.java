import java.util.Arrays;
import java.util.Random;

public class BuildHeap {
    //建大根堆
    public static void creatBigHeap(int[] array,int size){
        Adjust adjust = new Adjust();
        for (int i = (size - 2) / 2;i >= 0;i--){
            adjust.shiftDownBig(array,size,i);
        }
    }
    //建小根堆
    public static void creatSmallHeap(int[] array,int size){
        Adjust adjust = new Adjust();
        for (int i = (size - 2) / 2;i >= 0;i--){
            adjust.shiftDownSmall(array,size,i);
        }
    }
    public static void main(String[] args) {
        int[] t = new int[10];
        Random random = new Random(1997);
        for (int i = 0;i < 10;i++){
            t[i] = random.nextInt(20);
        }
        System.out.println(Arrays.toString(t));
        creatBigHeap(t,t.length);
        System.out.println(Arrays.toString(t));
        creatSmallHeap(t,t.length);
        System.out.println(Arrays.toString(t));
    }
}
