package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;


public interface FabbricaDiComandi {
	//crea un comando che ha un nome comando e un parametro aggiuntivo 
	public Comando costruisciComando (String istruzione,IO io);
}
