package hash;

import java.util.HashMap;

/**
 * @PackageName: hash
 * @ClassName: HashBucket
 * @Description:
 * 哈希表的实现
 * @author: 呆呆
 * @date: 2019/10/13
 */
public class HashBucket {
    //key-value模型
    private static class Node{
        private int key;
        private int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node[] array;
    private int size;       //当前数据个数，可以用来计算负载因子
    private static final double LOAD_FACTOR = 0.75; // 规定负载因子的阈值

    //计算负载因子
    private double loadFactor(){
        return size * 1.0 / array.length;
    }

    //构造方法
    public HashBucket(){
        array = new Node[8];
        size = 0;
    }
    // 时间复杂度O(1)，我们认为链表比较小，故链表遍历也是O(1)
    public  int get(int key){
        //1.key => int类型
        //2.int类型 => 合法下标
        int index = key % array.length;
        // 3.根据下标明确找到一个链表，可能空可能不空，在链表中查找key和cur.key相等位置的结点
        Node head = array[index];
        for (Node cur = head;cur != null;cur = cur.next){
            if (key == cur.key){
                return cur.value;
            }
        }
        return -1;
    }
    // 时间复杂度O(1)，我们认为链表比较小，故链表遍历也是O(1)
    public int put(int key,int value){
        //1.key => int类型
        //2.int类型 => 合法下标
        int index = key % array.length;
        //3.在链表中查找key所在的结点
        //  如果找到了，更新
        //  所有结点都不是key，插入一个新的结点
        for (Node cur = array[index];cur != null;cur = cur.next){
            if (key == cur.key){
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
        }
        //头插(比尾插方便)
        Node node = new Node(key,value);
        node.next = array[index];
        array[index] = node;
        size++;
        // 此处负载因子可能大于一个阈值
        if (loadFactor() >= LOAD_FACTOR){
            resize();
        }
        return -1;
    }

    //负载因子大于阈值时，数组扩容
    // 随着扩容的发生，key经过哈希得到的下标会发生
    // 所以要遍历哈希表中的所有数据，重新哈希放入新数组
    // 遍历旧哈希表有两重循环，外循环遍历数组内循环遍历链表
    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length;i++){
            Node next;
            for (Node cur = array[i];cur != null;cur = next){
                next = cur.next;
                // 进行重新哈希
                int index = cur.key % newArray.length;
                // 拿着cur做头插到新数组中的合适位置
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        array = newArray;
    }


}

