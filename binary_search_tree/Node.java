package binary_search_tree;

/**
 * @PackageName: binary_search_tree
 * @ClassName: Node
 * @Description:
 * @author: 呆呆
 * @date: 2019/10/8
 */
public class Node {
    int key;
    Node left;
    Node right;
    Node(int val){
        this.key = val;
        this.left = null;
        this.right = null;
    }
}
