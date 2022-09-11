/*
    La funcion de esta clase es manejar las operaciones a ejecutar en el archivo de texto.
    Interface.
 */
package datos;

import excepciones.*;
import java.io.*;
import java.util.*;
import domain.Pelicula;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        List<Pelicula> listaPeliculas = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;
            lectura = entrada.readLine();
            while (lectura != null) {
                var pelicula = new Pelicula(lectura);
                listaPeliculas.add(pelicula);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar peliculas " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar peliculas " + ex.getMessage());
        }
        return listaPeliculas;
    }

    @Override
    public void cargar(Pelicula nombrePelicula, String nombreArchivo) throws EscrituraDatosEx {
        var archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(nombrePelicula.toString());
            salida.close();
            System.out.println("Se ha escrito la informacion al archivo!");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al cargar peliculas " + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String nombrePelicula) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        String resultado = null;
        var indice = 1;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null) {
                if (nombrePelicula.equalsIgnoreCase(lectura)) {
                    resultado = "Pelicula " + nombrePelicula + " ha sido encontrada en el indice: " + indice + ".";
                    break;
                }
                lectura = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al buscar peliculas " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al buscar peliculas " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo!");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al crear archivo " + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx{
        var archivo = new File(nombreArchivo);
        if(!existe(nombreArchivo)){
            archivo.delete();
        }
    }
}
