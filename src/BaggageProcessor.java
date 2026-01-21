public class BaggageProcessor {

    public void processBaggage(Avion avion, int clock) {
        Stack<String> stack = new ArrayStack<>();

        for (int i = 1; i <= ConfigSimulacion.CANTIDAD_EQUIPAJE; i++) {
            String containerLabel = "Avion " + avion.getId() + " contenedor #" + i;
            stack.push(containerLabel);
            System.out.println("[t=" + clock + "] Apilado " + containerLabel);
        }

        while (!stack.isEmpty()) {
            String container = stack.pop();
            System.out.println("[t=" + clock + "] Procesado " + container);
            clock += ConfigSimulacion.TIEMPO_POR_EQUIPAJE;
        }

        System.out.println("Equipaje completado para " + avion + " en t=" + clock);
    }
}
