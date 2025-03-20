package controleur;

import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		return false;
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		int numeroEtal = -1;
		verifierIdentite(nomVendeur);
		return numeroEtal;
	}

	public boolean verifierIdentite(String nomVendeur) {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		return false;
	}
}
