package es.studium.es;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.sql.Connection;

import javax.swing.JFrame;

public class VistaRanking extends JFrame {
    private static final long serialVersionUID = 1L;
    TextArea txaRanking = new TextArea("",20, 10, TextArea.SCROLLBARS_NONE);
    Button btnVolver = new Button("Volver");
    ModeloB modelob = new ModeloB();
    Connection connection = null;

    public VistaRanking() {
    	setUndecorated(true);
    	
        setTitle(" Ranking de jugadores de la oca");
        txaRanking.setEditable(false);
        txaRanking.setFocusable(false);
        setBackground(Color.GREEN);
        setLayout(new BorderLayout());
         connection = modelob.conectarB();

		txaRanking.append(modelob.consultarJugadores(connection));

		modelob.desconectarB(connection);

		add(txaRanking);

		txaRanking.setFont(new Font("Monospaced", Font.PLAIN, 14)); 
  
        add(txaRanking, BorderLayout.CENTER);
       
        add(btnVolver, BorderLayout.SOUTH);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        
    }
    

    
    
}