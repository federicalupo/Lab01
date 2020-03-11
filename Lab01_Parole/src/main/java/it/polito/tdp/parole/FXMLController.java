package it.polito.tdp.parole;

import java.util.*;
	

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
	private Button btnCancella; // variabile bottone serve???

	@FXML
	private TextArea txtTempi;

	@FXML
	void doInsert(ActionEvent event) {

		double start = System.nanoTime();

		for (int i = 0; i < txtParola.getText().length(); i++) {
			char c = txtParola.getText().charAt(i);
			if (!Character.isLetter(c)) {
				txtResult.appendText("Inserire caratteri corretti \n");

				double stop = System.nanoTime();

				this.tempoEsecuzione(start, stop);
				return;
			}
		}

		elenco.addParola(this.txtParola.getText());

		this.scriviElenco();

		double stop = System.nanoTime();

		this.tempoEsecuzione(start, stop);

	}

	@FXML
	void doReset(ActionEvent event) {

		elenco.reset();
		txtResult.clear();

		this.txtTempi.clear();

	}

	@FXML
	void doCancella(ActionEvent event) {

		double start = System.nanoTime();

		String daCancellare = txtResult.getSelectedText();
		elenco.cancellaParola(daCancellare);

		this.scriviElenco();
		double stop = System.nanoTime();

		this.tempoEsecuzione(start, stop);
	}

	void scriviElenco() {
		LinkedList<String> l = new LinkedList<String>(elenco.getElenco());

		txtResult.clear();

		for (String s : l) {
			txtResult.appendText(s + "\n"); // a capo!
		}
	}

	void tempoEsecuzione(double start, double stop) {

		Double differenza = (stop - start); // SERVE DIFFERENZA

		this.txtTempi.appendText(differenza.toString() + "\n");
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
		
	}
}
