public interface Stack<T> {
    void push(T value);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}

public class ArrayStack<T> implements Stack<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int top;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        elements = new Object[initialCapacity];
        top = 0;
    }

    @Override
    public void push(T value) {
        if (top == elements.length) {
            grow();
        }
        elements[top++] = value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T value = (T) elements[--top];
        elements[top] = null; // clear reference
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) elements[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    private void grow() {
        int newCapacity = elements.length * 2;
        Object[] expanded = new Object[newCapacity];
        System.arraycopy(elements, 0, expanded, 0, elements.length);
        elements = expanded;
    }
}
