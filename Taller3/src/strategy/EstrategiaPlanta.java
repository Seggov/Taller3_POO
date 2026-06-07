package strategy;

public class EstrategiaPlanta implements EstrategiaPuntuacion {

    @Override
    public double calcularPuntuacion(int dano, int duracionStun, int cantidadPlantas) {
        return dano + (duracionStun * cantidadPlantas);
    }
}

