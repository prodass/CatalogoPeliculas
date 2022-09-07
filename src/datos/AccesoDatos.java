/*
    La funcion de esta clase es manejar las operaciones a ejecutar en el archivo de texto.
    Interface.
*/
package datos;

import domain.Pelicula;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatos {
    
    public static boolean existe(String nombreArchivo) {
        File archivo = new File (nombreArchivo);
        return archivo.exists();
    }
    
    public static boolean crearArchivo (String nombreArchivo){
        File archivo = new File (nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            return false;
        }
    }
    
    public static boolean borrarArchivo (String nombreArchivo){
        File archivo = new File (nombreArchivo);
        return archivo.delete();
    }
    
    public static boolean cargarPelicula(String nombrePelicula, String nombreArchivo){
        File archivo = new File (nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,true));
            salida.println(nombrePelicula);
            salida.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            return false;
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            return false;
        }
    }
    
    public static List<Pelicula> listar (String nombreArchivo){
        var archivo = new File (nombreArchivo);
        List listaPeliculas = new ArrayList();
        try {
            var entrada = new BufferedReader (new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null){
                listaPeliculas.add(lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }   catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return listaPeliculas;
    }
    
    public static boolean buscar (String nombreArchivo, String nombrePelicula){
        var archivo = new File (nombreArchivo);
        try {
            var entrada = new BufferedReader (new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null){
                if(nombrePelicula.equals(lectura)){
                    return true;
                }
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }   catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return false;
    }
}