package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	private Village village;
	private ControlVerifierIdentite ctrlVerif;
	private ControlPrendreEtal ctrlPrendreEtal;
	private Gaulois asterix;
	private Chef abraracourcix;
	@BeforeEach
	public void initConfig() {
		this.village = new Village("village", 10, 1);
		this.ctrlVerif = new ControlVerifierIdentite(village);
		this.ctrlPrendreEtal = new ControlPrendreEtal(ctrlVerif,village);
		this.asterix = new Gaulois("asterix", 5);
		village.ajouterHabitant(asterix);
		abraracourcix = new Chef("Abraracourcix", 5, village);
		village.setChef(abraracourcix);
		
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(ctrlPrendreEtal);
	}

	@Test
	void testResteEtals() {
		assertTrue(ctrlPrendreEtal.resteEtals());
		village.installerVendeur(asterix, "pdt", 1);
		assertFalse(ctrlPrendreEtal.resteEtals());
		village.partirVendeur(asterix);
	}

	@Test
	void testPrendreEtal() {
		assertEquals(ctrlPrendreEtal.prendreEtal("asterix", "pdt", 1),0);
		assertEquals(ctrlPrendreEtal.prendreEtal("obelix", "pdt2", 1),-1);
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(ctrlPrendreEtal.verifierIdentite("asterix"));
		assertFalse(ctrlPrendreEtal.verifierIdentite("Obelix"));
		
	}

}
