import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase que implementa la interfaz List.
 * 
 * @author Cynthia L. Sánchez
 * @version 1.0
 * @param <E>, el tipo de elementos que contendrá la lista.
 */
public class Lista<E> implements List<E> {
    /* Cabeza, el primer nodo de la lista */
    private Nodo cabeza;
    /* Cola, el último nodo de la lista */
    private Nodo cola;
    /* Tamaño, el tamaño de la lista */
    private int tamaño;

    /**
     * Clase que define un nodo de la lista.
     */
    public class Nodo {
        /* El elemento dentro del nodo */
        E elemento;
        /* El nodo siguiente */
        Nodo siguiente;

        /**
         * Constructor de la clase Nodo.
         * 
         * @param e, el elemento del nodo.
         */
        public Nodo(E e) {
            elemento = e;
            siguiente = null;
        }

        /**
         * Constructor de la clase Nodo.
         * 
         * @param e, el elemento del nodo.
         * @param n, el nodo siguiente.
         */
        public Nodo(E e, Nodo n) {
            elemento = e;
            siguiente = n;
        }
    }

    /**
     * Clase que implementa la interfaz Iterator.
     */
    public class Iterador implements Iterator<E> {

        /* El nodo donde se encuentra el iterador */
        private Nodo actual;

        /**
         * Constructor de la clase Iterador.
         */
        public Iterador() {
            actual = cabeza;
        }

        /**
         * Verifica si hay un siguiente elemento en la lista.
         * 
         * @return true si hay un siguiente elemento, false en otro caso.
         */
        public boolean hasNext() {
            return actual != null;
        }

        /**
         * Obtiene el siguiente elemento de la lista.
         * 
         * @return el siguiente elemento.
         */
        public E next() {
            // Verifica si hay un siguiente elemento
            if (!hasNext()) {
                throw new NoSuchElementException("No hay siguiente elemento");
            }
            // Si lo hay obtenemos el siguiente elemento y nos movemos al siguiente nodo
            E e = actual.elemento;
            actual = actual.siguiente;
            return e;
        }
    }

    /**
     * Obtiene un iterador de la lista.
     * @return un iterador de la lista.
     */
    public Iterator<E> iterator() {
        return new Iterador();
    }

    /**
     * Agrega un elemento al final de la lista.
     * 
     * @param e, el elemento a agregar.
     */
    public void agrega(E e) {
        // Si no hay elementos en la lista, el nuevo nodo será la cabeza y la cola
        if (cabeza == null) {
            cabeza = new Nodo(e);
            cola = cabeza;
        } else {
            // Si ya hay elementos en la lista, el nuevo nodo será el siguiente de la cola
            // y la cola será el nuevo nodo
            Nodo nuevo = new Nodo(e);
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        tamaño++;
    }

    /**
     * Agrega un elemento a la lista en una posición específica.
     * 
     * @param index, la posición en la que se agregará el elemento.
     * @param e,     el elemento a agregar.
     */
    public void agrega(int index, E e) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Indice fuera de rango, el indice debe ser mayor o igual a 0 y menor que" + tamaño);
        }
        // Caso 1: El elemento se agrega al inicio de la lista
        if (index == 0) {
            Nodo nuevo = new Nodo(e, cabeza);
            cabeza = nuevo;
            if (cola == null) {
                cola = cabeza;
            }
        // Caso 2: El elemento se agrega al final de la lista
        if (index == tamaño-1){
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        // Caso 2: El elemento se agrega en alguna posición intermedia
        } else {
            Nodo aux = cabeza;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.siguiente;
            }
            Nodo nuevo = new Nodo(e, aux.siguiente);
            aux.siguiente = nuevo;
        }
        tamaño++;
    }

    /**
     * Obtiene un elemento de la lista en una posición específica.
     * 
     * @param index, la posición del elemento a obtener.
     * @return el elemento en la posición index.
     */
    public E obtiene(int index) {
        // Verifica si el índice está dentro de los límites de la lista
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Indice fuera de rango, el indice debe ser mayor o igual a 0 y menor que" + tamaño);
        }
        // Obtenemos el elemento en la posición index
        Nodo aux = cabeza;
        for (int i = 0; i < index; i++) {
            aux = aux.siguiente;
        }
        return aux.elemento;
    }

    /**
     * Elimina un elemento de la lista en una posición específica.
     * 
     * @param index, la posición del elemento a eliminar.
     * @return el elemento eliminado.
     */
    public E elimina(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Indice fuera de rango, el indice debe ser mayor o igual a 0 y menor que" + tamaño);
        }
        // Caso 1: El elemento se elimina del inicio de la lista
        if (index == 0){
            E e = cabeza.elemento;
            cabeza = cabeza.siguiente;
            tamaño--;
            return e;
        }
        // Caso 2: El elemento se elimina de alguna otra posición
        Nodo aux = cabeza;
        for (int i = 0; i < index - 1; i++) {
            aux = aux.siguiente;
        }
        E e = aux.siguiente.elemento;
        aux.siguiente = aux.siguiente.siguiente;
        tamaño--;
        return e;
    }

    /**
     * Obtiene el tamaño de la lista.
     * 
     * @return el tamaño de la lista.
     */
    public int tamaño() {
        return tamaño;
    }

    /**
     * Verifica si la lista contiene un elemento en particular.
     * 
     * @return true si la lista contiene el elemento, false en otro caso.
     */
    public boolean contiene(E e) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Regresa una representación en cadena de la lista.
     * 
     * @return cadena, la representación en cadena de la lista.
     */
    public String toString() {
        String s = "";
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            s += it.next();
            if (it.hasNext()) {
                s += "\n\n";
            }
        }
        return s;
    }
}