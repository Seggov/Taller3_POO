package modelo;

import java.util.ArrayList;
import java.util.List;

public class Mago {

    private String nombre;
    private List<String> nombresHechizos;

    public Mago(String nombre) {
        this.nombre = nombre;
        // ArrayList guarda los nombres de hechizos que domina el mago en el orden del archivo.
        this.nombresHechizos = new ArrayList<String>();
    }

    // Suma los puntajes de los hechizos asociados al mago usando el catalogo general
    public double calcularPuntuacion(List<Hechizo> catalogoHechizos) {
        double total = 0;
        for (String nombreHechizo : nombresHechizos) {
            Hechizo hechizo = buscarHechizoPorNombre(catalogoHechizos, nombreHechizo);
            if (hechizo != null) {
                total += hechizo.calcularPuntuacion();
            }
        }
        return total;
    }

    private Hechizo buscarHechizoPorNombre(List<Hechizo> catalogoHechizos, String nombreHechizo) {
        for (Hechizo hechizo : catalogoHechizos) {
            if (hechizo.getNombre().equalsIgnoreCase(nombreHechizo)) {
                return hechizo;
            }
        }
        return null;
    }

    public String toArchivo() {
        StringBuilder builder = new StringBuilder(nombre);
        builder.append(";");
        for (int i = 0; i < nombresHechizos.size(); i++) {
            builder.append(nombresHechizos.get(i));
            if (i < nombresHechizos.size() - 1) {
                builder.append("|");
            }
        }
        return builder.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getNombresHechizos() {
        return nombresHechizos;
    }

    public void setNombresHechizos(List<String> nombresHechizos) {
        this.nombresHechizos = nombresHechizos;
    }
}

