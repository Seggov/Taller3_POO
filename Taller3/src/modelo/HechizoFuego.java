package modelo;

import strategy.EstrategiaFuego;

public class HechizoFuego extends Hechizo {

    public HechizoFuego(String nombre, int dano, int duracionQuemadura) {
        super(nombre, "Fuego", dano, duracionQuemadura, 0, new EstrategiaFuego());
    }

    @Override
    public String obtenerDescripcionParametros() {
        return "Duracion quemadura: " + getPrimerParametro();
    }
}

