/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laispaivaportela
 */
public class Tempo {

    private int hora;  //variavel de instancia
    private int minuto;  //variavel de instancia
    private int segundo;  //variavel de instancia

    public Tempo() {
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }

    //metodo para formatar o tempo
    public String formataOTempo() {

//%02d  - o format vai formatar esse numero pra ter dois dígitos
        String tempoFormatado = String.format(
                " %02d:%02d:%02d\n",
                hora,
                minuto,
                segundo
        );
        //retorna a string formatada
        return tempoFormatado;
    }

    //metodo para definir a hora
    public void setHora(int hora) {
        this.hora = hora;
    }

    //metodo para recuperar a hora
    public int getHora() {
        return hora; //retorna a hora
    }

    //metodo para definir o minuto
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    //metodo para recuperar o minuto
    public int getMinuto() {
        return minuto; //retorna o minuto
    }

    //metodo para definir o segundo
    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    //metodo para recuperar o segundo
    public int getSegundo() {
        return segundo; //retorna o segundo
    }

    //metodo para calcular o tempo total em segundos
    public int segundosTotalTempo() {
        int tempoTotalSegundos = hora * 3600 + minuto * 60 + segundo;
        return tempoTotalSegundos;
    }

    //metodo para incrementar os segundos
    public int incrementaOsSegundos() {
        segundo++;
        return segundo;
    }

    //metodo para incrementar os minutos
    public int incrementaOsMinutos() {
        minuto++;
        return minuto;
    }

    //metodo para incrementar as horas
    public int incrementaAsHoras() {
        hora++;
        return hora;
    }

    //metodo para decrementar os segundos
    public int decrementaOsSegundos() {
        segundo--;
        return segundo;
    }

    //metodo para decrementar os minutos
    public int decrementaOsMinutos() {
        minuto--;
        return minuto;
    }

    //metodo para decrementar as horas
    public int decrementaAsHoras() {
        hora--;
        return hora;
    }

    //metodo para ajeitar o tempo
    private void ajeitaOTempo() {
        if (segundo >= 60) {
            minuto += segundo / 60;
            segundo = segundo % 60;
        }

        if (minuto >= 60) {
            hora += minuto / 60;
            minuto = minuto % 60;
        }

        if (hora >= 24) {
            hora = hora % 24;
        }
        if (segundo < 0) {
            segundo = 59;
            minuto--;
            if (minuto < 0) {
                minuto = 59;
                hora--;
                if (hora < 0) {
                    hora = 23;
                }
            }
        }

        if (minuto < 0) {
            minuto = 59;
            hora--;
            if (hora < 0) {
                hora = 23;
            }
        }

        if (hora < 0) {
            hora = 23;
        }
    }
}
