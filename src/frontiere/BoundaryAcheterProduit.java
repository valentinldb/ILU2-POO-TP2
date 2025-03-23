package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!this.controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée "+ nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici!");
		}
		else {
			String produit = Clavier.entrerChaine("Quel produit voulez vous acheter ?");
			Gaulois[] vendeur = this.controlAcheterProduit.vendeurParProduit(produit);
			if(vendeur == null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
			else {
				System.out.println("Chez quel commerçant souhaitez-vous acheter des " + produit + "? \n");
				for(int i = 0; i<vendeur.length; i++) {
					System.out.println((i+1) + " - " + vendeur[i].getNom());
				}
				int indice = Clavier.entrerEntier("")-1;
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeur[indice]);
				int qteProduit = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				
				int qteAchetee = this.controlAcheterProduit.acheterProduit(vendeur[indice], qteProduit);
				if(qteAchetee == 0) {
					System.out.println(nomAcheteur + " veut acheter " + qteProduit + " " + produit + ", malheureusement il n'y en a plus !");
				} else if(qteAchetee < qteProduit) {
					System.out.println(nomAcheteur + " veut acheter " + qteProduit+ " " + produit + ", malheureusement " + vendeur[indice].getNom() + "n'en a pas plus de " + qteAchetee + ".");
					System.out.println(nomAcheteur + " achète tout le stock de " + vendeur[indice].getNom() + ".");
				} else {
					System.out.println(nomAcheteur + " achète " + qteProduit + " " + produit + " à " + vendeur[indice].getNom() + ".");
				}
			
				
			}
		}
		
		
	}
}
