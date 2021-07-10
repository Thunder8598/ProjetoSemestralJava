import classes.Aviao;
import classes.Voo;

import javax.swing.JOptionPane;

import java.util.*;

public class App {

    static String option = "";

    static ArrayList<Aviao> avioes = new ArrayList<Aviao>();
    static ArrayList<Voo> voos = new ArrayList<Voo>();

    static String avioesLista = "";
    static int numeroAviao = 0;

    public static void main(String[] args) throws Exception {

        while (true) {
            App.option = JOptionPane.showInputDialog(null,
                    "Menu Principal\n1-Parâmetros do sistema\n2-Reservas de Passagens\n3-Sair");

            switch (App.option) {
                case "1":
                    App.showParametrosSistema();
                    break;
                case "2":
                    break;
                default:
                    return;
            }
        }
    }

    public static void showParametrosSistema() {

        while (true) {
            App.option = JOptionPane.showInputDialog(null, "Parametros do Sistema\n1-Cadastrar Aeronave\n2-Cadastrar Voo\n3-Voltar");

            switch (App.option) {
                /*
                 * Cadastro do avião
                 */
                case "1":
                    try {
                        String modelo = JOptionPane.showInputDialog(null, "Insira o modelo do avião");
                        String totalFileiras = JOptionPane.showInputDialog(null, "O total de fileiras");
                        String totalAcentos = JOptionPane.showInputDialog(null, "O total de acentos");

                        App.avioes.add(new Aviao(modelo, totalFileiras, totalAcentos));
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, error.getMessage(), "Ops", 1);
                    }
                    break;

                /*
                 * Cadastro do Voo
                 */
                case "2":

                    App.avioesLista = "";
                    App.numeroAviao = 0;

                    App.avioes.forEach((aviao) -> {
                        App.numeroAviao++;
                        App.avioesLista += App.numeroAviao + " - " + aviao;
                    });

                    try {
                        int numeroAviao = Integer.parseInt(
                                JOptionPane.showInputDialog(null, avioesLista + "\nSelecione o número do avião"));
                        int numeroVoo = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o número do Vôo"));
                        String dataVoo = JOptionPane.showInputDialog(null, "Insira a data do Vôo");
                        String horaVoo = JOptionPane.showInputDialog(null, "Insira a hora do Vôo");

                        App.voos.add(new Voo(App.avioes.get(numeroAviao - 1), numeroVoo, dataVoo, horaVoo));
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, error.getMessage(), "Ops", 1);
                    }
                    break;

                default:
                    return;
            }
        }
    }
}
