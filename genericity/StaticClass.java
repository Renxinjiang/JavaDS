package genericity;

/**
 * @PackageName: genericity
 * @ClassName: StaticClass
 * @Description:
 * 加入静态内部类的示例
 * 静态内部类需要定义自己的泛型类型形参列表，
 * 此处的泛型类型形参列表与外部类的不是同一个，
 * 实例化对象时，String类型先传给Node，即MyLinkedList类变成String类型，再传给静态内部类。
 * @author: 呆呆
 * @date: 2019/10/16
 */
class MyLinkedList<E>{
    public static class Node<E> {
        private E value;
        private Node<E> next;
        private Node(E e) {
            value = e;
            next = null;
        }
    }
    private Node<E> head;
    private int size;
    public MyLinkedList() {
        head = null;
        size = 0;
    }
}
public class StaticClass {
    public static void main(String[] args) {
        MyLinkedList<String> l;
    }
}
