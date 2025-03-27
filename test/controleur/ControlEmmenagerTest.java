package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private ControlEmmenager ctrlEmm;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initConfig1() {
		this.village = new Village("village", 30, 5);
		this.ctrlEmm = new ControlEmmenager(village);
		
		abraracourcix = new Chef("Abraracourcix", 5, village);
		village.setChef(abraracourcix);
	}
	
	
	@Test
	void testControlEmmenager() {
		assertNotNull(ctrlEmm, "Constructeur ne renvoit pas null");
	}

	@Test
	void testIsHabitant() {
		assertTrue(ctrlEmm.isHabitant("Abraracourcix"));
		assertFalse(ctrlEmm.isHabitant("Asterix"));
	}

	@Test
	void testAjouterDruide() {
		assertFalse(ctrlEmm.isHabitant("panoramix"));
		ctrlEmm.ajouterDruide("panoramix", 5, 3, 7);
		assertTrue(ctrlEmm.isHabitant("panoramix"));
	}

	@Test
	void testAjouterGaulois() {
		assertFalse(ctrlEmm.isHabitant("asterix"));
		ctrlEmm.ajouterGaulois("asterix", 5);
		assertTrue(ctrlEmm.isHabitant("asterix"));
	}

}
