package es.studium.es;

import javax.swing.*;
import java.awt.*;

public class InicioPartida extends JFrame
{
    private static final long serialVersionUID = 1L;
    private int numJugadores = 0;
    private Image imagenFondo;

    // Componentes de jugador
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

    // Panel principal personalizado para fondo
    private JPanel panelFondo;

    public InicioPartida(int numJugadores)
    {
        this.numJugadores = numJugadores;
        setTitle("Selección de jugadores (" + numJugadores + " jugadores)");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cargar imagen de fondo
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/1.jpg"));
        imagenFondo = icon.getImage();

        // Panel principal con fondo
        panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagenFondo != null) {
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panelFondo.setLayout(new GridBagLayout());
        panelFondo.setOpaque(false);

        // Inicializar colores
        String[] colores = {"Rojo", "Amarillo", "Azul", "Verde"};
        for (String color : colores) {
            choiceColorJ1.addItem(color);
            choiceColorJ2.addItem(color);
            choiceColorJ3.addItem(color);
            choiceColorJ4.addItem(color);
        }
        choiceColorJ1.setSelectedItem("Rojo");
        choiceColorJ2.setSelectedItem("Azul");
        choiceColorJ3.setSelectedItem("Verde");
        choiceColorJ4.setSelectedItem("Amarillo");

        // Paneles de jugador
        JPanel pnlJugador1 = crearPanelJugador(lblJugador1, txtNombreJ1, choiceColorJ1);
        JPanel pnlJugador2 = crearPanelJugador(lblJugador2, txtNombreJ2, choiceColorJ2);
        JPanel pnlJugador3 = crearPanelJugador(lblJugador3, txtNombreJ3, choiceColorJ3);
        JPanel pnlJugador4 = crearPanelJugador(lblJugador4, txtNombreJ4, choiceColorJ4);

        // Layout con GridBagConstraints
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);

        // Primera fila: botón atrás
        c.gridx = 0; c.gridy = 0; c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        panelFondo.add(btnAtras, c);

        // Espacio vacío para alinear
        c.gridx = 1; c.anchor = GridBagConstraints.EAST;
        panelFondo.add(Box.createGlue(), c);

        // Fila de jugadores según cantidad
        c.anchor = GridBagConstraints.CENTER;
        c.gridwidth = 1;
        if(numJugadores >= 2) {
            c.gridy = 1;
            c.gridx = 0;
            panelFondo.add(pnlJugador1, c);
            c.gridx = 1;
            panelFondo.add(pnlJugador2, c);
        }
        if(numJugadores >= 3) {
            c.gridy = 2;
            c.gridx = 0;
            panelFondo.add(pnlJugador3, c);
            if(numJugadores == 4) {
                c.gridx = 1;
                panelFondo.add(pnlJugador4, c);
            }
        }

        // Última fila: botón jugar
        c.gridy = (numJugadores == 2) ? 2 : 3;
        c.gridx = 0;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.SOUTHEAST;
        panelFondo.add(btnAceptar, c);

        setContentPane(panelFondo);
        setLocationRelativeTo(null); // Centrar ventana
        setVisible(true);
    }

    // Método para crear panel de cada jugador
    private JPanel crearPanelJugador(JLabel lbl, JTextField txt, JComboBox<String> color) {
        JPanel p = new JPanel();
        p.setOpaque(false);
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        p.add(lbl);
        p.add(txt);
        p.add(color);
        return p;
    }

    // Métodos getters
    public int getNumJugadores() { return numJugadores; }
    public String getNombreJugador1() { return txtNombreJ1.getText(); }
    public String getNombreJugador2() { return txtNombreJ2.getText(); }
    public String getNombreJugador3() { return txtNombreJ3.getText(); }
    public String getNombreJugador4() { return txtNombreJ4.getText(); }
    public String getColorJugador1() { return (String) choiceColorJ1.getSelectedItem(); }
    public String getColorJugador2() { return (String) choiceColorJ2.getSelectedItem(); }
    public String getColorJugador3() { return (String) choiceColorJ3.getSelectedItem(); }
    public String getColorJugador4() { return (String) choiceColorJ4.getSelectedItem(); }

    public static void main(String[] args)
    {
        // Ejemplo con 4 jugadores
        SwingUtilities.invokeLater(() -> new InicioPartida(4));
    }
}