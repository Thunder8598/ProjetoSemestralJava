package classes;

public class Aeronave {
    protected String modelo;

    public Aeronave(String modelo) throws Exception {
        this.setModelo(modelo);
    }

    /*
     * Setters
     */
    public void setModelo(String modelo) throws Exception {
        if (modelo == null || modelo.trim().length() == 0)
            throw new Exception("Modelo não informado");

        this.modelo = modelo;
    }

    /*
     * Getters
     */
    public String getModelo() {
        return modelo;
    }
}
