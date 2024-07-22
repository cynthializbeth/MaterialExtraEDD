import java.util.Scanner;

/**
 * Clase principal que permite al usuario elegir entre dos opciones.
 * Un MiniEditor que usa pilas y un MiniGestorTareas que usa colas.
 * 
 * @author Cynthia L. Sánchez
 * @version 1.0
 */
public class ClasePrincipal {
    /* Colores */
    private static String RESET = "\u001B[0m";
    private static String RED = "\u001B[31m";
    private static String YELLOW = "\u001B[33m";
    private static String BLUE = "\u001B[34m";
    /* Formato en negritas */
    private static String BOLD = "\u001B[1m";
    /* Escaner para interactuar con el usuario */
    private static Scanner entrada = new Scanner(System.in);

    /**
     * Método principal que permite al usuario elegir entre dos opciones.
     * 
     * MiniEditor: un editor de texto simple que permite agregar texto, mostrarlo,
     * deshacer y rehacer, este usa una pila para almacenar los cambios y poder
     * deshacerlos o rehacerlos.
     * 
     * MiniGestorTareas: un gestor de tareas simple que permite agregar tareas,
     * verlas, ver la tarea actual, etc. se apoya del uso de colas para almacenar
     * las tareas.
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(BOLD + YELLOW + "Bienvenido al recurso de pilas y colas" + RESET);
        System.out.println(YELLOW + "Por favor elige una opción:\n"+ RESET + BLUE
                                  + "1-. Usar el MiniEditor (uso de pilas)\n"
                                  + "2-. Usar el MiniGestorTareas (uso de colas)\n"
                                  + "3-. Salir"+ RESET);
        String eleccion = entrada.nextLine();
        switch (eleccion) {
            case "1":
                MiniEditor editor = new MiniEditor();
                editor.menu();
                break;
            case "2":
                MiniGestorTareas gestor = new MiniGestorTareas();
                gestor.menu();
                break;
            case "3":
                System.out.println(RED + "Saliendo..." + RESET);
                entrada.close();
                System.exit(0);
                break;
            default:
                System.out.println(RED + "Opción no válida, intenta de nuevo" + RESET);
                main(args);
                break;
        }
    }
}