import java.io.File;
import java.io.IOException;
public class Ejercicio1 {
    public static void main(String[] args) {
        // Creo una ruta base adaptado a entorno macOS usando mi carpeta personal.
        String rutaBase = System.getProperty("user.home") + File.separator + "AD" + File.separator + "Ejercicios";
        // Creamos el objeto File para el directorio.
        File miDirectorio = new File(rutaBase + File.separator + "miDirectorio");
        // Aplicaremos mkdirs para crear carpetas intermedias si todavía no existen.
        if (miDirectorio.mkdirs()) {
            System.out.println("Directorio creado: " + miDirectorio.getAbsolutePath());
        } else {
            System.out.println("El directorio no se pudo crear o ya existe");
        }
        // En miDirectorio creamos un fichero.
        File fichero = new File(miDirectorio, "fichero_de_texto.txt");
        try {
            if (fichero.createNewFile()) {
                System.out.println("Fichero creado: " + fichero.getAbsolutePath());
            } else {
                System.out.println("El fichero no se pudo crear o ya existe");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());
        }
    }
}