package es.studium.es;

import javax.swing.*;
import java.awt.*;

public class InicioPartida extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 int numJugadores = 0;

    private JLabel lblJugador1 = new JLabel("Jugador1:");
    private JTextField txtNombreJ1 = new JTextField("Nombre1", 20);
    private JComboBox<String> choiceColorJ1 = new JComboBox<>();

    private JLabel lblJugador2 = new JLabel("Jugador2:");
    private JTextField txtNombreJ2 = new JTextField("Nombre2", 20);
    private JComboBox<String> choiceColorJ2 = new JComboBox<>();
    
    private JLabel lblJugador3 = new JLabel("Jugador3:");
    private JTextField txtNombreJ3 = new JTextField("Nombre3", 20);
    private JComboBox<String> choiceColorJ3 = new JComboBox<>();
    
    private JLabel lblJugador4 = new JLabel("Jugador4:");
    private JTextField txtNombreJ4 = new JTextField("Nombre4", 20);
    private JComboBox<String> choiceColorJ4 = new JComboBox<>();

    public JButton btnAceptar = new JButton("Jugar");
    public JButton btnAtras = new JButton("<--");

 
    public InicioPartida(int numJugadores)
    {
    	this.numJugadores = numJugadores;
        setTitle("Selección de jugadores (" + numJugadores + " jugadores)");
        setSize(500, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo"};
        for (String color : colores)
        {
            choiceColorJ1.addItem(color);
            choiceColorJ2.addItem(color);
            choiceColorJ3.addItem(color);
            choiceColorJ4.addItem(color);
        }
        choiceColorJ1.setSelectedIndex(0);
        choiceColorJ2.setSelectedIndex(1);
        choiceColorJ3.setSelectedIndex(2);
        choiceColorJ4.setSelectedIndex(3);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        // Botón Atras y vacío para alinear
        c.gridx = 0; c.gridy = 0;
        panel.add(btnAtras, c);
        c.gridx = 1;
        panel.add(new JLabel(""), c);
        
        // Jugador 1
        c.gridy = 1; c.gridx = 0;
        panel.add(lblJugador1, c);
        c.gridx = 1;
        panel.add(txtNombreJ1, c);
        c.gridx = 2;
        panel.add(choiceColorJ1, c);

        // Jugador 2
        c.gridy = 2; c.gridx = 0;
        panel.add(lblJugador2, c);
        c.gridx = 1;
        panel.add(txtNombreJ2, c);
        c.gridx = 2;
        panel.add(choiceColorJ2, c);
        if (numJugadores ==3) {
        // Jugador 3
        c.gridy = 3; c.gridx = 0;
        panel.add(lblJugador3, c);
        c.gridx = 1;
        panel.add(txtNombreJ3, c);
        c.gridx = 2;
        panel.add(choiceColorJ3, c);
        }
        if (numJugadores ==4) {
        // Jugador 3
        c.gridy = 3; c.gridx = 0;
        panel.add(lblJugador3, c);
        c.gridx = 1;
        panel.add(txtNombreJ3, c);
        c.gridx = 2;
        panel.add(choiceColorJ3, c);
        // Jugador 4
        c.gridy = 4; c.gridx = 0;
        panel.add(lblJugador4, c);
        c.gridx = 1;
        panel.add(txtNombreJ4, c);
        c.gridx = 2;
        panel.add(choiceColorJ4, c);
        }
        // Botón Jugar
        c.gridy = 5; c.gridx = 1;
        panel.add(btnAceptar, c);

        setContentPane(panel);
        setVisible(false);
    }

    public int getNumJugadores() { return numJugadores; }
    public String getNombreJugador1() { return txtNombreJ1.getText(); }
    public String getNombreJugador2() { return txtNombreJ2.getText(); }
    public String getNombreJugador3() { return txtNombreJ3.getText(); }
    public String getNombreJugador4() { return txtNombreJ4.getText(); }
    public String getColorJugador1() { return (String) choiceColorJ1.getSelectedItem(); }
    public String getColorJugador2() { return (String) choiceColorJ2.getSelectedItem(); }
    public String getColorJugador3() { return (String) choiceColorJ3.getSelectedItem(); }
    public String getColorJugador4() { return (String) choiceColorJ4.getSelectedItem(); } 
}
