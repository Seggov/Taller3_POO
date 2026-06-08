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

    public void cargarDatos() throws FileNotFoundException {//Permite trabajar con los datos de Magos.txt o Hechizos.txt
        this.hechizos = gestorArchivos.cargarHechizos();
        this.magos = gestorArchivos.cargarMagos();
    }

    public void guardarDatos() throws IOException {//Almacenar los cambios en Magos.txt y Hechizos.txt para que sea permanente
        gestorArchivos.guardarHechizos(hechizos);
        gestorArchivos.guardarMagos(magos);
    }

    public boolean agregarMago(String nombre, List<String> nombresHechizos) throws IOException {//Se busca si ese nombre ya existe, permite crear una instancia de Mago con sus respectivos atributos para guardar los datos
        if (buscarMago(nombre) != null) {
            return false;
        }
        Mago mago = new Mago(nombre);
        mago.setNombresHechizos(nombresHechizos);
        magos.add(mago);
        guardarDatos();
        return true;
    }

    public boolean modificarMago(String nombreActual, String nuevoNombre, List<String> nuevosHechizos) throws IOException {//Se busca si es que existe el nombre, al encontrarlo se da la opción de cambiar el nombre y el nombre de los hechizos para después guardarlos
        Mago mago = buscarMago(nombreActual);
        if (mago == null) {
            return false;
        }
        mago.setNombre(nuevoNombre);
        mago.setNombresHechizos(nuevosHechizos);
        guardarDatos();
        return true;
    }

    public boolean eliminarMago(String nombre) throws IOException {//Se busca si existe el mago y en caso de encontrarlo se elimina.
        Mago mago = buscarMago(nombre);
        if (mago == null) {
            return false;
        }
        magos.remove(mago);
        guardarDatos();
        return true;
    }

    public boolean agregarHechizo(String nombre, String tipo, int dano, int primerParametro, int segundoParametro)
            throws IOException {//{//Se busca si el nombre del hechizo existe, permite crear una instancia de Hechizos  con sus respectivos atributos para posteriormente guardarlos.
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

    public boolean eliminarHechizo(String nombre) throws IOException {//Eliminar el hechizo en Hechizos.txt, ingrsando el nombre del hechizo para eliminar el Objeto Hechizo. 
        Hechizo hechizo = buscarHechizo(nombre);
        if (hechizo == null) {
            return false;
        }
        hechizos.remove(hechizo);
        eliminarHechizoEnMagos(nombre);
        guardarDatos();
        return true;
    }

    private void actualizarNombreHechizoEnMagos(String nombreActual, String nuevoNombre) {//Metodo que actualiza el nombre de los hechizos en los magos.
        for (Mago mago : magos) {
            List<String> nombres = mago.getNombresHechizos();
            for (int i = 0; i < nombres.size(); i++) {
                if (nombres.get(i).equalsIgnoreCase(nombreActual)) {
                    nombres.set(i, nuevoNombre);
                }
            }
        }
    }

    private void eliminarHechizoEnMagos(String nombre) {//Elimina el hechizo ingresado en los atributos que aparecen en el documento Mago.txt.
        for (Mago mago : magos) {
            mago.getNombresHechizos().removeIf(nombreHechizo -> nombreHechizo.equalsIgnoreCase(nombre));
        }
    }

    public Hechizo buscarHechizo(String nombre) {//Método que busca en la lista hechizos el nombre que se ingresa.
        for (Hechizo hechizo : hechizos) {
            if (hechizo.getNombre().equalsIgnoreCase(nombre)) {
                return hechizo;
            }
        }
        return null;
    }

    public Mago buscarMago(String nombre) {//Método que busca en la lista magos el nombre que se ingresa.
        for (Mago mago : magos) {
            if (mago.getNombre().equalsIgnoreCase(nombre)) {
                return mago;
            }
        }
        return null;
    }

    public boolean existeHechizo(String nombre) {//en caso de que exista el nombre del hechizo.
        return buscarHechizo(nombre) != null;
    }

    public List<Hechizo> obtenerTopHechizos(int cantidad) {//Busca los tres hechizos con los puntajes más altos
        List<Hechizo> copia = new ArrayList<Hechizo>(hechizos);
        copia.sort(Comparator.comparingDouble(Hechizo::calcularPuntuacion).reversed());
        return copia.subList(0, Math.min(cantidad, copia.size()));
    }

    public List<Mago> obtenerTopMagos(int cantidad) {//Entrega los magos que poseen los hechizos con mayor puntaje.
        List<Mago> copia = new ArrayList<Mago>(magos);
        copia.sort(Comparator.comparingDouble((Mago mago) -> mago.calcularPuntuacion(hechizos)).reversed());
        return copia.subList(0, Math.min(cantidad, copia.size()));
    }

    public List<Hechizo> getHechizos() {//Obtener Hechizo en la lista donde se almacenan los Hechizos.
        return hechizos;
    }

    public List<Mago> getMagos() {//Obtener el Mago en la lista donde se almacenan los magos.
        return magos;
    }
}

