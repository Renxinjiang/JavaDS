/*
我的顺序表
有增、删、查、改、打印、扩容的功能
*/

public class MyArrayList{
    //定义属性
    private int[] array;
    private int size;
    //构造方法初始化
    public MyArrayList(){
        array = new int[2] ;
        size = 0;
    }
    //扩容
    public void ensureCapacity(){
        if(size < array.length){
            return;
        }
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        for(int i = 0;i< size;i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }
    //增
    public void pushBack(int element){
        ensureCapacity();
        array[size] = element;
        size++;
    }
    //删（从顺序表后面删除）
    public void popBack(){
        if(size <= 0){
            System.out.println("顺序表为空");
            return;
        }
        array[--size] = 0;
    }
    //删（从顺序表前面删除）
    public void popFront(){
        if(size <= 0){
            System.out.println("顺序表为空");
            return;
        }
        for(int i = 0; i < size-1; i++){
            array[i] = array[i+1];
        }
        array[--size] = 0;
    }
    //删（删除指定下标处元素）
    public void earse(int index){
        if(size <= 0){
            System.out.println("顺序表为空");
            return;
        }
        if(size < index || index < 0){
            System.out.println("下标不合法");
            return;
        }
        for(int i = index; i < size - 1; i++){
            array[i] = array[i+1];
        }
        array[--size] = 0;
    }
    //查（按照下标查找）
    public int search1(int index){
        if(size <= 0){
            System.out.println("顺序表为空");
            return -1;
        }
        if(size < index || index < 0){
            System.out.println("下标不合法");
            return -1;
        }
        return array[index];
    }
    //查（按照元素查找，若有多个，返回第一个的下标）
    public int search2(int element){
        for(int i = 0; i < size-1; i++){
            if(array[i] == element){
                return i;
            }
        }
        return -1;
    }
    //改（将指定下标处元素改为某值）
    public void change(int index,int element){
        if(size <= 0){
            System.out.println("顺序表为空");
            return;
        }
        if(size < index || index < 0){
            System.out.println("下标不合法");
            return;
        }
        array[index] = element;
    }
    //打印
    public void print(){
        System.out.println("打印顺序表：当前容量："+array.length);
        for(int i = 0;i < size;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println( );
    }
    public static void main(String[] args){
        MyArrayList list = new MyArrayList();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(5);
        list.pushBack(6);
        list.print();   //123456
        list.popBack();
        list.print();   //12345
        list.popFront();
        list.print();   //2345
        list.earse(1);
        list.print();   //245
        System.out.println(list.search1(1));   //4
        System.out.println(list.search2(2));   //0
        System.out.println(list.search2(6));   //-1
        list.change(0,6);
        list.print();   //645
    }
}