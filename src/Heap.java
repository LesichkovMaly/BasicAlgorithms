
public class Heap {

	private int size = 0;
	private Heap.Node root;

	/**
	 * Initializes a Heap with one Node.
	 *
	 * @param rootKey the key given to the root Node of the Heap.
	 */
	public Heap(int rootKey) {
		root = new Heap.Node(rootKey);
		size++;
	}

	/**
	 * @return the root Node of this Heap.
	 */
	public Heap.Node getRoot() {
		return root;
	}

	/**
	 * @param n The Node to get the left child from.
	 * @return the left child of n.
	 */
	public Heap.Node getLeft(Heap.Node n) {
		return n.left;
	}

	/**
	 * @param n The Node to get the right child from.
	 * @return the right child of n.
	 */
	public Heap.Node getRight(Heap.Node n) {
		return n.right;
	}

	/**
	 * @param n The Node to check the left child from.
	 * @return true iff Node n has a left child, false otherwise.
	 */
	public boolean hasLeft(Heap.Node n) {
		return n.left != null;
	}

	/**
	 * @param n The Node to check the right child from.
	 * @return true iff Node n has a right child, false otherwise.
	 */
	public boolean hasRight(Heap.Node n) {
		return n.right != null;
	}

	/**
	 * This method creates a new left child of n if it does not yet have a left
	 * child.
	 *
	 * @param n       The Node to set the left child from.
	 * @param leftKey The key to set in the left child of Node n.
	 */
	public void setLeft(Heap.Node n, int leftKey) {
		if (n.left == null) {
			
			n.left = new Heap.Node(leftKey);
			size++;
		} else {
			n.left.key = leftKey;
		}
	}

	/**
	 * This method creates a new right child of n if it does not yet have a right
	 * child.
	 *
	 * @param n        The Node to set the right child from.
	 * @param rightKey The key to set in the right child of Node n.
	 */
	public void setRight(Heap.Node n, int rightKey) {
		if (n.right == null) {
			n.right = new Heap.Node(rightKey);
			size++;
		} else {
			n.right.key = rightKey;
		}
	}

	/**
	 * @return The size of this Heap, i.e. the amount of Nodes.
	 */
	public int size() {
		return size;
	}

	class Node {
		private int key;
		private Heap.Node left, right;

		/**
		 * Simple constructor.
		 *
		 * @param key to set as key.
		 */
		public Node(int key) {
			this.key = key;
		}

		/**
		 * @return The integer key of this Node.
		 */
		public int getKey() {
			return key;
		}

		@Override
		public String toString() {
			return key + "(" + (left == null ? " " : left) + ',' + (right == null ? " " : right) + ')';
		}
	}
	
	public static Heap.Node findMiddleInLastLayer(Heap heap){
		Heap.Node res = heap.getRoot();
		int size = heap.size();
		int height = 0;
		if(size == 0) {
			return null;
		}
		else if(size == 0) {
			return heap.getRoot();
		}
		
		while(size > 1) {
			size = size/2;
			height++;
		}
		int extLeaves = heap.size() - (2^height-1);
		//System.out.println(extLeaves/2);
		String str = Integer.toBinaryString(extLeaves/2);
		int[] arr = new int[height];
		for(int i = 0 ; i < height ; i++) {
			if(i>=str.length()) {
				arr[i] = 0;
			}
			else {
				arr[i] = Character.getNumericValue(str.charAt(i));
			}
		}
		
		for(int i = 0 ; i < height;i++) {
			System.out.println(arr[i]);
			if(arr[i] == 1) {
				System.out.println("right");
				res = res.right;
			}
			else {
				System.out.println("left");
				res = res.left;
			}
		}
		System.out.println(res);
		
		
		return null;
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(4);
		
		heap.setLeft(heap.getRoot(), 5);
		heap.setRight(heap.getRoot(), 6);
		heap.setLeft(heap.getLeft(heap.getRoot()), 11);
		heap.setRight(heap.getLeft(heap.getRoot()), 10);
		heap.setLeft(heap.getRight(heap.getRoot()), 12);
		heap.setRight(heap.getRight(heap.getRoot()), 12);
		heap.setLeft(heap.getLeft(heap.getLeft(heap.getRoot())), 13);
		heap.setRight(heap.getLeft(heap.getLeft(heap.getRoot())), 14);
		heap.setLeft(heap.getRight(heap.getLeft(heap.getRoot())), 13);
		findMiddleInLastLayer(heap);
	}
}
