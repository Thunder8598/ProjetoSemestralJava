import classes.Aviao;
import classes.Passageiro;
import classes.Voo;

import javax.swing.JOptionPane;

import java.util.*;

public class App {

    static String option = "";

    static ArrayList<Aviao> avioes = new ArrayList<Aviao>();
    static ArrayList<Voo> voos = new ArrayList<Voo>();

    static String lista = "";
    static int numeroLista = 0;

    public static void main(String[] args) throws Exception {

        App.gerarCadastroAutomatico();

        while (true) {
            App.option = JOptionPane.showInputDialog(null,
                    "Menu Principal\n1-Parâmetros do sistema\n2-Reservas de Passagens\n3-Sair");

            if (App.option == null)
                break;

            switch (App.option) {
                case "1":
                    App.showParametrosSistema();
                    break;
                case "2":
                    App.showReservaPassagens();
                    break;
                default:
                    return;
            }
        }
    }

    public static void showParametrosSistema() {

        while (true) {
            App.option = JOptionPane.showInputDialog(null,
                    "Parametros do Sistema\n1-Cadastrar Aeronave\n2-Cadastrar Voo\n3-Voltar");

            if (App.option == null)
                break;

            switch (App.option) {
                /*
                 * Cadastro do avião
                 */
                case "1":
                    try {
                        String modelo = JOptionPane.showInputDialog(null, "Insira o modelo do avião");
                        String totalFileiras = JOptionPane.showInputDialog(null, "O total de fileiras");
                        String totalAcentos = JOptionPane.showInputDialog(null, "O total de acentos");

                        Aviao aviao = new Aviao(modelo, totalFileiras, totalAcentos);

                        if (aviao.passageiros != null)
                            App.avioes.add(aviao);
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, error.getMessage());
                    }
                    break;

                /*
                 * Cadastro do Voo
                 */
                case "2":

                    App.geraListaAvioes();

                    if (App.numeroLista == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhum avião cadastrado");
                        break;
                    }

                    try {
                        int numeroLista = Integer
                                .parseInt(JOptionPane.showInputDialog(null, lista + "\nSelecione o número do avião"));

                        if (numeroLista > App.avioes.size()) {
                            JOptionPane.showMessageDialog(null, "O avião seleciondo não existe");
                            break;
                        }

                        String dataVoo = JOptionPane.showInputDialog(null, "Insira a data do Vôo");
                        String horaVoo = JOptionPane.showInputDialog(null, "Insira a hora do Vôo");

                        App.voos.add(new Voo(App.avioes.get(numeroLista - 1), App.voos.size() + 1, dataVoo, horaVoo));

                    } catch (NumberFormatException error) {
                        JOptionPane.showMessageDialog(null, "O número do avião só pode conter valores númericos");
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, error.getMessage(), "Ops", 1);
                    }

                    break;

                default:
                    return;
            }
        }
    }

    public static void showReservaPassagens() {
        while (true) {

            App.option = JOptionPane.showInputDialog(null,
                    "Reserva de passagens\n1-Fazer reserva\n2-Consultar lugares vazios\n3-Consultar reservas realizadas\n4-Voltar");

            if (App.option == null)
                break;

            switch (App.option) {
                /*
                 * Reserva passagem
                 */
                case "1":

                    App.geraListaVoos();

                    if (App.numeroLista == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhum vôo cadastrado");
                        break;
                    }

                    try {
                        Passageiro passageiro = new Passageiro(
                                JOptionPane.showInputDialog(null, "Insira o nome do passageiro"),
                                JOptionPane.showInputDialog(null, "Insira o CPF do passageiro"));

                        int numeroVoo = Integer
                                .parseInt(JOptionPane.showInputDialog(null, App.lista + "Insira o número do vôo")) - 1;

                        if (App.voos.size() < numeroVoo + 1) {
                            JOptionPane.showMessageDialog(null, "Esse avião não existe");
                            break;
                        }

                        Aviao aviao = App.voos.get(numeroVoo).getAviao();

                        if (aviao.getNumeroLugaresVazios() == 0) {
                            JOptionPane.showMessageDialog(null, "Nenhum acento disponível");
                            break;
                        }

                        int fileira = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a fileira")) - 1;
                        int acento = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o lugar da fileira"))
                                - 1;

                        if (aviao.verificaLugarOcupado(fileira, acento)) {
                            JOptionPane.showMessageDialog(null, "Esse lugar não está vago");
                            break;
                        }

                        aviao.setPassageiro(fileira, acento, passageiro);

                    }

                    catch (NumberFormatException error) {
                        JOptionPane.showMessageDialog(null, "Insira somente valores númericos");
                    }

                    catch (Exception error) {
                        JOptionPane.showMessageDialog(null, error.getMessage());
                    }

                    break;

                /*
                 * Consultar lugares vazios
                 */
                case "2":

                    App.geraListaVoos();

                    if (App.numeroLista == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhum vôo cadastrado");
                        break;
                    }

                    try {
                        int numeroVoo = Integer.parseInt(
                                JOptionPane.showInputDialog(null, App.lista + "\nInsira a numero do vôo")) - 1;

                        if (App.voos.size() < numeroVoo + 1) {
                            JOptionPane.showMessageDialog(null, "Esse voo não está disponível");
                            break;
                        }

                        JOptionPane.showMessageDialog(null, App.voos.get(numeroVoo).getAviao().mostraLugaresVazios());

                    } catch (NumberFormatException error) {
                        JOptionPane.showMessageDialog(null, "Número do Vôo inválido");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;

                /*
                 * Consultar reservas realizadas
                 */
                case "3":
                    App.geraListaVoos();

                    if (App.numeroLista == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhum vôo cadastrado");
                        break;
                    }

                    try {
                        int numeroVoo = Integer.parseInt(
                                JOptionPane.showInputDialog(null, App.lista + "\nInsira a numero do vôo")) - 1;

                        if (App.voos.size() < numeroVoo + 1) {
                            JOptionPane.showMessageDialog(null, "Esse voo não está disponível");
                            break;
                        }

                        try {
                            JOptionPane.showMessageDialog(null,
                                    App.voos.get(numeroVoo).getAviao().mostraLugaresOcupados());
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    } catch (NumberFormatException error) {
                        JOptionPane.showMessageDialog(null, "Número do Vôo inválido");
                    }
                    break;

                default:
                    return;
            }
        }
    }

    public static void gerarCadastroAutomatico() {
        for (int i = 0; i < 10; i++) {
            try {
                App.avioes.add(new Aviao("Teste " + i, (i % 2 == 0 ? 2 : 1), 100));
                App.voos.add(new Voo(App.avioes.get(i), i, "25/08/2021", "20:00"));
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public static void geraListaVoos() {
        App.lista = "";
        App.numeroLista = 0;

        App.voos.forEach((voo) -> {
            App.numeroLista++;
            App.lista += App.numeroLista + " - " + voo + "\n";
        });
    }

    public static void geraListaAvioes() {
        App.lista = "";
        App.numeroLista = 0;

        App.avioes.forEach((aviao) -> {
            App.numeroLista++;
            App.lista += App.numeroLista + " - " + aviao + "\n";
        });
    }
}
