package servicio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import factory.HechizoFactory;//Importar las clases a ocupar
import modelo.Hechizo;
import modelo.Mago;
import persistencia.GestorArchivos;

public class SistemaTaller {

    private static SistemaTaller instancia;
    private List<Hechizo> hechizos;
    private List<Mago> magos;
    private GestorArchivos gestorArchivos;

    private SistemaTaller() {
        this.hechizos = new ArrayList<Hechizo>();
        this.magos = new ArrayList<Mago>();
        this.gestorArchivos = new GestorArchivos();
    }

    // Aplica Singleton para mantener una sola instancia del sistema durante toda la ejecucion.
    public static SistemaTaller getInstancia() {
        if (instancia == null) {
            instancia = new SistemaTaller();
        }
        return instancia;
    }

    public void cargarDatos() throws FileNotFoundException {
        this.hechizos = gestorArchivos.cargarHechizos();
        this.magos = gestorArchivos.cargarMagos();
    }

    public void guardarDatos() throws IOException {
        gestorArchivos.guardarHechizos(hechizos);
        gestorArchivos.guardarMagos(magos);
    }

    public boolean agregarMago(String nombre, List<String> nombresHechizos) throws IOException {
        if (buscarMago(nombre) != null) {
            return false;
        }
        Mago mago = new Mago(nombre);
        mago.setNombresHechizos(nombresHechizos);
        magos.add(mago);
        guardarDatos();
        return true;
    }

    public boolean modificarMago(String nombreActual, String nuevoNombre, List<String> nuevosHechizos) throws IOException {
        Mago mago = buscarMago(nombreActual);
        if (mago == null) {
            return false;
        }
        mago.setNombre(nuevoNombre);
        mago.setNombresHechizos(nuevosHechizos);
        guardarDatos();
        return true;
    }

    public boolean eliminarMago(String nombre) throws IOException {
        Mago mago = buscarMago(nombre);
        if (mago == null) {
            return false;
        }
        magos.remove(mago);
        guardarDatos();
        return true;
    }

    public boolean agregarHechizo(String nombre, String tipo, int dano, int primerParametro, int segundoParametro)
            throws IOException {
        if (buscarHechizo(nombre) != null) {
            return false;
        }
        hechizos.add(HechizoFactory.crearHechizo(nombre, tipo, dano, primerParametro, segundoParametro));
        guardarDatos();
        return true;
    }

    // Modifica un hechizo y actualiza el nombre en todos los magos que lo dominan.
    public boolean modificarHechizo(String nombreActual, String nuevoNombre, String tipo, int dano, int primerParametro,
            int segundoParametro) throws IOException {
        Hechizo hechizoActual = buscarHechizo(nombreActual);
        if (hechizoActual == null) {
            return false;
        }
        int indice = hechizos.indexOf(hechizoActual);
        hechizos.set(indice, HechizoFactory.crearHechizo(nuevoNombre, tipo, dano, primerParametro, segundoParametro));
        actualizarNombreHechizoEnMagos(nombreActual, nuevoNombre);
        guardarDatos();
        return true;
    }

    public boolean eliminarHechizo(String nombre) throws IOException {
        Hechizo hechizo = buscarHechizo(nombre);
        if (hechizo == null) {
            return false;
        }
        hechizos.remove(hechizo);
        eliminarHechizoEnMagos(nombre);
        guardarDatos();
        return true;
    }

    private void actualizarNombreHechizoEnMagos(String nombreActual, String nuevoNombre) {
        for (Mago mago : magos) {
            List<String> nombres = mago.getNombresHechizos();
            for (int i = 0; i < nombres.size(); i++) {
                if (nombres.get(i).equalsIgnoreCase(nombreActual)) {
                    nombres.set(i, nuevoNombre);
                }
            }
        }
    }

    private void eliminarHechizoEnMagos(String nombre) {
        for (Mago mago : magos) {
            mago.getNombresHechizos().removeIf(nombreHechizo -> nombreHechizo.equalsIgnoreCase(nombre));
        }
    }

    public Hechizo buscarHechizo(String nombre) {
        for (Hechizo hechizo : hechizos) {
            if (hechizo.getNombre().equalsIgnoreCase(nombre)) {
                return hechizo;
            }
        }
        return null;
    }

    public Mago buscarMago(String nombre) {
        for (Mago mago : magos) {
            if (mago.getNombre().equalsIgnoreCase(nombre)) {
                return mago;
            }
        }
        return null;
    }

    public boolean existeHechizo(String nombre) {
        return buscarHechizo(nombre) != null;
    }

    public List<Hechizo> obtenerTopHechizos(int cantidad) {
        List<Hechizo> copia = new ArrayList<Hechizo>(hechizos);
        copia.sort(Comparator.comparingDouble(Hechizo::calcularPuntuacion).reversed());
        return copia.subList(0, Math.min(cantidad, copia.size()));
    }

    public List<Mago> obtenerTopMagos(int cantidad) {
        List<Mago> copia = new ArrayList<Mago>(magos);
        copia.sort(Comparator.comparingDouble((Mago mago) -> mago.calcularPuntuacion(hechizos)).reversed());
        return copia.subList(0, Math.min(cantidad, copia.size()));
    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public List<Mago> getMagos() {
        return magos;
    }
}

