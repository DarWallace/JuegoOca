package es.studium.es;

public class Main
{
	public static void main(String[] args)
	{
		Vista vista = new Vista();
		ModeloB modelo = new ModeloB(); // Asegúrate de tener esta clase aunque esté vacía
		new Controlador(vista, modelo);
	}
}