package it.uniroma3.diadia.test.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbrica;
	private IO io;
	private Comando expected;
	
	@Before
	public void setUp() throws Exception {
		io = new IOConsole();
		fabbrica = new FabbricaDiComandiFisarmonica(io);
	}

	@After
	public void tearDown() throws Exception {
	}
}
