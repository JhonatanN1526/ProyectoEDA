import java.util.Scanner;
public class MainTestBaggage {
    public static void main(String[] args) {
        BaggageProcessor processor = new BaggageProcessor();
        BaggageProcessor.Flight flight = new BaggageProcessor.Flight("FL-001", "LIM", "MIA");

        int inicioReloj = 0;
        processor.processBaggage(flight, inicioReloj);

        Scanner sc = new Scanner(System.in);

        // ESTRUCTURAS (NO TOCAR IMPLEMENTACIÓN INTERNA)
        LandingQueue landingQueue = new LandingQueue();
        QueueFIFO<Flight> takeoffQueue = new CircularQueue<>();

        airportSimulator sim = new airportSimulator(landingQueue, takeoffQueue);

        int option;

        do {
            System.out.println(" SIMULADOR DE AEROPUERTO ");
            System.out.println("1. Agregar aterrizaje normal");
            System.out.println("2. Agregar aterrizaje de emergencia");
            System.out.println("3. Agregar despegue");
            System.out.println("4. Procesar siguiente aterrizaje");
            System.out.println("5. Procesar siguiente despegue");
            System.out.println("6. Mostrar estado");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    sim.addLanding(false);
                    break;
                case 2:
                    sim.addLanding(true);
                    break;
                case 3:
                    sim.addTakeoff();
                    break;
                case 4:
                    sim.processNextLanding();
                    break;
                case 5:
                    sim.processNextTakeoff();
                    break;
                case 6:
                    sim.showStatus();
                    break;
                case 0:
                    System.out.println(" Saliendo del simulador...");
                    break;
                default:
                    System.out.println(" Opción inválida");
            }

        } while (option != 0);

        sc.close();
    }
}


    

