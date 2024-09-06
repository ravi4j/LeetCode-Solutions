package leetcode;

class P00117_Populating_Next_Right_Pointers_In_Each_Node2 {
	public static void main(String[] args) {
		Node root = new Node(1, null, null, null);
		root.left = new Node(2, null, null, null);
		root.right = new Node(3, null, null, null);
		root.left.left = new Node(4, null, null, null);
		root.left.right = new Node(5, null, null, null);
		root.right.left = new Node(6, null, null, null);
		root.right.right = new Node(7, null, null, null);
		root.left.left.left = new Node(8, null, null, null);
		root.left.left.right = new Node(9, null, null, null);
		root.right.right.left = new Node(10, null, null, null);
		root.right.right.right = new Node(11, null, null, null);
		printTree(root);
		connect(root);
		printTree(root);
	}

	public static void printTree(Node root) {
		printTreeUtil(root, 0);
	}

	public static Node connect(Node root) {
		if (root == null) {
			return null;
		}
		root.next = null;
		connectRecur(root);
		return root;
	}

	public static void connectRecur(Node root) {
		if (root == null) {
			return;
		}
		Node p = root.next;
		while (p != null) {
			if (p.left != null) {
				p = p.left;
				break;
			}
			if (p.right != null) {
				p = p.right;
				break;
			}
			p = p.next;
		}

		if (root.right != null) {
			root.right.next = p;
		}

		if (root.left != null) {
			if (root.right != null) {
				root.left.next = root.right;
			} else {
				root.left.next = p;
			}
		}
		connectRecur(root.right);
		connectRecur(root.left);
	}

	public static void printTreeUtil(Node root, int space) {
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

	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};
}

