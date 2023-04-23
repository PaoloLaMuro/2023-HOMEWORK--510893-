package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.Giocatore;

class PartitaTest {
	
	private Partita partita;

	@BeforeEach
	public void setUp() throws Exception {
		this.partita = new Partita();	
		}
	//1.getStanzaVincente(I)
	@Test
	void testGetStanzaVincenteNotNull() {
		assertNotNull(this.partita.getStanzaVincente());
	}
	//2.getStanzaVincente(II) & setStanzaCorrente(I)
	@Test 
	void testVintaSeStanzaCorrenteEVincente() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	//3.vinta(I)
	@Test
	public void testNonVintaInizioPartita() {
		assertFalse(this.partita.vinta());
	}
	//4.setStanzaCorrente(II) & getStanzaVincente(III) & isFinita(I)
	@Test
	public void testFinitaSeVinta() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
	//5.isFinita(II) & setFinita(I)
	@Test
	public void testFinistaSeSettato() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	//6.isFinita(III) &setCFU(I)
	@Test
	public void testFinitaSeCFUFiniti() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}

	
	//7.setCFU(II) & getCfu(I)
	@Test
	public void testSetCFU() {
		this.partita.setCfu(24);
		assertEquals(24,this.partita.getCfu());
	}
	/*
	//8.vinta(III) se in biblioteca	
	@Test
	public void testVintaInBiblio() {
		this.partita.setStanzaCorrente(Biblioteca);
		assertTrue(this.partita.vinta());
	}
*/
	//9.vinta(II)
	@Test
	public void testNonVintaSeHoCfu() {
		this.partita.setCfu(3);
		assertFalse(this.partita.vinta());
	}
	
}
