package es.studium.es;

import java.awt.*;
import java.sql.*;

public class VistaRanking extends Frame {
    private static final long serialVersionUID = 1L;
    TextArea txaRanking = new TextArea(20, 10);
    Button btnVolver = new Button("Volver");
    ModeloB modelob = new ModeloB();
    Connection connection = null;

    public VistaRanking() {
        setTitle(" Ranking de jugadores de la oca");
        setBackground(Color.GREEN);
        setLayout(new BorderLayout());
         connection = modelob.conectarB();

		txaRanking.append(modelob.consultarJugadores(connection));

		modelob.desconectarB(connection);

		add(txaRanking);

		txaRanking.setFont(new Font("Monospaced", Font.PLAIN, 12)); 
  
        add(txaRanking, BorderLayout.CENTER);
        txaRanking.setFont(new Font ("monospaced", Font.PLAIN,12) ); // PARA QUE QUEDA ESPACIADO Y MAS BONITO
        add(btnVolver, BorderLayout.SOUTH);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }
    
}
