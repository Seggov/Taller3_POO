package modelo;

import strategy.EstrategiaFuego;

public class HechizoFuego extends Hechizo {

    public HechizoFuego(String nombre, int dano, int duracionQuemadura) {
        super(nombre, "Fuego", dano, duracionQuemadura, 0, new EstrategiaFuego());
    }

    @Override
    public String obtenerDescripcionParametros() {//Obtener el atributo de duración de quemadura
        return "Duracion quemadura: " + getPrimerParametro();
    }
}

