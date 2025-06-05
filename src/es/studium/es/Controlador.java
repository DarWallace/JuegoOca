package es.studium.es;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Controlador implements ActionListener,WindowListener
{
    Vista vista;
    ModeloT modelo;
    InicioPartida inicioPartida;

    public Controlador(Vista v, ModeloT m)
    {
        this.vista = v;
        this.modelo = m;

        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.addWindowListener(this);
        vista.btnPartidaNueva.addActionListener(this);
        vista.btnRanking.addActionListener(this);
        // ... otros listeners de Vista si los tienes
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Botón para comenzar nueva partida
        if(e.getSource() == vista.btnPartidaNueva)
        {
            // Por defecto para 2 jugadores (puedes pedir al usuario cuántos)
            inicioPartida = new InicioPartida(2);
            inicioPartida.btnAceptar.addActionListener(this);
            inicioPartida.btnAtras.addActionListener(this);
            vista.setVisible(false);
        }

        // Botón para volver atrás desde la selección de jugadores
        else if(inicioPartida != null && e.getSource() == inicioPartida.btnAtras)
        {
            inicioPartida.dispose();
            vista.setVisible(true);
        }

        // Botón para aceptar y empezar la partida
        else if(inicioPartida != null && e.getSource() == inicioPartida.btnAceptar)
        {
            int numJugadores = inicioPartida.getNumJugadores();
            String[] nombres = new String[numJugadores];
            String[] colores = new String[numJugadores];

            if(numJugadores >= 1) {
                nombres[0] = inicioPartida.getNombreJugador1();
                colores[0] = inicioPartida.getColorJugador1();
            }
            if(numJugadores >= 2) {
                nombres[1] = inicioPartida.getNombreJugador2();
                colores[1] = inicioPartida.getColorJugador2();
            }
            if(numJugadores >= 3) {
                nombres[2] = inicioPartida.getNombreJugador3();
                colores[2] = inicioPartida.getColorJugador3();
            }
            if(numJugadores == 4) {
                nombres[3] = inicioPartida.getNombreJugador4();
                colores[3] = inicioPartida.getColorJugador4();
            }

            // Aquí puedes pasar los datos al modelo o abrir el tablero:
            // modelo.iniciarPartida(nombres, colores);

            inicioPartida.dispose();
            // Aquí podrías abrir la ventana del tablero, por ejemplo:
            // new VistaTablero(nombres, colores);

            // Por ahora, volvemos a la ventana principal
            vista.setVisible(true);
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
		// TODO Auto-generated method stub
		
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
}