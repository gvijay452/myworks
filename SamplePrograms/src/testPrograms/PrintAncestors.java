package testPrograms;

public class PrintAncestors {
	public static class Node<T> {
		public T data;
		public Node<T> left, right;

		public Node(T data) {
			this.data = data;
			this.left = this.right = null;
		}

	}

	public static boolean printAncestors(Node<Integer> node, int target) {
		if (node == null)
			return false;
		if (node.data == target)
			return true;

		if (printAncestors(node.left, target)
				|| printAncestors(node.right, target)) {
			System.out.print(node.data + " ");
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		root.left = new Node<Integer>(2);
		root.right = new Node<Integer>(3);
		root.left.left = new Node<Integer>(4);
		root.left.right = new Node<Integer>(5);
		root.left.left.left = new Node<Integer>(7);
		printAncestors(root, 7);
	}

}
