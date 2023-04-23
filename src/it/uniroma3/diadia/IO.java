package it.uniroma3.diadia;
/**
 * Completiamo il processo di disaccoppiamento
dall’I/O tramite l’introduzione di un apposita
interfaccia denominata IO (presentata nella
prossima slide>>) che astragga IOConsole:
– Creare l’interfaccia e posizionarla nel package
it.uniroma3.diadia
– Cambiare IOConsole affinché la implementi
– Cambiare tutto il codice affinché ogni
riferimento ad IOConsole sia rimpiazzato da un
(meno vincolante) riferimento tipato IO
 */
public interface IO {
	//metodo mostraMessaggio
	public void mostraMessaggio(String messaggio);
	//metodo leggiRiga
	public String leggiRiga();
}
