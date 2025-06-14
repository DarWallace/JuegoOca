package es.studium.es;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Controlador implements ActionListener {
	Vista vista;
	ModeloB modelo;
	InicioPartida inicioPartida;
	SeleccionJugadores seleccionJugadores;
	Tablero tableroJuego;
	VistaRanking vistaRanking;
	Connection connection = null;

	public Controlador(Vista v, ModeloB m) {
		this.vista = v;
		this.modelo = m;

		vista.btnPartidaNueva.addActionListener(this);
		vista.btnRanking.addActionListener(this);
		vista.btnAyuda.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.btnRanking) {
			vistaRanking = new VistaRanking();
			vistaRanking.btnVolver.addActionListener(this);
			vista.frame.setVisible(true);
			vistaRanking.setVisible(true);
		} else if (vistaRanking != null && e.getSource() == vistaRanking.btnVolver) {
			vistaRanking.setVisible(false);
		}

		else if (e.getSource() == vista.btnAyuda) {
			ModeloB.ayuda();
		}

		else if (e.getSource() == vista.btnPartidaNueva) {
			seleccionJugadores = new SeleccionJugadores(); // ← asignación correcta
			// Añadir listeners a los botones nuevos
			seleccionJugadores.btn2jugadores.addActionListener(this);
			seleccionJugadores.btn3jugadores.addActionListener(this);
			seleccionJugadores.btn4jugadores.addActionListener(this);
			seleccionJugadores.btnVolver.addActionListener(this);
			vista.frame.setVisible(false);
			seleccionJugadores.setVisible(true);
		} else if (seleccionJugadores != null && e.getSource() == seleccionJugadores.btnVolver) {
			vista.frame.setVisible(true);
			seleccionJugadores.dispose();
		} else if (seleccionJugadores != null && e.getSource() == seleccionJugadores.btn2jugadores) {
			inicioPartida = new InicioPartida(2); // ← ahora sí se guarda
			inicioPartida.btnAtras.addActionListener(this);
			inicioPartida.btnAceptar.addActionListener(this);

			inicioPartida.setVisible(true);
			seleccionJugadores.dispose();
		} else if (seleccionJugadores != null && e.getSource() == seleccionJugadores.btn3jugadores) {
			inicioPartida = new InicioPartida(3);
			inicioPartida.btnAtras.addActionListener(this);
			inicioPartida.btnAceptar.addActionListener(this);

			inicioPartida.setVisible(true);
			seleccionJugadores.dispose();
		} else if (seleccionJugadores != null && e.getSource() == seleccionJugadores.btn4jugadores) {
			inicioPartida = new InicioPartida(4);
			inicioPartida.btnAtras.addActionListener(this);
			inicioPartida.btnAceptar.addActionListener(this);

			inicioPartida.setVisible(true);
			seleccionJugadores.dispose();
		} else if (inicioPartida != null && e.getSource() == inicioPartida.btnAtras) {
			inicioPartida.dispose();
			seleccionJugadores.setVisible(true);
		} else if (inicioPartida != null && e.getSource() == inicioPartida.btnAceptar) {
			if (modelo.verificarDuplicados(inicioPartida.getNombreJugador1(), inicioPartida.getNombreJugador2(),
					inicioPartida.getNombreJugador3(), inicioPartida.getNombreJugador4(),
					inicioPartida.getColorJugador1(), inicioPartida.getColorJugador2(),
					inicioPartida.getColorJugador3(), inicioPartida.getColorJugador4())) {

				int numJugadores = inicioPartida.getNumJugadores();
				System.out.println(numJugadores);
				if (numJugadores == 2) {
					tableroJuego = new Tablero(numJugadores, inicioPartida.getNombreJugador1(),
							inicioPartida.getColorJugador1(), inicioPartida.getNombreJugador2(),
							inicioPartida.getColorJugador2(), "", "", "", "");
					tableroJuego.btnTirarDados.addActionListener(this);
					tableroJuego.btnRehacer.addActionListener(this);
					tableroJuego.setVisible(true);
					inicioPartida.dispose();
					tableroJuego.contadorCasillasJ3 = 63;
					tableroJuego.contadorCasillasJ4 = 63;
				} else if (numJugadores == 3) {
					tableroJuego = new Tablero(numJugadores, inicioPartida.getNombreJugador1(),
							inicioPartida.getColorJugador1(), inicioPartida.getNombreJugador2(),
							inicioPartida.getColorJugador2(), inicioPartida.getNombreJugador3(),
							inicioPartida.getColorJugador3(), "", "");
					tableroJuego.btnTirarDados.addActionListener(this);
					tableroJuego.btnRehacer.addActionListener(this);
					tableroJuego.setVisible(true);
					inicioPartida.dispose();
					tableroJuego.contadorCasillasJ4 = 63;
				} else if (numJugadores == 4) {
					tableroJuego = new Tablero(numJugadores, inicioPartida.getNombreJugador1(),
							inicioPartida.getColorJugador1(), inicioPartida.getNombreJugador2(),
							inicioPartida.getColorJugador2(), inicioPartida.getNombreJugador3(),
							inicioPartida.getColorJugador3(), inicioPartida.getNombreJugador4(),
							inicioPartida.getColorJugador4());
					tableroJuego.btnTirarDados.addActionListener(this);
					tableroJuego.btnRehacer.addActionListener(this);
					tableroJuego.setVisible(true);
					inicioPartida.dispose();
				}
			} else {
				JOptionPane.showMessageDialog(inicioPartida, "Un nombre o un color esta repetido");
			}
		} else if (tableroJuego != null && e.getSource() == tableroJuego.btnTirarDados) {
			int numJugadores = inicioPartida.getNumJugadores();
			tableroJuego.moverCasilla();
			if (tableroJuego.finJuego(tableroJuego.contadorCasillasJ1, tableroJuego.contadorCasillasJ2,
					tableroJuego.contadorCasillasJ3, tableroJuego.contadorCasillasJ4)) {
				connection = modelo.conectarB();
				modelo.altaJugador(connection, tableroJuego.jugador1, tableroJuego.contadorTiradas1);
				modelo.altaJugador(connection, tableroJuego.jugador2, tableroJuego.contadorTiradas2);
				if (numJugadores >= 3) {
				    modelo.altaJugador(connection, tableroJuego.jugador3, tableroJuego.contadorTiradas3);
				}
				if (numJugadores == 4) {
				    modelo.altaJugador(connection, tableroJuego.jugador4, tableroJuego.contadorTiradas4);
				}
				modelo.desconectarB(connection);
				JOptionPane.showMessageDialog(tableroJuego, "Fin del juego");
				tableroJuego.dispose();
				vista.frame.setVisible(true);
			}
			tableroJuego.avanzarTurno();
			tableroJuego.actualizarLabelTurno();
		} else if (tableroJuego != null && e.getSource() == tableroJuego.btnRehacer) {
			UIManager.put("OptionPane.yesButtonText", "Sí");
			UIManager.put("OptionPane.noButtonText", "No");
			int respuesta = JOptionPane.showConfirmDialog(tableroJuego, "¿Estás seguro de rehacer la partida? ",
					"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (respuesta == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(tableroJuego, "Se reinicio la partida", "Partida reiniciada",
						JOptionPane.INFORMATION_MESSAGE);
				tableroJuego.contadorCasillasJ1 = 1;
				tableroJuego.contadorCasillasJ2 = 1;
				tableroJuego.contadorCasillasJ3 = 1;
				tableroJuego.contadorCasillasJ4 = 1;

				tableroJuego.contadorTiradas1 = 0;
				tableroJuego.contadorTiradas2 = 0;
				tableroJuego.contadorTiradas3 = 0;
				tableroJuego.contadorTiradas4 = 0;

				tableroJuego.saltosJ1 = 0;
				tableroJuego.saltosJ2 = 0;
				tableroJuego.saltosJ3 = 0;
				tableroJuego.saltosJ4 = 0;

				// Reinicia el turno al primero
				tableroJuego.turno = 1;
				tableroJuego.actualizarLabelTurno();

				// Actualiza los labels de casilla y tirada
				tableroJuego.lblCasilla1.setText("1");
				tableroJuego.lblCasilla2.setText("1");
				tableroJuego.lblCasilla3.setText("1");
				tableroJuego.lblCasilla4.setText("1");

				tableroJuego.lblTirada1.setText("0");
				tableroJuego.lblTirada2.setText("0");
				tableroJuego.lblTirada3.setText("0");
				tableroJuego.lblTirada4.setText("0");

				// Redibuja el tablero para reposicionar las fichas
				tableroJuego.repaint();
			} else {
			}
		}
	}
}
