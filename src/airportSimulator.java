public class airportSimulator {
    public class AirportSimulator {

    private LandingQueue landingQueue;
    private QueueFIFO<Flight> takeoffQueue;
    private int clock;
    private int flightCounter;

    public AirportSimulator(LandingQueue landingQueue, QueueFIFO<Flight> takeoffQueue) {
        this.landingQueue = landingQueue;
        this.takeoffQueue = takeoffQueue;
        this.clock = 0;
        this.flightCounter = 1;
    }

    // =====================
    // REGISTRO DE VUELOS
    // =====================

    public void addLanding(boolean emergency) {
        String id = "FL-" + flightCounter++;
        Flight f = new Flight(id, emergency, clock);
        landingQueue.add(f);
        System.out.println("✈ Vuelo agregado a ATERRIZAJE: " + f);
    }

    public void addTakeoff() {
        String id = "FL-" + flightCounter++;
        Flight f = new Flight(id, false, clock);
        takeoffQueue.enqueue(f);
        System.out.println("🛫 Vuelo agregado a DESPEGUE: " + f);
    }

    // =====================
    // PROCESAMIENTO
    // =====================

    public void processNextLanding() {
        if (landingQueue.isEmpty()) {
            System.out.println("❌ No hay vuelos esperando aterrizaje.");
            return;
        }

        Flight f = landingQueue.poll();
        System.out.println("⬇ ATERRIZANDO: " + f);

        clock += SimConfig.TIME_LAND;

        // Equipaje (usa la pila)
        BaggageProcessor processor = new BaggageProcessor();
        processor.processBaggage(f, clock);

        System.out.println("✔ Aterrizaje completado. Tiempo actual: " + clock);
    }

    public void processNextTakeoff() {
        if (takeoffQueue.isEmpty()) {
            System.out.println("❌ No hay vuelos esperando despegue.");
            return;
        }

        Flight f = takeoffQueue.dequeue();
        System.out.println("⬆ DESPEGANDO: " + f);

        clock += SimConfig.TIME_TAKEOFF;
        System.out.println("✔ Despegue completado. Tiempo actual: " + clock);
    }

    // =====================
    // ESTADO
    // =====================

    public void showStatus() {
        System.out.println("\n📊 ESTADO DEL AEROPUERTO");
        System.out.println("Tiempo actual: " + clock);
        System.out.println("Aterrizajes en cola: " + landingQueue.size());
        System.out.println("Despegues en cola: " + takeoffQueue.size());
        System.out.println("-----------------------------\n");
    }
}


}
