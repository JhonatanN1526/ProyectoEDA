import java.util.Scanner;

public class MainTestBaggage {
    public static void main(String[] args) {
        ColaAterrizaje landingQueue = new ColaAterrizaje(ConfigSimulacion.MAX_VUELOS);
        ColaDespegue takeoffQueue = new ColaDespegue(ConfigSimulacion.MAX_VUELOS);
        AirportSimulator sim = new AirportSimulator(landingQueue, takeoffQueue);

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            int opt = readInt(sc, "Opcion: ");

            try {
                switch (opt) {
                    case 1 -> {
                        boolean emergency = readYesNo(sc, "Es emergencia? (s/n): ");
                        sim.addLanding(emergency);
                    }
                    case 2 -> sim.addTakeoff();
                    case 3 -> sim.processNextLanding();
                    case 4 -> sim.processNextTakeoff();
                    case 5 -> sim.showStatus();
                    case 0 -> running = false;
                    default -> System.out.println("Opcion invalida.");
                }
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Fin.");
        sc.close();
    }

    private static void printMenu() {
        System.out.println("----- Menu -----");
        System.out.println("1) Registrar aterrizaje");
        System.out.println("2) Registrar despegue");
        System.out.println("3) Procesar siguiente aterrizaje (50 equipajes)");
        System.out.println("4) Procesar siguiente despegue");
        System.out.println("5) Ver estado");
        System.out.println("0) Salir");
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero valido.");
            }
        }
    }

    private static boolean readYesNo(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("s") || s.equals("si")) return true;
            if (s.equals("n") || s.equals("no")) return false;
            System.out.println("Responde con s/n.");
        }
    }
}
