/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementar;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lectura.LeerArchivo;

/**
 *
 * @author zomby
 */
public class Analizador {

    private String cadena;
    private Automata afd;
    private int simbolo_analizado;

    public Analizador() {
      //  cadena = "1010";
        simbolo_analizado = -1;
        afd = new Automata();
    }

    public Analizador(String w) {
        cadena = w;

    }

    public boolean analizar(String w) {
        cadena = w;
        int q = afd.getQ0();
        char s;
        int is;
        try {
            s = siguiente_simbolo();
            while (true) {
                is = afd.getAlpha().indexOf("" + s);
                if (is == -1) {
                    error(102);
                }
                q = afd.getMte(q, is);
                if (q == -1) {
                    error(101);
                }
                s = siguiente_simbolo();
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Fin de la cadena");
            // ex.printStackTrace();
        }

        return afd.getF().contains("" + q);
    }

    char siguiente_simbolo() throws StringIndexOutOfBoundsException {
        simbolo_analizado++;
        return cadena.charAt(simbolo_analizado);

    }

    private void error(int i) {
        switch (i) {
            case 101:
                System.out.println("Aceptado");
                break;
            case 102:
                System.out.println("Rechazado");
                break;
        }
    }
/*
    public static void main(String[] args) {
        Analizador x = new Analizador();
        lectura.LeerArchivo my_linea = new LeerArchivo();
        while (true) {
            try {
                my_linea.leer(my_linea.seleccionArchivo());
            } catch (IOException ex) {
                Logger.getLogger(Analizador.class.getName()).log(Level.SEVERE, null, ex);
            }

            String palabra = my_linea.getPalabra(0);

            if (x.analizar(palabra)) {
                System.out.println("------------CADENA ACEPTADA-----V------");
            } else {
                System.out.println("------------CADENA RECHAZADA----X-------");
            }
        }
    }
*/
}
