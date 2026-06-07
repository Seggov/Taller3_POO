package factory;

import modelo.Hechizo;
import modelo.HechizoAgua;
import modelo.HechizoFuego;
import modelo.HechizoPlanta;
import modelo.HechizoTierra;

public class HechizoFactory {

    private HechizoFactory() {
    }

    // Aplica Factory para crear la subclase correcta segun el tipo leido desde archivo o menu.
    public static Hechizo crearHechizo(String nombre, String tipo, int dano, int primerParametro, int segundoParametro) {
        if ("Fuego".equalsIgnoreCase(tipo)) {
            return new HechizoFuego(nombre, dano, primerParametro);
        }
        if ("Tierra".equalsIgnoreCase(tipo)) {
            return new HechizoTierra(nombre, dano, primerParametro);
        }
        if ("Planta".equalsIgnoreCase(tipo)) {
            return new HechizoPlanta(nombre, dano, primerParametro, segundoParametro);
        }
        if ("Agua".equalsIgnoreCase(tipo)) {
            return new HechizoAgua(nombre, dano, primerParametro, segundoParametro);
        }
        throw new IllegalArgumentException("Tipo de hechizo no valido: " + tipo);
    }
}

