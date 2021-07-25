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

    public boolean verificaLugarOcupado(int fileira, int acento) throws Exception {
        try {
            if (this.passageiros[fileira][acento] == null)
                return false;
            return true;

        } catch (Exception error) {
            throw new Exception("Número da fileira ou acento invalido");
        }
    }

    public String mostraLugaresVazios() throws Exception {

        String lista = "";

        for (int fileira = 0; fileira < this.passageiros.length; fileira++) {

            lista += "Fileira " + (fileira + 1) + " [";

            for (int acento = 0; acento < this.passageiros[fileira].length; acento++) {
                if (!this.verificaLugarOcupado(fileira, acento))
                    lista += "" + (acento + 1) + ", ";
            }

            lista+="]\n";
        }

        return lista;
    }

    public String mostraLugaresOcupados() throws Exception {

        String lista = "";

        for (int fileira = 0; fileira < this.passageiros.length; fileira++) {

            lista += "Fileira " + (fileira + 1) + " [";

            for (int acento = 0; acento < this.passageiros[fileira].length; acento++) {
                if (this.verificaLugarOcupado(fileira, acento))
                    lista += "" + (acento + 1) + ", ";
            }
            
            lista+="]\n";
        }

        return lista;
    }

    /*
     * Setters
     */
    public void setPassageiro(int fileira, int acento, Passageiro passageiro) throws Exception {
        try {
            this.passageiros[fileira][acento] = passageiro;
        } catch (Exception error) {
            throw new Exception("Número da fileira ou acento invalido");
        }
    }

    public void setPassageiro(String fileira, String acento, Passageiro passageiro) throws Exception {
        try {
            this.passageiros[Integer.parseInt(fileira)][Integer.parseInt(acento)] = passageiro;
        } catch (Exception e) {
            throw new Exception("A fileira e o número do acento precisam ser números inteiros");
        }
    }

    /*
     * Getters
     */
    public Passageiro getPassageiro(int fileira, int acento) {
        return passageiros[fileira][acento];
    }

    public int getNumeroLugaresVazios() throws Exception {

        int lugaresVazios = 0;

        for (int fileira = 0; fileira < this.passageiros.length; fileira++) {
            for (int acento = 0; acento < this.passageiros[fileira].length; acento++)
                if (!this.verificaLugarOcupado(fileira, acento))
                    lugaresVazios++;
        }

        return lugaresVazios;
    }

    @Override
    public String toString() {
        return "[Modelo: " + this.modelo + " - Fileiras: " + this.passageiros.length + " - Acento por fileiras: "
                + this.passageiros[0].length + "]";
    }
}
