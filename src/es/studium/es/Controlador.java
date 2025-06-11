package es.studium.es;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener
{
	Vista vista;
	ModeloB modelo;
	InicioPartida inicioPartida;
	SeleccionJugadores seleccionJugadores;
	Tablero tableroJuego;
	VistaRanking vistaRanking;

	public Controlador(Vista v, ModeloB m)
	{
		this.vista = v;
		this.modelo = m;

		vista.btnPartidaNueva.addActionListener(this);
		vista.btnRanking.addActionListener(this);
		vista.btnAyuda.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == vista.btnRanking) {
			vistaRanking = new VistaRanking();
			vistaRanking.btnVolver.addActionListener(this);
			vista.frame.setVisible(true);
			vistaRanking.setVisible(true);
		}else if (e.getSource() == vistaRanking.btnVolver)
		{vistaRanking.setVisible(false);}
		else if (e.getSource() == vista.btnPartidaNueva)
		{
			seleccionJugadores = new SeleccionJugadores(); // ← asignación correcta
			// Añadir listeners a los botones nuevos
			seleccionJugadores.btn2jugadores.addActionListener(this);
			seleccionJugadores.btn3jugadores.addActionListener(this);
			seleccionJugadores.btn4jugadores.addActionListener(this);

			vista.frame.setVisible(false);
			seleccionJugadores.setVisible(true);
		} else if (e.getSource() == seleccionJugadores.btn2jugadores)
		{
			inicioPartida = new InicioPartida(2); // ← ahora sí se guarda
			inicioPartida.btnAtras.addActionListener(this);
			inicioPartida.btnAceptar.addActionListener(this);

			inicioPartida.setVisible(true);
			seleccionJugadores.dispose();
		} else if (e.getSource() == seleccionJugadores.btn3jugadores)
		{
			inicioPartida = new InicioPartida(3);
			inicioPartida.btnAtras.addActionListener(this);
			inicioPartida.btnAceptar.addActionListener(this);

			inicioPartida.setVisible(true);
			seleccionJugadores.dispose();
		} else if (e.getSource() == seleccionJugadores.btn4jugadores)
		{
			inicioPartida = new InicioPartida(4);
			inicioPartida.btnAtras.addActionListener(this);
			inicioPartida.btnAceptar.addActionListener(this);

			inicioPartida.setVisible(true);
			seleccionJugadores.dispose();
		} else if (inicioPartida != null && e.getSource() == inicioPartida.btnAtras)
		{
			inicioPartida.dispose();
			seleccionJugadores.setVisible(true);
		} else if (inicioPartida != null && e.getSource() == inicioPartida.btnAceptar)
		{
			int numJugadores = inicioPartida.getNumJugadores();
			System.out.println(numJugadores);
			if (numJugadores == 2)
			{
				tableroJuego = new Tablero(numJugadores, inicioPartida.getNombreJugador1(), inicioPartida.getColorJugador1(),
						inicioPartida.getNombreJugador2(), inicioPartida.getColorJugador2(), "", "", "", "");
				System.out.println(inicioPartida.getColorJugador1());
				tableroJuego.setVisible(true);
				inicioPartida.dispose();
			} else if (numJugadores == 3)
			{
				tableroJuego = new Tablero(numJugadores, inicioPartida.getNombreJugador1(), inicioPartida.getColorJugador1(),
						inicioPartida.getNombreJugador2(), inicioPartida.getColorJugador2(),
						inicioPartida.getNombreJugador3(), inicioPartida.getColorJugador3(), "", "");
				tableroJuego.setVisible(true);
				inicioPartida.dispose();
			} else if (numJugadores == 4)
			{
				tableroJuego = new Tablero(numJugadores, inicioPartida.getNombreJugador1(), inicioPartida.getColorJugador1(),
						inicioPartida.getNombreJugador2(), inicioPartida.getColorJugador2(),
						inicioPartida.getNombreJugador3(), inicioPartida.getColorJugador3(),
						inicioPartida.getNombreJugador4(), inicioPartida.getColorJugador4());
				tableroJuego.setVisible(true);
				inicioPartida.dispose();
			}
		}
	}
}
