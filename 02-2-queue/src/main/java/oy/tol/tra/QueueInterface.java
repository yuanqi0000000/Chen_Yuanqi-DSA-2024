package oy.tol.tra;

public interface QueueInterface<E> {

   public int capacity();

   public void enqueue(E element) throws QueueAllocationException, NullPointerException;

   public E dequeue() throws QueueIsEmptyException;

   public E element() throws QueueIsEmptyException;

   public int size();

   public boolean isEmpty();

   public void clear();

}
