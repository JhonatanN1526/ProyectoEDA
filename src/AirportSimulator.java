public class AirportSimulator {
    private final ColaAterrizaje landingQueue;
    private final ColaDespegue takeoffQueue;
    private final BaggageProcessor baggageProcessor;

    private int clock;
    private int flightCounter;

    public AirportSimulator(ColaAterrizaje landingQueue, ColaDespegue takeoffQueue) {
        if (landingQueue == null || takeoffQueue == null) {
            throw new IllegalArgumentException("Las colas no pueden ser nulas");
        }
        this.landingQueue = landingQueue;
        this.takeoffQueue = takeoffQueue;
        this.baggageProcessor = new BaggageProcessor();
        this.clock = 0;
        this.flightCounter = 1;
    }

    public void addLanding(boolean emergency) {
        String id = "FL-" + flightCounter++;
        Avion f = new Avion(id, emergency, clock);
        landingQueue.add(f);
        System.out.println("Agregado a aterrizaje: " + f);
    }

    public void processNextLanding() {
        if (landingQueue.isEmpty()) {
            System.out.println("No hay vuelos esperando aterrizaje.");
            return;
        }

        Avion f = landingQueue.poll();
        System.out.println("Aterrizando: " + f);

        clock += ConfigSimulacion.TIEMPO_ATERRIZAJE;
        clock = baggageProcessor.processBaggage(f, clock);

        // Pasa el mismo avion a la cola de despegue
        takeoffQueue.enqueue(f);

        System.out.println("Aterrizaje completado. Tiempo actual: " + clock);
        System.out.println("Avion agregado a cola de despegue: " + f.getId());
    }

    public void processNextTakeoff() {
        if (takeoffQueue.isEmpty()) {
            System.out.println("No hay vuelos esperando despegue.");
            return;
        }

        Avion f = takeoffQueue.dequeue();
        System.out.println("Despegando: " + f);

        clock += ConfigSimulacion.TIEMPO_DESPEGUE;
        System.out.println("Despegue completado. Tiempo actual: " + clock);
    }

    public void showStatus() {
        System.out.println();
        System.out.println("Tiempo actual: " + clock);
        System.out.println("Cola aterrizaje: " + landingQueue.size() + "/" + landingQueue.capacity());
        System.out.println("Cola despegue: " + takeoffQueue.size() + "/" + takeoffQueue.capacity());
        System.out.println();
    }
}
