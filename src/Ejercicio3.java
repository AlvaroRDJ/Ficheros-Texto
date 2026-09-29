import java.io.*;
import java.io.IOException;
import java.util.Scanner;
public class Ejercicio3 {
    static String rutaBase = System.getProperty("user.home") + File.separator + "AD" + File.separator + "Ejercicios";
    static String[] provinciasAndalucia = {
            "Almería", "Jaén", "Granada", "Córdoba", "Sevilla", "Huelva", "Cádiz", "Málaga"
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1) Crear nuevoDirectorio");
            System.out.println("2) Crear fichero_de_texto2.txt");
            System.out.println("3) Eliminar fichero_de_texto.txt");
            System.out.println("4) Eliminar nuevoDirectorio (aunque haya contenido)");
            System.out.println("5) Escribir las provincias de Andalucía en fichero_de_texto2.txt");
            System.out.println("6) Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: crearNuevoDirectorio();
                break;
                case 2: crearFichero2();
                break;
                case 3: eliminarFichero();
                break;
                case 4: eliminarDirectorioRecursivo(new File(rutaBase + File.separator + "nuevoDirectorio"));
                break;
                case 5: escribirProvincias();
                break;
                case 6: System.out.println("Salir del programa");
                break;
                default: System.out.println("¡Opción inválida!");
            }
        } while (opcion != 6);
        sc.close();
    }
    // 1) Creamos un nuevo directorio
    static void crearNuevoDirectorio() {
        File nuevoDirectorio = new File(rutaBase + File.separator + "nuevoDirectorio");
        if (nuevoDirectorio.mkdirs()) {
            System.out.println("Directorio creado: " + nuevoDirectorio.getAbsolutePath());
        } else {
            System.out.println("El directorio no se pudo crear o ya existe");
        }
    }
    // 2) Creamos un nuevo fichero dentro de ese directorio
    static void crearFichero2() {
        File nuevoDirectorio = new File(rutaBase + File.separator + "nuevoDirectorio");
        File fichero2 = new File(nuevoDirectorio, "fichero_de_texto2.txt");
        try {
            if (fichero2.createNewFile()) {
                System.out.println("Fichero creado");
            } else {
                System.out.println("No se pudo crear el fichero o ya existe");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    // 3) Eliminamos fichero_de_texto.txt
    static void eliminarFichero() {
        File miDirectorio = new File(rutaBase + File.separator + "miDirectorio");
        File fichero = new File(miDirectorio, "fichero_de_texto.txt");
        if (fichero.delete()) {
            System.out.println("Fichero eliminado");
        } else {
            System.out.println("No se ha podido eliminar el fichero o no existe");
        }
    }
    // 4) Eliminamos el nuevo directorio aunque haya contenido
    static void eliminarDirectorioRecursivo(File directorio) {
        File nuevoDirectorio = new File(rutaBase + File.separator + "nuevoDirectorio");
        if (!directorio.exists()) {
            System.out.println("El directorio no existe");
            return;
        }
        File[] contenido = directorio.listFiles();
        if (contenido != null) {
            for (File f : contenido) {
                if (f.isDirectory()) {
                    eliminarDirectorioRecursivo(f);
                } else {
                    f.delete();
                }
            }
        }
        if (directorio.delete()) {
            System.out.println("Directorio eliminado" + directorio.getAbsolutePath());
        } else {
            System.out.println("No se pudo eliminar el directorio o no existe");
        }
    }
    // 5) Escribimos la lista de provincias de Andalucía dentro de fichero_de_texto2.txt
    static void escribirProvincias() {
        File nuevoDirectorio = new File(rutaBase + File.separator + "nuevoDirectorio");
        File fichero2 = new File(nuevoDirectorio, "fichero_de_texto2.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero2))) {
            for (String provincia : provinciasAndalucia) {
                bw.write(provincia);
                bw.newLine();
            }
            System.out.println("Provincias escritas en " + fichero2.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }
}

