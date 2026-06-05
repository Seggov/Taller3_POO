package sistema;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Mago;
import Dominio.magoInstan;

public class SystemaImpl implements Systema {
	Scanner scaan=new Scanner(System.in);
	public static ArrayList<Mago> listaMagos=new ArrayList<>();
	
	@Override
	public void agregarMago() throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new FileWriter("Magos.txt",true));
		System.out.print("Ingrese nombre del mago");
		String nombreMagoIngresado=scaan.nextLine();
		System.out.println();
		bw.write(nombreMagoIngresado + ";");
		System.out.print("Ingrese la cantidad de hechizos:");
		int cantHechizos= scaan.nextInt();
		
		for (int i=0;i<cantHechizos;i++ ) {
			System.out.println("Ingrese el nombre del hechizo "+ i +") ");
			String nombreHechizo=scaan.nextLine();
			bw.write(nombreHechizo);
			bw.write("|");
			System.out.println();
			
			
		}
		
		bw.newLine();
		bw.close();
		
		
	}

	@Override
	public void leerArchivo(ArrayList<Mago> listaMagos) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file= new File("Magos.txt"); 
		Scanner scanner= new Scanner(file);
		
		while(scanner.hasNextLine()) {
			ArrayList <String> magoHechizo=new ArrayList<>();
			String linea = scanner.nextLine();
			String[] Partes= linea.split(";");
			String nombreMago=Partes[0];
			String listaHechizos=Partes[1];
			String[] Parts=listaHechizos.split("\\|");
			for(String h:Parts) {
				magoHechizo.add(h);
			}
			
			
			magoInstan magoleido= new magoInstan( nombreMago, magoHechizo);
			listaMagos.add(magoleido);			
		}
		
		
		scanner.close();
	}

	@Override
	public void eliminarMago(String nombreMangoEliminar) throws IOException {
		// TODO Auto-generated method stub
		for (Mago mago:listaMagos) {
			if(mago.getNombremago().equalsIgnoreCase(nombreMangoEliminar)) {
				int posicionMago=listaMagos.indexOf(mago);
				listaMagos.remove(posicionMago);
				Guardarmagoslistamodificada(listaMagos);
				
			}
			
		}
		
	}

	private void Guardarmagoslistamodificada(ArrayList<Mago> listaMagos2) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedWriter bw= new BufferedWriter(new FileWriter("Magos.txt"));
		for(Mago mago:listaMagos2 ) {
			
			bw.write(mago.getNombremago() + ";");
			
			
			
			
			for(int i=0; i<mago.getHechizoNombre().size();i++) {
				String hechizoUnico=mago.getHechizoNombre().get(i);
				bw.write(hechizoUnico + "\\|");
				
			}
			bw.newLine();
		}
		bw.close();
		
	}

	@Override
	public void modificarMago(ArrayList<Mago> listaMagos) throws IOException {
		// TODO Auto-generated method stub
		Scanner sss= new Scanner(System.in);
		System.out.print("¿A qué mago le va a modificar el nombre?");
		String magoacambiar=sss.nextLine();
		
		for(Mago mago: listaMagos) {
			if (mago.getNombremago().equalsIgnoreCase(magoacambiar)) {
				mago.setNombremago(magoacambiar);
				
				
			}
			
			
		}
		Guardarmagoslistamodificada(listaMagos);
		System.out.println("Nombre modificado");
	}

	

	

}
