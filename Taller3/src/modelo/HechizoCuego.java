package modelo;

import Lógica.VisitoI;

public class Fuego extends Hechizo{
	private static double duracionQuemadura;
	
	public Fuego(String nombrehechizo, String tipohechizo, double daño,int duracionquemadura) {
		super(nombrehechizo, tipohechizo, daño);
		// TODO Auto-generated constructor stub
		this.duracionQuemadura=duracionquemadura;
	}

	public static double getDuracionQuemadura() {
		return duracionQuemadura;
	}

	public void setDuracionQuemadura(int duracionQuemadura) {
		this.duracionQuemadura = duracionQuemadura;
	}
	
	

	@Override
	public double  accept(VisitoI visitor) {
		// TODO Auto-generated method stub
		return visitor.visitar(this);
		
		
	}

	
	
}

