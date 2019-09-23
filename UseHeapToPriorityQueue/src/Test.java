public class Test {
    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(7);
        queue.offer(9);
        queue.offer(5);
        System.out.println(queue.poll()); //5
        queue.offer(3);
        System.out.println(queue.poll());//3
        queue.offer(1);
        System.out.println(queue.poll());//1
        System.out.println(queue.peek());//7
        System.out.println(queue.poll());//7
    }
}
