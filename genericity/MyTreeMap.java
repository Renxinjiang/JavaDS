package genericity;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

/**
 * @PackageName: genericity
 * @ClassName: MyTreeMap
 * @Description:
 * 泛型类型的搜索树
 * @author: 呆呆
 * @date: 2019/10/16
 */
public class MyTreeMap<K,V> implements Map<K,V> {
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        //未实现
        return false;
    }

    @Override
    public V get(Object key) {
        K k = (K)key;
        Node<K,V> cur = root;
        //如果使用自定义类型作为TreeMap的K类型
        //1.要不自定义类型是Comparable
        //2.否则，需要在构造方法中传入一个比较器
        int r;
        while (cur != null){
            if (comparator != null){
                r = comparator.compare(k,cur.key);
            }else{
                Comparable<K> comparable = (Comparable<K>)key;
                r = comparable.compareTo(cur.key);
            }
            if (r == 0){
                return cur.value;
            }else if (r < 0){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (root == null){
            root = new Node<>(key,value);
            size++;
            return null;
        }
        Node<K,V> parent = null;
        Node<K,V> cur = root;

        int r;
        while (cur != null){
            if (comparator != null){
                r = comparator.compare(key,cur.key);
            }else{
                Comparable<K> comparable = (Comparable<K>)key;
                r = comparable.compareTo(cur.key);
            }
            if (r == 0){
                V oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }else if (r < 0){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        if (cur == parent.left){
            parent.left = new Node<>(key,value);
        }else {
            parent.right = new Node<>(key,value);
        }
        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    private static class Node<K,V> implements Map.Entry<K,V>{
        private K key;
        private V value;
        private Node<K,V> left;
        private Node<K,V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    private Node<K,V> root = null;
    private int size = 0;
    private Comparator<K> comparator = null;
    public MyTreeMap(){

    }
    public MyTreeMap(Comparator<K> comparator){
        this.comparator = comparator;
    }
}
