package modelo;

import strategy.EstrategiaAgua;

public class HechizoAgua extends Hechizo {

    public HechizoAgua(String nombre, int dano, int cantidadHeal, int presionAgua) {
        super(nombre, "Agua", dano, cantidadHeal, presionAgua, new EstrategiaAgua());
    }

    @Override
    public String obtenerDescripcionParametros() {//Obtener Parametro último y penultimo  parámetro del HechizoAgua
        return "Cantidad heal: " + getPrimerParametro() + ", Presion agua: " + getSegundoParametro();
    }
}

