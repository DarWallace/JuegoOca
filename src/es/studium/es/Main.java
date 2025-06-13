package es.studium.es;

public class Main
{
	public static void main(String[] args)
	{
		Vista vista = new Vista();
		ModeloB modelo = new ModeloB();
		new Controlador(vista, modelo);
	}
}