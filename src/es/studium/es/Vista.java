package es.studium.es;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista
{
	 // Crear la ventana principal
    JFrame frame = new JFrame("El Juego de la Oca");
    JButton btnPartidaNueva = new JButton("Juego nuevo");
    JButton btnAyuda = new JButton("Ayuda");
    JButton btnRanking = new JButton("Ranking");

    // Obtener la imagen de fondo usando Toolkit
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image backgroundImage = toolkit.getImage("img\\Copia de fondo.png");

    public Vista() {
    	frame.setSize(800, 600);  // Tamaño de la ventana
    	frame.setLocationRelativeTo(null);
        // Crear un panel para dibujar la imagen de fondo
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
        frame.setContentPane(panel);
        frame.setLayout(null);  // Usar un layout absoluto para un control más preciso

        // Crear los botonea

        // Personalizar los botones
        btnPartidaNueva.setPreferredSize(new Dimension(200, 50));
        btnAyuda.setPreferredSize(new Dimension(200, 50));
        btnRanking.setPreferredSize(new Dimension(200, 50));

        // Posicionar el botón "Juego nuevo" al centro
        btnPartidaNueva.setBounds(300, 150, 200, 50);

        // Posicionar los botones "Ayuda" y "Ranking" en los lados inferiores
        btnAyuda.setBounds(50, 450, 200, 50);  // A la izquierda
        btnRanking.setBounds(550, 450, 200, 50);  // A la derecha

        // Añadir los botones al frame
        frame.add(btnPartidaNueva);
        frame.add(btnAyuda);
        frame.add(btnRanking);

        // Mostrar la ventana
        frame.setVisible(true);	
    } 
}
