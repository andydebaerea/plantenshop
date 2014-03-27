package be.plantenshop.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import be.plantenshop.enums.Geslacht;
import be.plantenshop.valueobjects.Adres;
import be.plantenshop.valueobjects.EmailAdres;
import be.plantenshop.valueobjects.TelefoonNummer;



@Entity
public class Klant extends Persoon implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String gebruikersNaam;
	
	private String paswoord;
	
	private Date klantSinds;

	protected Klant() {
		super();
	}

	public Klant(String voornaam, String familienaam, Adres adres, Date date,
			EmailAdres emailAdres, TelefoonNummer telefoonNummer,
			Geslacht geslacht, String gebruikersNaam, String paswoord, Date klantSinds) {
		super(voornaam, familienaam, adres, date, emailAdres, telefoonNummer, geslacht);
		this.gebruikersNaam = gebruikersNaam;
		this.paswoord = paswoord;
		this.klantSinds = klantSinds;
	}

	public String getGebruikersNaam() {
		return gebruikersNaam;
	}

	public void setGebruikersNaam(String gebruikersNaam) {
		this.gebruikersNaam = gebruikersNaam;
	}

	public String getPaswoord() {
		return paswoord;
	}

	public void setPaswoord(String paswoord) {
		this.paswoord = paswoord;
	}

	public Date getKlantSinds() {
		return klantSinds;
	}

	public void setKlantSinds(Date klantSinds) {
		this.klantSinds = klantSinds;
	}
	
	
	
}
