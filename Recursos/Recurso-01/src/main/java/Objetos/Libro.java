package Objetos;

/**
 * Clase Libro: Representa un libro con sus atributos.
 * Un libro esta definido por su titulo, autor, editorial, genero, año de publicacion y no. de paginas.
 * @autor Cynthia L. Sánchez
 * @version 1.0
 */
public class Libro {
    /* Titulo, el titulo del libro */
    private String titulo;
    /* Autor, el autor del libro */
    private String autor;
    /* Editorial, la editorial del libro */
    private String editorial;
    /* Genero, el genero del libro */
    private String genero;
    /* Año de Publicacion, el año en que se publico el libro */
    private int añoPublicacion;
    /* No. Paginas, la cantidad de paginas del libro */
    private int noPaginas;

    /**
     * Constructor de la clase Libro
     * @param titulo, el titulo del libro
     * @param autor, el autor del libro
     * @param editorial, la editorial del libro
     * @param genero, el genero del libro
     * @param añoPublicacion, el año en que se publico el libro
     * @param noPaginas, la cantidad de paginas del libro
     */
    public Libro(String titulo, String autor, String editorial, String genero, int añoPublicacion, int noPaginas){
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.añoPublicacion = añoPublicacion;
        this.noPaginas = noPaginas;
    }

    /**
     * Obtiene el titulo del libro
     * @return titulo, el titulo del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el titulo del libro
     * @param titulo, el titulo del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el autor del libro
     * @return autor, el autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro
     * @param autor, el autor del libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene la editorial del libro
     * @return editorial, la editorial del libro
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Establece la editorial del libro
     * @param editorial, la editorial del libro
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Obtiene el genero del libro
     * @return genero, el genero del libro
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el genero del libro
     * @param genero, el genero del libro
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el año de publicacion del libro
     * @return añoPublicacion, el año de publicacion del libro
     */
    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    /**
     * Establece el año de publicacion del libro
     * @param añoPublicacion, el año de publicacion del libro
     */
    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    /**
     * Obtiene la cantidad de paginas del libro
     * @return noPaginas, la cantidad de paginas del libro
     */
    public int getNoPaginas() {
        return noPaginas;
    }

    /**
     * Establece la cantidad de paginas del libro
     * @param noPaginas, la cantidad de paginas del libro
     */
    public void setNoPaginas(int noPaginas) {
        this.noPaginas = noPaginas;
    }

    /**
     * Metodo toString de la clase Libro
     * @return cadena, la representacion en cadena del libro
     */
    public String toString(){
        String cadena = String.format("Titulo               : %s\n" +
                                      "Autor                : %s\n" +
				                      "Editorial            : %s\n" +
     			                      "Genero               : %s\n" +
				                      "Año de Publicación   : %04d\n" +
				                      "No. Paginas          : %d",
                                    this.titulo, this.autor, this.editorial, this.genero, this.añoPublicacion, this.noPaginas);
        return cadena;
    }

    /**
     * Metodo equals de la clase Libro
     * @param l, el objeto con el que se comparara
     * @return true si los libros son iguales, false en otro caso
     */
    public boolean equals(Libro l){
        if (l == null) {
            return false;
        }
        if (l == this) {
            return true;
        }
        if (l.getClass() != this.getClass()) {
            return false;
        }
        return this.titulo.equals(l.getTitulo()) && this.autor.equals(l.getAutor()) && this.editorial.equals(l.getEditorial()) && this.genero.equals(l.getGenero()) && this.añoPublicacion == l.getAñoPublicacion() && this.noPaginas == l.getNoPaginas();
    }
}