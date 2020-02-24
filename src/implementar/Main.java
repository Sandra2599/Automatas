/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementar;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import lectura.LeerArchivo;

/**
 *
 * @author zomby
 */
public class Main {

    Analizador analizar;
    LeerArchivo lectura;


    public void MenuContinuar(int caso) {

        analizar = new Analizador();
        lectura = new LeerArchivo();
        Scanner entrada = new Scanner(System.in);

        String palabra = "";

        switch (caso) {
            case 1:
                System.out.println("Cargar Archivo");
                 {
                    try {
                        lectura.leer(lectura.seleccionArchivo());
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                palabra = lectura.getPalabra(0);

                if (analizar.analizar(palabra)) {
                    System.out.println("------------CADENA ACEPTADA-----V------");
                } else {
                    System.out.println("------------CADENA RECHAZADA----X-------");
                }
                break;
            case 2:
                System.out.println("Escribir cadena");
                palabra = entrada.nextLine();
                if (analizar.analizar(palabra)) {
                    System.out.println("------------CADENA ACEPTADA-----V------");
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

    public void init() {
        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.println("1: Agregar Archivo \n2: Escribir Cadena \n3: salir");
            int caso = entrada.nextInt();
            MenuContinuar(caso);
        }
    }

    public static void main(String[] args) {
        new Main().init();
    }
}
