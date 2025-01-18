/**
 * Interfaz que define los métodos que debe tener una lista.
 * @author Cynthia L. Sánchez
 * @version 1.0
 * @param <E>, el tipo de elementos que contendrá la lista.
 */
public interface List<E> {

    /**
     * Agrega un elemento al final de la lista.
     * @param e, el elemento a agregar.
     */
    public void agrega(E e);

    /**
     * Agrega un elemento a la lista en una posición específica.
     * @param index, la posición en la que se agregará el elemento.
     * @param e, el elemento a agregar.
     */
    public void agrega(int index, E e);

    /**
     * Obtiene un elemento de la lista en una posición específica.
     * @param index, la posición del elemento a obtener.
     * @return el elemento en la posición index.
     */
    public E obtiene(int index);

    /**
     * Elimina un elemento de la lista en una posición específica.
     * @param index, la posición del elemento a eliminar.
     * @return el elemento eliminado.
     */
    public E elimina(int index);

    /**
     * Obtiene el tamaño de la lista.
     * @return el tamaño de la lista.
     */
    public int tamaño();

    /**
     * Verifica si la lista contiene un elemento en particular.
     * @return true si la lista contiene el elemento, false en otro caso.
     */
    public boolean contiene(E e);

    /**
     * Regresa una representación en cadena de la lista.
     * @return cadena, la representación en cadena de la lista.
     */
    public String toString();
}