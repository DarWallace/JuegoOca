package es.studium.es;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JFrame
{
    private static final long serialVersionUID = 1L;
    private Image tablero;
    private int numJugadores;
    private String jugador1, jugador2, jugador3, jugador4, color1, color2, color3, color4;
    private int turnoJugador = 1;
    private int tirada = 0;
    private int contadorTiradas1 = 0;
    private int contadorTiradas2 = 0;
    private int contadorTiradas3 = 0;
    private int contadorTiradas4 = 0;
    private JLabel lblJugador1 = new JLabel("Jugador 1:", JLabel.CENTER);
    private JLabel lblJugador2 = new JLabel("Jugador 2:", JLabel.CENTER);
    private JLabel lblJugador3 = new JLabel("Jugador 3:", JLabel.CENTER);
    private JLabel lblJugador4 = new JLabel("Jugador 4:", JLabel.CENTER);

    private JLabel lblTirada1 = new JLabel(contadorTiradas1 + "", JLabel.CENTER);
    private JLabel lblTirada2 = new JLabel(contadorTiradas2 + "", JLabel.CENTER);
    private JLabel lblTirada3 = new JLabel(contadorTiradas3 + "", JLabel.CENTER);
    private JLabel lblTirada4 = new JLabel(contadorTiradas4 + "", JLabel.CENTER);

    private JLabel lblCasilla1 = new JLabel("0", JLabel.CENTER);
    private JLabel lblCasilla2 = new JLabel("0", JLabel.CENTER);
    private JLabel lblCasilla3 = new JLabel("0", JLabel.CENTER);
    private JLabel lblCasilla4 = new JLabel("0", JLabel.CENTER);

    private JLabel lblColor1 = new JLabel();
    private JLabel lblColor2 = new JLabel();
    private JLabel lblColor3 = new JLabel();
    private JLabel lblColor4 = new JLabel();

    private JButton btnTirarDados = new JButton("Tirar los dados");
    private JButton btnRehacer = new JButton("Rehacer");

    // Constructor
    public Tablero(int n, String j1, String c1, String j2, String c2, String j3,
            String c3, String j4, String c4)
    {
        numJugadores = n;
        jugador1 = j1;
        color1 = c1;
        jugador2 = j2;
        color2 = c2;
        jugador3 = j3;
        color3 = c3;
        jugador4 = j4;
        color4 = c4;
        // Cargar la imagen desde el archivo
        tablero = Toolkit.getDefaultToolkit().getImage("img\\tablero.png");

        // Configuración de la ventana
        setTitle("Juego de la Oca");
        setSize(1720, 808); // Tamaño de la ventana actualizado
        setLocationRelativeTo(null); // Centrar la ventana
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel para dibujar el tablero
        JPanel panel = new JPanel()
        {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g); // Llamar al método de la superclase para asegurar un buen repintado

                // Obtener el tamaño del panel y ajustar la imagen
                int width = getWidth();
                int height = getHeight();

                // Ajustar la imagen al tamaño del panel
                g.drawImage(tablero, 0, 0, width, height, this);
            }
        };

        // Layout para los componentes adicionales
        panel.setLayout(null); // Para posicionar elementos de manera absoluta

        // Tabla de jugadores en la parte derecha
        JPanel tablePanel = new JPanel(new GridLayout(1 + numJugadores, 4, 1, 1));
        tablePanel.setBounds(1340, 100, 250, 250); // Ubicación de la tabla
        tablePanel.setBackground(new Color(255, 255, 204)); // Color de fondo de la tabla

        // Ajustar las fichas de color
        lblColor1.setOpaque(true);
        if(c1.equals("Rojo")) {
            lblColor1.setBackground(Color.RED);
        }else if(c1.equals("Azul")) {
            lblColor1.setBackground(Color.BLUE);
        }else if(c1.equals("Verde")) {
            lblColor1.setBackground(Color.GREEN);
        }else if(c1.equals("Amarillo")) {
            lblColor1.setBackground(Color.YELLOW);
        }
        lblColor1.setPreferredSize(new Dimension(2, 2));  // Tamaño de la ficha

        lblColor2.setOpaque(true);
        if(c2.equals("Rojo")) {
            lblColor2.setBackground(Color.RED);
        }else if(c2.equals("Azul")) {
            lblColor2.setBackground(Color.BLUE);
        }else if(c2.equals("Verde")) {
            lblColor2.setBackground(Color.GREEN);
        }else if(c2.equals("Amarillo")) {
            lblColor2.setBackground(Color.YELLOW);
        }
        lblColor2.setPreferredSize(new Dimension(2, 2));  // Tamaño de la ficha

        if (numJugadores >= 3)
        {
            lblColor3.setOpaque(true);
            if(c3.equals("Rojo")) {
                lblColor3.setBackground(Color.RED);
            }else if(c3.equals("Azul")) {
                lblColor3.setBackground(Color.BLUE);
            }else if(c3.equals("Verde")) {
                lblColor3.setBackground(Color.GREEN);
            }else if(c3.equals("Amarillo")) {
                lblColor3.setBackground(Color.YELLOW);
            }
            lblColor3.setPreferredSize(new Dimension(2, 2));  // Tamaño de la ficha
        }

        if (numJugadores == 4)
        {           
            lblColor4.setOpaque(true);
            if(c4.equals("Rojo")) {
                lblColor4.setBackground(Color.RED);
            }else if(c4.equals("Azul")) {
                lblColor4.setBackground(Color.BLUE);
            }else if(c4.equals("Verde")) {
                lblColor4.setBackground(Color.GREEN);
            }else if(c4.equals("Amarillo")) {
                lblColor4.setBackground(Color.YELLOW);
            }
            lblColor4.setPreferredSize(new Dimension(2, 2));  // Tamaño de la ficha
        }
        
        tablePanel.add(new JLabel("Nombre", JLabel.CENTER));
        tablePanel.add(new JLabel("Tiradas", JLabel.CENTER));
        tablePanel.add(new JLabel("Casilla", JLabel.CENTER));
        tablePanel.add(new JLabel("Ficha", JLabel.CENTER));

        // Agregar labels para cada jugador
        tablePanel.add(new JLabel(jugador1));
        tablePanel.add(lblTirada1);
        tablePanel.add(lblCasilla1);
        tablePanel.add(lblColor1); // Ficha junto al jugador

        System.out.println(jugador2);
        tablePanel.add(new JLabel(jugador2));
        tablePanel.add(lblTirada2);
        tablePanel.add(lblCasilla2);
        tablePanel.add(lblColor2); // Ficha junto al jugador

        if (numJugadores >= 3)
        {
        	System.out.println(jugador3);
            tablePanel.add(new JLabel(jugador3));
            tablePanel.add(lblTirada3);
            tablePanel.add(lblCasilla3);
            tablePanel.add(lblColor3); // Ficha junto al jugador
        }
        if (numJugadores == 4)
        {
            tablePanel.add(new JLabel(jugador4));
            tablePanel.add(lblTirada4);
            tablePanel.add(lblCasilla4);
            tablePanel.add(lblColor4); // Ficha junto al jugador
        }

        // Agregar los botones debajo de la tabla (en la parte derecha)
        btnTirarDados.setBounds(1390, 480, 200, 50);
        panel.add(tablePanel);
        panel.add(btnTirarDados);

        // Agregar el botón "Rehacer" debajo de la imagen del tablero (debajo de la Oca)
        btnRehacer.setBounds(105, 600, 200, 50); // Colocarlo al centro, justo abajo
        panel.add(btnRehacer);

        // Agregar el panel principal al JFrame
        add(panel);
    }
}
