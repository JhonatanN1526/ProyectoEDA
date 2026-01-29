public class Avion {
    private final String id;
    private final boolean casoEmergencia;
    private final int tiempoLlegada;

    public Avion(String id, boolean casoEmergencia, int tiempoLlegada) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id no puede ser nulo o vacio");
        }
        this.id = id;
        this.casoEmergencia = casoEmergencia;
        this.tiempoLlegada = tiempoLlegada;
    }

    public String getId() {
        return id;
    }

    public boolean isCasoEmergencia() {
        return casoEmergencia;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    @Override
    public String toString() {
        return "Id: " + id + ". Emergencia: " + casoEmergencia + ". Llegada: " + tiempoLlegada;
    }
}
