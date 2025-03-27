package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	private Village village;
	private ControlVerifierIdentite ctrlVerif;
	private Gaulois asterix;
	private Chef abraracourcix;
	@BeforeEach
	public void initConfig() {
		this.village = new Village("village", 10, 5);
		this.ctrlVerif = new ControlVerifierIdentite(village);
		this.asterix = new Gaulois("asterix", 5);
		
		abraracourcix = new Chef("Abraracourcix", 5, village);
		village.setChef(abraracourcix);
		
	}
	
	@Test
	void testControlVerifierIdentite() {
		assertNotNull(ctrlVerif);
	}

	@Test
	void testVerifierIdentite() {
		assertFalse(ctrlVerif.verifierIdentite("asterix"));
		this.village.ajouterHabitant(asterix);
		assertTrue(ctrlVerif.verifierIdentite("asterix"));
	}

}
