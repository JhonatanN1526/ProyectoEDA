public class MainTestBaggage {
    public static void main(String[] args) {
        BaggageProcessor processor = new BaggageProcessor();
        BaggageProcessor.Flight flight = new BaggageProcessor.Flight("FL-001", "LIM", "MIA");

        int inicioReloj = 0;
        processor.processBaggage(flight, inicioReloj);
    }
}
