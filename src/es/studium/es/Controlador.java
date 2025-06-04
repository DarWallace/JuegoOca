package es.studium.es;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent; // Para cerrar la ventana
import java.awt.event.WindowListener;

public class Controlador  implements WindowListener, ActionListener, MouseListener
{
	Vista vista;
	ModeloT modelo;
	
	int numJugadores=2;
	VistaRanking vistaRanking = new VistaRanking(); // Top Ten
	InicioPartida vistaInicioPartida = new InicioPartida(numJugadores); // Partida Nueva
	VistaTablero tablero; // Tablero
	int turno = 1;
	int tirada;
	int tiradasRojo = 0;
	int tiradasRosa = 0;
	int tiradasVerde = 0;
	int tiradasAzul = 0;


	// Constructor que recibe la vista
	public Controlador(Vista v, ModeloT m) {
		this.vista = v;
		this.modelo = m;
		
		vista.addWindowListener(this);
		vista.btnRanking.addActionListener(this); // Top Ten
		vista.btnPartidaNueva.addActionListener(this); // Partida Nueva
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vistaInicioPartida.btnAceptar) {
			System.out.println("Botón Jugar presionado.");
									
			// Solo si hay 2 o más jugadores:
			if (vistaInicioPartida.getNumJugadores() >= 2) {
				
			}
			// Solo si hay 3 o más jugadores:
			if (vistaInicioPartida.getNumJugadores() >= 3) {
				
			}
			// Solo si hay 4 jugadores:
			if (vistaInicioPartida.getNumJugadores() == 4) {
			
			}

			// Opcional: ocultar la vista actual o pasar a la siguiente vista
			// vista.dispose(); // Cierra la ventana actual
			// new OtraVistaDelJuego(); // Abre la siguiente vista
		} else if (e.getSource() == vistaInicioPartida.btnAtras) {
			System.out.println("Botón Atrás presionado.");
			// Aquí iría la lógica para volver a la pantalla anterior
			vista.dispose(); // Cierra la ventana actual
			// new PantallaAnterior(); // Volver a la pantalla anterior
		}
	}

	

	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
