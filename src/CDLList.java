class CDLList<T> {
	class Node {
		// Each Node object has these three fields
		private T element;
		private Node previous;
		private Node next;

		// Constructor: Creates a Node object with element = e, previous = p and next =
		// n
		Node(T e, Node p, Node n) {
			element = e;
			previous = p;
			next = n;
		}

		// This function gets T e as input and sets e as the element of the Node
		public void setElement(T e) {
			element = e;
		}

		// This function returns the element variable of the Node
		public T getElement() {
			return element;
		}

		// This function gets Node n as input and sets the next variable of the current
		// Node object as n.
		public void setNext(Node n) {
			next = n;
		}

		// This function returns the next Node
		public Node getNext() {
			return next;
		}

		// This function gets Node p as input and sets the previous variable of the
		// current Node object as p.
		public void setPrevious(Node p) {
			previous = p;
		}

		// This function returns the previous Node
		public Node getPrevious() {
			return previous;
		}
	}

	// Each object in CDLList has one field head, which points to the starting Node
	// of CDLList.
	private Node head;
	private int size;

	/**
	 * Constructor: initialises the head field as null
	 */
	public CDLList() {
		head = null;
		size = 0;
	}

	/**
	 * @return The element in the first Node of this CDLL. If the list is empty,
	 *         this method returns null.
	 */
	public T getFirst() {
		if (head == null) {
			return null;
		} else
			return head.getNext().getElement();
	}
	
	public int getSize() {
		return this.size;
	}

	/**
	 * Adds element e in a new Node to the head of the list.
	 *
	 * @param e The element to add.
	 */
	public void addFirst(T e) {
		if (size == 0) {
			Node res = new Node(e, null, null);
			head = new Node(null, null, null);
			res.setNext(res);
			res.setPrevious(res);
			head.setNext(res);
			head.setPrevious(res);
		} else {
			Node firstNode = head.getNext();
			Node res = new Node(e, null, null);
			res.setPrevious(head.getPrevious());
			res.setNext(firstNode);
			head.setNext(res);
			head.getPrevious().setNext(res);
			firstNode.setPrevious(res);

		}

	}

	/**
	 * Remove the first Node in the list and return its element.
	 *
	 * @return The element of the first Node. If the list is empty, this method
	 *         returns null.
	 */
	public T removeFirst() {
		if (head == null) {
			return null;
		} else {
			Node first = head.getNext();
			T temp = first.getElement();
			head.setNext(first.getNext());
			first.getNext().setPrevious(head.getPrevious());
			return temp;
		}
	}

	/**
	 * @return The element in the last Node of the CDLL. If the list is empty, this
	 *         method returns null.
	 */
	public T getLast() {
		if (head == null) {
			return null;
		} else {
			Node last = head.getPrevious();
			return last.getElement();
		}
	}

	/**
	 * Adds element e in a new Node to the end of the list.
	 *
	 * @param e The element to add.
	 */
	public void addLast(T e) {
		if (head == null) {
			addFirst(e);
		} else {
			Node last = new Node(e, null, null);
			last.setNext(head.getNext());
			last.setPrevious(head.getPrevious());
			head.getPrevious().setNext(last);
			head.setPrevious(last);
		}
	}

	/**
	 * Remove the last Node in the list and return its element.
	 *
	 * @return The element of the last Node. If the list is empty, this method
	 *         returns null.
	 */
	public T removeLast() {
		if (head == null) {
			return null;
		} else {
			Node last = head.getPrevious();
			head.setPrevious(last.getPrevious());
			last.getPrevious().setNext(head);
			return last.getElement();
		}
	}

	/**
	 * Moves the head reference to the next element.
	 */
	public void rotateForward() {
		if (head == null) {
			
		} else {
			Node next = head.getNext();
			head.setNext(next.getNext());
			head.setPrevious(next);
		}
	}

	/**
	 * Moves the head reference to the previous element.
	 */
	public void rotateBackward() {
		if (head == null) {
			
		} else {
			Node prev = head.getPrevious();
			head.setNext(prev);
			head.setPrevious(prev.getPrevious());
		}
	}
	
	
	public static void main(String[] args) {
		CDLList<String> list = new CDLList<>();
	    list.addLast("Duck");
	    list.addLast("Dog");
	    list.addLast("Cat");
	    list.addLast("Goose");
	    System.out.println(list.getFirst());
	    list.rotateForward();
	    System.out.println(list.getFirst());
	    list.rotateForward();
	    System.out.println(list.getFirst());
	    list.rotateForward();
	    System.out.println(list.getFirst());
	    list.rotateForward();
	    System.out.println(list.getFirst());
	    list.rotateBackward();
	    System.out.println(list.getFirst());
	    System.out.println(list.removeLast());
	    System.out.println(list.getFirst());
	    
	}
}
//
