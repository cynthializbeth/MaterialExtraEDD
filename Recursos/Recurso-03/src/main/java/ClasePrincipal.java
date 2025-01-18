import java.util.List;
import java.util.Scanner;

/**
 * Clase principal, interactua con el usuario y muestra el menú de opciones
 * para interactuar con la clase BuscaAmigos.
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
    /* Instancia de la clase BuscaAmigos */
    private static BuscaAmigos buscaAmigos = new BuscaAmigos();

    /**
     * Método principal, llena la instancia de BuscaAmigos y muestra el menú.
     */
    public static void main(String[] args) {
        llenaBuscaAmigos();
        menu();
    }

    /**
     * Muestra el menú de opciones para interactuar con la clase BuscaAmigos.
     */
    public static void menu() {
        System.out.println(BOLD + YELLOW + "Bienvenido a Busca Amigos" + RESET);
        System.out.println(BLUE + "1. Agregar gusto\n" +
                "2. Agregar relación gusto persona\n" +
                "3. Buscar amigos\n" +
                "4. Obtener gustos\n" +
                "5. Salir" + RESET);
        String eleccion = entrada.nextLine();
        switch (eleccion) {
            case "1":
                System.out.println(YELLOW + "Ingresa el gusto" + RESET);
                String gusto = entrada.nextLine();
                if (buscaAmigos.agregaGusto(gusto)) {
                    System.out.println(YELLOW + "Gusto agregado" + RESET);
                } else {
                    System.out.println(RED + "El gusto ya existe" + RESET);
                }
                menu();
                break;
            case "2":
                System.out.println(YELLOW + "Ingresa el gusto" + RESET);
                String gustop = entrada.nextLine();
                System.out.println(YELLOW + "Ingresa la persona" + RESET);
                String persona = entrada.nextLine();
                buscaAmigos.relaciónGustoPersona(gustop, persona);
                System.out.println(YELLOW + "Relación agregada" + RESET);
                menu();
                break;
            case "3":
                System.out.println(YELLOW + "Ingresa la persona" + RESET);
                String personab = entrada.nextLine();
                List<String> posiblesAmigos = buscaAmigos.buscaAmigos(personab);
                if (posiblesAmigos.isEmpty()) {
                    System.out.println(RED + "No se encontraron amigos que compartan gustos T-T" + RESET);
                } else {
                    System.out.println(BOLD + BLUE + "Posibles amigos de " +
                            personab + " con gustos similares" + RESET);
                    for (String amigo : posiblesAmigos) {
                        System.out.println(amigo);
                    }
                }
                menu();
                break;
            case "4":
                System.out.println(YELLOW + "Ingresa la persona" + RESET);
                String personao = entrada.nextLine();
                List<String> gustosPersona = buscaAmigos.obtenGustos(personao);
                if (gustosPersona.isEmpty()) {
                    System.out.println(RED + "La persona no tiene gustos registrados" + RESET);
                } else {
                    System.out.println(BOLD + BLUE + "Gustos de " + personao + RESET);
                    for (String g : buscaAmigos.obtenGustos(personao)) {
                        System.out.println(g);
                    }
                }
                menu();
                break;
            case "5":
                System.out.println(BOLD + RED + "Saliendo..." + RESET);
                System.exit(0);
                break;
            default:
                break;
        }
    }

    /**
     * Llena la instancia de BuscaAmigos con gustos y relaciones de personas.
     */
    public static void llenaBuscaAmigos() {
        buscaAmigos.agregaGusto("Jugar futbol");
        buscaAmigos.agregaGusto("Ver peliculas");
        buscaAmigos.agregaGusto("Escuchar música");
        buscaAmigos.agregaGusto("Chatear");
        buscaAmigos.relaciónGustoPersona("Jugar futbol", "Juan");
        buscaAmigos.relaciónGustoPersona("Jugar futbol", "Pedro");
        buscaAmigos.relaciónGustoPersona("Jugar futbol", "Luis");
        buscaAmigos.relaciónGustoPersona("Ver peliculas", "Juan");
        buscaAmigos.relaciónGustoPersona("Ver peliculas", "Anna");
        buscaAmigos.relaciónGustoPersona("Escuchar música", "Anna");
        buscaAmigos.relaciónGustoPersona("Escuchar música", "Luis");
        buscaAmigos.relaciónGustoPersona("Jugar videojuegos", "Pedro");
        buscaAmigos.relaciónGustoPersona("Jugar videojuegos", "Sonia");
        buscaAmigos.relaciónGustoPersona("Jugar videojuegos", "Anna");
        buscaAmigos.relaciónGustoPersona("Jugar videojuegos", "Teresa");
        buscaAmigos.relaciónGustoPersona("Leer libros", "Sonia");
        buscaAmigos.relaciónGustoPersona("Hacer ejercicio", "Juan");
        buscaAmigos.relaciónGustoPersona("Hacer ejercicio", "Teresa");
        buscaAmigos.relaciónGustoPersona("Cocinar", "Luis");
        buscaAmigos.relaciónGustoPersona("Cocinar", "Karla");
        buscaAmigos.relaciónGustoPersona("Bailar", "Karla");
        buscaAmigos.relaciónGustoPersona("Bailar", "Teresa");
        buscaAmigos.relaciónGustoPersona("Ver anime", "Juan");
        buscaAmigos.relaciónGustoPersona("Ver anime", "Pedro");
        buscaAmigos.relaciónGustoPersona("Ver anime", "Teresa");
        buscaAmigos.relaciónGustoPersona("Escuchar k-pop", "Karla");
        buscaAmigos.relaciónGustoPersona("Escuchar k-pop", "Sonia");
        buscaAmigos.relaciónGustoPersona("Chatear", "Anna");
        buscaAmigos.relaciónGustoPersona("Chatear", "Luis");
        buscaAmigos.relaciónGustoPersona("Chatear", "Alfredo");
    }
}
