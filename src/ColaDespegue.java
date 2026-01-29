public class ColaDespegue {
    private final Avion[] data;
    private int front;
    private int rear;
    private int count;

    public ColaDespegue(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser positiva");
        }
        data = new Avion[capacidad];
        front = 0;
        rear = 0;
        count = 0;
    }

    public void enqueue(Avion avion) {
        if (avion == null) {
            throw new IllegalArgumentException("El avion no puede ser nulo");
        }
        if (count == data.length) {
            throw new IllegalStateException("Cola de despegue llena");
        }

        data[rear] = avion;
        rear = (rear + 1) % data.length;
        count++;
    }

    public Avion dequeue() {
        if (isEmpty()) return null;

        Avion avion = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        count--;
        return avion;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public int capacity() {
        return data.length;
    }
}
