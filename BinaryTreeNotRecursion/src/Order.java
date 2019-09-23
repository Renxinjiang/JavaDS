import java.util.Stack;

public class Order {
    //主要思想：用栈实现非递归
    public static void preOrder(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                System.out.print(cur.val+" ");
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    }

    public static void inOrder(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.print(top.val+" ");
            cur = top.right;
        }
    }

    //后序非递归top在哪，栈中存的是从根到top的一条完整路径
    public static void postOrder(Node root){
        //后序出栈应该为：top.right == null;右子树为空
        //要知道peek的值是遍历完左子树还是右子树得到的：找一个last（上一次遍历完的结点）做记录，last = top
        //因此出栈的第二个条件为 top.right == last;遍历完右子树之后
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node last = null;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.peek();
            if (top.right == null || top.right == last){
                System.out.println(top.val);
                stack.pop();
                last = top;
            }else{
                cur = top.right;
            }
        }
    }
}
