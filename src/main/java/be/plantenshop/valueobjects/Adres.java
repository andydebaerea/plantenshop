package be.plantenshop.valueobjects;

import javax.persistence.Embeddable;

@Embeddable
public class Adres {
	private String straat;

	private String huisNr;

	private Integer postcode;

	private String gemeente;


	protected Adres() {
	}

	public Adres(String straat, String huisNr, Integer postcode, String gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}


	public String getStraat() {
		return straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}


	public String toString() {
		return String.format("%s %s, %d %s", straat, huisNr, postcode, gemeente);
		}
}
