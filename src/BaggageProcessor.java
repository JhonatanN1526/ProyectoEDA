public class BaggageProcessor {

    public static class Flight {
        private final String id;
        private final String origin;
        private final String destination;

        public Flight(String id, String origin, String destination) {
            this.id = id;
            this.origin = origin;
            this.destination = destination;
        }

        public String getId() {
            return id;
        }

        public String getOrigin() {
            return origin;
        }

        public String getDestination() {
            return destination;
        }

        @Override
        public String toString() {
            return "Flight " + id + " (" + origin + " -> " + destination + ")";
        }
    }

    public void processBaggage(Flight flight, int clock) {
        Stack<String> stack = new ArrayStack<>();

        for (int i = 1; i <= ConfigSimulacion.CANTIDAD_EQUIPAJE; i++) {
            String containerLabel = "Flight " + flight.getId() + " container #" + i;
            stack.push(containerLabel);
            System.out.println("[t=" + clock + "] Apilado " + containerLabel);
        }

        while (!stack.isEmpty()) {
            String container = stack.pop();
            System.out.println("[t=" + clock + "] Procesado " + container);
            clock += ConfigSimulacion.TIEMPO_POR_EQUIPAJE;
        }

        System.out.println("Equipaje completado para " + flight + " en t=" + clock);
    }
}
