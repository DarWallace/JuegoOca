package es.studium.es;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener
{
    Vista vista;
    ModeloT modelo;
    InicioPartida inicioPartida;

    public Controlador(Vista v, ModeloT m)
    {
        this.vista = v;
        this.modelo = m;

        vista.btnPartidaNueva.addActionListener(this);
        vista.btnRanking.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == vista.btnPartidaNueva)
        {
            inicioPartida = new InicioPartida(4); // Cambia el número si quieres más jugadores
            inicioPartida.btnAceptar.addActionListener(this);
            inicioPartida.btnAtras.addActionListener(this);
            vista.setVisible(false);
        }
        else if(inicioPartida != null && e.getSource() == inicioPartida.btnAtras)
        {
            inicioPartida.dispose();
            vista.setVisible(true);
        }
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
            }if(numJugadores >= 3) {
                nombres[2] = inicioPartida.getNombreJugador3();
                colores[2] = inicioPartida.getColorJugador3();
            }if(numJugadores >= 4) {
                nombres[3] = inicioPartida.getNombreJugador4();
                colores[3] = inicioPartida.getColorJugador4();
            }

            inicioPartida.dispose();
            vista.setVisible(true);
        }
    }
}