package modelo;

public class Planta extends Hechizo {
	private static double DuracionStun;
	private static  double CantPlantas;

	public Planta(String nombrehechizo, String tipohechizo, double daño,int duracionstun,int cantplantas) {
		super(nombrehechizo, tipohechizo, daño);
		// TODO Auto-generated constructor stub
		this.DuracionStun=duracionstun;
		this.CantPlantas=cantplantas;
	}

	public static double getDuracionStun() {
		return DuracionStun;
	}

	public static double getCantPlantas() {
		return CantPlantas;
	}

	public void setDuracionStun(int duracionStun) {
		DuracionStun = duracionStun;
	}

	public void setCantPlantas(int cantPlantas) {
		CantPlantas = cantPlantas;
	}
	

	@Override
	public double accept(VisitoI visitor) {
		// TODO Auto-generated method stub
		return visitor.visitar(this);
		
	}

}

