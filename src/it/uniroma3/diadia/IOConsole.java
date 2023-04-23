package it.uniroma3.diadia;

import java.util.Scanner;

/*questa è la classe della console di input output*/


public class IOConsole implements IO {
	//ci serve una funzione di output che stampi su schermo
	public void mostraMessaggio(String msg) {		//gli passo la stringa msg quando invoco this.io.stampa()
		System.out.println(msg);		//e uso system.out.println per stamparlo, mascherato dietro "stampa()"
	}
	//restituisce la stringa letta tramite il classico scanner di linee di java
	public String leggiRiga() {
		//creo un oggetto di tipo Scanner che chiamo scannerDiLinee, gli passo come parametro l'input della tastiera(?)
		Scanner scannerDiLinee = new Scanner(System.in);
		//creo una string che chiamo riga e ci schiaffo dentro la nextLine che leggo da tastiera con lo scannerDiLinee 
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;		
	}

}
