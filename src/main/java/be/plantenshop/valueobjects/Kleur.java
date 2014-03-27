package be.plantenshop.valueobjects;

import javax.persistence.Embeddable;

@Embeddable
public class Kleur {
	
	private String kleur;
	
	protected Kleur(){	
	}
	
	public Kleur(String kleur) {
		this.kleur = kleur;
	}
	
	
	public String getKleur() {
		return kleur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kleur == null) ? 0 : kleur.hashCode());
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
		Kleur other = (Kleur) obj;
		if (kleur == null) {
			if (other.kleur != null)
				return false;
		} else if (!kleur.equals(other.kleur))
			return false;
		return true;
	}
	
	
}
