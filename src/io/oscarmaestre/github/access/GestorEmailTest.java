package io.oscarmaestre.github.access;

import static org.junit.Assert.*;

import org.junit.Test;

public class GestorEmailTest {

	@Test
	public void test() {
		GestorEmail.enviar_email(
			"pepe@n.com",
			"clave",
			"smtp.gmail.com",
			"otro@gmail.com",
			"Asunto saludo",
			"texto:Probando envio",
			"587");
	}

}
