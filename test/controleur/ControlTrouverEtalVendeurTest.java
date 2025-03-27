package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {

	private Village village;
	private ControlTrouverEtalVendeur ctrlTrouverEtal;
	private Gaulois asterix;
	private Chef abraracourcix;
	@BeforeEach
	public void initConfig() {
		this.village = new Village("village", 10, 1);
		this.ctrlTrouverEtal = new ControlTrouverEtalVendeur(village);
		this.asterix = new Gaulois("asterix", 5);
		village.ajouterHabitant(asterix);
		abraracourcix = new Chef("Abraracourcix", 5, village);
		village.setChef(abraracourcix);
		
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(ctrlTrouverEtal);
	}

	@Test
	void testTrouverEtalVendeur() {
		assertNotNull(ctrlTrouverEtal.trouverEtalVendeur("asterix"));
		assertNull(ctrlTrouverEtal.trouverEtalVendeur("Obelix"));
	}

}
