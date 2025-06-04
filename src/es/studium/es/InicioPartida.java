package es.studium.es;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;

public class InicioPartida extends Frame 
{

	
	private static final long serialVersionUID = 1L;
// Declarar el objeto Image
	Image imagenFondo;
	// Declarar el objeto Toolkit para manejo de imágenes
	Toolkit herramienta;
	Label lblJugador1 = new Label("Jugador1:");
	TextField txtNombreJ1 = new TextField("Nombre1",20);
	Choice choiceColorJ1 = new Choice();
	Panel pnlJugador1 = new Panel(new FlowLayout(FlowLayout.LEFT)); // Panel para el Jugador 1
	
	Label lblJugador2 = new Label("Jugador2:");
	TextField txtNombreJ2 = new TextField("Nombre2",20);
	Choice choiceColorJ2 = new Choice();
	Panel pnlJugador2 = new Panel(new FlowLayout(FlowLayout.LEFT)); // Panel para el Jugador 2
	
	Label lblJugador3 = new Label("Jugador3:");
	TextField txtNombreJ3 = new TextField("Nombre3",20);
	Choice choiceColorJ3 = new Choice();
	Panel pnlJugador3 = new Panel(new FlowLayout(FlowLayout.LEFT)); // Panel para el Jugador 3
	
	Label lblJugador4 = new Label("Jugador4:");
	TextField txtNombreJ4 = new TextField("Nombre4",20);
	Choice choiceColorJ4 = new Choice();
	Panel pnlJugador4 = new Panel(new FlowLayout(FlowLayout.LEFT)); // Panel para el Jugador 4
	
	Button btnAceptar = new Button("Jugar");
	Button btnAtras = new Button("<--");
	private int numJugadores;
	public InicioPartida(int numJugadores) {
		
		setTitle("Selección de jugadores (" + numJugadores + " jugadores)");
		setSize(800, 600);
		setResizable(false);
		
		// Inicializar las opciones de colores
		String[] colores = {"Rojo", "Amarillo", "Azul", "Verde"};
		for (String color : colores) {
			choiceColorJ1.add(color);
			choiceColorJ2.add(color);
			choiceColorJ3.add(color);
			choiceColorJ4.add(color);
		}
		// Seleccionar un color por defecto
		choiceColorJ1.select("Rojo");
		choiceColorJ2.select("Azul");
		choiceColorJ3.select("Verde");
		choiceColorJ4.select("Amarillo");
		
		
		
		// Llenar los paneles de los jugadores (independientemente de si se mostrarán)
		pnlJugador1.add(lblJugador1);
		pnlJugador1.add(txtNombreJ1);
		pnlJugador1.add(choiceColorJ1);

		pnlJugador2.add(lblJugador2);
		pnlJugador2.add(txtNombreJ2);
		pnlJugador2.add(choiceColorJ2);

		pnlJugador3.add(lblJugador3);
		pnlJugador3.add(txtNombreJ3);
		pnlJugador3.add(choiceColorJ3);

		pnlJugador4.add(lblJugador4);
		pnlJugador4.add(txtNombreJ4);
		pnlJugador4.add(choiceColorJ4);
		// Determinar el número de filas del GridLayout basado en el número de jugadores
		// Si son 2 jugadores: 3 filas (atrás, 2 jugadores, jugar)
		// Si son 3 o 4 jugadores: 4 filas (atrás, 2 jugadores, 2 jugadores, jugar)
		int numFilas = (numJugadores <= 2) ? 3 : 4;
		setLayout(new GridLayout(numFilas, 2, 10, 10));
		
		// --- Disposición de componentes en el Frame ---

		// Panel para el botón de atrás (Fila 0, Columna 0)
		Panel pnlAtras = new Panel(new FlowLayout(FlowLayout.LEFT));
		pnlAtras.add(btnAtras);
		add(pnlAtras);
		add(new Panel()); // Panel vacío para Fila 0, Columna 1 para mantener el botón a la izquierda
		
		// Añadir los paneles de jugadores condicionalmente
		if (numJugadores >= 2) {
			add(pnlJugador1); // Fila 1, Columna 0
			add(pnlJugador2); // Fila 1, Columna 1
		} else {
			// Añadir paneles vacíos si no hay suficientes jugadores para esta fila
			add(new Panel());
			add(new Panel());
		}

		if (numJugadores >= 3) {
			add(pnlJugador3); // Fila 2 (o 3 si numJugadores <= 2), Columna 0
			// Si solo hay 3 jugadores, la columna de la derecha de la fila 2 debería ser vacía
			if (numJugadores == 3) {
				add(new Panel()); // Panel vacío para Fila 2 (o 3), Columna 1
			} else { // numJugadores == 4
				add(pnlJugador4); // Fila 2 (o 3), Columna 1
			}
		} else if (numJugadores < 3 && numFilas == 4) { // Si hay menos de 3 jugadores pero GridLayout es de 4 filas
		    add(new Panel()); // Ocupar celda vacía para mantener el layout
		    add(new Panel()); // Ocupar celda vacía para mantener el layout
		}


		// Panel para el botón "Jugar" (Última Fila, Columna 1 - alineado a la derecha)
		Panel pnlBotonJugar = new Panel(new FlowLayout(FlowLayout.RIGHT));
		pnlBotonJugar.add(btnAceptar);
		add(pnlBotonJugar);
		add(new Panel()); // Panel vacío para la última fila, columna 0, para empujar "Jugar" a la derecha
		
		setVisible(true);
	}
	public int getNumJugadores() {
		return numJugadores;
	}
	public static void main(String[] args)
	{
		// Para probar la vista con diferentes números de jugadores
		// new VistaChoiceJugadores(2); // Para 2 jugadores
		// new VistaChoiceJugadores(3); // Para 3 jugadores
		new InicioPartida(4); // Para 4 jugadores
	}
}
