public class MainTestBaggage {
    public static void main(String[] args) {
        Avion avion = new Avion("A123", false, 10);
        BaggageProcessor processor = new BaggageProcessor();

        int startClock = 0;
        int endClock = processor.processBaggage(avion, startClock);
        System.out.println("Tiempo total transcurrido: " + (endClock - startClock) + " unidades");
    }
}


    

