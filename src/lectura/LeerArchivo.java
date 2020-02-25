/**
 * Clase encargada de la selección de un archivo,  lectura y creacion de nuevos
 * datos para un nuevo automata
 */
package lectura;

import implementar.Automata;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;

public class LeerArchivo {

    private Automata automataNuevo;
    private int matrix[][];
    private String Q, alpha, q0, F;

    /**
     * Lee el archivo y inicializa las variables de esta clase menos el automataNuevo
     * @param nombre_archivo Dirección del archivo que se va a leer
     * @throws IOException En caso de que ocurra un problema al leer el archivo
     */
    public void leer(String nombre_archivo) throws IOException {
        FileReader archivo = new FileReader(nombre_archivo);// Recibe como parametro la direccion de el arcchivo
        BufferedReader myBuffer = new BufferedReader(archivo);//Recibe como parametro un archivo
        StringTokenizer tokens;
        String reglon = "";
        Q = myBuffer.readLine();
        alpha = myBuffer.readLine();
        q0 = myBuffer.readLine();
        F = myBuffer.readLine();
        int tam_Q = Integer.parseInt(Q);
        int tam_alph = alpha.length();
        matrix = new int[tam_Q][tam_alph];
        reglon = myBuffer.readLine();
        tokens = new StringTokenizer(reglon);
        for (int i = 0; i < tam_Q; i++) {
            for (int j = 0; j < tam_alph; j++) {
                if (tokens.hasMoreTokens()) {
                    matrix[i][j] = Integer.parseInt(tokens.nextToken());
                }
            }
        }
    }

    /**
     * Inicializa el nuevoAutomata con las variables que se inicializan
     * en el metodo leer
     */
    public void CrearNuevoAutomata() {
        automataNuevo = new Automata(Integer.parseInt(Q), alpha, Integer.parseInt(q0), F, matrix);
    }

    /**
     * Con JFileChooser nos permite seleccionar un archivo para unicamente
     * extraer su ruta
     * @return Ruta del archivo que se ha selecciónado
     */
    public String seleccionArchivo() {
        String ruta = "";
        JFileChooser seleccion = new JFileChooser();
        File archivo;
        int selec = seleccion.showOpenDialog(null);
        archivo = seleccion.getSelectedFile();
        if (archivo.canRead() & archivo.getName().endsWith(".txt")) {
            System.out.println("Se cargo Correctamente ");
            ruta = archivo.getPath();
        } else {
            System.out.println("rechazado solo txt");
        }
        return ruta;
    }

    /**
     * Nos debuelve el nuevo automata que se creo
     * @return 
     */
    public Automata getAfd() {
        return automataNuevo;
    }
}
