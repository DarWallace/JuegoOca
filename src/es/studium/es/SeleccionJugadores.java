package es.studium.es;

import javax.swing.*;
import java.awt.*;

public class SeleccionJugadores extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btn2jugadores = new JButton("2 jugadores");
    public JButton btn3jugadores = new JButton("3 jugadores");
    public JButton btn4jugadores = new JButton("4 jugadores");
    Toolkit herramientas = Toolkit.getDefaultToolkit();
    Image backgroundImage = herramientas.getImage("img\\Copia de fondo.png");
    JButton btnVolver = new JButton("<--");

    // Crear un panel para dibujar la imagen de fondo
    

    public SeleccionJugadores()
    {
    	
        setTitle("Menú Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel() {
    		private static final long serialVersionUID = 1L;

    		@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar la imagen escalada al tamaño de la ventana
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Establecer el panel como contenido de la ventana
        setContentPane(panel);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(btn2jugadores, gbc);

        gbc.gridy = 1;
        panel.add(btn3jugadores, gbc);
        
        gbc.gridy = 2;
        panel.add(btn4jugadores, gbc);
        
        btnVolver.setBounds(10, 10, 100, 30);
        getLayeredPane().add(btnVolver, JLayeredPane.PALETTE_LAYER);
        
        setContentPane(panel);
        setVisible(false);
    }
}