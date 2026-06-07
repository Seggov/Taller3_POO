package modelo;

import strategy.EstrategiaPuntuacion;

public abstract class Hechizo {

    private String nombre;
    private String tipo;
    private int dano;
    private int primerParametro;
    private int segundoParametro;
    private EstrategiaPuntuacion estrategiaPuntuacion;

    public Hechizo(String nombre, String tipo, int dano, int primerParametro, int segundoParametro,
            EstrategiaPuntuacion estrategiaPuntuacion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.dano = dano;
        this.primerParametro = primerParametro;
        this.segundoParametro = segundoParametro;
        this.estrategiaPuntuacion = estrategiaPuntuacion;
    }

    // Aplica Strategy para calcular el puntaje sin preguntar por el tipo del hechizo
    public double calcularPuntuacion() {
        return estrategiaPuntuacion.calcularPuntuacion(dano, primerParametro, segundoParametro);
    }

    public abstract String obtenerDescripcionParametros();

    public String toArchivo() {
        if (usaDosParametros()) {
            return nombre + ";" + tipo + ";" + dano + ";" + primerParametro + "," + segundoParametro;
        }
        return nombre + ";" + tipo + ";" + dano + ";" + primerParametro;
    }

    public boolean usaDosParametros() {
        return "Agua".equalsIgnoreCase(tipo) || "Planta".equalsIgnoreCase(tipo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getPrimerParametro() {
        return primerParametro;
    }

    public void setPrimerParametro(int primerParametro) {
        this.primerParametro = primerParametro;
    }

    public int getSegundoParametro() {
        return segundoParametro;
    }

    public void setSegundoParametro(int segundoParametro) {
        this.segundoParametro = segundoParametro;
    }
}

