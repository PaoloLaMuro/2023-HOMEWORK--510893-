package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * tutti i comandi del gioco saranno realizzati da oggetti istanze di classi
 * che implementano l'interface Comando:
 * l'implementazione del metodo esegui(Partita partita) codifica la semantica 
 * del comando specifico
 * 
 */
public interface Comando {
	
	//esecuzione del comando
	public void esegui(Partita partita);
	
	//set parametro del comand
	public void setParametro(String parametro);

	void setIO(IO io);
	
	String getParametro();
	
	
	
}
