package it.polito.tdp.parole.model;

import java.util.List;
import java.util.*;

public class ParoleArrayList {

	private ArrayList<String> listaParole;

	public ParoleArrayList() {
		listaParole = new ArrayList<String>(10);

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
