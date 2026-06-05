package modelo;

import java.util.ArrayList;

import Lógica.App;
import Lógica.VisitoI;
import Lógica.reporVisitor;

public abstract class Mago {
	private String Nombremago;
	private ArrayList<String> hechizoNombre;
	
	public Mago(String nombremago,ArrayList<String> hechizonombre) {
		this.Nombremago=nombremago;
		this.hechizoNombre=hechizonombre;
	}

	public ArrayList<String> getHechizoNombre() {
		return hechizoNombre;
	}

	public void setHechizoNombre(ArrayList<String> hechizoNombre) {
		this.hechizoNombre = hechizoNombre;
	}

	public String getNombremago() {
		return Nombremago;
	}

	public void setNombremago(String nombremago) {
		Nombremago = nombremago;
	}
	
	public abstract void accept(reporVisitor save);

}

