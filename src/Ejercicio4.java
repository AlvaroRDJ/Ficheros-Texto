import java.io.*;

public class Ejercicio4 {
    static final String rutaBase = System.getProperty("user.home") + File.separator + "AD" + File.separator + "Ejercicios";
    static final String[] nombres = {
            "Javier", "Álvaro", "Ainhoa", "Gorka", "Mairena", "Teresa", "Aram", "Sandra", "Henar", "Oriol"
    };
    public static void main(String[] args) {
        File directorio = new File(rutaBase);
        directorio.mkdirs();
        File fichero = new File(rutaBase, "Empleados.txt");

        // Usando FileWriter / FileReader
        System.out.println("\n--- Ahora con FileWriter / FileReader ---");
        escribirConFileWriter(fichero);
        leerConFileReader(fichero);
        // Usando BufferedWriter / BufferedReader
        System.out.println("\n--- Ahora con BufferedWriter / BufferedReader ---");
        escribirConBufferedWriter(fichero);
        leerConBufferedReader(fichero);
    }
    static void escribirConFileWriter(File fichero) {
        try (FileWriter fw = new FileWriter(fichero)) {
            for (int i = 1; i <= 10; i++) {
                fw.write(i + " - " + nombres[i - 1]);
                fw.write(System.lineSeparator());
            }
            System.out.println("Empleados.txt escrito con FileWriter");
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }
    static void leerConFileReader(File fichero) {
        try (FileReader fr = new FileReader(fichero)) {
            int c;
            StringBuilder sb = new StringBuilder();
            while ((c = fr.read()) != -1) {
                sb.append((char) c);
            }
            System.out.println("Contenido leído con FileReader");
            System.out.print(sb);
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }
    static void escribirConBufferedWriter(File fichero) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
            for (int i = 1; i <= 10; i++) {
                bw.write(i + " - " + nombres[i - 1]);
                bw.newLine();
            }
            System.out.println("Empleados.txt escrito con BufferedWriter");
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }
    static void leerConBufferedReader(File fichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            System.out.println("--- Contenido leído con BufferedReader ---");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }
}
