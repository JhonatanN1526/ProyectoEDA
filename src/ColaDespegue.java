public class ColaDespegue {

    private Avion[] data;
    private int front;
    private int rear;
    private int count;

    public ColaDespegue(int capacidad) {
        data = new Avion[capacidad];
        front = 0;
        rear = 0;
        count = 0;
    }

    // encola un avion al final de la cola
    public void enqueue(Avion avion) {
        if (count == data.length) {
            throw new IllegalStateException("Cola de despegue llena");
        }

        data[rear] = avion;
        rear = (rear + 1) % data.length;
        count++;
    }

    // Saca el avion del frente de la cola
    public Avion dequeue() {
        if (isEmpty()) {
            return null;
        }

        Avion avion = data[front];
        data[front] = null; 
        front = (front + 1) % data.length;
        count--;

        return avion;
    }

    // Mira el primero sin sacarlo
    public Avion peek() {
        if (isEmpty()) {
            return null;
        }
        return data[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }
}