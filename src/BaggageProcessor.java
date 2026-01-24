import java.io.PrintStream;

public class BaggageProcessor {


    public int processBaggage(Avion avion, int clock, PrintStream out) {
        if (avion == null) {
            throw new IllegalArgumentException("El avion no puede ser nulo");
        }
        PrintStream target = out == null ? System.out : out;

        Stack<String> stack = new ArrayStack<>(ConfigSimulacion.CANTIDAD_EQUIPAJE);

        for (int i = 1; i <= ConfigSimulacion.CANTIDAD_EQUIPAJE; i++) {
            String containerLabel = "Avion " + avion.getId() + " contenedor #" + i;
            stack.push(containerLabel);
            target.println("[t=" + clock + "] Apilado " + containerLabel);
        }

        while (!stack.isEmpty()) {
            String container = stack.pop();
            target.println("[t=" + clock + "] Procesado " + container);
            clock += ConfigSimulacion.TIEMPO_POR_EQUIPAJE;
        }

        target.println("Equipaje completado para " + avion + " en t=" + clock);
        return clock;
    }

    public int processBaggage(Avion avion, int clock) {
        return processBaggage(avion, clock, System.out);
    }

    public int processBaggage(Avion avion) {
        return processBaggage(avion, 0, System.out);
    }
}
