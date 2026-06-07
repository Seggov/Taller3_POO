
package sistema;

import java.io.IOException;
import java.util.Scanner;





public class App {
	
	
	public static void main(String[] args) throws IOException {
		
		
		Scanner scanner= new Scanner(System.in);
		System.out.println("Menú: ");
		System.out.println();
		System.out.println("1)Administrador.");
		System.out.println("2)Analista:");
		System.out.println();
		System.out.print("Seleccione menu:");
		int opcion = scanner.nextInt();
		
		while (opcion<1 && 2<opcion) {
			System.out.println("Elección incorrecta.Intente denuevo.");
			System.out.println("Menú: ");
			System.out.println();
			System.out.println("1)Administrador.");
			System.out.println("2)Analista:");
			System.out.println();
			System.out.println("Seleccione menu:");
			opcion = scanner.nextInt();
		}
		
		if(opcion ==1) {
			Admisnistrador admin=new Admisnistrador();
			admin.menuAdmin();
			
			
			
		}else {
			if(opcion == 2) {
				Analista analis=new Analista();
				analis.menuAnalista();
				
			}
		}
		
		
		scanner.close();
	}

	
	

}

