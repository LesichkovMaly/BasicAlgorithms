
public class DLList {
	class Node {
	    // Each node object has these three fields
	    private Object element;
	    private Node previous;
	    private Node next;

	    // Constructor: Creates a Node object with element = e, previous = p and next = n
	    Node(Object e, Node p, Node n) {
	      element = e;
	      previous = p;
	      next = n;
	    }

	    // This function gets Object e as input and sets e as the element of the Node
	    public void setElement(Object e) {
	      element = e;
	    }

	    // This function returns the element variable of the Node
	    public Object getElement() {
	      return element;
	    }

	    // This function gets Node n as input and sets the next variable of the current Node object as n.
	    public void setNext(Node n) {
	      next = n;
	    }

	    // This function returns the next Node
	    public Node getNext() {
	      return next;
	    }

	    // This function gets Node p as input and sets the previous variable of the current Node object as p.
	    public void setPrevious(Node p) {
	      previous = p;
	    }

	    // This function returns the previous Node
	    public Node getPrevious() {
	      return previous;
	    }
	  }

	  // Each object in DLList has one field head, which points to the starting Node of DLList.
	  private Node head;
	  // Each object in DLList has one field tail, which points to the final Node of DLList.
	  private Node tail;

	  /**
	   * Constructor: initialises the head and tail fields as null
	   */
	  public DLList() {
	    head = null;
	    tail = null;
	  }

	  /**
	   * @return The element in the head Node of the DLL
	   */
	  public Object getHead() {
	    return head.getElement();
	  }

	  /**
	   * @return The element in the tail Node of the DLL
	   */
	  public Object getTail() {
	    return tail.getElement();
	  }

	  /**
	   * Adds element e in a new Node to the head of the list.
	   *
	   * @param e
	   *     The element to add.
	   */
	  public void addFirst(Object e) {
	    addAtPosition(0,e);
	    
	  }

	  /**
	   * Remove the first Node in the list and return its element.
	   *
	   * @return The element of the head Node. If the list is empty, this method returns null.
	   */
	  public Object removeFirst() {
		return removeFromPosition(0);
	    // TODO
	  }

	  /**
	   * Adds element e in a new Node to the tail of the list.
	   *
	   * @param e
	   *     The element to add.
	   */
	  public void addLast(Object e) {
	    addAtPosition(this.size()-1,e);
	  }

	  /**
	   * Remove the last Node in the list and return its element.
	   *
	   * @return The element of the tail Node. If the list is empty, this method returns null.
	   */
	  public Object removeLast() {
		  return removeFromPosition(this.size()-1);
	  }

	  /**
	   * @return the number of Nodes in the list
	   */
	  public int size() {
		return 0;
	  }

	  /**
	   * Adds element e in a new Node which is inserted at position pos.
	   * The list is zero indexed, so the first element in the list corresponds to position 0.
	   * This also means that `addAtPosition(0, e)` has the same effect as `addFirst(e)`.
	   * If there is no Node in position pos, this method adds it to the last position.
	   *
	   * @param pos
	   *     The position to insert the element at.
	   * @param e
	   *     The element to add.
	   */
	  public void addAtPosition(int pos, Object e) {
		  
	  }

	  /**
	   * Remove Node at position pos and return its element.
	   * The list is zero indexed, so the first element in the list corresponds to position 0.
	   * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
	   *
	   * @param pos
	   *     The position to remove the Node from.
	   * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
	   */
	  public Object removeFromPosition(int pos) {
		return pos;
	    // TODO
	  }

	  /**
	   * @return A new DLL that contains the elements of the current one in reversed order.
	   */
	  public DLList reverse() {
		return null;
	    // TODO
	  }

}
