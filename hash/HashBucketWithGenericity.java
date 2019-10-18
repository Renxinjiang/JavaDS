package hash;

import java.util.Objects;

/**
 * @PackageName: hash
 * @ClassName: HashBucketWithGenericity
 * @Description:
 * 泛型实现哈希表
 * @author: 呆呆
 * @date: 2019/10/18
 */
class Person{
    String sn;  // 学号，学号相同就是同一个人
    Person(String sn){
        this.sn = sn;
    }

    //覆写hashCode和equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(sn, person.sn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sn);
    }
}
public class HashBucketWithGenericity<K,V> {
    private static class Node<K,V>{
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private Node<K,V> next = null;

    }
    // 泛型不能定义数组,需要强转
    private Node<K,V>[] array = (Node<K,V>[])new Node[8];
    private int size;
    private static final double LOAD_FACTOR = 0.75; // 规定负载因子的阈值

    //计算负载因子
    private double loadFactor(){
        return size * 1.0 / array.length;
    }

    public V get(K key){
        // 1.key => int
        //Java中的规定
        // Object有一个方法hashCode（），任意key用来转换成int类型
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> head = array[index];
        for (Node<K,V> cur = head;cur != null;cur = cur.next){
            //引用类型判断是否相等
            if (key.equals(cur.key)){
                return cur.value;
            }
        }
        return null;
    }
    public V put(K key,V value){
        int hash = key.hashCode();
        int index = hash % array.length;

        Node<K,V> head = array[index];
        for (Node<K,V> cur = head;cur != null;cur = cur.next){
            if (key.equals(cur.key)){
                V oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
        }
        //头插
        Node<K,V> node = new Node<K,V>(key,value);
        node.next = array[index];
        array[index] = node;
        size++;

        // 此处负载因子可能大于一个阈值
        if (loadFactor() >= LOAD_FACTOR){
            resize();
        }
        return null;
    }

    private void resize() {
        Node<K,V>[] newArray = (Node<K,V>[])new Node[array.length * 2];
        for (int i = 0; i < array.length;i++){
            Node<K,V> next;
            for (Node<K,V> cur = array[i];cur != null;cur = next){
                next = cur.next;
                // 进行重新哈希
                int hash = cur.key.hashCode();
                int index = hash % newArray.length;
                // 拿着cur做头插到新数组中的合适位置
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        array = newArray;
    }

    public V remove(K key){
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> head = array[index];
        if (head != null & key == head.key){
            array[index] = array[index].next;
            return head.value;
        }
        Node<K,V> prev = null;
        for (Node<K,V> cur = head;cur != null;cur = cur.next){
            //引用类型判断是否相等
            if (key.equals(cur.key)){
                prev.next = cur.next;
                return cur.value;
            }
            prev = cur;
        }
        return null;
    }

}
