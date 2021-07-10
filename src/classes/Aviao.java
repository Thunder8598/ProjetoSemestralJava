package classes;

import javax.swing.JOptionPane;

public class Aviao extends Aeronave {

    public Passageiro[][] passageiros;

    public Aviao(String modeloAviao, int totalFileiras, int numeroAcentos) throws Exception {
        super(modeloAviao);

        this.passageiros = new Passageiro[totalFileiras][numeroAcentos];
    }

    public Aviao(String modeloAviao, String totalFileiras, String numeroAcentos) throws Exception {
        super(modeloAviao);

        try {
            this.passageiros = new Passageiro[Integer.parseInt(totalFileiras)][Integer.parseInt(numeroAcentos)];
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Total de fileiras e número de acentos precisam ser números inteiros");
        }
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
        return "Modelo: " + this.modelo;
    }
}
