package io.oscarmaestre.github.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorDB {
	Connection conexion;
	public GestorDB (String rutaArchivoAccess) throws ClassNotFoundException, SQLException{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		this.conexion=DriverManager.getConnection(
				"jdbc:ucanaccess://"+rutaArchivoAccess);
	}
	public ResultSet ejecutarConsulta(String select) throws SQLException{
		Statement sentenciaSQL=this.conexion.createStatement();
		ResultSet resultados=sentenciaSQL.executeQuery(select);
		return resultados;
	}
	
	public ResultSet getCumplenHoy() throws SQLException{
		String sql="select * from gaseosa "+
			"where month(fechanacimiento)=month(date()) "+
			" and day(fechanacimiento)=day(date());";
		ResultSet resultados;
		resultados=ejecutarConsulta(sql);
		return resultados;
	}
}
