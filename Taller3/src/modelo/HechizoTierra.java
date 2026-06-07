package modelo;

import strategy.EstrategiaTierra;

public class HechizoTierra extends Hechizo {

    public HechizoTierra(String nombre, int dano, int mejoraDefensa) {
        super(nombre, "Tierra", dano, mejoraDefensa, 0, new EstrategiaTierra());
    }

    @Override
    public String obtenerDescripcionParametros() {
        return "Mejora defensa: " + getPrimerParametro();
    }
}

