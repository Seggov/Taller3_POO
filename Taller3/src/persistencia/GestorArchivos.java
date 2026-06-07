package persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import factory.HechizoFactory;
import modelo.Hechizo;
import modelo.Mago;

public class GestorArchivos {

    private static final String RUTA_HECHIZOS = "data/Hechizos.txt";
    private static final String RUTA_MAGOS = "data/Magos.txt";

    // ArrayList almacena el catalogo completo de hechizos cargado desde el archivo
    public List<Hechizo> cargarHechizos() throws FileNotFoundException {
        List<Hechizo> hechizos = new ArrayList<Hechizo>();
        Scanner scanner = new Scanner(new File(RUTA_HECHIZOS));
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine().trim();
            if (!linea.isEmpty()) {
                hechizos.add(parsearHechizo(linea));
            }
        }
        scanner.close();
        return hechizos;
    }

    // Convierte una linea del txt al objeto correcto manteniendo las reglas de cada parte
    private Hechizo parsearHechizo(String linea) {
        String[] partes = linea.split(";");
        String nombre = partes[0];
        String tipo = partes[1];
        int dano = Integer.parseInt(partes[2]);
        int primerParametro;
        int segundoParametro = 0;

        if (partes[3].contains(",")) {
            String[] parametros = partes[3].split(",");
            primerParametro = Integer.parseInt(parametros[0]);
            segundoParametro = Integer.parseInt(parametros[1]);
        } else {
            primerParametro = Integer.parseInt(partes[3]);
        }
        return HechizoFactory.crearHechizo(nombre, tipo, dano, primerParametro, segundoParametro);
    }

    // ArrayList almacena los magos y sus nombres de hechizos tal como aparecen en el txt
    public List<Mago> cargarMagos() throws FileNotFoundException {
        List<Mago> magos = new ArrayList<Mago>();
        Scanner scanner = new Scanner(new File(RUTA_MAGOS));
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine().trim();
            if (!linea.isEmpty()) {
                magos.add(parsearMago(linea));
            }
        }
        scanner.close();
        return magos;
    }

    private Mago parsearMago(String linea) {
        String[] partes = linea.split(";");
        Mago mago = new Mago(partes[0]);
        if (partes.length > 1 && !partes[1].isEmpty()) {
            String[] hechizos = partes[1].split("\\|");
            for (String nombreHechizo : hechizos) {
                mago.getNombresHechizos().add(nombreHechizo);
            }
        }
        return mago;
    }

    public void guardarHechizos(List<Hechizo> hechizos) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_HECHIZOS));
        for (Hechizo hechizo : hechizos) {
            writer.write(hechizo.toArchivo());
            writer.newLine();
        }
        writer.close();
    }

    public void guardarMagos(List<Mago> magos) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_MAGOS));
        for (Mago mago : magos) {
            writer.write(mago.toArchivo());
            writer.newLine();
        }
        writer.close();
    }
}

