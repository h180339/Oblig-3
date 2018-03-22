package no.hvl.dat102.dobbelkjedetordnetlistem;

import no.hvl.dat102.adt.DobbelKjedetOrdnetListeMADT;

//********************************************************************
//  
//  Representerer en dobbeltkjedet ordnet liste med midtpeker.
//********************************************************************
;

public class DobbelKjedetOrdnetListeM<T extends Comparable<T>> implements DobbelKjedetOrdnetListeMADT<T> {
//M for midtpeker
	private DobbelNode<T> foerste;
	private DobbelNode<T> midten;
	private DobbelNode<T> siste;
	private int antall;
	private int Ahoyre;
	private int Avenstre;

	/******************************************************************
	 * Oppretter en tom liste.
	 ******************************************************************/
	// Konstrukt�r

	public DobbelKjedetOrdnetListeM(T minVerdi, T maksVerdi) {

		// F�rste node
		DobbelNode<T> nyNode1 = new DobbelNode<T>(minVerdi);
		foerste = nyNode1;
		midten = foerste;

		// Siste node
		DobbelNode<T> nyNode2 = new DobbelNode<T>();
		nyNode2.setElement(maksVerdi);
		nyNode1.setNeste(nyNode2);
		nyNode2.setForrige(nyNode1);
		siste = nyNode2;
		Ahoyre = 0;
		Avenstre = 0;
		antall = 0;
	}

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************

	@Override
	public void leggTil(T el) {


		// Setter inn ordnet f�r den noden p peker p�
		DobbelNode<T> p;

		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier

			antall++;
			if (el.compareTo(midten.getElement()) >= 0) {// Finn plass i siste
										// halvdel
				p = midten.getNeste();
				if (antall != 1) {
					Ahoyre++;
				}


			} else { // Finn plass i f�rste halvdel
				p = foerste.getNeste();
				Avenstre++;
			}

			while (el.compareTo(p.getElement()) >= 0) {
				p = p.getNeste();
			} // while

			// Setter inn:
			// Innsett foran noden som p peker p�

			DobbelNode<T> nyNode = new DobbelNode<T>(el);

			// Fyll ut med noen f� setninger
			if (antall == 1) {
				this.midten = nyNode;
				siste.setForrige(nyNode);
				foerste.setNeste(nyNode);
				nyNode.setNeste(siste);
				nyNode.setForrige(foerste);
			}else {
				nyNode.setForrige(p.getForrige());
				p.getForrige().setNeste(nyNode);
				nyNode.setNeste(p);
				p.setForrige(nyNode);
			}

			// Oppdaterer ny midten


			if (antall % 2 == 1 && antall > 1) { //oppdaterer midten bare når det er odetall antall noder
				//nyMidten();
				if(Ahoyre > Avenstre) {
					midten = midten.getNeste();
				} else if (Avenstre > Ahoyre) {
					midten = midten.getForrige();
				}
				Avenstre = antall / 2;
				Ahoyre = antall / 2;
			}





		} // else lovlige

	}//

	// **********************************************************************************
	// Hjelpemetode til � finne ny midten.
	// Mindre effektiv fordi vi m� gjennomg� ca halve listen, men greit nok,
	// ellers kan en teste p� om antall er partall er oddetall ved oppdatering
	// av midtpeker
	// *********************************************************************************
	private void nyMidten() {
		int midtNR = antall / 2;
		DobbelNode<T> p = foerste.getNeste();
		for (int i = 1; i <= midtNR; i++) {
			p = p.getNeste();
		}
		midten = p;
	}//

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************
	@Override
	public boolean fins(T el) {
		boolean funnet = false;
		DobbelNode<T> p = null;
		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier
			if (el.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
				p = midten; // Midten defineres � tilh�re siste del
			} else { // Let i f�rste halvdel
				p = foerste.getNeste();
			}

			while (el.compareTo(p.getElement()) > 0) {
				p = p.getNeste();
			} // while

			// Test p� funnet
			if (el.compareTo(p.getElement()) == 0) {
				funnet = true;
			}
		} // else
		return funnet;
	}//

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************
    // Omskrive til � bruke finn-metoden
	@Override
	public T fjern(T el) {
		System.out.println("antall hoyre:" + Ahoyre + " antall venstre : " + Avenstre);
		T resultat = null;
		DobbelNode<T> p = null;
		boolean funnet = false;

		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier
			/*
			if (el.compareTo(midten.getElement()) >= 0) {
				p = midten;
			} else {
				p = foerste.getNeste();
			}

			while (el.compareTo(p.getElement()) > 0) {
				p = p.getNeste();
			} // while
			*/
			p = finn(el);

			if (el.compareTo(p.getElement()) == 0) {
				funnet = true;
			}


			if (funnet) {
				// Tar ut 
				antall = antall - 1;
				if (el.compareTo(midten.getElement()) == 0) { //sjekker om man sletter midtelement

					if(Ahoyre > Avenstre) {
						midten = midten.getForrige();
					} else if (Avenstre > Ahoyre) {
						midten = midten.getNeste();
					} else {
						midten = midten.getForrige();
					}
				}
				if (antall % 2 == 1) { //oppdaterer midten bare når det er odetall antall noder
					//nyMidten();
					//System.out.println("antall hoyre:" + Ahoyre + " antall venstre : " + Avenstre);
					if(Ahoyre > Avenstre) {
						midten = midten.getForrige();

					} else if (Avenstre > Ahoyre) {
						midten = midten.getNeste();
					}
				}
				// Fyll ut med noen f� setninger.
				p.getNeste().setForrige(p.getForrige());
				p.getForrige().setNeste(p.getNeste());

				// Oppadtere midten


				resultat = p.getElement();

			} // funnet

		} // lovlige
		return resultat;
	}//

	/* Alternativ kan fjern-metoden bruke finn-metoden */

	private DobbelNode<T> finn(T el) {
		DobbelNode<T> node = null;
		DobbelNode<T> p = null;

		// Kun lovlige verdier
		if (el.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
			p = midten; // Midten defineres � tilh�re siste del
			Ahoyre--;
		} else { // Let i f�rste halvdel
			p = foerste.getNeste();
			Avenstre--;
		}
		while (el.compareTo(p.getElement()) > 0) {
			p = p.getNeste();
		} // while

		// Test p� funnet
		if (el.compareTo(p.getElement()) == 0) {
			node = p;
		}
		return node;
	}

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************

	public void skrivListe() {
		DobbelNode<T> p = foerste;

		while (p != null) {
			System.out.print(p.getElement() + " ");
			p = p.getNeste();
		}

		System.out.println(
				"Foerste:" + foerste.getElement() + " Midten:" + midten.getElement() + " Siste:" + siste.getElement());
		System.out.println();

	}//

}// class
