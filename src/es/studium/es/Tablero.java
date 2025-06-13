package es.studium.es;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;

public class Tablero extends JFrame
{
	private static final long serialVersionUID = 1L;
	int contadorCasillasJ1 = 1;
	int contadorCasillasJ2 = 1;
	int contadorCasillasJ3 = 1;
	int contadorCasillasJ4 = 1;
	Image tablero;
	int numJugadores;
	String jugador1, jugador2, jugador3, jugador4, color1, color2, color3, color4;
	int tirada = 0;
	int contadorTiradas1 = 0;
	int contadorTiradas2 = 0;
	int contadorTiradas3 = 0;
	int contadorTiradas4 = 0;

	ModeloB modelo = new ModeloB();

	int turno = 1;

	JLabel lblJugador1 = new JLabel("Jugador 1:", JLabel.CENTER);
	JLabel lblJugador2 = new JLabel("Jugador 2:", JLabel.CENTER);
	JLabel lblJugador3 = new JLabel("Jugador 3:", JLabel.CENTER);
	JLabel lblJugador4 = new JLabel("Jugador 4:", JLabel.CENTER);

	Point p1 = new Point();
	Point p2 = new Point();
	Point p3 = new Point();
	Point p4 = new Point();

	JLabel lblTirada1 = new JLabel(contadorTiradas1 + "", JLabel.CENTER);
	JLabel lblTirada2 = new JLabel(contadorTiradas2 + "", JLabel.CENTER);
	JLabel lblTirada3 = new JLabel(contadorTiradas3 + "", JLabel.CENTER);
	JLabel lblTirada4 = new JLabel(contadorTiradas4 + "", JLabel.CENTER);

	JLabel lblCasilla1 = new JLabel(contadorCasillasJ1 + "", JLabel.CENTER);
	JLabel lblCasilla2 = new JLabel(contadorCasillasJ2 + "", JLabel.CENTER);
	JLabel lblCasilla3 = new JLabel(contadorCasillasJ3 + "", JLabel.CENTER);
	JLabel lblCasilla4 = new JLabel(contadorCasillasJ4 + "", JLabel.CENTER);

	JLabel lblColor1 = new JLabel();
	JLabel lblColor2 = new JLabel();
	JLabel lblColor3 = new JLabel();
	JLabel lblColor4 = new JLabel();

	JButton btnTirarDados = new JButton("Tirar los dados");
	JButton btnRehacer = new JButton("Rehacer");
	int posFicha1 = 0;
	int posFicha2 = 0;
	int posFicha3 = 0;
	int posFicha4 = 0;

	Point[] posicionesCasillas = new Point[64];

// NUEVO: Array para indicar el tipo de cada casilla
	String[] tipoCasilla = new String[64];

	public Tablero(int n, String j1, String c1, String j2, String c2, String j3, String c3, String j4, String c4)
	{
		numJugadores = n;
		jugador1 = j1;
		color1 = c1;
		jugador2 = j2;
		color2 = c2;
		jugador3 = j3;
		color3 = c3;
		jugador4 = j4;
		color4 = c4;

// Coordenadas tablero...
		posicionesCasillas[0] = new Point(371, 684); // Salida
		posicionesCasillas[1] = new Point(568, 684);
// ... (las demás igual que antes)
		posicionesCasillas[63] = new Point(876, 372);

// Imagen tablero
		tablero = Toolkit.getDefaultToolkit().getImage("img\\tablero.png");

// Configuración ventana...
		setTitle("Juego de la Oca");
		setSize(1720, 808);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel()
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				int width = getWidth();
				int height = getHeight();
				g.drawImage(tablero, 0, 0, width, height, this);

				if (numJugadores >= 1)
				{
					p1 = posicionesCasillas[contadorCasillasJ1];
					g.setColor(getColorFromString(color1));
					g.fillOval(p1.x, p1.y, 35, 35);
				}
				if (numJugadores >= 2)
				{
					p2 = posicionesCasillas[contadorCasillasJ2];
					g.setColor(getColorFromString(color2));
					g.fillOval(p2.x, p2.y, 30, 30);
				}
				if (numJugadores >= 3)
				{
					p3 = posicionesCasillas[contadorCasillasJ3];
					g.setColor(getColorFromString(color3));
					g.fillOval(p3.x, p3.y, 25, 25);
				}
				if (numJugadores == 4)
				{
					p4 = posicionesCasillas[contadorCasillasJ4];
					g.setColor(getColorFromString(color4));
					g.fillOval(p4.x, p4.y, 20, 20);
				}
			}
		};
		panel.setLayout(null);

// Tabla lateral...
		JPanel tablePanel = new JPanel(new GridLayout(1 + numJugadores, 4, 1, 1));
		tablePanel.setBounds(1340, 100, 250, 250);
		tablePanel.setBackground(new Color(255, 255, 204));

		lblColor1.setOpaque(true);
		lblColor1.setBackground(getColorFromString(c1));
		lblColor1.setPreferredSize(new Dimension(20, 20));
		lblColor2.setOpaque(true);
		lblColor2.setBackground(getColorFromString(c2));
		lblColor2.setPreferredSize(new Dimension(20, 20));
		if (numJugadores >= 3)
		{
			lblColor3.setOpaque(true);
			lblColor3.setBackground(getColorFromString(c3));
			lblColor3.setPreferredSize(new Dimension(20, 20));
		}
		if (numJugadores == 4)
		{
			lblColor4.setOpaque(true);
			lblColor4.setBackground(getColorFromString(c4));
			lblColor4.setPreferredSize(new Dimension(20, 20));
		}

		tablePanel.add(new JLabel("Nombre", JLabel.CENTER));
		tablePanel.add(new JLabel("Tiradas", JLabel.CENTER));
		tablePanel.add(new JLabel("Casilla", JLabel.CENTER));
		tablePanel.add(new JLabel("Ficha", JLabel.CENTER));
		tablePanel.add(new JLabel(jugador1));
		tablePanel.add(lblTirada1);
		tablePanel.add(lblCasilla1);
		tablePanel.add(lblColor1);
		tablePanel.add(new JLabel(jugador2));
		tablePanel.add(lblTirada2);
		tablePanel.add(lblCasilla2);
		tablePanel.add(lblColor2);
		if (numJugadores >= 3)
		{
			tablePanel.add(new JLabel(jugador3));
			tablePanel.add(lblTirada3);
			tablePanel.add(lblCasilla3);
			tablePanel.add(lblColor3);
		}
		if (numJugadores == 4)
		{
			tablePanel.add(new JLabel(jugador4));
			tablePanel.add(lblTirada4);
			tablePanel.add(lblCasilla4);
			tablePanel.add(lblColor4);
		}
		btnTirarDados.setBounds(1396, 510, 200, 50);
		panel.add(tablePanel);
		panel.add(btnTirarDados);
		btnRehacer.setBounds(110, 570, 200, 50);
		panel.add(btnRehacer);

		add(panel);

// INICIALIZACIÓN tipos de casilla
		for (int i = 0; i < tipoCasilla.length; i++)
			tipoCasilla[i] = "normal";
// Ejemplo de configuración; ajusta según tus reglas:
		tipoCasilla[5] = "oca";
		tipoCasilla[9] = "oca";
		tipoCasilla[14] = "oca";
		tipoCasilla[18] = "oca";
		tipoCasilla[23] = "oca";
		tipoCasilla[27] = "oca";
		tipoCasilla[32] = "oca";
		tipoCasilla[36] = "oca";
		tipoCasilla[41] = "oca";
		tipoCasilla[45] = "oca";
		tipoCasilla[50] = "oca";
		tipoCasilla[54] = "oca";
		tipoCasilla[59] = "oca";
		tipoCasilla[6] = "puente";
		tipoCasilla[12] = "posada";
		tipoCasilla[19] = "pozo";
		tipoCasilla[26] = "dados";
		tipoCasilla[31] = "pozo";
		tipoCasilla[42] = "laberinto";
		tipoCasilla[52] = "carcel";
		tipoCasilla[58] = "muerte";
		tipoCasilla[63] = "meta";
// Añade las que falten según tu tablero

	}

	private Color getColorFromString(String colorName)
	{
		switch (colorName)
		{
		case "Rojo":
			return Color.RED;
		case "Azul":
			return Color.BLUE;
		case "Verde":
			return Color.GREEN;
		case "Amarillo":
			return Color.YELLOW;
		default:
			return Color.BLACK;
		}
	}

// NUEVO: Método para aplicar la lógica de cada casilla especial
	private int aplicarReglaCasilla(int posicion, int jugador)
	{
		switch (tipoCasilla[posicion])
		{
		case "oca":
			mostrarMensaje("¡De oca a oca y tiro porque me toca!");
// Busca la siguiente oca y mueve allí
			return buscarSiguiente("oca", posicion);
		case "puente":
			mostrarMensaje("¡De puente a puente y tiro porque me lleva la corriente!");
			return buscarSiguiente("puente", posicion);
		case "posada":
			mostrarMensaje("¡En la posada! Pierde un turno.");
			perderTurnos(jugador, 1);
			return posicion;
		case "pozo":
			mostrarMensaje("¡En el pozo! Pierde 2 turnos.");
			perderTurnos(jugador, 2);
			return posicion;
		case "dados":
			mostrarMensaje("¡De dados a dados y tiro porque son dados!");
			return buscarSiguiente("dados", posicion);
		case "laberinto":
			mostrarMensaje("¡En el laberinto! Vuelve a la casilla 30.");
			return 30;
		case "carcel":
			mostrarMensaje("¡En la cárcel! Pierde 3 turnos.");
			perderTurnos(jugador, 3);
			return posicion;
		case "muerte":
			mostrarMensaje("¡Te has muerto! Vuelve a la casilla de salida.");
			return 1;
		case "meta":
			mostrarMensaje("¡Has llegado a la meta! ¡Victoria!");
			return 63;
		default:
			return posicion;
		}
	}

// Busca la siguiente casilla del tipo indicado, si no hay más, devuelve la misma posición
	private int buscarSiguiente(String tipo, int desde)
	{
		for (int i = desde + 1; i < tipoCasilla.length; i++)
		{
			if (tipoCasilla[i].equals(tipo))
				return i;
		}
		return desde;
	}

// Lógica para perder turnos (puedes implementarla como prefieras)
	private void perderTurnos(int jugador, int cuantos)
	{
// Ejemplo simple: suma los turnos perdidos al contador de tiradas
		switch (jugador)
		{
		case 1:
			contadorTiradas1 += cuantos;
			break;
		case 2:
			contadorTiradas2 += cuantos;
			break;
		case 3:
			contadorTiradas3 += cuantos;
			break;
		case 4:
			contadorTiradas4 += cuantos;
			break;
		}
	}

// Método para mostrar mensajes (puedes cambiarlo por un JOptionPane si quieres)
	private void mostrarMensaje(String texto)
	{
		System.out.println(texto);
	}

// MODIFICA moverCasilla para aplicar las reglas centralizadas
	public void moverCasilla()
	{
		if (turno == 1)
		{
			int tiradaJ1 = modelo.tirada();
			contadorCasillasJ1 += tiradaJ1;
			if (contadorCasillasJ1 >= 63)
				contadorCasillasJ1 = 63;
			contadorCasillasJ1 = aplicarReglaCasilla(contadorCasillasJ1, 1);
			contadorTiradas1++;
			lblCasilla1.setText(contadorCasillasJ1 + "");
			lblTirada1.setText(contadorTiradas1 + "");
		} else if (turno == 2)
		{
			int tiradaJ2 = modelo.tirada();
			contadorCasillasJ2 += tiradaJ2;
			if (contadorCasillasJ2 >= 63)
				contadorCasillasJ2 = 63;
			contadorCasillasJ2 = aplicarReglaCasilla(contadorCasillasJ2, 2);
			contadorTiradas2++;
			lblCasilla2.setText(contadorCasillasJ2 + "");
			lblTirada2.setText(contadorTiradas2 + "");
		} else if (turno == 3)
		{
			int tiradaJ3 = modelo.tirada();
			contadorCasillasJ3 += tiradaJ3;
			if (contadorCasillasJ3 >= 63)
				contadorCasillasJ3 = 63;
			contadorCasillasJ3 = aplicarReglaCasilla(contadorCasillasJ3, 3);
			contadorTiradas3++;
			lblCasilla3.setText(contadorCasillasJ3 + "");
			lblTirada3.setText(contadorTiradas3 + "");
		} else if (turno == 4)
		{
			int tiradaJ4 = modelo.tirada();
			contadorCasillasJ4 += tiradaJ4;
			if (contadorCasillasJ4 >= 63)
				contadorCasillasJ4 = 63;
			contadorCasillasJ4 = aplicarReglaCasilla(contadorCasillasJ4, 4);
			contadorTiradas4++;
			lblCasilla4.setText(contadorCasillasJ4 + "");
			lblTirada4.setText(contadorTiradas4 + "");
		}

		turno++;
		if (turno > numJugadores)
			turno = 1;
		repaint();
	}
}