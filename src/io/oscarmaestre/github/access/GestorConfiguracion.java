package io.oscarmaestre.github.access;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GestorConfiguracion {
	private static GestorConfiguracion gestor=null;
	private Properties propiedades;
	private GestorConfiguracion(String rutaFichero){
		try {
			FileInputStream fichero=
				new FileInputStream(rutaFichero);
			propiedades=new Properties();
			propiedades.load(fichero);
		} catch (IOException e) {
			System.out.println(
				"Este programa necesita un fichero"
				+
				"llamado configuracion.properties"
				+
				" donde se almacenan los datos de"
				+
				" configuración, pero el fichero "
				+
				"no está, está borrado, o no hay permisos para leerlo. Sin "
				+
				"ese fichero no se puede hacer nada."
			);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getEmailRemitente(){
		return propiedades.getProperty(
				"email_remitente_felicitador");
	}
	
	
	public String getClaveRemitente(){
		return propiedades.getProperty(
				"clave_email_remitente_felicitador");
	}
	
	public String getServidorSMTPRemitente(){
		return propiedades.getProperty(
				"servidor_smtp_remitente");
	}
	
	public String getPuertoTCPSMTPRemitente(){
		return propiedades.getProperty(
				"puerto_servidor_smtp");
	}
	
	public static GestorConfiguracion getInstancia(){
		if (gestor==null){
			gestor=new GestorConfiguracion(
				"configuracion.properties"	);
			return gestor;
		}
		return gestor;
	}
	
}
