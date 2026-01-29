import java.util.LinkedList;

public class ColaAterrizaje {
    private final LinkedList<Avion> data = new LinkedList<>();
    private final int capacity;

    public ColaAterrizaje(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser positiva");
        }
        this.capacity = capacity;
    }

    public void add(Avion avion) {
        if (avion == null) {
            throw new IllegalArgumentException("El avion no puede ser nulo");
        }
        if (data.size() >= capacity) {
            throw new IllegalStateException("Cola de aterrizaje llena");
        }

        if (avion.isCasoEmergencia()) {
            data.addFirst(avion);
        } else {
            data.addLast(avion);
        }
    }

    public Avion poll() {
        if (data.isEmpty()) return null;
        return data.removeFirst();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }

    public int capacity() {
        return capacity;
    }
}
