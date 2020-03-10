package it.polito.tdp.parole;

import java.util.*;

//import it.polito.tdp.parole.model.ParoleArrayList;		//DOMANDA: DUE VERSIONI??

import it.polito.tdp.parole.model.Parole;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Parole elenco; // viene creato nell'inizializzazione
	//ParoleArrayList elenco;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnInserisci;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;
	
	@FXML
	private Button btnCancella; //variabile bottone serve???
	
	 @FXML
	    private TextArea txtTempi;

	@FXML
	void doInsert(ActionEvent event) {

		elenco.addParola(this.txtParola.getText());

		this.scriviElenco();
		
		this.tempoEsecuzione();

	}

	@FXML
	void doReset(ActionEvent event) {

		elenco.reset();
		txtResult.clear();
		
		this.tempoEsecuzione();
		this.txtTempi.clear();

	}

	@FXML
	void doCancella(ActionEvent event) {

		String daCancellare = txtResult.getSelectedText();
		elenco.cancellaParola(daCancellare);

		this.scriviElenco();
		this.tempoEsecuzione();
	}

	void scriviElenco() {
		LinkedList<String> l = new LinkedList<String>(elenco.getElenco());

		txtResult.clear();
		
		for (String s : l) {
			txtResult.appendText(s + "\n"); // a capo!
		}
	}
	
	void tempoEsecuzione() {
		Long l= System.nanoTime();
		String s= l.toString();
		
		this.txtTempi.appendText(s+"\n");
	}

	@FXML
	void initialize() {
		 assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtTempi != null : "fx:id=\"txtTempi\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

		elenco = new Parole();
		//elenco = new ParoleArrayList();
	}
}
