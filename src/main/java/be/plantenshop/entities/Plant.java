package be.plantenshop.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import be.plantenshop.valueobjects.Kleur;


@Entity
@Table(name= "planten")
public class Plant implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name= "art_code")
	private long plantId;
	
	@Column(name= "plantennm")
	private String naam;
	
	@Embedded
	private Kleur kleur;
	
	private int hoogte;
	
	@Column(name = "bl_b")
	private int beginBloeiMaand;
	
	@Column(name= "bl_e")
	private int eindBloeiMaand;
	
	private BigDecimal prijs;
	
	@ManyToOne
	@JoinColumn(name= "soort_id")
	private Soort soort;
	
	protected Plant() {	
	}
	

	public Plant(long plantId, String naam, Kleur kleur, int hoogte,
			int beginBloeiMaand, int eindBloeiMaand, BigDecimal prijs) {
		this.plantId = plantId;
		this.naam = naam;
		this.kleur = kleur;
		this.hoogte = hoogte;
		this.beginBloeiMaand = beginBloeiMaand;
		this.eindBloeiMaand = eindBloeiMaand;
		this.prijs = prijs;
	}


	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Kleur getKleur() {
		return kleur;
	}

	public void setKleur(Kleur kleur) {
		this.kleur = kleur;
	}

	public int getHoogte() {
		return hoogte;
	}

	public void setHooghte(int hoogte) {
		this.hoogte = hoogte;
	}

	public int getBeginBloeiMaand() {
		return beginBloeiMaand;
	}

	public void setBeginBloeiMaand(int beginBloeiMaand) {
		this.beginBloeiMaand = beginBloeiMaand;
	}

	public int getEindBloeiMaand() {
		return eindBloeiMaand;
	}

	public void setEindBloeiMaand(int eindBloeiMaand) {
		this.eindBloeiMaand = eindBloeiMaand;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

	public Soort getSoort() {
		return soort;
	}

	public void setSoort(Soort soort) {
		this.soort = soort;
	}

	public long getPlantId() {
		return plantId;
	}

	@Override
	public String toString() {
		return "Plant [plantId=" + plantId + ", naam=" + naam + ", kleur="
				+ kleur + ", hooghte=" + hoogte + ", beginBloeiMaand="
				+ beginBloeiMaand + ", eindBloeiMaand=" + eindBloeiMaand
				+ ", prijs=" + prijs + ", soort=" + soort + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + beginBloeiMaand;
		result = prime * result + eindBloeiMaand;
		result = prime * result + hoogte;
		result = prime * result + ((kleur == null) ? 0 : kleur.hashCode());
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		result = prime * result + ((soort == null) ? 0 : soort.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plant other = (Plant) obj;
		if (beginBloeiMaand != other.beginBloeiMaand)
			return false;
		if (eindBloeiMaand != other.eindBloeiMaand)
			return false;
		if (hoogte != other.hoogte)
			return false;
		if (kleur == null) {
			if (other.kleur != null)
				return false;
		} else if (!kleur.equals(other.kleur))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		if (soort == null) {
			if (other.soort != null)
				return false;
		} else if (!soort.equals(other.soort))
			return false;
		return true;
	}
	
	
}
