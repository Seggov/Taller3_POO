package modelo;

import strategy.EstrategiaPlanta;

public class HechizoPlanta extends Hechizo {

    public HechizoPlanta(String nombre, int dano, int duracionStun, int cantidadPlantas) {
        super(nombre, "Planta", dano, duracionStun, cantidadPlantas, new EstrategiaPlanta());
    }

    @Override
    public String obtenerDescripcionParametros() {//obtener la duraciuon de Stun y la cantidad de plantas.
        return "Duracion stun: " + getPrimerParametro() + ", Cantidad plantas: " + getSegundoParametro();
    }
}

