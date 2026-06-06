package interface;
import modelo.HechizoAgua;

//Systema implm simil
public interface reporVisitor  {
	void visitar(Mago mago);
	double visitar(Hechizo hechizo);
	double visitar(Fuego Hechizofuego);
	double visitar(Agua Hechizoagua);
	double visitar(Planta Hechizoplanta);
	double visitar(Tierra Hechizotierra);
}
