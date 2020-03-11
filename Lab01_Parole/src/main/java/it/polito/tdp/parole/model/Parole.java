package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {

	private List<String> listaParole; //basta fare così

	public Parole() {
		listaParole = new LinkedList<String>();
		//listaParole = new ArrayList<String>(10);

	}

	public void addParola(String p) {
		/*for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (!Character.isLetter(c)) {
				//listaParole.add("Inserire caratteri corretti");

				return;
			}
		}*/
		listaParole.add(p);
	}

	public List<String> getElenco() {
		Collections.sort(listaParole, new ComparatoreOrdineAlfabetico());

		return listaParole;
	}

	public void reset() {
		listaParole.clear();
	}

	public void cancellaParola(String daCancellare) {
		if (listaParole.contains(daCancellare)) {
			listaParole.remove(daCancellare);
		}

	}

}
