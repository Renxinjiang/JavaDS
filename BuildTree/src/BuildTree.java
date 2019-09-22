import java.util.Arrays;
import java.util.List;

public class BuildTree {
    //前序中序构建二叉树
    //思路：
    //1.找到前序第一个结点为根结点
    //2.找到中序里对应前序根结点的下标leftCount，该下标值是左子树结点个数
    //3.前序中左子树为[1，leftCount+1]
    //  中序中左子树为[0，leftCount]
    //4.前序中右子树为[leftCount+1,前序.length]
    //  中序中右子树为[leftCount+1,中序.length]
    //5.递归左子树构造二叉树
    //6.递归右子树构造二叉树
    public Node buildTree1(char[] preorder, char[] inorder) {
        if (preorder.length == 0){
            return null;
        }
        char rootVal = preorder[0];
        int leftCount;
        for (leftCount = 0;leftCount < inorder.length;leftCount++){
            if (inorder[leftCount] == rootVal){
                break;
            }
        }
        Node root = new Node(rootVal);
        char[] leftPreorder = Arrays.copyOfRange(preorder,1,leftCount+1);
        char[] leftInorder = Arrays.copyOfRange(inorder,0,leftCount);

        char[] rightPreorder = Arrays.copyOfRange(preorder,leftCount+1,preorder.length);
        char[] rightInorder = Arrays.copyOfRange(inorder,leftCount+1,inorder.length);

        root.left = buildTree1(leftPreorder,leftInorder);
        root.right = buildTree1(rightPreorder,rightInorder);
        return root;
    }

    //后序中序构建二叉树
    //思路：
    //1.找到后序最后一个结点为根结点
    //2.找到中序里对应后序根结点的下标leftCount，该下标值是左子树结点个数
    //3.后序中左子树为[0，leftCount]
    //  中序中左子树为[0，leftCount]
    //4.后序中右子树为[leftCount,后序.length-1]
    //  中序中右子树为[leftCount+1,中序.length]
    //5.递归左子树构造二叉树
    //6.递归右子树构造二叉树
    public Node buildTree2(char[] postorder, char[] inorder) {
        if (postorder.length == 0){
            return null;
        }
        char rootVal = postorder[postorder.length - 1];
        int leftCount;
        for (leftCount = 0;leftCount < inorder.length;leftCount++){
            if (inorder[leftCount] == rootVal){
                break;
            }
        }
        Node root = new Node(rootVal);
        char[] leftPostorder = Arrays.copyOfRange(postorder,0,leftCount);
        char[] leftInorder = Arrays.copyOfRange(inorder,0,leftCount);

        char[] rightPostorder = Arrays.copyOfRange(postorder,leftCount,postorder.length-1);
        char[] rightInorder = Arrays.copyOfRange(inorder,leftCount+1,inorder.length);

        root.left = buildTree2(leftPostorder,leftInorder);
        root.right = buildTree2(rightPostorder,rightInorder);
        return root;
    }

    //根据包含空结点的前序字符串构造二叉树---方法1
    //1.创建一个空结点
    //2.只要第i个字符不是#重复以下步骤
    //  2.1将第一个i的结点作为根结点放入二叉树
    //  2.2i++
    //  2.3左子树递归构建，右子树递归构建
    //3.第i个值若为#，i++
    public static int i = 0;
    public  Node buildTree3(String s){
        Node root = null;
        if (s.charAt(i) != '#'){
            root = new Node(s.charAt(i));
            i++;
            root.left = buildTree3(s);
            root.right = buildTree3(s);
        }else{
            i++;
        }
        return root;
    }

    //根据包含空结点的前序字符串构造二叉树---方法2
    //在创建树的过程中，会得到用掉了多少个结点
    //要返回两个值，所以写一个包装类
    //1.左子树是从原字符串上截取下标[1,前序.size()]递归构建
    //2.右子树是从原字符串上截取下标[1+leftReturn.used,前序.size()]递归构建
    //3.递归出口：rootVal = '#'和preorder.size() == 0;
    public static class BTRV{
        public Node root;
        private int used;
    }
    public BTRV buildTree4(List<Character> preorder){
        BTRV returnVal = new BTRV();
        if (preorder.size() == 0){
            returnVal.root = null;
            returnVal.used = 0;
            return returnVal;
        }
        char rootVal = preorder.get(0);
        if (rootVal == '#'){
            returnVal.root = null;
            returnVal.used = 1;
            return returnVal;
        }
        BTRV leftReturn = buildTree4(preorder.subList(1,preorder.size()));
        BTRV rightReturn = buildTree4(preorder.subList(1+leftReturn.used,preorder.size()));
        Node root = new Node(rootVal);
        root.left = leftReturn.root;
        root.right = rightReturn.root;
        returnVal.root = root;
        returnVal.used = 1+leftReturn.used+rightReturn.used;
        return returnVal;
    }

}
