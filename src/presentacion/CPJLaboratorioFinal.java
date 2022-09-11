/*
    Esta clase es aquella con la que el usuario va a interactuar.
 */
package presentacion;

import java.util.Scanner;
import negocio.CatalogoPeliculasImpl;
import negocio.ICatalogoPeliculas;

public class CPJLaboratorioFinal extends CatalogoPeliculasImpl {

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        
        String respuestaSalida = "S";
        int respuestaMenu;
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        
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
                    break;
                }
                case 1 -> {
                    catalogo.iniciarArchivo();
                    break;
                }
                case 2 -> {
                    System.out.print("\n- Ingrese el nombre de la pelicula a agregar: ");
                    String nombrePelicula = scanner.nextLine();

                    catalogo.agregarPeliculas(nombrePelicula);
                    break;
                }
                case 3 -> {
                    System.out.println("\n- Sus peliculas actuales son: ");
                    catalogo.listarPeliculas();
                    break;
                }
                case 4 -> {
                    System.out.print("\n- Ingrese el nombre de la pelicula a buscar: ");
                    String nombrePelicula = scanner.nextLine();
                    
                    catalogo.buscarPelicula(nombrePelicula);
                    break;
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
