package es.studium.es;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ModeloB {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/juegooca";
	String login = "admin";
	String password = "Studium2025#";
	String sentencia = "";
	Random rnd = new Random();
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	// Añadir este método en la clase ModeloB

	public Connection conectarB() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
		} catch (ClassNotFoundException e) {
			return null;
		} catch (SQLException e) {
			return null;
		}
		return connection;
	}

	public void desconectarB(Connection conexion) {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {
			}
		}
	}

	public boolean altaJugador(Connection conexion, String nombre, int tiradas) {
		boolean altaCorrecta = false;

		sentencia = "INSERT INTO ranking VALUES (null,'" + nombre + "', CURDATE() ," + tiradas + ");";
		try {
			statement = conexion.createStatement();
			guardarLog(sentencia);
			statement.executeUpdate(sentencia);
			altaCorrecta = true;

		} catch (SQLException e) {
			altaCorrecta = false;
			System.out.println(e);
			System.out.println("error en la sentencia");
		}

		return altaCorrecta;
	}

	public String consultarJugadores(Connection conexion) {
		int posicion = 0;
		{
			String contenidoTextarea = String.format("%-8s - %-10s - %-15s - %-4s\n", "Posición", "Nombre", "Fecha",
					"Tiradas");
			sentencia = "SELECT nombreJugador,date_format(fecha, '%d/%m/%Y') 'fechas',tiradas FROM ranking order by tiradas;";
			try {
				statement = conexion.createStatement();
				guardarLog(sentencia);
				rs = statement.executeQuery(sentencia);
				while (rs.next()) {
					posicion++;
					contenidoTextarea = contenidoTextarea + String.format("%-8s - %-10s - %-15s - %-4s\n", posicion,
							rs.getString("nombreJugador"), rs.getString("fechas"), rs.getString("tiradas"));

				}

			} catch (SQLException sqlex)

			{

				System.out.println("Error en SQL");
			}
			return contenidoTextarea;
		}
	}

	public int tirada() {
		int t;
		t = rnd.nextInt(6) + 1; // 0-5
		return (t);
	}

	public boolean victoriaFallida(int contadorCasillas) {
		if (contadorCasillas > 63) {
			return true;
		}
		return false;
	}

	public boolean comprobarVictoria(int contadorCasillas) {
		if (contadorCasillas == 63) {
			return true;
		}
		return false;
	}

	public boolean verificarDuplicados(String nombre1, String nombre2, String nombre3, String nombre4, String color1,
			String color2, String color3, String color4) {
		String[] nombres = { nombre1, nombre2, nombre3, nombre4 };
		String[] colores = { color1, color2, color3, color4 };

		for (int i = 0; i < nombres.length; i++) {
			for (int j = i + 1; j < nombres.length; j++) {
				if (nombres[i].equals(nombres[j]) && !nombres[i].isEmpty()) {
					return false;
				}
			}
		}

		for (int i = 0; i < colores.length; i++) {
			for (int j = i + 1; j < colores.length; j++) {
				if (colores[i].equals(colores[j]) && !colores[i].isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}

	public void guardarLog(String mensaje) {
		// [01/04/2025][11:50:40][mensaje]
		Date ahora = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("[dd/MM/yyyy][HH:mm:ss.S]");

		try {
			// Destino de los datos
			FileWriter fw = new FileWriter("log.txt", true);
			// Buffer de escritura
			BufferedWriter bw = new BufferedWriter(fw);
			// Objeto para la escritura
			PrintWriter salida = new PrintWriter(bw);
			// Guardamos la primera línea
			salida.println(formateador.format(ahora) + " [" + mensaje + "]");
			// Cerrar el objeto salida, el objeto bw y el fw
			salida.close();
			bw.close();
			fw.close();
			System.out.println("¡Archivo creado correctamente!");
		} catch (IOException i) {
			System.out.println("Se produjo un error de Archivo");
		}
	}

	public static void ayuda() {
		try {
			ProcessBuilder pb = new ProcessBuilder("hh.exe", "AyudaJuego.chm");
			pb.start();
			System.out.println("Abriendo el archivo CHM...");
		} catch (IOException e) {
			System.err.println("Error al intentar abrir el archivo CHM: " + e.getMessage());
		}
	}
}
