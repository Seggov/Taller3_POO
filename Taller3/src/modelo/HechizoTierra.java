package modelo;

public class Tierra extends Hechizo{
	private static double mejoraDefensa;

	public Tierra(String nombrehechizo, String tipohechizo, double daño,int mejoradefensa) {
		super(nombrehechizo, tipohechizo, daño);
		// TODO Auto-generated constructor stub
		this.mejoraDefensa=mejoradefensa;
	}

	public static double getMejoraDefensa() {
		return mejoraDefensa;
	}

	public void setMejoraDefensa(double mejoraDefensa) {
		this.mejoraDefensa = mejoraDefensa;
	}
	

	@Override
	public double accept(VisitoI visitor) {
		// TODO Auto-generated method stub
		return visitor.visitar(this);
		
	}

}

