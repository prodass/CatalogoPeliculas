/*
    Se encarga de contener las operaciones necesarias para la aplicacion del catalogo.
    Interface.
*/
package negocio;

public interface ICatalogoPeliculas {
    String NOMBRE_ARCHIVO = "c:\\CatalogoPeliculas\\peliculas.txt";
    
    void agregarPeliculas(String nombrePelicula);
    void listarPeliculas();
    void buscarPelicula(String buscar);
    void iniciarArchivo();
}
