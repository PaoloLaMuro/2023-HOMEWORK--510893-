package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	
	private IO io;
	private String nomeAtrezzo;
	
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(this.nomeAtrezzo);
		
		if(a == null) {
			this.io.mostraMessaggio("Non trovo" + this.nomeAtrezzo + "in borsa");
			return;
		}
		
		boolean posato = partita.getStanzaCorrente().addAttrezzo(a);
		
		if(!posato) {
			this.io.mostraMessaggio(partita.getStanzaCorrente().getNome().toString() +"contiene troppi oggetti, non posso posare"+ this.nomeAtrezzo);
			return;
		}
		
		partita.getGiocatore().getBorsa().removeAttrezzo(this.nomeAtrezzo);
		this.io.mostraMessaggio(this.nomeAtrezzo + "posato");
		
	
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAtrezzo = parametro;
	}

	@Override
	public void setIO(IO io) {
		// TODO Auto-generated method stub
		this.io = io;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAtrezzo;
	}

}
