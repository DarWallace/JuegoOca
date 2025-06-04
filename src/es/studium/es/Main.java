package es.studium.es;

public class Main
{
	public static void main(String[] args)
	{
		Vista vista = new Vista();  // Vista
		ModeloT modelo = new ModeloT(); // Modelo: Ranking (Consulta BD)
		new Controlador(vista, modelo); // Controlador
	}
}
