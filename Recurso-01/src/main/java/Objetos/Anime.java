package Objetos;

/**
 * Clase Anime: Representa un anime con sus atributos.
 * Un anime esta definido como una seríe de televisión animada japonesa
 * usualmente tiene un titulo, genero, cantidad de episodios, edad recomendada, etc.
 * @author Cynthia L. Sánchez
 * @version 1.0
 */
public class Anime{
    /* Titulo, el titulo del anime */
    private String titulo;
    /* Genero, el genero del anime */
    private String genero;
    /* Episodios, la cantidad de episodios del anime */
    private int episodios;
    /* Edad Recomendada, la edad recomendada para ver el anime */
    private int edadRecomendada;
    /* Año de Estreno, el año en que se estreno el anime */
    private int añoEstreno;
    /* Temporadas, la cantidad de temporadas del anime */
    private int temporadas;

    /**
     * Constructor de la clase Anime
     * @param titulo, el titulo del anime
     * @param genero, el genero del anime
     * @param episodios, la cantidad de episodios del anime
     * @param edadRecomendada, la edad recomendada para ver el anime
     * @param añoEstreno, el año en que se estreno el anime
     * @param temporadas, la cantidad de temporadas del anime
     */
    public Anime(String titulo, String genero, int episodios, int edadRecomendada, int añoEstreno, int temporadas){
        this.titulo = titulo;
        this.genero = genero;
        this.episodios = episodios;
        this.edadRecomendada = edadRecomendada;
        this.añoEstreno = añoEstreno;
        this.temporadas = temporadas;
    }

    /**
     * Obtiene el titulo del anime
     * @return titulo, el titulo del anime
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el titulo del anime
     * @param titulo, el titulo del anime
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el genero del anime
     * @return genero, el genero del anime
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el genero del anime
     * @param genero, el genero del anime
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la cantidad de episodios del anime
     * @return episodios, la cantidad de episodios del anime
     */
    public int getEpisodios() {
        return episodios;
    }

    /**
     * Establece la cantidad de episodios del anime
     * @param episodios, la cantidad de episodios del anime
     */
    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    /**
     * Obtiene la edad recomendada para ver el anime
     * @return edadRecomendada, la edad recomendada para ver el anime
     */
    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    /**
     * Establece la edad recomendada para ver el anime
     * @param edadRecomendada, la edad recomendada para ver el anime
     */
    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    /**
     * Obtiene el año en que se estreno el anime
     * @return añoEstreno, el año en que se estreno el anime
     */
    public int getAñoEstreno() {
        return añoEstreno;
    }

    /**
     * Establece el año en que se estreno el anime
     * @param añoEstreno, el año en que se estreno el anime
     */
    public void setAñoEstreno(int añoEstreno) {
        this.añoEstreno = añoEstreno;
    }

    /**
     * Obtiene la cantidad de temporadas del anime
     * @return temporadas, la cantidad de temporadas del anime
     */
    public int getTemporadas() {
        return temporadas;
    }

    /**
     * Establece la cantidad de temporadas del anime
     * @param temporadas, la cantidad de temporadas del anime
     */
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    /**
     * Metodo toString, regresa una cadena con la informacion del anime
     * @return cadena, la informacion del anime
     */
    public String toString(){
        String cadena = String.format("Titulo            : %s\n" +
                                      "Genero            : %s\n" +
				                      "Episodios         : %d\n" +
     			                      "Edad Recomendada  : %d\n" +
				                      "Año de Estreno    : %04d\n" +
				                      "Temporadas        : %d",
	               		      this.titulo, this.genero, this.episodios, this.edadRecomendada, this.añoEstreno, this.temporadas);
        return cadena;
    }

    /**
     * Metodo equals, compara si dos animes son iguales
     * @param a, el objeto con el que se comparara
     * @return true si los animes son iguales, false en otro caso
     */
    public boolean equals(Anime a){
        if (a == null) {
            return false;
        }
        if (a == this) {
            return true;
        }
        return this.titulo.equals(a.titulo) && this.genero.equals(a.genero) && this.episodios == a.episodios && this.edadRecomendada == a.edadRecomendada && this.añoEstreno == a.añoEstreno && this.temporadas == a.temporadas;
    }
}