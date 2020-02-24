/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectura;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class LeerArchivo {

    private ArrayList<String>palabras;

    public void leer(String nombre_archivo) throws IOException {
         palabras = new ArrayList();
        FileReader archivo = new FileReader(nombre_archivo);// Recibe como parametro la direccion de el arcchivo
        BufferedReader myBuffer = new BufferedReader(archivo);//Recibe como parametro un archivo
        StringTokenizer tokens;
        String reglon = "";
        int Palabras = 0;
        int lineas = 0;
        while (reglon != null) {
            reglon = myBuffer.readLine();
            if (reglon != null) {
                tokens = new StringTokenizer(reglon);
                while (tokens.hasMoreTokens()) {
                    palabras.add(tokens.nextToken());
                    Palabras++;
                }
                lineas++;
            }
        }
    }

    public String seleccionArchivo() {
        String ruta = "";
        JFileChooser seleccion = new JFileChooser();
        File archivo;
        int selec = seleccion.showOpenDialog(null);
        archivo = seleccion.getSelectedFile();
        if (archivo.canRead() & archivo.getName().endsWith(".txt")) {
            System.out.println("txt ");
            ruta = archivo.getPath();
        } else {
            System.out.println("rechazado solo txt");
        }
        return ruta;
    }
/*
    public static void main(String[] args) {
        LeerArchivo myFile = new LeerArchivo();
        try {
            String nombre = myFile.seleccionArchivo();
            System.out.println(nombre);
            if (nombre != "") {
                myFile.leer(nombre);
            }
        } catch (IOException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    public String getPalabra(int n){
        return palabras.get(n);
    }
}
