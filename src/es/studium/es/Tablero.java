package es.studium.es;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

	// Inicialización (llámalo en el constructor de Tablero)

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
		
		posicionesCasillas[0] = new Point(371, 684); // Salida
		posicionesCasillas[1] = new Point(568, 684);
		posicionesCasillas[2] = new Point(736, 684);
		posicionesCasillas[3] = new Point(805, 684);
		posicionesCasillas[4] = new Point(863, 684);
		posicionesCasillas[5] = new Point(945, 684);
		posicionesCasillas[6] = new Point(1013, 684);
		posicionesCasillas[7] = new Point(1078, 684);
		posicionesCasillas[8] = new Point(1148, 688);
		posicionesCasillas[9] = new Point(1196, 647);
		posicionesCasillas[10] = new Point(1192, 585);
		posicionesCasillas[11] = new Point(1192, 527);
		posicionesCasillas[12] = new Point(1192, 465);
		posicionesCasillas[13] = new Point(1192, 404);
		posicionesCasillas[14] = new Point(1192, 341);
		posicionesCasillas[15] = new Point(1192, 286);
		posicionesCasillas[16] = new Point(1192, 221);
		posicionesCasillas[17] = new Point(1192, 173);
		posicionesCasillas[18] = new Point(1185, 102);
		posicionesCasillas[19] = new Point(1133, 64);
		posicionesCasillas[20] = new Point(1072, 64);
		posicionesCasillas[21] = new Point(1010, 64);
		posicionesCasillas[22] = new Point(947, 64);
		posicionesCasillas[23] = new Point(873, 64);
		posicionesCasillas[24] = new Point(814, 64);
		posicionesCasillas[25] = new Point(747, 64);
		posicionesCasillas[26] = new Point(685, 64);
		posicionesCasillas[27] = new Point(620, 64);
		posicionesCasillas[28] = new Point(555, 73);
		posicionesCasillas[29] = new Point(504, 115);
		posicionesCasillas[30] = new Point(504, 171);
		posicionesCasillas[31] = new Point(504, 226);
		posicionesCasillas[32] = new Point(504, 281);
		posicionesCasillas[33] = new Point(504, 344);
		posicionesCasillas[34] = new Point(504, 407);
		posicionesCasillas[35] = new Point(504, 464);
		posicionesCasillas[36] = new Point(495, 527);
		posicionesCasillas[37] = new Point(539, 566);
		posicionesCasillas[38] = new Point(609, 566);
		posicionesCasillas[39] = new Point(666, 566);
		posicionesCasillas[40] = new Point(738, 566);
		posicionesCasillas[41] = new Point(808, 566);
		posicionesCasillas[42] = new Point(863, 566);
		posicionesCasillas[43] = new Point(941, 566);
		posicionesCasillas[44] = new Point(1013, 569);
		posicionesCasillas[45] = new Point(1052, 529);
		posicionesCasillas[46] = new Point(1052, 459);
		posicionesCasillas[47] = new Point(1052, 405);
		posicionesCasillas[48] = new Point(1052, 346);
		posicionesCasillas[49] = new Point(1052, 287);
		posicionesCasillas[50] = new Point(1059, 221);
		posicionesCasillas[51] = new Point(1002, 185);
		posicionesCasillas[52] = new Point(936, 185);
		posicionesCasillas[53] = new Point(875, 185);
		posicionesCasillas[54] = new Point(812, 185);
		posicionesCasillas[55] = new Point(744, 185);
		posicionesCasillas[56] = new Point(681, 182);
		posicionesCasillas[57] = new Point(626, 226);
		posicionesCasillas[58] = new Point(626, 285);
		posicionesCasillas[59] = new Point(626, 348);
		posicionesCasillas[60] = new Point(626, 405);
		posicionesCasillas[61] = new Point(670, 446);
		posicionesCasillas[62] = new Point(749, 446);
		posicionesCasillas[63] = new Point(876, 372);
		// Cargar la imagen desde el archivo
		tablero = Toolkit.getDefaultToolkit().getImage("img\\tablero.png");

		// Configuración de la ventana
		setTitle("Juego de la Oca");
		setSize(1720, 808); // Tamaño de la ventana actualizado
		setLocationRelativeTo(null); // Centrar la ventana
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Crear un panel para dibujar el tablero y las fichas
		JPanel panel = new JPanel()
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g); // Llamar al método de la superclase para asegurar un buen repintado

				// Obtener el tamaño del panel y ajustar la imagen
				int width = getWidth();
				int height = getHeight();

				// Ajustar la imagen al tamaño del panel
				g.drawImage(tablero, 0, 0, width, height, this);

				// DIBUJAR FICHAS DE LOS JUGADORES
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

		// Layout para los componentes adicionales
		panel.setLayout(null); // Para posicionar elementos de manera absoluta

		// Tabla de jugadores en la parte derecha
		JPanel tablePanel = new JPanel(new GridLayout(1 + numJugadores, 4, 1, 1));
		tablePanel.setBounds(1340, 100, 250, 250); // Ubicación de la tabla
		tablePanel.setBackground(new Color(255, 255, 204)); // Color de fondo de la tabla

		// Ajustar las fichas de color
		lblColor1.setOpaque(true);
		lblColor1.setBackground(getColorFromString(c1));
		lblColor1.setPreferredSize(new Dimension(20, 20)); // Tamaño ficha en tabla

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

		System.out.println(jugador2);
		tablePanel.add(new JLabel(jugador2));
		tablePanel.add(lblTirada2);
		tablePanel.add(lblCasilla2);
		tablePanel.add(lblColor2);

		if (numJugadores >= 3)
		{
			System.out.println(jugador3);
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

		// Agregar los botones debajo de la tabla (en la parte derecha)
		btnTirarDados.setBounds(1396, 510, 200, 50);
		panel.add(tablePanel);
		panel.add(btnTirarDados);

		// Agregar el botón "Rehacer" debajo de la imagen del tablero
		btnRehacer.setBounds(110, 570, 200, 50);
		panel.add(btnRehacer);

		// Agregar el panel principal al JFrame
		add(panel);
	}

	// MÉTODO AUXILIAR: Convierte nombre de color a Color
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

	public void moverCasilla()
	{
		if (turno == 1)
		{
			int tiradaJ1 = modelo.tirada();
			contadorCasillasJ1 = contadorCasillasJ1 + tiradaJ1;
			contadorTiradas1++;
			System.out.println("Turno = " +turno);
			System.out.println("Tiradas jugador = "+contadorTiradas1);
			System.out.println("Tirada dado = " + tiradaJ1);
			if(modelo.ocaComprobarTurno(contadorCasillasJ1)) {
				contadorCasillasJ1 = modelo.moverCasillaOca(contadorCasillasJ1);
			}
		} else if (turno == 2)
		{
			int tiradaJ2 = modelo.tirada();
			contadorCasillasJ2 = contadorCasillasJ2 + tiradaJ2;
			contadorTiradas2++;
			System.out.println("Turno = " +turno);
			System.out.println("Tiradas jugador = "+contadorTiradas2);
			System.out.println("Tirada dado = " + tiradaJ2);
			if(modelo.ocaComprobarTurno(contadorCasillasJ2)) {
				contadorCasillasJ2 = modelo.moverCasillaOca(contadorCasillasJ2);
			}
		} else if (turno == 3)
		{
			int tiradaJ3 = modelo.tirada();
			contadorCasillasJ3 = contadorCasillasJ3 + tiradaJ3;
			contadorTiradas3++;
			System.out.println("Turno = " +turno);
			System.out.println("Tiradas jugador = "+contadorTiradas1);
			System.out.println("Tirada dado = " + tiradaJ3);
			if(modelo.ocaComprobarTurno(contadorCasillasJ3)) {
				contadorCasillasJ3 = modelo.moverCasillaOca(contadorCasillasJ3);
			}
		} else if (turno == 4)
		{
			int tiradaJ4 = modelo.tirada();
			contadorCasillasJ4 = contadorCasillasJ4 + tiradaJ4;
			contadorTiradas4++;
			System.out.println("Turno = " +turno);
			System.out.println("Tiradas jugador = "+contadorTiradas4);
			System.out.println("Tirada dado = " + tiradaJ4);
			if(modelo.ocaComprobarTurno(contadorCasillasJ4)) {
				contadorCasillasJ4 = modelo.moverCasillaOca(contadorCasillasJ4);
			}
		}
		if (!modelo.ocaComprobarTurno(contadorCasillasJ1) && !modelo.ocaComprobarTurno(contadorCasillasJ2)
				&& !modelo.ocaComprobarTurno(contadorCasillasJ3) && !modelo.ocaComprobarTurno(contadorCasillasJ4))
		{
			turno++;
			System.out.println("Se ha actualizado el turno");
		}
		if (turno > numJugadores)
		{
			turno = 1;
			System.out.println(turno);
		}
		repaint();
	}
}