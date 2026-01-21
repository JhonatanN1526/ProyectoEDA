public class MainTestBaggage {
    public static void main(String[] args) {
        // Prueba mínima: procesar equipaje de un avión
        Avion avion = new Avion("A123", false, 10);
        BaggageProcessor processor = new BaggageProcessor();
        int clock = 0;
        processor.processBaggage(avion, clock);
    }
}


    

