package io.oscarmaestre.github.access;

import static org.junit.Assert.*;

import org.junit.Test;

public class GestorConfiguracionTest {

	@Test
	public void test() {
		GestorConfiguracion gestor;
		gestor=GestorConfiguracion.getInstancia();
		String email;
		email=gestor.getEmailRemitente();
		
		String clave=gestor.getClaveRemitente();
		String servidor=gestor.getServidorSMTPRemitente();
		String puerto=gestor.getPuertoTCPSMTPRemitente();
		System.out.println("Email:"+email+
				" clave:"+clave+
				" servidor:"+servidor +
				" puerto:"+puerto);
	}

}
