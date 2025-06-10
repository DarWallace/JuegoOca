package es.studium.es;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;

public class VistaRanking extends Frame
{
	private static final long serialVersionUID = 1L;
	TextArea txaRanking = new TextArea(20,10);
	Button btnVolver = new Button("Volver");
	
	public VistaRanking()
	{
		setTitle("Juego de la Oca: Ranking"); // Título
		setBackground(Color.GREEN); // Color de fondo del Frame
		setLayout(new BorderLayout()); // Layout del Frame
		txaRanking.append("#\tNombre\t\tPuntos");
		add(txaRanking, "Center");
		add(btnVolver, "South");
		setSize(400,200); // Tamaño de Frame
		setLocationRelativeTo(null); // Centrar la ventana
		setResizable(false); // Evitar redimensionado
	}
}
