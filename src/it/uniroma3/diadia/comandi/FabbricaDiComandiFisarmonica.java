package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{
	
	private IO io;
	//mi fa comodo avere elenco comandi da restituire con comandoAiuto
	//static final private String[] elencoComandi = {"aiuto","posa","prendi","vai","fine","guarda"};
	
	public FabbricaDiComandiFisarmonica(IO io) {
		// TODO Auto-generated constructor stub
		this.io = io;
	}

	//costruttore di comando
	public Comando costruisciComando(String istruzione,IO io) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;		

		if(scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();	//la prima parola è il nome del comando	es"vai"
		if(scannerDiParole.hasNext())				
			parametro = scannerDiParole.next();		//la seconda parola è il parametro es"sud"

		//in base alla String comando che ho ricevuto lancio il costruttore del comando relativo
		if(nomeComando == null) 
			comando = new ComandoNonValido();
		if (nomeComando.equals("vai"))
			comando = new ComandoVai();
		else if(nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		else if(nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda(); 

		else	comando = new ComandoNonValido();

		comando.setParametro(parametro);
		comando.setIO(io);
		return comando;		
	}

}
