package leetcode;

import java.util.*;

public class P00144_Binary_Tree_Preorder_Traversal {
    public static void main(String[] args) {
        P00144_Binary_Tree_Preorder_Traversal solution = new P00144_Binary_Tree_Preorder_Traversal();
        Integer[] input = {1, null, 2, null, null,3};
        TreeNode root = solution.buildTree(input);
        solution.printTree(root);
        List<Integer> preOrderList = solution.preorderTraversal(root);
        System.out.println(preOrderList);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> preOrderList = new ArrayList<>();

      if(root == null){
          return preOrderList;
      }
      Deque<TreeNode> stack = new ArrayDeque<>();
      stack.push(root);
      while (!stack.isEmpty()){
          TreeNode node = stack.pop();
          preOrderList.add(node.val);
          if(node.right != null){
              stack.push(node.right);
          }
          if(node.left != null){
              stack.push(node.left);
          }
      }
        return preOrderList;
    }

    public void printTree(TreeNode root) {
        printTreeUtil(root, 0);
    }

    public static void printTreeUtil(TreeNode root, int space) {
        if (root == null) {
            return;
        }
        space += 10;
        printTreeUtil(root.right, space);
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(root.val + "\n");
        printTreeUtil(root.left, space);
    }

    public TreeNode buildTree(Integer[] input) {
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.put(i,  input[i] != null ? new TreeNode(input[i]) : null);
        }
        for (int i = 0; i < input.length / 2; i++) {
            TreeNode node = map.get(i);
            if(node != null) {
                int leftChild = (2 * i) + 1;
                int rightChild = (2 * i) + 2;
                node.left = map.get(leftChild);
                node.right = map.get(rightChild);
            }
        }
        return map.get(0);
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
