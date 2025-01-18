import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Clase que simula un gestor de tareas simple que permite agregar tareas, verlas,
 * ver la tarea actual, completar la tarea actual, etc. se apoya del uso de colas
 * para almacenar las tareas.
 * 
 * @author Cynthia L. Sánchez
 * @version 1.0
 */
public class MiniGestorTareas {
    /* Cola de tareas */
    private Queue<String> tareas = new LinkedList<>();
    /* Scanner para leer la entrada del usuario */
    private Scanner entrada = new Scanner(System.in);
    /* Colores */
    private static String RESET = "\u001B[0m";
    private static String RED = "\u001B[31m";
    private static String YELLOW = "\u001B[33m";
    private static String BLUE = "\u001B[34m";
    /* Formato en negritas */
    private static String BOLD = "\u001B[1m";

    public void menu() {
        System.out.println(BOLD + YELLOW + "\nBienvenid@ al Mini Gestor de Tareas" + RESET);
        System.out.println(BLUE+"1. Agregar tarea\n" +
                "2. Ver tareas\n" +
                "3. Ver la tarea actual\n" +
                "4. Completar la tarea actual\n" +
                "5. Salir"+RESET);
        int eleccion = entrada.nextInt();
        switch (eleccion) {
            case 1:
                entrada.nextLine();
                System.out.println(BLUE+"Ingrese la tarea:\n"+RESET);
                String tarea = entrada.nextLine();
                tareas.add(tarea);
                System.out.println(YELLOW+"Tarea agregada"+RESET);
                menu();
                break;
            case 2:
                System.out.println(YELLOW+"Tareas Guardadas:"+RESET);
                System.out.println(tareas);
                menu();
                break;
            case 3:
                System.out.println(YELLOW+"Tarea actual:"+RESET);
                System.out.println(tareas.peek());
                menu();
                break;
            case 4:
                entrada.nextLine();
                System.out.println(RED+"Desea completar la tarea actual? (s/n)"+RESET);
                System.out.println(tareas.peek());
                if (entrada.nextLine().equals("s")) {
                    System.out.println(YELLOW+"La tarea " + tareas.peek() + " ha sido completada"+RESET);
                    tareas.poll();
                } else {
                    System.out.println(RED+"La tarea " + tareas.peek() + " no ha sido completada"+RESET);
                }
                menu();
                break;
            case 5:
                System.out.println(RED+"Saliendo...");
                System.exit(0);
                break;
            default:
                System.out.println(RED+"Opción inválida intente de nuevo"+RESET);
                menu();
        }
    }
}
