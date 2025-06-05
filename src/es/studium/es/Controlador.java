package es.studium.es;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controlador extends WindowAdapter implements ActionListener
{
    Vista vista;
    ModeloT modelo;
    InicioPartida inicioPartida;
    // Puedes declarar aquí la referencia al tablero o lo que uses después

    public Controlador(Vista vista, ModeloT modelo)
    {
        this.vista = vista;
        this.modelo = modelo;
        // Listeners para la ventana principal
        vista.addWindowListener(this);
        vista.btnPartidaNueva.addActionListener(this);
        vista.btnRanking.addActionListener(this);
        // Puedes añadir más listeners aquí si tienes más botones
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Cuando el usuario pulsa "Partida Nueva"
        if(e.getSource() == vista.btnPartidaNueva)
        {
            // Por defecto lanzamos para 2 jugadores; aquí podrías pedir el número antes
            inicioPartida = new InicioPartida(2); // O el número que elijas
            inicioPartida.btnAceptar.addActionListener(this);
            inicioPartida.btnAtras.addActionListener(this);
            vista.setVisible(false);
        }

        // Cuando el usuario pulsa "Atrás" en InicioPartida
        else if(inicioPartida != null && e.getSource() == inicioPartida.btnAtras)
        {
            inicioPartida.setVisible(false);
            vista.setVisible(true);
        }

        // Cuando el usuario pulsa "Jugar" en InicioPartida
        else if(inicioPartida != null && e.getSource() == inicioPartida.btnAceptar)
        {
            int numJugadores = inicioPartida.getNumJugadores();
            String[] nombres = new String[numJugadores];
            String[] colores = new String[numJugadores];

            // Recoger los nombres y colores seleccionados según el número de jugadores
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

            // Aquí puedes usar los datos para inicializar la partida, el modelo, etc.
            // Ejemplo: modelo.iniciarPartida(nombres, colores);

            // Cierra la pantalla de inicio de partida y abre la pantalla del juego
            inicioPartida.setVisible(false);
            // Aquí deberías crear y mostrar tu tablero o la siguiente vista
            // Ejemplo: new VistaTablero(nombres, colores);
        }
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}
