package modelo;

  public abstract class Hechizo {
	private String nombreHechizo;
	private String tipoHechizo;
	private static double Daño;
	
	public Hechizo(String nombrehechizo, String tipohechizo,double daño) {
		this.nombreHechizo=nombrehechizo;
		this.tipoHechizo=tipohechizo;
		this.Daño=daño;
	}

	public static double getDaño() {
		return Daño;
	}

	
	public String getNombreHechizo() {
		return nombreHechizo;
	}

	public String getTipoHechizo() {
		return tipoHechizo;
	}

	public void setNombreHechizo(String nombreHechizo) {
		this.nombreHechizo = nombreHechizo;
	}

	public void setTipoHechizo(String tipoHechizo) {
		this.tipoHechizo = tipoHechizo;
	}
	public void setDaño(double daño) {
		Daño = daño;
	}
	public abstract double accept(VisitoI visitor);

}
