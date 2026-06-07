package strategy;

public class EstrategiaTierra implements EstrategiaPuntuacion {

    @Override
    public double calcularPuntuacion(int dano, int mejoraDefensa, int segundoParametro) {
        return (dano * mejoraDefensa) / 2.0;
    }
}

