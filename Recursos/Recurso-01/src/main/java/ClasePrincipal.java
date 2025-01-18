import Objetos.*;

import java.util.Scanner;

/**
 * Clase principal para mostrar el uso de la lista.
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
    /* Lista de animes */
    private static List<Anime> listaAnime;
    /* Lista de estudiantes */
    private static List<Estudiante> listaEstudiante;
    /* Lista de libros */
    private static List<Libro> listaLibro;

    /**
     * Método que despliega el primer menú para seleccionar el tipo de lista.
     * 
     * @param args, los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        System.out.println(BOLD + BLUE + "Seleccione el tipo de lista que desea usar:" + RESET);
        System.out.println(BLUE + "1. Usar lista de Animes (interacción)\n" +
                "2. Usar lista de Estudiantes (interacción)\n" +
                "3. Usar lista de Libros (interacción)\n" +
                "4. Representación predeterminada\n" +
                "5. Salir" + RESET);
        String eleccion = entrada.nextLine();
        switch (eleccion) {
            case "1":
                listaAnime = new Lista<Anime>();
                menuInteraccionAnime();
                break;
            case "2":
                listaEstudiante = new Lista<Estudiante>();
                menuInteraccionEstudiante();
                break;
            case "3":
                listaLibro = new Lista<Libro>();
                menuInteraccionLibro();
                break;
            case "4":
                representacionPrederminado();
                break;
            case "5":
                System.out.println(BOLD + RED + "Saliendo..." + RESET);
                System.exit(0);
                break;
            default:
                System.out.println(BOLD + RED + "Opción no válida" + RESET);
                main(args);
                break;
        }
    }

    /**
     * Despliega el menú en caso de haber seleccionado la lista de animes.
     */
    public static void menuInteraccionAnime() {
        System.out.println(BOLD + BLUE + "---------------[ MENÚ ANIME ]---------------" + RESET);
        System.out.println(BOLD + BLUE + "Seleccione la acción que desea realizar:" + RESET);
        System.out.println(BLUE + "1. Agregar un anime\n" +
                                  "2. Eliminar un anime\n" +
                                  "3. Obtener un anime\n" +
                                  "4. Mostrar la lista de animes\n" +
                                  "5. Salir" + RESET);
        String eleccion = entrada.nextLine();
        switch (eleccion) {
            case "1":
                listaAnime.agrega(agregaAnime());
                System.out.println(YELLOW + "Elemento agregado a la lista de animes" + RESET);
                menuInteraccionAnime();
                break;
            case "2":
                System.out.println(BLUE + "Ingrese la posición del elemento que desea eliminar: " + RESET);
                int posicionElimina = verificaEntero();
                if (posicionElimina < 0 || posicionElimina >= listaAnime.tamaño()) {
                    System.out.println(BOLD + RED + "Posición no válida" + RESET);
                    menuInteraccionAnime();
                }
                System.out.println(BOLD + RED + "Esta seguro que desea eliminar el elemento en la posición "
                        + posicionElimina + "? (s/n)" + RESET);
                System.out.println(listaAnime.obtiene(posicionElimina));
                String confirmacion = entrada.nextLine();
                if (confirmacion.equals("s")) {
                    listaAnime.elimina(posicionElimina);
                    System.out.println(YELLOW + "Elemento eliminado" + RESET);
                }
                menuInteraccionAnime();
                break;
            case "3":
                System.out.println(BLUE + "Ingrese la posición del elemento que desea obtener: " + RESET);
                int posicionObtiene = verificaEntero();
                Anime anime = listaAnime.obtiene(posicionObtiene);
                System.out.println(YELLOW + "Elemento " + posicionObtiene + " obtenido:" + RESET);
                System.out.println(anime.toString());
                menuInteraccionAnime();
                break;
            case "4":
                System.out.println(BOLD + YELLOW + "Lista de animes:" + RESET);
                System.out.println(listaAnime.toString());
                menuInteraccionAnime();
                break;
            case "5":
                System.out.println(BOLD + RED + "Saliendo..." + RESET);
                System.exit(0);
                break;
            default:
                System.out.println(BOLD + RED + "Opción no válida" + RESET);
                menuInteraccionAnime();
                break;
        }
    }

    /**
     * Despliega el menú en caso de haber seleccionado la lista de estudiantes.
     */
    public static void menuInteraccionEstudiante() {
        System.out.println(BOLD + BLUE + "---------------[ MENÚ ESTUDIANTE ]---------------" + RESET);
        System.out.println(BOLD + BLUE + "Seleccione la acción que desea realizar:" + RESET);
        System.out.println(BLUE + "1. Agregar un estudiante\n" +
                                  "2. Eliminar un estudiante\n" +
                                  "3. Obtener un estudiante\n" +
                                  "4. Mostrar la lista de estudiantes\n" +
                                  "5. Salir" + RESET);
        String eleccion = entrada.nextLine();
        switch (eleccion) {
            case "1":
                listaEstudiante.agrega(agregaEstudiante());
                System.out.println(YELLOW + "Elemento agregado a la lista de estudiantes" + RESET);
                menuInteraccionEstudiante();
                break;
            case "2":
                System.out.println(BLUE + "Ingrese la posición del elemento que desea eliminar: " + RESET);
                int posicionElimina = verificaEntero();
                if (posicionElimina < 0 || posicionElimina >= listaEstudiante.tamaño()) {
                    System.out.println(BOLD + RED + "Posición no válida" + RESET);
                    menuInteraccionEstudiante();
                }
                System.out.println(BOLD + RED + "Esta seguro que desea eliminar el elemento en la posición "
                        + posicionElimina + "? (s/n)" + RESET);
                System.out.println(listaEstudiante.obtiene(posicionElimina));
                String confirmacion = entrada.nextLine();
                if (confirmacion.equals("s")) {
                    listaEstudiante.elimina(posicionElimina);
                    System.out.println(YELLOW + "Elemento eliminado" + RESET);
                }
                menuInteraccionEstudiante();
                break;
            case "3":
                System.out.println(BLUE + "Ingrese la posición del elemento que desea obtener: " + RESET);
                int posicionObtiene = verificaEntero();
                Estudiante estudiante = listaEstudiante.obtiene(posicionObtiene);
                System.out.println(YELLOW + "Elemento " + posicionObtiene + " obtenido:" + RESET);
                System.out.println(estudiante.toString());
                menuInteraccionEstudiante();
                break;
            case "4":
                System.out.println(BOLD + YELLOW + "Lista de estudiantes:" + RESET);
                System.out.println(listaEstudiante.toString());
                menuInteraccionEstudiante();
                break;
            case "5":
                System.out.println(BOLD + RED + "Saliendo..." + RESET);
                System.exit(0);
                break;
            default:
                System.out.println(BOLD + RED + "Opción no válida" + RESET);
                menuInteraccionEstudiante();
                break;
        }
    }

    /**
     * Despliega el menú en caso de haber seleccionado la lista de libros.
     */
    public static void menuInteraccionLibro() {
        System.out.println(BOLD + BLUE + "---------------[ MENÚ LIBRO ]---------------" + RESET);
        System.out.println(BOLD + BLUE + "Seleccione la acción que desea realizar:" + RESET);
        System.out.println(BLUE + "1. Agregar un libro\n" +
                                  "2. Eliminar un libro\n" +
                                  "3. Obtener un libro\n" +
                                  "4. Mostrar la lista de libros\n" +
                                  "5. Salir" + RESET);
        String eleccion = entrada.nextLine();
        switch (eleccion) {
            case "1":
                listaLibro.agrega(agregaLibro());
                System.out.println(YELLOW + "Elemento agregado a la lista de libros" + RESET);
                menuInteraccionLibro();
                break;
            case "2":
                System.out.println(BLUE + "Ingrese la posición del elemento que desea eliminar: " + RESET);
                int posicionElimina = verificaEntero();
                if (posicionElimina < 0 || posicionElimina >= listaLibro.tamaño()) {
                    System.out.println(BOLD + RED + "Posición no válida" + RESET);
                    menuInteraccionLibro();
                }
                System.out.println(BOLD + RED + "Esta seguro que desea eliminar el elemento en la posición "
                        + posicionElimina + "? (s/n)" + RESET);
                System.out.println(listaLibro.obtiene(posicionElimina));
                String confirmacion = entrada.nextLine();
                if (confirmacion.equals("s")) {
                    listaLibro.elimina(posicionElimina);
                    System.out.println(YELLOW + "Elemento eliminado" + RESET);
                }
                menuInteraccionLibro();
                break;
            case "3":
                System.out.println(BLUE + "Ingrese la posición del elemento que desea obtener: " + RESET);
                int posicionObtiene = verificaEntero();
                Libro libro = listaLibro.obtiene(posicionObtiene);
                System.out.println(YELLOW + "Elemento " + posicionObtiene + " obtenido:" + RESET);
                System.out.println(libro.toString());
                menuInteraccionLibro();
                break;
            case "4":
                System.out.println(BOLD + YELLOW + "Lista de libros:" + RESET);
                System.out.println(listaLibro.toString());
                menuInteraccionLibro();
                break;
            case "5":
                System.out.println(BOLD + RED + "Saliendo..." + RESET);
                System.exit(0);
                break;
            default:
                System.out.println(BOLD + RED + "Opción no válida" + RESET);
                menuInteraccionLibro();
                break;
        }
    }

    /**
     * Método para agregar un anime especificando cada atributo del anime.
     * Mantiene la interacción con el usuario quien ingresa los datos.
     * 
     * @return anime, el anime creado.
     */
    public static Anime agregaAnime() {
        System.out.println(BOLD + BLUE + "Agregando un anime" + RESET);
        System.out.println(BLUE + "Ingrese el titulo del anime: " + RESET);
        String titulo = entrada.nextLine();
        System.out.println(BLUE + "Ingrese el genero del anime: " + RESET);
        String genero = entrada.nextLine();
        System.out.println(BLUE + "Ingrese la cantidad de episodios del anime: " + RESET);
        int episodios = verificaEntero();
        System.out.println(BLUE + "Ingrese la edad recomendada para ver el anime: " + RESET);
        int edadRecomendada = verificaEntero();
        System.out.println(BLUE + "Ingrese el año en que se estreno el anime: " + RESET);
        int añoEstreno = verificaEntero();
        System.out.println(BLUE + "Ingrese la cantidad de temporadas del anime: " + RESET);
        int temporadas = verificaEntero();
        Anime anime = new Anime(titulo, genero, episodios, edadRecomendada, añoEstreno, temporadas);
        return anime;
    }

    /**
        * Método para agregar un estudiante especificando cada atributo del estudiante.
        * Mantiene la interacción con el usuario quien ingresa los datos.
        * 
        * @return estudiante, el estudiante creado.
        */
    public static Estudiante agregaEstudiante() {
        System.out.println(BOLD + BLUE + "Agregando un estudiante" + RESET);
        System.out.println(BLUE + "Ingrese el nombre del estudiante: " + RESET);
        String nombre = entrada.nextLine();
        System.out.println(BLUE + "Ingrese el apellido del estudiante: " + RESET);
        String apellido = entrada.nextLine();
        System.out.println(BLUE + "Ingrese la edad del estudiante: " + RESET);
        int edad = verificaEntero();
        System.out.println(BLUE + "Ingrese la carrera del estudiante: " + RESET);
        String carrera = entrada.nextLine();
        System.out.println(BLUE + "Ingrese el número de cuenta del estudiante: " + RESET);
        int noCuenta = verificaEntero();
        System.out.println(BLUE + "Ingrese el promedio del estudiante: " + RESET);
        double promedio = verificaDouble();
        Estudiante estudiante = new Estudiante(nombre, apellido, edad, carrera, noCuenta, promedio);
        return estudiante;
    }

    /**
     * Método para agregar un libro especificando cada atributo del libro.
     * Mantiene la interacción con el usuario quien ingresa los datos.
     * 
     * @return libro, el libro creado.
     */
    public static Libro agregaLibro() {
        System.out.println(BOLD + BLUE + "Agregando un libro" + RESET);
        System.out.println(BLUE + "Ingrese el titulo del libro: " + RESET);
        String titulo = entrada.nextLine();
        System.out.println(BLUE + "Ingrese el autor del libro: " + RESET);
        String autor = entrada.nextLine();
        System.out.println(BLUE + "Ingrese la editorial del libro: " + RESET);
        String editorial = entrada.nextLine();
        System.out.println(BLUE + "Ingrese el genero del libro: " + RESET);
        String genero = entrada.nextLine();
        System.out.println(BLUE + "Ingrese el año en que se publico el libro: " + RESET);
        int añoPublicacion = verificaEntero();
        System.out.println(BLUE + "Ingrese la cantidad de paginas del libro: " + RESET);
        int noPaginas = verificaEntero();
        Libro libro = new Libro(titulo, autor, editorial, genero, añoPublicacion, noPaginas);
        return libro;
    }

    /**
     * Método para verificar que el número ingresado sea un entero.
     * 
     * @return entero, el número entero ingresado.
     */
    private static int verificaEntero() {
        try {
            return Integer.parseInt(entrada.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(BOLD + RED + "El número debe ser un entero" + RESET);
            return verificaEntero();
        }
    }

    /**
     * Método para verificar que el número ingresado sea un decimal.
     * 
     * @return decimal, el número decimal ingresado.
     */
    private static double verificaDouble() {
        try {
            return Double.parseDouble(entrada.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(BOLD + RED + "El número debe ser un entero o decimal" + RESET);
            return verificaDouble();
        }
    }

    /**
     * Método para representar la lista de estudiantes con valores predeterminados.
     */
    public static void representacionPrederminado() {
        /* Creamos la lista entre los diamantes debemos agregar el tipo */
        List<Estudiante> lista = new Lista<>();
        /* Creamos los estudiantes */
        Estudiante e1 = new Estudiante("Juan", "Perez", 20, "Ciencias de la computación", 314012345, 8.5);
        Estudiante e2 = new Estudiante("Maria", "Lopez", 21, "Biologia", 315097891, 9.0);
        Estudiante e3 = new Estudiante("Pedro", "Ramirez", 22, "Fisica", 302345678, 8.0);
        Estudiante e4 = new Estudiante("Ana", "Garcia", 23, "Matematicas", 328908659, 9.5);
        /* Ahora podemos agregar los estudiantes a la lista */
        lista.agrega(e1);
        lista.agrega(e2);
        lista.agrega(e3);
        lista.agrega(e4);
        /* Mostramos la lista */
        System.out.println(BOLD + YELLOW + "Lista de estudiantes con valores predeterminados:" + RESET);
        System.out.println(lista.toString());
        System.out.println(YELLOW + "Estudiantes en la lista: " + lista.tamaño() + RESET);
        System.out.println(BOLD + RED + "Eliminando al estudiante en la posición 2" + RESET);
        System.out.println(RED + lista.elimina(2) + RESET);
        System.out.println(BOLD + YELLOW + "Imprimiendo la lista después de eliminar un estudiante" + RESET);
        System.out.println(lista.toString());
        System.out.println(YELLOW + "Estudiantes en la lista: " + lista.tamaño() + RESET);
        System.out.println(BOLD + YELLOW + "Obteniendo al estudiante en la posición 1" + RESET);
        System.out.println(lista.obtiene(1));
        Estudiante e5 = new Estudiante("Luis", "Gomez", 24, "Quimica", 301234567, 8.0);
        System.out.println(BOLD + YELLOW + "Agregando al estudiante Luis en la posición 2" + RESET);
        lista.agrega(2, e5);
        System.out.println(lista.toString());
    }
}