package be.plantenshop.valueobjects;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import be.plantenshop.entities.BestelBon;
import be.plantenshop.entities.Plant;

public class BestelbonLijn implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "art_code")
	private Plant plant;
	
	private int aantal;
	
	@ManyToOne
	@JoinColumn(name= "BonNr")
	private BestelBon bestelBon;
	
	protected BestelbonLijn() {
		
	}

	public BestelbonLijn(Plant plant, int aantal, BestelBon bestelBon) {
		super();
		this.plant = plant;
		this.aantal = aantal;
		this.bestelBon = bestelBon;
	}

	public Plant getPlant() {
		return plant;
	}

	public int getAantal() {
		return aantal;
	}

	public BestelBon getBestelBon() {
		return bestelBon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((plant == null) ? 0 : plant.hashCode());
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
		BestelbonLijn other = (BestelbonLijn) obj;
		if (plant == null) {
			if (other.plant != null)
				return false;
		} else if (!plant.equals(other.plant))
			return false;
		return true;
	}
	
	
}
