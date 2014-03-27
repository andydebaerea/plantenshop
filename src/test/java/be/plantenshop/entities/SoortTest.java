package be.plantenshop.entities;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.plantenshop.valueobjects.Kleur;

public class SoortTest {
	
	private Soort soort;
	
	@Before
	public void before() {
		soort= new Soort(1L, "soorttest");
	}
	
	
	@Test
	public void testOfPlantenKunnenToegevoegdWordenAanSet() {
		Plant plant = new Plant(1L, "plant", new Kleur("geel"), 1, 1, 1, new BigDecimal(1));
		soort.addPlant(plant);
		assertEquals(1, soort.getPlanten().size());
	}

}
