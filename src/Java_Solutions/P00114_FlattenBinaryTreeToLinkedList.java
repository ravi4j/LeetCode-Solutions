import java.util.Stack;

class P00114_FlattenBinaryTreeToLinkedList {
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.left.left = new TreeNode(3);
		tree.left.right = new TreeNode(4);
		tree.right = new TreeNode(5);
		tree.right.right = new TreeNode(6);
		printTree(tree);
		flatten(tree);
		printTree(tree);
	}

	public static void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null || !stack.empty()) {
			if (p.right != null) {
				stack.push(p.right);
			}

			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.empty()) {
				TreeNode temp = stack.pop();
				p.right = temp;
			}
			p = p.right;
		}
	}

	public static void printTree(TreeNode root) {
		printTreeUtil(root , 0);
	}

	public static void printTreeUtil(TreeNode root , int space) {
		if (root == null) {
			return;
		}
		space += 10;
		printTreeUtil(root.right ,space);
		System.out.print("\n");
		for (int i = 10; i < space; i++)
			System.out.print(" ");
		System.out.print(root.val + "\n");
		printTreeUtil(root.left ,space);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}


