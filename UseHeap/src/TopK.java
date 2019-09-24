public class TopK {
    public static void topK(int[]array,int k){
        BuildHeap buildHeap = new BuildHeap();
        Adjust adjust = new Adjust();
        buildHeap.creatSmallHeap(array,k);

        for (int i = k+1;i < array.length;i++){
            int front = array[0];
            if (array[i] > front){
                adjust.swap(array,i,0);
                adjust.shiftDownSmall(array,k,0);
            }
        }
        for (int i = 0;i < k;i++){
            System.out.print(array[i]+"  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {19,15,12,14,55,66,34,89,10};
        topK(a,3);
    }
}
