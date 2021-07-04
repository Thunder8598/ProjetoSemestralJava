package classes;

public class Aviao extends Aeronave {

    public Passageiro[][] passageiros;

    public Aviao(String modeloAviao, int totalFileiras, int numeroAcentos) throws Exception {
        super(modeloAviao);

        this.passageiros = new Passageiro[totalFileiras][numeroAcentos];
    }

    public boolean verificaLugarOcupado(int fileira, int acento) {
        if (this.passageiros[fileira][acento] == null)
            return true;
        return false;
    }

    /*
     * Setters
     */
    public void setPassageiro(int fileira, int acento, Passageiro passageiro) {
        this.passageiros[fileira][acento] = passageiro;
    }

    /*
     * Getters
     */
    public Passageiro getPassageiro(int fileira, int acento) {
        return passageiros[fileira][acento];
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Modelo: "+this.modelo;
    }
}
