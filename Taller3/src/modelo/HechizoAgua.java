package modelo;

public class Agua extends Hechizo {
	private static double cantidadHeal;
	private static double presionDelAgua;

	public Agua(String nombrehechizo, String tipohechizo, double daño,int cantidadheal,int presiondelagua) {
		super(nombrehechizo, tipohechizo, daño);
		// TODO Auto-generated constructor stub
		this.cantidadHeal=cantidadheal;
		this.presionDelAgua=presiondelagua;
	}

	public static double getCantidadHeal() {
		return cantidadHeal;
	}

	public static double getPresionDelAgua() {
		return presionDelAgua;
	}

	public void setCantidadHeal(int cantidadHeal) {
		this.cantidadHeal = cantidadHeal;
	}

	public void setPresionDelAgua(int presionDelAgua) {
		this.presionDelAgua = presionDelAgua;
	}
	

	@Override
	public double  accept(VisitoI visitor) {
		// TODO Auto-generated method stub
		return visitor.visitar(this);
		
	}

}

