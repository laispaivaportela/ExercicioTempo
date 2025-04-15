/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;
import  model.Tempo;
/**
 *
 * @author laispaivaportela
 */

/*
ExercicioTempo
Faça um programa orientado a objetos para manipular o tempo de
um relógio. A classe possui 3 atributos do tipo inteiro(int)
chamados hora, minuto e segundo.

a) Analise o contexto e faça as abstrações necessárias para obter os atributos principais;
b) Crie a estrutura de pacotes;
c) Adicione os atributos e métodos get's set's; ok
d) Adicione os construtores desta classe; ok
e) Crie um método que retorne o tempo total em segundos. (hora * 60 (minutos) * 60 (segundos)). ok
f) Crie um método para incrementar o segundo. Considere que não existe segundo acima de 59. Represente 60 segundos
como 1 minuto e 0 segundos. ok
g) Crie uma método para incrementar o minuto. Considere que não existe minuto acima de 59. Represente 60 minutos
como 1 hora e 0 minutos. ok
h) Crie um método para incrementar a hora. Considere que não existe hora acima de 23. Represente 24 horas como 0
horas. ok
i) Crie um método para decrementar o segundo. Considere que não existe segundo negativo. Se for menor que 0
represente com 59 segundos e um minuto a menos. ok
j) Crie um método para decrementar o minuto. Considere que não existe minuto negativo. Se for menor que 0 represente
com 59 minuto e uma hora a menos. ok
k) Crie um método para decrementar a hora. Se for menor que 0 represente como 23 horas. ok
l) Crie uma método para retornar os dados do tempo como uma String no formato : "hh:mm:ss". Onde hh é a hora com
dois dígitos, mm o minuto com dois dígitos e ss os segundos com dois dígitos. Exemplo: "01:19:03".
m) Na Classe principal (main class) instancie um objeto da classe Tempo e faça a entrada de dados e saída dos dados
para testar todos os métodos criados.
*/
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {

        //cria um objeto Tempo e o atribui a meuTempo  (cria um tempo chamado meuTempo)
        Tempo meuTempo = new Tempo();

        //exibe o tempo atual
        JOptionPane.showMessageDialog(null, "Tempo padrão:" + meuTempo.formataOTempo());

        //pergunta se quer começar com o tempo padrão ou se quer alterar
        int resposta = JOptionPane.showConfirmDialog(
                null,
                "Deseja continuar com o tempo padrão?",
                "Escolha",
                JOptionPane.YES_NO_OPTION
        );
        while (true) {
            //ve o que o usuario quer
            if (resposta == JOptionPane.YES_OPTION) {
                break;
            } else if (resposta == JOptionPane.NO_OPTION) {
                String entrada = JOptionPane.showInputDialog("Digite o horário no formato hh:mm:ss:");
                String[] partes = entrada.split(":");
                int asHoras = Integer.parseInt(partes[0]);
                meuTempo.setHora(asHoras);
                int osMinutos = Integer.parseInt(partes[1]);
                meuTempo.setMinuto(osMinutos);
                int osSegundos = Integer.parseInt(partes[2]);
                meuTempo.setSegundo(osSegundos);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Resposta inválida, escolha de novo.");
            }
        }

        while (true) {
            Object[] opcoes = {"tempo atual formatado", "tempo total em segundos", "incremento", "decremento", "sair"};
            // Criando a caixa de diálogo com opções personalizadas
            int escolhaDeOpcao = JOptionPane.showOptionDialog(
                    null,
                    "Escolha o que você deseja:",
                    "Operações",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );
            // Verificando qual opção foi escolhida
            if (escolhaDeOpcao != JOptionPane.CLOSED_OPTION) {
                String opcaoEscolhida = (String) opcoes[escolhaDeOpcao];
                //se o usuario escolher sair o programa encerra
                if (escolhaDeOpcao == 4) { //sair
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                } else {
                    //realiza o pedido do usuario
                    switch (opcaoEscolhida) {
                        case "tempo atual formatado":
                            JOptionPane.showMessageDialog(null, meuTempo.formataOTempo());
                            break;
                        case "tempo total em segundos":
                            JOptionPane.showMessageDialog(null, meuTempo.segundosTotalTempo());
                            break;
                        case "incremento":
                            while (true) {
                                Object[] opcoesIncremento = {"segundos", "minutos", "horas", "voltar"};
                                int escolhaIncremento = JOptionPane.showOptionDialog(
                                        null,
                                        "Escolha qual incremento você deseja:",
                                        "Incremento",
                                        JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcoesIncremento,
                                        opcoesIncremento[0]
                                );
                                // Verificando qual opção foi escolhida
                                if (escolhaIncremento != JOptionPane.CLOSED_OPTION) {
                                    if (escolhaIncremento == 0) { //segundos
                                        meuTempo.incrementaOsSegundos();
                                    } else if (escolhaIncremento == 1) { //minutos
                                        meuTempo.incrementaOsMinutos();
                                    } else if (escolhaIncremento == 2) { //horas
                                        meuTempo.incrementaAsHoras();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Voltando...");
                                        break;
                                    }

                                } else { //voltar
                                    JOptionPane.showMessageDialog(null, "Nenhuma opção foi selecionada. Tente novamente.");
                                }
                            }
                            break;
                        case "decremento":
                            while (true) {
                                Object[] opcoesDecremento = {"segundos", "minutos", "horas", "voltar"};
                                int escolhaDecremento = JOptionPane.showOptionDialog(
                                        null,
                                        "Escolha qual decremento você deseja:",
                                        "Decremento",
                                        JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcoesDecremento,
                                        opcoesDecremento[0]
                                );
                                // Verificando qual opção foi escolhida
                                if (escolhaDecremento != JOptionPane.CLOSED_OPTION) {
                                    if (escolhaDecremento == 0) { //segundos
                                        meuTempo.decrementaOsSegundos();
                                    } else if (escolhaDecremento == 1) { //minutos
                                        meuTempo.decrementaOsMinutos();
                                    } else if (escolhaDecremento == 2) { //horas
                                        meuTempo.decrementaAsHoras();
                                    } else { //voltar
                                        JOptionPane.showMessageDialog(null, "Voltando...");
                                        break;
                                    }
                                }
                            }

                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma opção foi selecionada. Tente novamente.");

            }
        }
    }
}
