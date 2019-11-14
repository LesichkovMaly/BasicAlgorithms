
class MyQueue<T> {
  java.util.LinkedList<T> ll;

  public MyQueue() {
    ll = new java.util.LinkedList<>();
  }

  /**
   * @return true iff it contains no elements.
   */
  public boolean isEmpty() {
    return ll.isEmpty();
  }

  /**
   * @return the number of elements in the queue.
   */
  public int size() {
    return ll.size();
  }

  /**
   * Add an element to the end of the queue
   *
   * @param e
   *     element to enqueue.
   */
  public void enqueue(T e) {
    ll.offer(e);
  }

  /**
   * Removes the first element from the queue.
   *
   * @return the first element.
   * @throws NoSuchElementException
   *     iff the queue is empty
   */
  public T dequeue() throws java.util.NoSuchElementException {
    return ll.remove();
  }

  /**
   * Returns the first element from the queue, but does not remove it.
   *
   * @return the first element.
   * @throws NoSuchElementException
   *     iff the queue is empty
   */
  public T front() throws java.util.NoSuchElementException {
    if (ll.peek() == null) {
      throw new java.util.NoSuchElementException();
    }
    return ll.peek();
  }
}
