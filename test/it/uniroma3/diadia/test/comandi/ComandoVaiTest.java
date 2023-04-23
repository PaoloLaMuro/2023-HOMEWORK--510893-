package it.uniroma3.diadia.test.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

class ComandoVaiTest {
	
	//mi servono due aule il comando in questione e una partita
	private Partita p;
	private Comando comandoVai;
	private Stanza s1;
	private Stanza s2;
	
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		s1 = new Stanza("prima stanza");
		s2 = new Stanza("seconda stanza");
		p = new Partita();
		comandoVai = new ComandoVai();
		comandoVai.setIO(new IOConsole());
	}

	@Test
	void testComandoVaiNoDirection() {
		p.setStanzaCorrente(s1);
		comandoVai.esegui(p);
		assertEquals(s1, p.getStanzaCorrente());
	}
	@Test
	void testComandoVaiDirection() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("nord", s2);
		comandoVai.setParametro("nord");
		comandoVai.esegui(p);
		assertEquals(s2, p.getStanzaCorrente());
	}
	@Test
	void testComandoVaiWrongDirection() {
		p.setStanzaCorrente(s1);	//lo metto in s1
		s1.impostaStanzaAdiacente("nord", s2);	//a nord di s1 c'è s2
		comandoVai.setParametro("sud");	//lo mando a sud
		comandoVai.esegui(p);
		assertEquals(s1, p.getStanzaCorrente());	//non si muove è rimasto in s1
	}
	@Test
	void testComandoVaiInesistente() {
		p.setStanzaCorrente(s1);	//lo metto in s1
		s1.impostaStanzaAdiacente("nord", s2);	//a nord di s1 c'è s2
		comandoVai.setParametro("alBar");	//lo mando a sud
		comandoVai.esegui(p);
		assertEquals(s1, p.getStanzaCorrente());	//non si muove è rimasto in s1
	}
	/*comportamento osservato negli ultimi due test
	 * 1- se la direzione è una direzione esistente fra le direzioni ma non è presente per 
	 * quella stanza in particolare, viene restituito un generico "Direrzione inesistente"
	 * 2- quando viene inserita una direzione di fantasia, non presente fra le direzioni viene stampato:
	 * Dove vuoi andare? Devi specificare una direzione:
	 * 
	 * é un comportamento corretto? da rivedere
 */
	
}