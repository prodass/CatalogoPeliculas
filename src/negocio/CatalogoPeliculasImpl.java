/*
    Se encarga de contener la implementacion de las operaciones necesarias para la aplicacion
    CatalogoPeliculas.
    Clase.
 */
package negocio;

import datos.AccesoDatosImpl;
import datos.IAccesoDatos;
import domain.Pelicula;
import excepciones.*;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPeliculas(String nombrePelicula) {
        var pelicula = new Pelicula(nombrePelicula);
        try {
            datos.cargar(pelicula, NOMBRE_ARCHIVO);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var listadoPeliculas = this.datos.listar(NOMBRE_ARCHIVO);
            for (var elemento : listadoPeliculas) {
                System.out.println("\t.- " + elemento);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos.");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String nombrePelicula) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_ARCHIVO, nombrePelicula);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error acceso a datos.");
            ex.printStackTrace(System.out);
        }
        System.out.println("Resultado = " + resultado);
    }
    
    @Override
    public void iniciarArchivo() {
        try {
            if (this.datos.existe(NOMBRE_ARCHIVO)) {
                System.out.println("El archivo "+ NOMBRE_ARCHIVO +" ya existe!");
            }
            else{
                datos.crear(NOMBRE_ARCHIVO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar el archivo del catalogo.");
            ex.printStackTrace(System.out); 
        }
    }
}
