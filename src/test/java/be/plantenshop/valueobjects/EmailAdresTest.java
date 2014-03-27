package be.plantenshop.valueobjects;

import org.junit.Test;

public class EmailAdresTest {

	@Test
	public void testCorrectEmailAdressIsOK() {
		new EmailAdres("test@test.be");
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void emailadresZonderGebruikersNaamIsFout() {
		new EmailAdres("@test.be");
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void emailadresZonderProviderIsFout() {
		new EmailAdres("test@.be");
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void emailadresZonderTopLevelDomainIsFout() {
		new EmailAdres("test@test.");
	}

	@Test(expected= IllegalArgumentException.class)
	public void emailadresCijferInTopLevelDomainIsFout() {
		new EmailAdres("test@test.1be");
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void leegEmailadresIsFout() {
		new EmailAdres("");
	}
	
	@Test(expected= NullPointerException.class)
	public void nullAlsEmailadresIsFout() {
		new EmailAdres(null);
	}
}
