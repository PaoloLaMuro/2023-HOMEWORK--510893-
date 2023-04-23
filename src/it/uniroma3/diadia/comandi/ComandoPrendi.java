package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	
	private IO io;
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
		
		if(a == null) {
			this.io.mostraMessaggio("Non trovo" + this.nomeAttrezzo + "in stanza");
			return;
		}
		
		boolean preso = partita.getGiocatore().getBorsa().addAttrezzo(a);
		
		if(!preso) {
			this.io.mostraMessaggio("la tua borsa contiene troppi oggetti, non posso prendere"+ this.nomeAttrezzo);
			return;
		}
		
		partita.getStanzaCorrente().removeAttrezzo(a);
		this.io.mostraMessaggio(this.nomeAttrezzo + "preso!");
		

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo = parametro;
	}

	@Override
	public void setIO(IO io) {
		// TODO Auto-generated method stub
		this.io = io;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}

}
