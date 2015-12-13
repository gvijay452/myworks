package testPrograms;

public class RandomListClone {

	public static class Node<T> {
		public T data;
		public Node<T> arbitrary, next;

		public Node(T data) {
			this.data = data;
			this.arbitrary = this.next = null;
		}

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return "[prev=" + getNullOrValue(this.arbitrary) + "][data="
					+ getNullOrValue(this) + "][next="
					+ getNullOrValue(this.next) + "]";
		}

		private String getNullOrValue(Node<T> node) {
			return (node != null && node.data != null ? node.data : "null")
					.toString();
		}
	}

	public static Node<Integer> cloneList(Node<Integer> root) {
		Node<Integer> head = root;
		while (head != null) {
			head.next = new Node<Integer>(head.data, head.next);
			head = head.next.next;
		}
		head = root;
		while (head != null) {
			head.next.arbitrary = head.arbitrary.next;
			head = head.next.next;
		}

		Node<Integer> copy = root.next;
		Node<Integer> copyTemp = copy;
		head = root;
		while (head != null) {
			head.next = head.next.next;
			if (copyTemp.next != null)
				copyTemp.next = copyTemp.next.next;
			head = head.next;
			copyTemp = copyTemp.next;
		}
		return copy;
	}

	public static void printList(Node<Integer> root) {
		System.out.println("\n");
		Node<Integer> head = root;
		while (head != null) {
			System.out.print(head);
			head = head.next;
			if (head != null) {
				System.out.print("-->");
			}
		}
	}

	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		node1.arbitrary = node3;
		node2.arbitrary = node4;
		node3.arbitrary = node1;
		node4.arbitrary = node2;

		node4.next = null;

		Node<Integer> head = node1;
		printList(head);
		head = cloneList(node1);
		System.out.println("\n---- Cloned Linked List ----");
		printList(head);

	}
}
