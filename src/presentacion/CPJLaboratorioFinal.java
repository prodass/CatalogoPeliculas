/*
    Esta clase es aquella con la que el usuario va a interactuar.
 */
package presentacion;

import java.util.Scanner;
import negocio.CatalogoPeliculasImpl;

public class CPJLaboratorioFinal extends CatalogoPeliculasImpl {

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        
        String respuestaSalida = "S";
        int respuestaMenu;
        var nombreArchivo = "c:\\CatalogoPeliculas\\peliculas.txt";
        
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.print("---------------------------------------------------------");
            System.out.println("\n\tSistema gestor Catalogos de Peliculas");
            System.out.println("Elige una opcion:");
            System.out.println("1.- Iniciar catalogo peliculas.");
            System.out.println("2.- Agregar pelicula.");
            System.out.println("3.- Listar peliculas.");
            System.out.println("4.- Buscar pelicula.");
            System.out.println("0.- Salir.");
            System.out.print("Ingrese su respuesta: ");
            respuestaMenu = Integer.parseInt(scanner.nextLine());

            switch (respuestaMenu) {
                case 0 -> {
                    respuestaSalida = "n";
                }
                case 1 -> {
                    Mensaje(iniciarArchivo(nombreArchivo));
                }
                case 2 -> {
                    System.out.print("\n- Ingrese el nombre de la pelicula a agregar: ");
                    String nombrePelicula = scanner.nextLine();

                    Mensaje(agregarPelicula(nombrePelicula, nombreArchivo));
                }
                case 3 -> {
                    System.out.println("\n- Sus peliculas actuales son: ");
                    listarPeliculas(nombreArchivo);
                }
                case 4 -> {
                    System.out.print("\n- Ingrese el nombre de la pelicula a buscar: ");
                    String nombrePelicula = scanner.nextLine();
                    
                    Mensaje(buscarPelicula(nombreArchivo, nombrePelicula));
                }
            }

            while (respuestaSalida.equals("S") && respuestaSalida.equals("n")) {
                System.out.print("Desea volver al menu? (S/n): ");
                respuestaSalida = scanner.nextLine();
            }
            System.out.println("\n");
        } while (respuestaSalida.equals("S"));
    }

    
    public static void Mensaje(String mensaje) {
        System.out.println("\n+ " + mensaje);
    }
}
