package it.uniroma3.diadia;




import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;



/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	//inizializzo oggetto partita
	private Partita partita;
	private IO io;	//oggetto console inupt output
	
	//creo nuova partita 
	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io = io;
	}

	public void gioca() {
		String istruzione; 
		/*Scanner scannerDiLinee;*/

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		/*scannerDiLinee = new Scanner(System.in);*/		
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}
	
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String parametro) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(this.io);
		
		comandoDaEseguire = factory.costruisciComando(parametro,this.io);
		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.vinta())
			this.io.mostraMessaggio("Hai Vinto!!!");
		if(this.partita.getCfu() == 0) 
			this.io.mostraMessaggio("Partita finita, CFU esauriti");
		return this.partita.isFinita();
		}

	
	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}