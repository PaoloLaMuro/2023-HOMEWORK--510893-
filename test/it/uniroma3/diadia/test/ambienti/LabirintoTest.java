package it.uniroma3.diadia.test.ambienti;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class LabirintoTest {
	
	private Labirinto labirinto;
	private static final String STANZA_INIZIALE = "atrio";

	@BeforeEach
	void setUp(){
		this.labirinto = new Labirinto();
	}
	@Test
	void testGetStanzaInizialeatrio() {
		String s = "atrio";
		assertTrue((this.labirinto.getStanzaIniziale().getNome().equals(s)));
	}
	@Test
	void testGetStanzaInizialeNotNull() {
		assertNotNull(this.labirinto.getStanzaIniziale());
	}
	@Test
	void testGetStanzaVincenteNotNull(){
		assertNotNull(this.labirinto.getStanzaVincente());
	}
	

}
