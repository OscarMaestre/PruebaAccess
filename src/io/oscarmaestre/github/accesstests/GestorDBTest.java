package io.oscarmaestre.github.accesstests;

import static org.junit.Assert.*;

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
		//Ojo, los meses se devuelve en valores de 0(Enero) a 11 (Diciembre)
		//por eso sumamos 1
		mesDeHoy=mesDeHoy+1;
		int diaDeHoy=gestorFechas.get(Calendar.DAY_OF_MONTH);
		System.out.println("Hoy es (DD/MM):"+diaDeHoy+"/"+mesDeHoy);
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
