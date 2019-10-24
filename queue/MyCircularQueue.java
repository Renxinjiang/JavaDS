package queue;

/**
 * @PackageName: queue
 * @ClassName: MyCircularQueue
 * @Description:
 * 循环队列
 * 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。
 * 它也被称为“环形缓冲器”。
 *
 *  MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * 	Front: 从队首获取元素。如果队列为空，返回 -1 。
 * 	Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * 	enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * 	deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * 	isEmpty(): 检查循环队列是否为空。
 * 	isFull(): 检查循环队列是否已满。
 *
 * @author: 呆呆
 * @date: 2019/10/24
 */
public class MyCircularQueue {
    private int[] array;
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        array = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (!isFull()){
            array[rear] = value;
            size++;
            rear = (rear+1) % array.length;
            return true;
        }
        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (!isEmpty()){
            size--;
            front = (front+1) % array.length;
            return true;
        }
        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (!isEmpty()){
            return array[front];
        }
        return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (!isEmpty()){
            if(rear!=0){
                return array[rear-1];
            } else {
                return array[array.length - 1];
            }
        }
        return -1;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == array.length;
    }
}
