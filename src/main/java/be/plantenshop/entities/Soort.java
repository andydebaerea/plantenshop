package be.plantenshop.entities;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "soorten")
public class Soort {

	@Id
	@GeneratedValue
	@Column(name = "soort_id")
	private long soortId;
	
	@Column(name= "soort")
	private String naam;
	
	@OneToMany
	@JoinColumn(name = "soort_id")
	private Set<Plant> planten;
	
	protected Soort() {
	}
	
	protected Soort(long soortId, String naam) {
		this.soortId = soortId;
		this.naam = naam;
		this.planten = new LinkedHashSet<>();
	}

	public long getSoortId() {
		return soortId;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Set<Plant> getPlanten() {
		return Collections.unmodifiableSet(planten);
	}
	
	public void addPlant(Plant plant) {
		planten.add(plant);
	}
	
	public void removePlant(Plant plant) {
		planten.add(plant);
	}
	
	@Override
	public String toString() {
		return soortId + ": " + naam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
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
		Soort other = (Soort) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}
	
}
