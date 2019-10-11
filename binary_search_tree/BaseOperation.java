package binary_search_tree;

/**
 * @PackageName: binary_search_tree
 * @ClassName: BaseOperation
 * @Description:
 * 二叉搜索树的查找、插入、删除
 * @author: 呆呆
 * @date: 2019/10/8
 */
public class BaseOperation {

    private Node root = null;

    //查找
    public Node search(int key){
        Node cur = root;
        while (cur != null){
            if (key == cur.key){
                return cur;
            }else if (key < cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return null;
    }

    //插入
    public boolean insert(int key){
        Node node = new Node(key);
        //树为空，单独处理
        if (root == null){
            root = node;
            return true;
        }
        Node cur = root;
        Node parent = null;
        //找parent
        while (cur != null){
            if (key == cur.key){
                return false;
            }else if (key < cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        if (key < parent.key){
            parent.left = node;
        }else{
            parent.right = node;
        }
        return true;
    }

    //删除
    /**
     * 设待删除结点为 cur, 待删除结点的双亲结点为 parent
     * 1. cur.left == null
     *    1)cur 是 root，则 root = cur.right
     *    2)cur 不是 root，cur 是 parent.left，则 parent.left = cur.right
     *    3)cur 不是 root，cur 是 parent.right，则 parent.right = cur.right
     * 2. cur.right == null
     *    1)cur 是 root，则 root = cur.left
     *    2)cur 不是 root，cur 是 parent.left，则 parent.left = cur.left
     *    3)cur 不是 root，cur 是 parent.right，则 parent.right = cur.left
     * 3. cur.left != null && cur.right != null
     *    1)需要使用替换法进行删除，即在它的右子树中寻找中序下的第一个结点(关键码最小)，
     *    用它的值填补到被删除节点中，再来处理该结点的删除问题
     */
    public boolean remove(int key){
        Node cur = root;
        Node parent = null;
        while (cur != null){
            if (key == cur.key){
                //准备删除
                removeNode(parent,cur);
                return true;
            }else if (key < cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        return false;
    }
    private void removeNode(Node parent, Node cur) {
        if (cur.left == null){
            if (cur == root){
                root = cur.right;
            }else if (cur == parent.left){
                parent.left = cur.right;
            }else if (cur == parent.right){
                parent.right = cur.right;
            }
        }else if (cur.right == null){
            if (cur == root){
                root = cur.left;
            }else if (cur == parent.left){
                parent.left = cur.left;
            }else  if (cur == parent.right){
                parent.right = cur.left;
            }
        }else {
            Node goatParent = cur;
            Node goat = cur.right;
            while (goat != null){
                goatParent = goat;
                goat = goat.left;
            }
            //用goat的值代替要删除的结点的值
            cur.key = goat.key;
            //删除goat结点
            if (goat == goatParent.left){
                goatParent.left = goat.right;
            }else if (goat == goatParent.right){
                goatParent.right = goat.right;
            }
        }
    }

    //测试
    public static void main(String[] args) {
        // 1.创建搜索树
        // 2.随机插入一些数据
        // 3.打印前序、中序遍历
        // 4.查找
        BaseOperation tree = new BaseOperation();
        int[] array = {3,6,7,9,2,4,5,8,1};
        //通过插入的方式建树
        for (int k : array){
            System.out.println(tree.insert(k));
        }
        System.out.print("插入重复数据:");
        System.out.println(tree.insert(7));

        //前序、中序遍历树
        preOrder(tree.root);
        System.out.println();
        inOrder(tree.root);
        System.out.println();
        //查找
        System.out.println(tree.search(7).key);
        System.out.println(tree.search(8).key);
        System.out.println(tree.search(10));

        //删除
        System.out.println(tree.remove(7));
        System.out.println(tree.search(7));

    }

    private static void inOrder(Node node) {
        if (node != null){
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    private static void preOrder(Node node) {
        if (node != null){
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

}
