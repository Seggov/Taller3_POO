package strategy;

public class EstrategiaAgua implements EstrategiaPuntuacion {

    @Override
    public double calcularPuntuacion(int dano, int cantidadHeal, int presionAgua) {
        return (dano + cantidadHeal + presionAgua) * 2.0;
    }
}

