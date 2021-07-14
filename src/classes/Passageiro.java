package classes;

public class Passageiro {

    private String nome, cpf;

    public Passageiro(String nome, String cpf) throws Exception {

        if (nome == null || nome.trim().length() == 0)
            throw new Exception("Nome não informado");
        else if (cpf == null || cpf.trim().length() == 0)
            throw new Exception("CPF não informado");

        this.nome = nome;
        this.cpf = cpf;
    }

    /*
     * Getters
     */
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" + "CPF: " + this.cpf;
    }
}
