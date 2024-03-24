package oy.tol.tra;

public class QueueImplementation<E> implements QueueInterface<E> {
    private E[] itemArray;
    private int capacity;
    private int head;
    private int tail;
    private static final int DEFAULT_QUEUE_SIZE = 10;
    private int count = 0;

    public QueueImplementation() throws QueueAllocationException {
        this.capacity = DEFAULT_QUEUE_SIZE;
        this.itemArray = (E[]) new Object[capacity];
        this.head = this.tail = 0;
    }

    public QueueImplementation(int capacity) throws QueueAllocationException {
        if (capacity < 2)
            throw new QueueAllocationException("The size is less than 2");
        else {
            this.itemArray = (E[]) new Object[capacity];
            ;
            this.capacity = capacity;
            this.head = this.tail = 0;

        }

    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    private void resize(int max) {
        E[] a = (E[]) new Object[max];
        int i = 0;
        while (!isEmpty()) {
            a[i] = dequeue();
            i++;
        }
        itemArray = a;
        this.capacity = max;
        this.head = 0;
        this.tail = i;
        this.count = i;

    }

    @Override
    public void enqueue(E element) throws QueueAllocationException, NullPointerException {
        if (null == element)
            throw new NullPointerException();
        if (this.tail == this.head && (this.itemArray[head] != null))
            resize(2 * this.capacity);
        this.itemArray[this.tail] = element;
        this.count++;

        if (this.tail == (capacity - 1))
            this.tail = 0;
        else
            this.tail++;
    }

    public E dequeue() throws QueueIsEmptyException {
        if (isEmpty())
            throw new QueueIsEmptyException(null);
        E item = itemArray[head];
        this.itemArray[head] = null;
        this.count--;
        if ((capacity - 1) == head)
            head = 0;
        else
            head++;
        return item;
    }

    public E element() throws QueueIsEmptyException {
        if (isEmpty())
            throw new QueueIsEmptyException(null);
        return itemArray[head];
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return ((this.head == this.tail) && (this.itemArray[head] == null));
    }

    public void clear() {
        this.itemArray = (E[]) new Object[this.capacity];
        this.head = this.tail = 0;
        this.count = 0;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        int head = this.head;
        int tail = this.tail;
        if (isEmpty())
            ;
        else {
            do {
                builder.append(itemArray[head].toString());
                builder.append(", ");
                if ((capacity - 1) == head)
                    head = 0;
                else
                    head++;
            } while (head != tail);
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);

        }

        builder.append("]");
        return builder.toString();
    }

}
