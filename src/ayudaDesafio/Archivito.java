package ayudaDesafio;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Archivito {

    public static void main(String[] args) {
        // Crear el archivo y escribir en él
        crearArchivo("src/carpeta", "texto.txt");

        // Buscar texto en el archivo
        buscarTexto("src/carpeta/texto.txt", "texto 1");
    }

    // Método para crear el archivo y escribir datos
    public static void crearArchivo(String directorioPath, String fichero) {
        File directorio = new File(directorioPath);
        File archivo = new File(directorio, fichero);

        // Validar y crear el directorio si no existe
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
                return;
            }
        } else {
            System.out.println("Directorio ya está creado");
        }

        // Validar y crear el archivo .txt
        if (!fichero.endsWith(".txt")) {
            System.out.println("El archivo debe terminar con .txt");
            return;
        }

        // Escribir en el archivo
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Perro");
        lista.add("Gato");
        lista.add("Juan");
        lista.add("Daniel");
        lista.add("Juan");
        lista.add("Gato");
        lista.add("Perro");
        lista.add("Camila");
        lista.add("Daniel");
        lista.add("Camila");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivo))) {
            Iterator<String> iterator = lista.iterator();
            while (iterator.hasNext()) {
                bufferedWriter.write(iterator.next());
                bufferedWriter.newLine();
            }
            System.out.println("Archivo creado y datos escritos exitosamente");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Método para buscar texto en el archivo
    public static void buscarTexto(String nombreFichero, String texto) {
        File archivo = new File(nombreFichero);

        // Validar que el archivo exista
        if (!archivo.exists()) {
            System.out.println("El fichero ingresado no existe");
            return;
        }

        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String data;
            while ((data = br.readLine()) != null) {
                if (data.equals(texto)) {
                    count++;
                }
            }
            System.out.println("Cantidad de repeticiones del texto -> " + count);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}