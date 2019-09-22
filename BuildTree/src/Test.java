import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        char[] pre = {'1','2','4','5','3','6'};
        char[] in = {'4', '2', '5', '1', '6', '3'};
        char[] post = {'4', '5', '2', '6', '3', '1'};

        Print print = new Print();
        BuildTree tree = new BuildTree();
        print.binaryTreePrevOrder(tree.buildTree1(pre, in));
        System.out.println();
        print.binaryTreeInOrder(tree.buildTree1(pre, in));
        System.out.println();
        print.binaryTreePostOrder(tree.buildTree1(pre, in));
        System.out.println();
        System.out.println("===========================");
        print.binaryTreePrevOrder(tree.buildTree2(post, in));
        System.out.println();
        print.binaryTreeInOrder(tree.buildTree2(post, in));
        System.out.println();
        print.binaryTreePostOrder(tree.buildTree2(post, in));
        System.out.println();
        String s = "124##5##36###";
        System.out.println();
        System.out.println("===========================");
        Node node = tree.buildTree3(s);
        print.binaryTreePrevOrder(node);
        System.out.println();
        print.binaryTreeInOrder(node);
        System.out.println();
        print.binaryTreePostOrder(node);
        System.out.println();
        System.out.println("===========================");

        List<Character> c = new ArrayList<>();
        c.add('1');
        c.add('2');
        c.add('4');
        c.add('#');
        c.add('#');
        c.add('5');
        c.add('#');
        c.add('#');
        c.add('3');
        c.add('6');
        c.add('#');
        c.add('#');
        c.add('#');
        print.binaryTreePrevOrder(tree.buildTree4(c).root);
        System.out.println();
        print.binaryTreeInOrder(tree.buildTree4(c).root);
        System.out.println();
        print.binaryTreePostOrder(tree.buildTree4(c).root);
    }
    public void levelOrder(Node root){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node front = queue.poll();
            if (front.left != null){
                queue.offer(front.left);
            }
            if (front.right != null){
                queue.offer(front.right);
            }
        }
    }
}
