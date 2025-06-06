package es.studium.es;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;



public class ModeloB
{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/juegooca";
	String login = "admin";
	String password = "Studium2025#";
	String sentencia = "";

	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;

	public Connection conectarB()
	{
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
		} catch (ClassNotFoundException e)
		{
			return null;
		} catch (SQLException e)
		{
			return null;
		}
		return connection;
	}

	public void desconectarB(Connection conexion)
	{
		if (conexion != null)
		{
			try
			{
				conexion.close();
			} catch (SQLException e)
			{
			}
		}
	}

	public boolean altaJugador(Connection conexion, String nombre, int tiradas)
	{
		boolean altaCorrecta = false;
		
			sentencia = "INSERT INTO ranking VALUES (null,'" + nombre + "',' CURDATE() ',"+tiradas+");";
			try
			{
				statement =  conexion.createStatement();
				guardarLog(sentencia);
				statement.executeUpdate(sentencia);
				altaCorrecta = true;

			} catch (SQLException e)
			{
				altaCorrecta = false;
			}
		
		return altaCorrecta;
	}
	
	public String consultarJugadores(Connection conexion)
	{int posicion=0;
		{
			String contenidoTextarea = String.format("%-8s - %-18s - %-10s - %-4s\n","Posición","Nombre","Fecha","Tiradas");
			sentencia = "SELECT nombreJugador,date_format(fecha, '%d/%m/%Y') 'fechas',tiradas FROM ranking order by tiradas;";
			try
			{
				statement = conexion.createStatement();
				guardarLog(sentencia);
				rs = statement.executeQuery(sentencia);
				while (rs.next())
				{
					 posicion++;
					contenidoTextarea = contenidoTextarea + String.format("%-8s - %-18s - %-10s - %-4s\n",
							posicion,
							rs.getString("nombreJugador"),
							rs.getString("fechas"),
							rs.getString("tiradas"));

				}

			} catch (SQLException sqlex)

			{

				System.out.println("Error en SQL");
			}
			return contenidoTextarea;
		}
	}
	
	
	
	public void guardarLog( String mensaje) {
		//[01/04/2025][11:50:40][mensaje]
		Date ahora = new Date();
		SimpleDateFormat formateador= new SimpleDateFormat("[dd/MM/yyyy][HH:mm:ss.S]");

		try
		{
			// Destino de los datos
			FileWriter fw = new FileWriter("log.txt", true);
			// Buffer de escritura
			BufferedWriter bw = new BufferedWriter(fw);
			// Objeto para la escritura
			PrintWriter salida = new PrintWriter(bw);
			// Guardamos la primera línea
			salida.println(formateador.format(ahora)+" ["+mensaje+"]");
			// Cerrar el objeto salida, el objeto bw y el fw
			salida.close();
			bw.close();
			fw.close();
			System.out.println("¡Archivo creado correctamente!");
		} catch (IOException i)
		{
			System.out.println("Se produjo un error de Archivo");
		}}
}
