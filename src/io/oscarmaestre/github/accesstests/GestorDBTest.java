package io.oscarmaestre.github.accesstests;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.junit.Test;

import io.oscarmaestre.github.access.GestorDB;

public class GestorDBTest {

	@Test
	public void testCreacion() throws ClassNotFoundException, SQLException {
		GestorDB gestor=new GestorDB("Neptuno.mdb");
	}
	
	@Test
	public void testEmpleados() throws ClassNotFoundException, SQLException {
		GestorDB gestor=new GestorDB("Neptuno.mdb");
		ResultSet resultados=gestor.ejecutarConsulta(
				"Select apellidos, nombre, fechanacimiento from empleados");
		Calendar gestorFechas=Calendar.getInstance();
		//Para sacar la fecha de hoy basta con poner el objeto
		//a las 0 horas, y automáticamente se rellenan el
		//resto de campos a la fecha de hoy
		gestorFechas.set(Calendar.HOUR_OF_DAY, 0);
		
		int mesDeHoy=gestorFechas.get(Calendar.MONTH);
		
		int diaDeHoy=gestorFechas.get(Calendar.DAY_OF_MONTH);
		//Ojo, los meses van en valores de 0(Enero) a 11 (Diciembre)
		//por eso sumamos 1
			
		System.out.println("Hoy es (DD/MM):"+diaDeHoy+"/"+(mesDeHoy+1));
		while (resultados.next()){
			String apellidos=resultados.getString("apellidos");
			Date fechaNacimiento=resultados.getDate("fechanacimiento");
			int numeroDeMes=fechaNacimiento.getMonth();
			int numeroDeDia=fechaNacimiento.getDate();
			
			if ( (numeroDeMes==mesDeHoy) && (numeroDeDia==diaDeHoy) ){
				System.out.println(apellidos);
			}
			
		}
		
	}
	

}
