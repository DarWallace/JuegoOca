package es.studium.es;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

	int saltosJ1 = 0;
	int saltosJ2 = 0;
	int saltosJ3 = 0;
	int saltosJ4 = 0;
	
	JPanel panelDado = new JPanel(null);
	JLabel lblDado = new JLabel();
	ImageIcon[] dados = new ImageIcon[6];

	ModeloB modelo = new ModeloB();

	int turno = 1;

	JLabel lblTurno = new JLabel("Turno de: ", JLabel.CENTER);

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

		posicionesCasillas[17] = new Point(1192, 170);

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

		lblTurno.setBounds(1340, 60, 250, 30); // Ajusta la posición según necesites
		lblTurno.setFont(lblTurno.getFont().deriveFont(18f)); // Fuente más grande opcional
		lblTurno.setText("Turno de: " + obtenerNombreTurno());
		panel.add(lblTurno);

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
		
		for (int i = 0; i < 6; i++) {
	        dados[i] = new ImageIcon("img\\dado" + (i + 1) + ".png");
	    }

	    // Configura el JLabel del dedo
		for (int i = 0; i < 6; i++) {
		    dados[i] = new ImageIcon("img/dado" + (i + 1) + ".png");
		}

		// Configura el JLabel para el dado
		lblDado.setBounds(0, 0, 80, 80); // Tamaño dentro del panel
		lblDado.setIcon(dados[0]);

		// Configura el panel y añádele el JLabel
		panelDado.setBounds(160, 480, 80, 80); // Ponlo justo encima del dado del tablero
		panelDado.setOpaque(false); // Para que sea transparente si lo necesitas
		panelDado.add(lblDado);

		// Añade el panelDado al tablero principal (suponiendo que tu tablero es un JPanel con layout null)
		add(panelDado);
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
		tipoCasilla[12] = "puente";
		tipoCasilla[19] = "posada";
		tipoCasilla[26] = "dados";
		tipoCasilla[31] = "pozo";
		tipoCasilla[42] = "laberinto";
		tipoCasilla[56] = "carcel";
		tipoCasilla[53] = "dados";
		tipoCasilla[58] = "calavera";
		tipoCasilla[63] = "meta";
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
	
	public void mostrarDado(int tirada) {
	    switch (tirada) {
	        case 1:
	            lblDado.setIcon(new ImageIcon("img\\dado1.png"));
	            break;
	        case 2:
	            lblDado.setIcon(new ImageIcon("img\\dado2.png"));
	            break;
	        case 3:
	            lblDado.setIcon(new ImageIcon("img\\dado3.png"));
	            break;
	        case 4:
	            lblDado.setIcon(new ImageIcon("img\\dado4.png"));
	            break;
	        case 5:
	            lblDado.setIcon(new ImageIcon("img\\dado5.png"));
	            break;
	        case 6:
	            lblDado.setIcon(new ImageIcon("img\\dado6.png"));
	            break;
	        default:
	            lblDado.setIcon(new ImageIcon("img\\dado1.png"));
	    }
	}

// NUEVO: Método para aplicar la lógica de cada casilla especial
	private int aplicarReglaCasilla(int posicion, int jugador)
	{
		switch (tipoCasilla[posicion])
		{
		case "oca":
			JOptionPane.showMessageDialog(this, "¡De oca a oca y tiro porque me toca!");
			return buscarSiguiente("oca", posicion);
		case "puente":
			JOptionPane.showMessageDialog(this, "¡Del puente a la posada!");
			return aplicarReglaCasilla(19, jugador);
		case "posada":
			JOptionPane.showMessageDialog(this, "¡En la posada! Pierde un turno.");
			perderTurnos(jugador, 1);
			return posicion;
		case "pozo":
			JOptionPane.showMessageDialog(this, "¡En el pozo! Pierde 2 turnos.");
			perderTurnos(jugador, 2);
			return posicion;
		case "dados":
			JOptionPane.showMessageDialog(this, "¡De dados a dados y tiro porque son dados!");
			if (posicion == 26)
			{
				return 53;
			} else if (posicion == 53)
			{
				return 26;
			}
		case "laberinto":
			JOptionPane.showMessageDialog(this, "¡En el laberinto! Vuelve a la casilla 30.");
			return 30;
		case "carcel":
			JOptionPane.showMessageDialog(this, "¡En la cárcel! Pierde 3 turnos.");
			perderTurnos(jugador, 3);
			return posicion;
		case "muerte":
			JOptionPane.showMessageDialog(this, "¡Te has muerto! Vuelve a la casilla de salida.");
			return 1;
		case "meta":
			JOptionPane.showMessageDialog(this, "¡Has llegado a la meta! ¡Victoria!");
			return 63;
		default:
			return posicion;
		}
	}

	public void actualizarLabelTurno()
	{
		lblTurno.setText("Turno de: " + obtenerNombreTurno());
	}

	private String obtenerNombreTurno()
	{
		switch (turno)
		{
		case 1:
			return jugador1;
		case 2:
			return jugador2;
		case 3:
			return jugador3;
		case 4:
			return jugador4;
		default:
			return "";
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
		switch (jugador)
		{
		case 1:
			saltosJ1 += cuantos;
			break;
		case 2:
			saltosJ2 += cuantos;
			break;
		case 3:
			saltosJ3 += cuantos;
			break;
		case 4:
			saltosJ4 += cuantos;
			break;
		}
	}

// MODIFICA moverCasilla para aplicar las reglas centralizadas
	public void moverCasilla()
	{		
		if (turno == 1 && saltosJ1 > 0) {
	        saltosJ1--;
	        JOptionPane.showMessageDialog(this,jugador1 + " pierde este turno.");
	        turno++;
	        if (turno > numJugadores) turno = 1;
	        actualizarLabelTurno();
	        return;
	    }
	    if (turno == 2 && saltosJ2 > 0) {
	        saltosJ2--;
	        JOptionPane.showMessageDialog(this,jugador2 + " pierde este turno.");
	        turno++;
	        if (turno > numJugadores) turno = 1;
	        actualizarLabelTurno();
	        return;
	    }
	    if (turno == 3 && saltosJ3 > 0) {
	        saltosJ3--;
	        JOptionPane.showMessageDialog(this,jugador3 + " pierde este turno.");
	        turno++;
	        if (turno > numJugadores) turno = 1;
	        actualizarLabelTurno();
	        return;
	    }
	    if (turno == 4 && saltosJ4 > 0) {
	        saltosJ4--;
	        JOptionPane.showMessageDialog(this,jugador4 + " pierde este turno.");
	        turno++;
	        if (turno > numJugadores) turno = 1;
	        actualizarLabelTurno();
	        return;
	    }
	    
		boolean caeEnOca = false;
		int jugadorTurno = turno;

		if (jugadorTurno == 1)
		{
			int tiradaJ1 = modelo.tirada();
			mostrarDado(tiradaJ1);
			contadorCasillasJ1 += tiradaJ1;
			if (modelo.victoriaFallida(contadorCasillasJ1)) {
				int casillasRetroceder = contadorCasillasJ1 - 63;
				contadorCasillasJ1 = 63 - casillasRetroceder;
				if (contadorCasillasJ1 < 1) contadorCasillasJ1 = 1;
			}else if(modelo.comprobarVictoria(contadorCasillasJ1)) {
				aplicarReglaCasilla(contadorCasillasJ1, 1);
			}
			int nuevaPos = aplicarReglaCasilla(contadorCasillasJ1, 1);
			caeEnOca = (tipoCasilla[nuevaPos].equals("oca") && nuevaPos != contadorCasillasJ1);
			contadorCasillasJ1 = nuevaPos;
			contadorTiradas1++;
			lblCasilla1.setText(contadorCasillasJ1 + "");
			lblTirada1.setText(contadorTiradas1 + "");
		} else if (jugadorTurno == 2)
		{
			int tiradaJ2 = modelo.tirada();
			mostrarDado(tiradaJ2);
			contadorCasillasJ2 += tiradaJ2;
			if (modelo.victoriaFallida(contadorCasillasJ2)) {
				int casillasRetroceder = contadorCasillasJ2 - 63;
				contadorCasillasJ4 = 62 - casillasRetroceder;
				if (contadorCasillasJ2 < 1) contadorCasillasJ2 = 1;
			}else if(modelo.comprobarVictoria(contadorCasillasJ2)) {
				aplicarReglaCasilla(contadorCasillasJ2, 2);
			}
			int nuevaPos = aplicarReglaCasilla(contadorCasillasJ2, 2);
			caeEnOca = (tipoCasilla[nuevaPos].equals("oca") && nuevaPos != contadorCasillasJ2);
			contadorCasillasJ2 = nuevaPos;
			contadorTiradas2++;
			lblCasilla2.setText(contadorCasillasJ2 + "");
			lblTirada2.setText(contadorTiradas2 + "");
		} else if (jugadorTurno == 3)
		{
			int tiradaJ3 = modelo.tirada();
			mostrarDado(tiradaJ3);
			contadorCasillasJ3 += tiradaJ3;
			if (modelo.victoriaFallida(contadorCasillasJ3)) {
				int casillasRetroceder = contadorCasillasJ3 - 63;
				contadorCasillasJ3 = 63 - casillasRetroceder;
				if (contadorCasillasJ3 < 1) contadorCasillasJ3 = 1;
			}else if(modelo.comprobarVictoria(contadorCasillasJ3)) {
				aplicarReglaCasilla(contadorCasillasJ3, 3);
			}
			int nuevaPos = aplicarReglaCasilla(contadorCasillasJ3, 3);
			caeEnOca = (tipoCasilla[nuevaPos].equals("oca") && nuevaPos != contadorCasillasJ3);
			contadorCasillasJ3 = nuevaPos;
			contadorTiradas3++;
			lblCasilla3.setText(contadorCasillasJ3 + "");
			lblTirada3.setText(contadorTiradas3 + "");
		} else if (jugadorTurno == 4)
		{
			int tiradaJ4 = modelo.tirada();
			mostrarDado(tiradaJ4);
			contadorCasillasJ4 += tiradaJ4;
			if (modelo.victoriaFallida(contadorCasillasJ4)) {
				int casillasRetroceder = contadorCasillasJ4 - 63;
				contadorCasillasJ4 = 63 - casillasRetroceder;
				if (contadorCasillasJ4 < 1) contadorCasillasJ4 = 1;
			}else if(modelo.comprobarVictoria(contadorCasillasJ4)) {
				aplicarReglaCasilla(contadorCasillasJ4, 4);
			}
			int nuevaPos = aplicarReglaCasilla(contadorCasillasJ4, 4);
			caeEnOca = (tipoCasilla[nuevaPos].equals("oca") && nuevaPos != contadorCasillasJ4);
			contadorCasillasJ4 = nuevaPos;
			contadorTiradas4++;
			lblCasilla4.setText(contadorCasillasJ4 + "");
			lblTirada4.setText(contadorTiradas4 + "");
		}
		lblTurno.setText("Turno de: " + obtenerNombreTurno());

		repaint();

		// Si caes en una oca, vuelve a tirar SIN cambiar de turno
		if (caeEnOca)
		{
			moverCasilla();
		} else
		{
			turno++;
			if (turno > numJugadores)
				turno = 1;
		}
	}
}