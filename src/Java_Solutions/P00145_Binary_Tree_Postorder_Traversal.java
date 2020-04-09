import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P00145_Binary_Tree_Postorder_Traversal {
    public static void main(String[] args) {
        P00145_Binary_Tree_Postorder_Traversal solution = new P00145_Binary_Tree_Postorder_Traversal();
        TreeNode root = solution.buildTree();
        List<Integer> postOrderList = solution.postorderTraversal(root);
        System.out.println(postOrderList);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrderList =  new ArrayList<>();
        if(root == null){
            return postOrderList;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            
        }

        return postOrderList;
    }

    private TreeNode buildTree(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
