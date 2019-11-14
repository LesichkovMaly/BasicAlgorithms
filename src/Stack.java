import java.util.*;

class Stack<T> {
  private MyQueue<T> q1 = new MyQueue<>();
  private MyQueue<T> q2 = new MyQueue<>();

  /**
   * @return true iff there are no elements left.
   */
  public boolean isEmpty() {
	  return q1.isEmpty();
  }

  /**
   * @return the number of elements in the stack.
   */
  public int size() {
	  return q1.size();
  }

  /**
   * Adds an element to the stack.
   *
   * @param i
   *     element to enqueue.
   */
  public void push(T i) {
	  q1.enqueue(i);
  }

  /**
   * Removes the top element from the stack.
   *
   * @return the top element from the stack.
   * @throws NoSuchElementException
   *     iff the stack is empty.
   */
  public T pop() throws NoSuchElementException {
	  if(this.size()<=0) {
		  throw new NoSuchElementException();
	  }
	  else {
		  T temp;
		  int q1Size = q1.size();
		  for(int i = 0 ; i < q1Size - 1 ; i++) {
			  q2.enqueue(q1.dequeue());
		  }
		  int q2Size =  q2.size();
		  for(int i = 0 ; i < q2Size; i++) {
			  q1.enqueue(q2.dequeue());
		  }
		  temp = q1.dequeue();
		  
		  return temp;
	  }
  }

  /**
   * Only returns (i.e. does not remove) the top element from the stack.
   *
   * @return the top element from the stack.
   * @throws NoSuchElementException
   *     iff the stack is empty.
   */
  public T top() throws NoSuchElementException {
    if(this.size()<=0) {
    	throw new NoSuchElementException();
    }
    else {
    	T temp;
		  int q1Size = q1.size();
		  for(int i = 0 ; i < q1Size - 1 ; i++) {
			  q2.enqueue(q1.dequeue());
		  }
		  int q2Size =  q2.size();
		  for(int i = 0 ; i < q2Size; i++) {
			  q1.enqueue(q2.dequeue());
		  }
		  temp = q1.dequeue();
		  q1.enqueue(temp);
		  return temp;
    }
  }
  public static void main(String[] args) {
	  Stack<Integer> stack = new Stack<Integer>();
	  stack.push(1);
	  stack.push(2);
	  stack.push(3);
	  stack.push(4);
	  int four = stack.pop();
	  stack.push(1);
	  int one = stack.top();
	  System.out.println(four);
	  System.out.println(one);
	  
  }
}
//
