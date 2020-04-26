package challenge.april2020;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
      /*  TreeNode root = solution.buildTree();
        int diameter = solution.diameterOfBinaryTree(root);
        System.out.println(diameter); */

        TreeNode root1 = solution.buildTree2();
        int diameter1 = solution.diameterOfBinaryTree(root1);
        System.out.println(diameter1);
    }

    private TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }

    private TreeNode buildTree2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        return root;
    }

   /* public int diameterOfBinaryTree(TreeNode root) {
        if (root != null) {
            // get the left and right subtree height
            int leftH = getHeight(root.left);
            int rightH = getHeight(root.right);

            // get the left diameter and right diameter recursively.
            int leftDiameter = diameterOfBinaryTree(root.left);
            int rightDiameter = diameterOfBinaryTree(root.right);

            // get the max leftsubtree, rightsubtree, longest path goes through
            // root.
            return getMax(leftH + rightH + 1, leftDiameter, rightDiameter) ;
        }
        return 0;
    } */

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return diameterOfBinaryTreeHelper(root)[1] - 1;
    }

    public int[] diameterOfBinaryTreeHelper(TreeNode root) {
        int[] hAndD = new int[]{0, 0};
        if (root == null) {
            return hAndD;
        }

        int[] leftResult = diameterOfBinaryTreeHelper(root.left);
        int[] rightResult = diameterOfBinaryTreeHelper(root.right);

        int height = Math.max(leftResult[0], rightResult[0]) + 1;
        int leftDiameter = leftResult[1];
        int rightDiameter = rightResult[1];
        int rootDiameter = leftResult[0] + rightResult[0] + 1;
        int finalDiameter = Math.max(leftDiameter, Math.max(rightDiameter, rootDiameter));

        hAndD[0] = height;
        hAndD[1] = finalDiameter;
        return hAndD;
    }

    public int getHeight(TreeNode root) {
        if (root != null) {
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
        return 0;
    }

    public int getMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
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
