/**
 * Desde esta clase se hace uso de las clases analizador y del automata
 * permite crear un nuevo automata apartir de un archivo de texto e interacturar con
 * dicho automata
 */
package implementar;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import lectura.LeerArchivo;

/**
 *
 * @author Paulino Salas
 */
public class Main {

    private Analizador analizar;
    private LeerArchivo lectura;

    /**
     * Inicializa la clase LeerArchivo y valida los casos del menu
     * @param caso Numero de la operacion que desea realizar el usuario
     */
    public void MenuContinuar(int caso) {

        lectura = new LeerArchivo();
        Scanner entrada = new Scanner(System.in);
        String palabra = "";
        switch (caso) {
            case 1:
                System.out.println("Cargar Automata");
                try {
                    lectura.leer(lectura.seleccionArchivo()); //lee el archivo que recibe como parametro de la selección
                    analizar = new Analizador(lectura.getAfd());
                } catch (IOException ex) {
                }
                break;
            case 2:
                analizar = new Analizador();
                System.out.println("Escribir cadena");
                palabra = entrada.nextLine();
                if (analizar.analizar(palabra)) {//validando si la cadena es aceptada o rechazada
                    System.out.println("------------CADENA ACEPTADA-----------");
                } else {
                    System.out.println("------------CADENA RECHAZADA----X-------");
                }

                break;
            case 3:
                System.out.println("Has salido");
                System.exit(0);
                break;
            default:
                System.out.println("No se has seleccionado nada! -_-");
                break;
        }
        System.out.println(palabra);
    }

    /**
     * Inicia el programa muestra el menu y no termina hasta que el usuario lo 
     * finalice
     */
    public void init() {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("1: Agregar Automata \n2: Escribir Cadena \n3: salir");
            int caso = entrada.nextInt();
            MenuContinuar(caso);
        }
    }

    public static void main(String[] args) {
        new Main().init();
    }
}
