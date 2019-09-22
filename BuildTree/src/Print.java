public class Print {
    public static void binaryTreePrevOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.val + " ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.right);
    }
    //递归中序遍历：左子树+根+右子树
    public static void binaryTreeInOrder(Node root){
        if (root == null) {
            return;
        }
        binaryTreeInOrder(root.left);
        System.out.print(root.val + " ");
        binaryTreeInOrder(root.right);
    }
    //递归后序遍历：左子树+右子树+根
    public static void binaryTreePostOrder(Node root){
        if (root == null) {
            return;
        }
        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
        System.out.print(root.val + " ");
    }

}
