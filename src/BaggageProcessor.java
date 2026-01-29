public class BaggageProcessor {

    public int processBaggage(Avion avion, int clock) {
        if (avion == null) {
            throw new IllegalArgumentException("El avion no puede ser nulo");
        }

        int n = ConfigSimulacion.CANTIDAD_EQUIPAJE;

        Stack<String> stack = new ArrayStack<>(n);

        for (int i = 1; i <= n; i++) {
            String label = "Avion " + avion.getId() + " contenedor #" + i;
            stack.push(label);
        }

        while (!stack.isEmpty()) {
            stack.pop();
            clock += ConfigSimulacion.TIEMPO_POR_EQUIPAJE;
        }

        System.out.println("Equipaje procesado para " + avion.getId()
                + ": " + n + " contenedores. Tiempo actual: " + clock);

        return clock;
    }
}
