package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoGuarda implements Comando {
	
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		//1-cfu residui
		this.io.mostraMessaggio("CFU residui: "+partita.getGiocatore().getCfu());
		this.io.mostraMessaggio(partita.getStanzaCorrente().toString());
		this.io.mostraMessaggio(partita.getGiocatore().toString());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIO(IO io) {
		// TODO Auto-generated method stub
		this.io = io;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
