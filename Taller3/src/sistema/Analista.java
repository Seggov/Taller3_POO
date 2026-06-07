package sistema;

public class Analista {
	private static Systema sys= new SystemaImpl();
	
	public void menuAnalista() {
		System.out.println("Menú Análisis:");
		System.out.println();
		System.out.println("1. Top 10 Mejores Hechizos");
		System.out.println("2. Top 3 Mejores Magos");
		System.out.println("3. Mostrar todos los Hechizos");
		System.out.println("4. Mostrar todos los magos");
		System.out.println("5. Mostrar todos los Hechizos junto a su puntuacion");
		System.out.println("6. Mostrar todos los magos junto a su puntuacion");
	}

}
