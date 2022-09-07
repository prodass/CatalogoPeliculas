/*
    Se encarga de contener la implementacion de las operaciones necesarias para la aplicacion
    CatalogoPeliculas.
    Clase.
 */
package negocio;

import datos.AccesoDatos;

public class CatalogoPeliculasImpl extends AccesoDatos implements ICatalogoPeliculas {

    public CatalogoPeliculasImpl() {

    }

    public static String iniciarArchivo(String nombreArchivo) {
        if (!existe(nombreArchivo)) {
            if (crearArchivo(nombreArchivo)) {
                return "El archivo fue creado con exito!";
            } else {
                return "El archivo no pudo ser creado.";
            }
        } else {
            return "El archivo ya existe!";
        }
    }

    public String borrar(String nombreArchivo) {
        if (borrarArchivo(nombreArchivo)) {
            return "El archivo se ha borrado con exito!";
        } else {
            return "El archivo no se pudo borrar!";
        }
    }

    public static String agregarPelicula(String nombrePelicula, String nombreArchivo) {
        if (!existe(nombreArchivo)) {
            return "Nombre del archivo ingresado no existe!";
        } else {
            if (cargarPelicula(nombrePelicula, nombreArchivo)) {
                return "La pelicula " + nombrePelicula + " ha sido agregada con exito!";
            } else {
                return "No se ha podido agregar la pelicula deseada.";
            }
        }
    }

    public static void listarPeliculas(String nombreArchivo) {
        var listadoPeliculas = listar(nombreArchivo);

        for (Object elemento : listadoPeliculas) {
            System.out.println("\t.- " + elemento);
        }
    }
    
    public static String buscarPelicula(String nombreArchivo, String nombrePelicula) {
        if(buscar(nombreArchivo, nombrePelicula)){
            return "La pelicula" + " existe dentro del catalogo!";
        }
        else {
            return "La pelicula" + " no existe dentro del catalogo!";
        }
    }
}
