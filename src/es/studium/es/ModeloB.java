package es.studium.es;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloB
{
		String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/empresamaquina";
	String login = "admin";
	String password = "Studium2025#";
	String sentencia = "";

	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;

	public Connection conectar()
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

	public void desconectar(Connection conexion)
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

}
