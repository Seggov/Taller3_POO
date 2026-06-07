package sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Admisnistrador {
	private static Systema sys= new SystemaImpl();
	
	public void menuAdmin() throws IOException{
		Scanner scan= new Scanner(System.in);
		System.out.println("Menú Administrador:");
		System.out.println();
		System.out.println("1. Agregar Mago");
		System.out.println("2. Modificar Mago");
		System.out.println("3. Eliminar Mago");
		System.out.println("4. Agregar Hechizo");
		System.out.println("5. Modificar Hechizo");
		System.out.println("6. Eliminar Hechizo");
		System.out.println();
		
		System.out.print("Sleccione opción: ");
		int eleccion=scan.nextInt();
		System.out.println();
		
		switch(eleccion) {
		case 1:
			agregarMagos();
			break;
		
		case 2:
			modificarMago();
			break;
			
		case 3:
			eliminarMago();
			break;
			
		case 4:
			agregarHechizo();
			break;
		
		case 5:
			modificarHechizo();
			break;
			
		case 6:
			eliminarHechizo();
			break;
		}
		scan.close();
		
	}
	
	private void eliminarHechizo() throws IOException {
		// TODO Auto-generated method stub
		Scanner acanner=new Scanner(System.in);
		System.out.println();
		System.out.print("Ingrese el nombre del hechizo a eliminar= ");
		String hechizoselectEliminar=acanner.nextLine();
		sys.eliminarHechizo(hechizoselectEliminar);
		acanner.close();
		
	}

	private static void modificarHechizo() throws FileNotFoundException {
		// TODO Auto-generated method stub
		sys.modificarHechizo();
		
	}

	private static void agregarHechizo() throws IOException{
		// TODO Auto-generated method stub
		sys.agregarHechizo();
		
	}

	private static void modificarMago() throws IOException {
		// TODO Auto-generated method stub
		sys.modificarMago(null);
		
	}

	private static void eliminarMago() throws IOException {
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		System.out.print("Agregue magos que desea eliminar: ");
		String Nombre= scan.nextLine();
		sys.eliminarMago( Nombre);
	}

	private static void agregarMagos() throws IOException {
		// TODO Auto-generated method stub
		leerArchivo();
		sys.agregarMago();
			
	}

	private static void leerArchivo() throws FileNotFoundException {
		// TODO Auto-generated method stub
		sys.leerArchivo(null);
		
	}
	

}
