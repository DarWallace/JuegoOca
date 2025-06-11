package es.studium.es;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
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

    // VARIABLES DE POSICIÓN DE FICHAS EN EL TABLERO
    private int posFicha1 = 0;
    private int posFicha2 = 0;
    private int posFicha3 = 0;
    private int posFicha4 = 0;

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

        // Crear un panel para dibujar el tablero y las fichas
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

                // DIBUJAR FICHAS DE LOS JUGADORES
                if (numJugadores >= 1) {
                    Point p1 = casillaACoordenadas(posFicha1);
                    g.setColor(getColorFromString(color1));
                    g.fillOval(p1.x, p1.y, 35, 35);
                }
                if (numJugadores >= 2) {
                    Point p2 = casillaACoordenadas(posFicha2);
                    g.setColor(getColorFromString(color2));
                    g.fillOval(p2.x, p2.y, 30, 30);
                }
                if (numJugadores >= 3) {
                    Point p3 = casillaACoordenadas(posFicha3);
                    g.setColor(getColorFromString(color3));
                    g.fillOval(p3.x, p3.y, 25, 25);
                }
                if (numJugadores == 4) {
                    Point p4 = casillaACoordenadas(posFicha4);
                    g.setColor(getColorFromString(color4));
                    g.fillOval(p4.x, p4.y, 20, 20);
                }
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
        lblColor1.setBackground(getColorFromString(c1));
        lblColor1.setPreferredSize(new Dimension(20, 20));  // Tamaño ficha en tabla

        lblColor2.setOpaque(true);
        lblColor2.setBackground(getColorFromString(c2));
        lblColor2.setPreferredSize(new Dimension(20, 20));

        if (numJugadores >= 3)
        {
            lblColor3.setOpaque(true);
            lblColor3.setBackground(getColorFromString(c3));
            lblColor3.setPreferredSize(new Dimension(20, 20));
        }
        if (numJugadores == 4)
        {
            lblColor4.setOpaque(true);
            lblColor4.setBackground(getColorFromString(c4));
            lblColor4.setPreferredSize(new Dimension(20, 20));
        }

        tablePanel.add(new JLabel("Nombre", JLabel.CENTER));
        tablePanel.add(new JLabel("Tiradas", JLabel.CENTER));
        tablePanel.add(new JLabel("Casilla", JLabel.CENTER));
        tablePanel.add(new JLabel("Ficha", JLabel.CENTER));
        tablePanel.add(new JLabel(jugador1));
        tablePanel.add(lblTirada1);
        tablePanel.add(lblCasilla1);
        tablePanel.add(lblColor1);

        tablePanel.add(new JLabel(jugador2));
        tablePanel.add(lblTirada2);
        tablePanel.add(lblCasilla2);
        tablePanel.add(lblColor2);

        if (numJugadores >= 3)
        {
            tablePanel.add(new JLabel(jugador3));
            tablePanel.add(lblTirada3);
            tablePanel.add(lblCasilla3);
            tablePanel.add(lblColor3);
        }
        if (numJugadores == 4)
        {
            tablePanel.add(new JLabel(jugador4));
            tablePanel.add(lblTirada4);
            tablePanel.add(lblCasilla4);
            tablePanel.add(lblColor4);
        }

        // Agregar los botones debajo de la tabla (en la parte derecha)
        btnTirarDados.setBounds(1390, 480, 200, 50);
        panel.add(tablePanel);
        panel.add(btnTirarDados);

        // Agregar el botón "Rehacer" debajo de la imagen del tablero
        btnRehacer.setBounds(105, 600, 200, 50);
        panel.add(btnRehacer);

        // Agregar el panel principal al JFrame
        add(panel);
    }

    // MÉTODO AUXILIAR: Convierte nombre de color a Color
    private Color getColorFromString(String colorName) {
        switch (colorName) {
            case "Rojo": return Color.RED;
            case "Azul": return Color.BLUE;
            case "Verde": return Color.GREEN;
            case "Amarillo": return Color.YELLOW;
            default: return Color.BLACK;
        }
    }

    // MÉTODO AUXILIAR: Convierte número de casilla a coordenadas (ajusta según tu tablero)
    private Point casillaACoordenadas(int casilla) {
        // EJEMPLO: casillas seguidas en horizontal, AJUSTA según tu imagen real
        int x = 70 + (casilla % 10) * 60; // 60 píxeles entre casillas
        int y = 600 - (casilla / 10) * 60; // Cambia fila cada 10 casillas
        return new Point(x, y);
    }

    // MÉTODOS PARA ACTUALIZAR POSICIÓN DE FICHAS DESDE EL CONTROLADOR

    public void setPosFicha(int jugador, int nuevaPos) {
        switch(jugador) {
            case 1: posFicha1 = nuevaPos; break;
            case 2: posFicha2 = nuevaPos; break;
            case 3: posFicha3 = nuevaPos; break;
            case 4: posFicha4 = nuevaPos; break;
        }
        repaint();
    }

    // Puedes añadir getters si los necesitas
    public int getPosFicha(int jugador) {
        switch(jugador) {
            case 1: return posFicha1;
            case 2: return posFicha2;
            case 3: return posFicha3;
            case 4: return posFicha4;
            default: return 0;
        }
    }
}