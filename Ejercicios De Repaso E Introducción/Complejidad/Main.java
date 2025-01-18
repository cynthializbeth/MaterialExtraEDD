public class Main {
    public static void main(String[] args) {
        imprimePares(10);
        buscaAlumno("Óscar Lopez");
        int[] arreglo = { 5, 3, 2, 4, 1 };
        int[] arregloOrdenado = bubbleSort(arreglo);
        for (int i : arregloOrdenado) {
            System.out.println(i);
        }

        System.out.println(factorial(5));
        double[] arreglo2 = { 10, 7.0, 8.5, 9.0, 6.5 };
        System.out.println(promedio(arreglo2));
    }

    public static void imprimePares(int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void buscaAlumno(String nombre) {
        String[] arreglo = { "Andrea Sánchez", "Antonio Lozano", "Óscar Lopez", "Sonia Rodriguez",
                "Esmeralda Perez" };
        for (String s : arreglo)
            if (s.equals(nombre)) {
                System.out.println(s + " encontrado");
                return;
            }
        System.err.println("Alumno no encontrado");
    }

    public static int[] bubbleSort(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
        return arreglo;
    }

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser positivo");
        }
        return auxFactorial(n);
    }

    public static int auxFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * auxFactorial(n - 1);
    }

    public static double promedio(double[] arreglo) {
        double suma = 0;
        for (double i : arreglo) {
            suma += i;
        }
        return suma / arreglo.length;
    }
}