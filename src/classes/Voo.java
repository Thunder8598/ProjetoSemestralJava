package classes;

public class Voo {

    private Aviao aviao;
    private int numeroVoo;
    private String data, hora;

    public Voo(Aviao aviao, int numeroVoo, String data, String hora) {
        this.aviao = aviao;
        this.numeroVoo = numeroVoo;
        this.data = data;
        this.hora = hora;
    }

    /*
     * Getters
     */
    public Aviao getAviao() {
        return aviao;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public int getNumeroVoo() {
        return numeroVoo;
    }

    @Override
    public String toString() {
        return "[ Número do Vôo: "+this.numeroVoo + " - Data e hora: " + this.data + " " + this.hora + "\n" + this.aviao+"]";
    }
}
