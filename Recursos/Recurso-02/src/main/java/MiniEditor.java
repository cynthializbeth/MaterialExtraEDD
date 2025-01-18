import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


/**
 * Clase que simula un editor de texto simple que permite agregar texto, mostrarlo,
 * deshacer y rehacer, este usa una pila para almacenar los cambios y poder
 * deshacerlos o rehacerlos.
 * @author Cynthia L. Sánchez
 * @version 1.0
 */
public class MiniEditor {
  /* Pila de operaciones hechas */
  private Stack<String> hechas = new Stack<>();
  /* Pila de operaciones deshechas */
  private Stack<String> deshechas = new Stack<>();
  /* Lista que mantiene el texto actualizado */
  private List<String> textoActual = new ArrayList<String>();
  /* Scanner para leer la entrada del usuario */
  private Scanner entrada = new Scanner(System.in);
  /* Archivo donde se guarda el texto */
  private String archivo = "";
  /* Colores */
  private static String RESET = "\u001B[0m";
  private static String RED = "\u001B[31m";
  private static String YELLOW = "\u001B[33m";
  private static String BLUE = "\u001B[34m";
  /* Formato en negritas */
  private static String BOLD = "\u001B[1m";

  /**
   * Método que muestra el menú de opciones para el MiniEditor.
   */
  public void menu() {
    System.out.println(BOLD + YELLOW + "\nBienvenid@ al Mini Editor" + RESET);
    System.out.println(BLUE + "\n1. Agregar texto\n" +
        "2. Mostrar texto\n" +
        "3. Deshacer\n" +
        "4. Rehacer\n" +
        "5. Guardar en un archivo\n" +
        "6. Salir" + RESET);
    String eleccion = entrada.nextLine();
    switch (eleccion) {
      case "1":
        System.out.println(BLUE + "\nIngrese el texto, para mayor claridad puede separar por renglones.\n"
            + "Cuando haya terminado " + BOLD + "deje una línea en blanco y pulse enter" + RESET);
        agregaTexto();
        menu();
        break;
      case "2":
        System.out.println(YELLOW + "\nTexto actual:" + RESET);
        imprimeTexto();
        menu();
        break;
      case "3":
        deshacer();
        menu();
        break;
      case "4":
        rehacer();
        menu();
        break;
      case "5":
        System.out.println(BLUE + "\nDa el nombre del archivo en donde se guardara el texto\n" + RESET);
        archivo = entrada.nextLine();
        if (guardarArchivo(archivo)) {
          System.out.println(YELLOW + "\nEl archivo fue guardado con exito\n" + RESET);
        }
        menu();
        break;
      case "6":
        System.out.println(RED + "Saliendo..." + RESET);
        System.exit(0);
        break;
      default:
        System.out.println(RED + "\nOpción inválida intente de nuevo\n" + RESET);
        menu();
    }
  }

  /**
   * Método que agrega texto a la lista de texto actual y a la pila de operaciones
   */
  public void agregaTexto() {
    while (true) {
      String texto = entrada.nextLine();
      if (texto.isEmpty()) {
        break;
      }
      hechas.push(texto);
      textoActual.add(texto);
    }
  }

  /**
   * Método que guarda el texto en un archivo.
   * 
   * @param archivo nombre del archivo donde se guardará el texto.
   * @return true si se guardó el archivo, false en caso contrario.
   */
  public boolean guardarArchivo(String archivo) {
    try {
      PrintStream writer = new PrintStream(new FileOutputStream(archivo, true));
      for (String linea : textoActual) {
        writer.println(linea);
      }
      writer.close();
    } catch (Exception e) {
      System.out.println(RED + "\nNo se pudo guardar el archivo.\n" + e + RESET);
    }
    return true;
  }

  /**
   * Método que deshace la última acción realizada, si no hay nada que deshacer
   * muestra un mensaje.
   * Considera revisar que la pila de acciones hechas no esté vacía y también
   * remueve el último elemento de la lista de texto actual.
   */
  public void deshacer() {
    if (hechas.isEmpty()) {
      System.out.println(RED + "\nNo hay nada que deshacer\n" + RESET);
    } else {
      deshechas.push(hechas.pop());
      textoActual.remove(textoActual.size() - 1);
      System.out.println(YELLOW + "\nSe deshizo la última acción\n" + RESET);
      imprimeTexto();
    }
  }

  /**
   * Método que rehace la última acción deshecha, si no hay nada que rehacer muestra
   * un mensaje.
   * Considera revisar que la pila de acciones deshechas no esté vacía y también
   * agrega el último elemento de la lista de texto actual.
   */ 
  public void rehacer() {
    if (deshechas.isEmpty()) {
      System.out.println(RED + "\nNo hay nada que rehacer\n" + RESET);
    } else {
      textoActual.add(deshechas.peek());
      hechas.push(deshechas.pop());
      System.out.println(YELLOW + "\nSe rehizo la última acción\n" + RESET);
      imprimeTexto();
    }
  }

  /**
   * Método que imprime el texto actual.
   */
  public void imprimeTexto() {
    for (String linea : textoActual) {
      System.out.println(linea);
    }
    System.out.println();
  }
}
