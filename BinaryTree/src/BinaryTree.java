import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class BinaryTree {
    //定义一个内部类为结点类
    private static class Node{
        private char val;
        private Node left;
        private Node right;
        public Node(char val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return String.format("%c",val);
        }
    }

    //根据字符串创建一个二叉树
    public static int i = 0;
    public static Node createTestTree(String s){
        Node root = null;
        if (s.charAt(i) != '#'){
            root = new Node(s.charAt(i));
            i++;
            root.left = createTestTree(s);
            root.right = createTestTree(s);
        }else{
            i++;
        }
        return root;
    }
    //递归前序遍历：根+左子树+右子树
    public static void binaryTreePrevOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root + " ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.right);
    }
    //递归中序遍历：左子树+根+右子树
    public static void binaryTreeInOrder(Node root){
        if (root == null) {
            return;
        }
        binaryTreeInOrder(root.left);
        System.out.print(root + " ");
        binaryTreeInOrder(root.right);
    }
    //递归后序遍历：左子树+右子树+根
    public static void binaryTreePostOrder(Node root){
        if (root == null) {
            return;
        }
        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
        System.out.print(root + " ");
    }

    //求二叉树结点个数
    private static int count = 0;
    public static void getSize(Node root){
        if (root == null){
            return;
        }
        count++;
        getSize(root.left);
        getSize(root.right);
    }

    public static int getSize2(Node root){
        if (root == null){
            return 0;
        }
        int left = getSize2(root.left);
        int right = getSize2(root.right);
        return left + right+1;
    }

    //求叶子结点个数
    private static int leafSize = 0;
    private static void getLeafSize(Node root){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize(root.left);
        getLeafSize(root.right);
    }

    private static int getLeafSize2(Node root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int left = getLeafSize2(root.left);
        int right = getLeafSize2(root.right);
        return left + right;
    }

    //求二叉树的高
    private static int getHigh(Node root){
        if (root == null){
            return 0;
        }
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        return Math.max(left,right) + 1;
    }

    //求第k层结点的个数
    public static int getKLevel(Node root, int k){
        if (root == null){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        return getKLevel(root.left,k-1) + getKLevel(root.right,k-1);
    }
    public static void main(String[] args) {
        Node root = createTestTree("ABD##E##C##");
        binaryTreePrevOrder(root);//ABDEC
        System.out.println();
        binaryTreeInOrder(root);//DBEAC
        System.out.println();
        binaryTreePostOrder(root);//DEBCA
        System.out.println();
        getSize(root);
        System.out.println("结点个数：" + count);
        System.out.println("结点个数：" + getSize2(root));
        getLeafSize(root);
        System.out.println("叶子结点个数：" + leafSize);
        System.out.println("叶子结点个数：" + getLeafSize2(root));
        System.out.println("二叉树的高：" + getHigh(root));
        System.out.println("第2层结点个数：" + getKLevel(root,2));
    }
}
