package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai implements Comando {
	
	//il parametro qui è la direzione
	private String parametro;
	//mi serve la console in ogni comando
	private IO io;
	
	//sovrascrivo il metodo esegui di Comando
	@Override
	public void esegui (Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		//il parametro del comando è la direzione
		if(this.parametro==null) {
			this.io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione:");
			return;
		}
		//prendo la stanza adiacente nella direzione del parametro alla stanza corrente
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.parametro);
		if(prossimaStanza==null) {
			this.io.mostraMessaggio("Direzione inesistente");
			return;
		}
		//adesso setto la stanza corrente con quella adiacente scelta sopra
		partita.setStanzaCorrente(prossimaStanza);
		this.io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		//una volta che ho spostato il giocatore nella stanza desiderata decremento il numero di cfu disponibili
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	public IO getIo() {
		return io;
	}
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
	public String getParametro() {
		return this.parametro;
	}
	
}
