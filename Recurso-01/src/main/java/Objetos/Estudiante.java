package Objetos;


/**
 * Clase Estudiante: Representa un estudiante con sus atributos.
 * Un estudiante esta definido por su nombre, apellido, edad, carrera, no. de cuenta y promedio.
 * @author Cynthia L. Sánchez
 * @version 1.0
 */
public class Estudiante{
    /* Nombre, el nombre del estudiante */
    private String nombre;
    /* Apellido, el apellido del estudiante */
    private String apellido;
    /* Edad, la edad del estudiante */
    private int edad;
    /* Carrera, la carrera del estudiante */
    private String carrera;
    /* No. Cuenta, el numero de cuenta del estudiante */
    private int noCuenta;
    /* Promedio, el promedio del estudiante */
    private double promedio;

    /**
     * Constructor de la clase Estudiante
     * @param nombre, el nombre del estudiante
     * @param apellido, el apellido del estudiante
     * @param edad, la edad del estudiante
     * @param carrera, la carrera del estudiante
     * @param noCuenta, el numero de cuenta del estudiante
     * @param promedio, el promedio del estudiante
     */
    public Estudiante(String nombre, String apellido, int edad, String carrera, int noCuenta, double promedio){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;
        this.noCuenta = noCuenta;
        this.promedio = promedio;
    } 

    /**
     * Obtiene el nombre del estudiante
     * @return nombre, el nombre del estudiante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estudiante
     * @param nombre, el nombre del estudiante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del estudiante
     * @return apellido, el apellido del estudiante
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del estudiante
     * @param apellido, el apellido del estudiante
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la edad del estudiante
     * @return edad, la edad del estudiante
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del estudiante
     * @param edad, la edad del estudiante
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la carrera del estudiante
     * @return carrera, la carrera del estudiante
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Establece la carrera del estudiante
     * @param carrera, la carrera del estudiante
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Obtiene el numero de cuenta del estudiante
     * @return noCuenta, el numero de cuenta del estudiante
     */
    public int getNoCuenta() {
        return noCuenta;
    }

    /**
     * Establece el numero de cuenta del estudiante
     * @param noCuenta, el numero de cuenta del estudiante
     */
    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }

    /**
     * Obtiene el promedio del estudiante
     * @return promedio, el promedio del estudiante
     */
    public double getPromedio() {
        return promedio;
    }

    /**
     * Establece el promedio del estudiante
     * @param promedio, el promedio del estudiante
     */
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    /**
     * Metodo toString de la clase Estudiante
     * @return cadena, la representacion en cadena del estudiante
     */
    public String toString(){
        String cadena = String.format("Nombre       : %s\n" +
                                      "Apellido     : %s\n" +
				                      "Edad         : %02d\n" +
     			                      "Carrera      : %s\n" +
				                      "No. Cuenta   : %09d\n" +
				                      "Promedio     : %2.2f",
                                    this.nombre, this.apellido, this.edad, this.carrera, this.noCuenta, this.promedio);
        return cadena;
    }

    /**
     * Metodo equals de la clase Estudiante
     * @param e, el estudiante con el que se comparará
     * @return true si los objetos son iguales, false en otro caso
     */
    public boolean equals(Estudiante e){
        // Si el estudiante es nulo, no son iguales
        if (e == null) {
            return false;
        }
        // Si el estudiante es el mismo objeto, son iguales
        if (this == e) {
            return true;
        }
        // Si alguno de los atributos no es igual el estudiante no es el mismo
        if (!this.nombre.equals(e.nombre)) {
            return false;
        }
        if (!this.apellido.equals(e.apellido)) {
            return false;
        }
        if (this.edad != e.edad) {
            return false;
        }
        if (!this.carrera.equals(e.carrera)) {
            return false;
        }
        if (this.noCuenta != e.noCuenta) {
            return false;
        }
        if (this.promedio != e.promedio) {
            return false;
        }
        return true;
    }
}