/**
 * Esta clase hace uso de la clase Automata dado una cadena si es aceptada por este o no
 * permite recorrer una cadena y validarla con el automata
 */
package implementar;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lectura.LeerArchivo;

public class Analizador {

    private String cadena;
    private Automata afd;
    private int simbolo_analizado;

    public Analizador() {
        simbolo_analizado = -1;
        afd = new Automata();
    }

    public Analizador(Automata afd) {
        this.afd = afd;
    }

    /**
     * Analiza la cadena, verifica si se encuentra en el conjunto de estados finales
     * @param w Cadena de texto a validar
     * @return Si se encuentra o no el valor final en el conjunto de estados finales
     */
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
        }

        return afd.getF().contains("" + q);
    }
    
    /**
     * Lee caracter a caracter una cadena
     * @return Un caracter de tipo char de principio a fin de la cadena
     * @throws StringIndexOutOfBoundsException Cuando ya no hay mas letras en la cadena 
     */
    char siguiente_simbolo() throws StringIndexOutOfBoundsException {
        simbolo_analizado++;
        return cadena.charAt(simbolo_analizado);

    }

    /**
     * Imprime mensaje de error dependiendo del parametro i
     * @param i Tipo de error que mostrara en consola
     */
    private void error(int i) {
        switch (i) {
            case 101:
                System.out.println("Error de simbolo");
                break;
            case 102:
                System.out.println("Error de simbolo no declarado");
                break;
        }
    }
}
