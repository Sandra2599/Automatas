/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementar;

/**
 *
 * @author zomby
 */
public class FinitoDeterminista {

    int[][] matriz;
    int F = 3;
    int[] m = {0, 1};
    int[] AFD = {0, 1, 2, 3};

    public FinitoDeterminista() {
        init();
    }

    public void init() {
        /*
        matriz = new int[4][2];
        matriz[0][0] = 1;
        matriz[0][1] = 0;
        matriz[1][0] = 3;
        matriz[1][1] = 2;
        matriz[2][0] = 0;
        matriz[2][1] = 3;
        matriz[2][0] = 0;
        matriz[3][0] = 2;
        matriz[3][1] = 1;
         */

        matriz = new int[4][2];
        matriz[0][0] = 2;
        matriz[0][1] = 1;
        matriz[1][0] = 3;
        matriz[1][1] = 0;
        matriz[2][0] = 0;
        matriz[2][1] = 3;
        matriz[3][0] = 1;
        matriz[3][1] = 2;
    }

    public void cadena(String cadena) {
        int Q = 0;
        int inicio = 0;
        int S = Integer.parseInt(String.valueOf(cadena.charAt(inicio)));
        int longitud = cadena.length();

        while (inicio < longitud) {
            Q = matriz[Q][S];
            inicio++;
            if (inicio < longitud) {
                S = Integer.parseInt(String.valueOf(cadena.charAt(inicio)));
            }
        }
        if (Q == F) {
            System.out.println("Cadena Aceptada");
        } else {
            System.out.println("Cadena Rechazada");
        }
    }

    public static void main(String[] args) {
        new FinitoDeterminista().cadena("1010");
        
        String letra="aetra";
        char v=letra.charAt(0);
        System.out.println(v);
    }
}
