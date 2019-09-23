public class MyPriorityQueue {
    //入队：尾插到大根堆或小根堆中，然后向上调整

    //出队：为了防止破坏堆的结构，删除时并不是直接将堆顶元素删除，
    // 而是用数组的最后一个元素替换堆顶元素，然后通过向下调整方式重新调整成堆

    private int[] array = new int[5];
    private int size = 0;
    Adjust adjust = new Adjust();

    //入队
    public void offer(int element){
        array = ensureCapacity(size,array);
        array[size] = element;
        size++;
        adjust.shiftUpSmall(array,size - 1);//或 adjust.shiftUpBig(array,size - 1);
    }

    //出队
    public int poll(){
        int oldeVal = array[0];
        array[0] = array[size - 1];
        size--;
        adjust.shiftDownSmall(array,size,0);//adjust.shiftDownBig(array,size,0);
        return oldeVal;
    }

    //取队头元素
    public int peek(){
        return array[0];
    }

    //为保证数组容量够用，需要考虑到扩容
    private int[] ensureCapacity(int size,int[] array) {
       if (size < array.length){
           return array;
       }
       int newCapacity = array.length * 2;
       int[] newArray = new int[newCapacity];
       for (int i = 0;i < size;i++){
           newArray[i] = array[i];
       }
       return newArray;
    }
}
