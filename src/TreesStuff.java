import java.util.*;

public class TreesStuff {

	public static int countLeaves(BinaryTree tree) {

		int count = 0;
		if (tree == null) {
			return count;
		}
		if (!tree.hasLeft() && !tree.hasRight()) {
			count++;

		}
		return count + countLeaves(tree.getLeft()) + countLeaves(tree.getRight());
	}

	public static int countNodes(BinaryTree tree) {
		int count = 0;
		if (tree == null) {
			return count;
		}
		count++;
		return count + countNodes(tree.getLeft()) + countNodes(tree.getRight());
	}

	public static List<BinaryTree> getAllNodesDF(BinaryTree tree, Order order) {
		ArrayList<BinaryTree> res = new ArrayList<BinaryTree>();
		if (tree == null) {
			return null;
		}
		if (order == Order.PRE) {
			PreOrderBT(tree, res);
		}
		if (order == Order.POST) {
			PostOrderBT(tree, res);
		}
		if (order == Order.IN) {
			InOrderBT(tree, res);
		}
		return res;
	}

	private static void InOrderBT(BinaryTree tree, ArrayList<BinaryTree> res) {
		if (tree.hasLeft()) {
			InOrderBT(tree.getLeft(), res);
		}
		res.add(tree);
		if (tree.hasRight()) {
			InOrderBT(tree.getRight(), res);
		}

	}

	private static void PostOrderBT(BinaryTree tree, ArrayList<BinaryTree> res) {

		if (tree.hasLeft()) {
			PostOrderBT(tree.getLeft(), res);
		}
		if (tree.hasRight()) {
			PostOrderBT(tree.getRight(), res);
		}
		res.add(tree);
	}

	private static void PreOrderBT(BinaryTree tree, ArrayList res) {
		res.add(tree);
		if (tree.hasLeft()) {
			PreOrderBT(tree.getLeft(), res);
		}
		if (tree.hasRight()) {
			PreOrderBT(tree.getRight(), res);
		}
	}

	private static void BFS(BinaryTree tree, ArrayList res) {

		Queue<BinaryTree> q = new Queue();
		q.enqueue(tree);
		while (!q.isEmpty()) {
			BinaryTree curr = q.dequeue();
			res.add(curr);
			if (curr.hasLeft()) {
				q.enqueue(curr.getLeft());
			}
			if (curr.hasRight()) {
				q.enqueue(curr.getRight());
			}

		}
	}

	private static boolean isTreeComplete(BinaryTree tree) {
		if (tree == null) {
			return true;
		}
		Queue<BinaryTree> q = new Queue();
		q.enqueue(tree);
		boolean flag = false;
		while (!q.isEmpty()) {
			BinaryTree curr = q.dequeue();
			if (curr.hasLeft()) {
				if(flag == true) {
					return false;
				}
				q.enqueue(curr.getLeft());
			}
			else {
				flag = true;
			}
			if (curr.hasRight()) {
				if(flag == true) {
					return false;
				}
				q.enqueue(curr.getRight());
			}
			else {
				flag = true;
			}

		}
		return true;
	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree(42, new BinaryTree(21), new BinaryTree(31));
		BinaryTree tree1 = new BinaryTree(42, tree, tree);
		System.out.println(countLeaves(tree1));
		BinaryTree tree2 = new BinaryTree(1, new BinaryTree(2, new BinaryTree(3), new BinaryTree(4)),
				new BinaryTree(5));
		System.out.println(getAllNodesDF(tree2, Order.PRE));
		System.out.println(getAllNodesDF(tree2, Order.POST));
		System.out.println(getAllNodesDF(tree2, Order.IN));
		System.out.println(countNodes(tree2));

	}

}
