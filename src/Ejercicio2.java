import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Ejercicio2 {
    static String rutaBase = System.getProperty("user.home") + File.separator + "AD" + File.separator + "Ejercicios";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1) Crear nuevoDirectorio");
            System.out.println("2) Crear fichero_de_texto2.txt dentro de nuevoDirectorio");
            System.out.println("3) Eliminar fichero_de_texto.txt");
            System.out.println("4) Eliminar nuevoDirectorio");
            System.out.println("5) Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: crearNuevoDirectorio();
                break;
                case 2: crearFichero2();
                break;
                case 3: eliminarFichero();
                break;
                case 4: eliminarDirectorio();
                break;
                case 5: System.out.println("Salir del programa");
                break;
                default: System.out.println("¡Opción inválida!");
            }
        } while (opcion != 5);
        sc.close();
    }
    static void crearNuevoDirectorio() {
        File nuevoDirectorio = new File(rutaBase + File.separator + "nuevoDirectorio");
        if (nuevoDirectorio.mkdirs()) {
            System.out.println("Directorio creado: " + nuevoDirectorio.getAbsolutePath());
        } else {
            System.out.println("El directorio no se pudo crear o ya existe");
        }
    }
    static void crearFichero2() {
        File nuevoDirectorio = new File(rutaBase + File.separator + "nuevoDirectorio");
        File fichero2 = new File(nuevoDirectorio, "fichero_de_texto2.txt");
        try {
            if (fichero2.createNewFile()) {
                System.out.println("Fichero creado: " + fichero2.getAbsolutePath());
            } else {
                System.out.println("El fichero no se pudo crear o ya existe");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    static void eliminarFichero() {
        File miDirectorio = new File(rutaBase + File.separator + "miDirectorio");
        File fichero = new File(miDirectorio, "fichero_de_texto.txt");
        if (fichero.delete()) {
            System.out.println("Fichero eliminado");
        } else {
            System.out.println("El fichero no se pudo eliminar o no existe");
        }
    }
    static void eliminarDirectorio() {
        File nuevoDirectorio = new File(rutaBase + File.separator + "nuevoDirectorio");
        if (nuevoDirectorio.delete()) {
            System.out.println("Directorio eliminado");
        } else {
            System.out.println("El directorio no se pudo eliminar o no existe");
        }
    }
}
