package datos;

import domain.Pelicula;
import excepciones.*;
import java.util.List;

public interface IAccesoDatos {
    
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    
    void crear (String nombreArchivo) throws AccesoDatosEx;
    
    void borrar (String nombreArchivo) throws AccesoDatosEx;
    
    void cargar(Pelicula nombrePelicula, String nombreArchivo) throws EscrituraDatosEx;
    
    List<Pelicula> listar (String nombreArchivo) throws LecturaDatosEx;
    
    String buscar (String nombreArchivo, String nombrePelicula) throws LecturaDatosEx;
}