public class Avion {
    private String id;
    private boolean casoEmergencia;
    private int tiempoLlegada;
    
    public Avion(String id, boolean casoEmergencia, int tiempoLlegada){
        this.id = id;
        this.casoEmergencia = casoEmergencia;
        this.tiempoLlegada = tiempoLlegada;
    }

    public String getId(){
        return this.id;
    }

    public boolean isCasoEmergencia(){
        return this.casoEmergencia;
    }

    public int getTiempoLlegada(){
        return this.tiempoLlegada;
    }

    @Override
    public String toString(){
        return "Id: " + id + ". Caso de emergencia: " + casoEmergencia + ". Tiempo de llegada: " + tiempoLlegada;
    }
}
