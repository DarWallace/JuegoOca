package es.studium.es;

public class Main
{
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Vista vista = new Vista();
            ModeloT modelo = new ModeloT(); // Asegúrate de tener esta clase aunque esté vacía
            new Controlador(vista, modelo);
        });
    }
}