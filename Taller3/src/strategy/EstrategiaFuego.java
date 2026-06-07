package strategy;

public class EstrategiaFuego implements EstrategiaPuntuacion {

    @Override
    public double calcularPuntuacion(int dano, int duracionQuemadura, int segundoParametro) {
        return dano * duracionQuemadura;
    }
}

