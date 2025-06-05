package es.studium.es;


import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame
{
    private static final long serialVersionUID = 1L;

    public JButton btnPartidaNueva = new JButton("Partida Nueva");
    public JButton btnRanking = new JButton("Ranking");
    // Puedes añadir más botones o componentes según necesites

    public Vista()
    {
        setTitle("Menú Principal");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); // Centra la ventana

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE); // Puedes cambiar el color

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Botón "Partida Nueva"
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(btnPartidaNueva, gbc);

        // Botón "Ranking"
        gbc.gridy = 1;
        panel.add(btnRanking, gbc);

        setContentPane(panel);
        setVisible(true);
    }

    
}