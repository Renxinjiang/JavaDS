package binary_search_tree;

/**
 * @PackageName: binary_search_tree
 * @ClassName: Contact
 * @Description:
 * 电话本
 * 可以插入联系人和其电话
 * 可以更新联系人的电话
 * 可以根据联系人姓名查找联系人电话
 * 可以删除联系人
 * @author: 呆呆
 * @date: 2019/10/11
 */
public class Contact {
    public static class Node{
        String name;
        String phone;

        Node left;
        Node right;

        public Node(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }

    private Node root = null;

    public boolean insert(String name,String phone){
        Node node = new Node(name,phone);
        if (root == null){
            root = node;
            return true;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null){
            int r = name.compareTo(cur.name);
            if (r == 0){
                return false;
            }else if (r < 0){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
            int c = name.compareTo(parent.name);
            if (c < 0){
                parent.left = node;
            }else{
                parent.right = node;
            }
        }
        return true;
    }

    public boolean update(String name,String phone){
        Node cur = root;
        while (cur != null){
            int r = name.compareTo(cur.name);
            if (r == 0){
                cur.phone = phone;
                return true;
            }else if (r < 0){
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return false;
    }

    public String serch(String name){
        Node cur = root;
        while (cur != null){
            int r = name.compareTo(cur.name);
            if (r == 0){
                return cur.name;
            }else if (r < 0){
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return null;
    }
}
