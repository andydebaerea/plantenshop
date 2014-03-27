package be.plantenshop.entities;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import be.plantenshop.entities.BestelBon;
import be.plantenshop.entities.Klant;
import be.plantenshop.entities.Plant;
import be.plantenshop.valueobjects.BestelbonLijn;
import be.plantenshop.valueobjects.Kleur;


public class BestelbonTest {
	
	private BestelBon bestelBon;
	private BestelbonLijn bestelbonLijn;
	
	@Before
	public void before() {
		bestelBon = new BestelBon(1L, new Klant(), new Date());
		Plant plant = new Plant(1L, "plant", new Kleur("geel"), 1, 1, 1, new BigDecimal(1));
		bestelbonLijn = new BestelbonLijn(plant, 1, bestelBon);
		bestelBon.addBestelbonLijnen(bestelbonLijn);
	}
	
	@Test
	public void testOfBestelbonLijnKanWordenToegevoegd() {
		assertEquals(1, bestelBon.getBestelbonLijnen().size());
	}
	
	@Test
	public void testOfBestelbonlijnKanVerwijderdWorden() {
		bestelBon.removeBestelbonlijnen(bestelbonLijn);
		assertTrue(bestelBon.getBestelbonLijnen().isEmpty());
	}
}
