package be.plantenshop.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import be.plantenshop.enums.Geslacht;
import be.plantenshop.valueobjects.Adres;
import be.plantenshop.valueobjects.EmailAdres;
import be.plantenshop.valueobjects.TelefoonNummer;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "klanten")
public abstract class Persoon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "klant_code")
	private long klantId;

	private String voornaam;

	private String familienaam;
	
	@Embedded
	private Adres adres;

	private Date date;

	private EmailAdres emailAdres;

	private TelefoonNummer telefoonNummer;
	
	@Enumerated(EnumType.STRING)
	private Geslacht geslacht;
	

	protected Persoon() {

	}


	protected Persoon(String voornaam, String familienaam, Adres adres, Date date,
			EmailAdres emailAdres, TelefoonNummer telefoonNummer,
			Geslacht geslacht) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.adres = adres;
		this.date = date;
		this.emailAdres = emailAdres;
		this.telefoonNummer = telefoonNummer;
		this.geslacht = geslacht;
	}


	public String getVoornaam() {
		return voornaam;
	}


	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}


	public String getFamilienaam() {
		return familienaam;
	}


	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}


	public Adres getAdres() {
		return adres;
	}


	public void setAdres(Adres adres) {
		this.adres = adres;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public EmailAdres getEmailAdres() {
		return emailAdres;
	}


	public void setEmailAdres(EmailAdres emailAdres) {
		this.emailAdres = emailAdres;
	}


	public TelefoonNummer getTelefoonNummer() {
		return telefoonNummer;
	}


	public void setTelefoonNummer(TelefoonNummer telefoonNummer) {
		this.telefoonNummer = telefoonNummer;
	}


	public Geslacht getGeslacht() {
		return geslacht;
	}


	public void setGeslacht(Geslacht geslacht) {
		this.geslacht = geslacht;
	}


	public long getKlantId() {
		return klantId;
	}
	
	
	
}
