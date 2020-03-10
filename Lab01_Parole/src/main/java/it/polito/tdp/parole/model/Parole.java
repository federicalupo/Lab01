package it.polito.tdp.parole.model;

import java.util.List;
import java.util.*;

public class Parole {

	private LinkedList<String> listaParole;

	public Parole() {
		listaParole = new LinkedList<String>();

	}

	public void addParola(String p) {
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
		if(listaParole.contains(daCancellare))
		{
			listaParole.remove(daCancellare); 
		}
		
	}

}
