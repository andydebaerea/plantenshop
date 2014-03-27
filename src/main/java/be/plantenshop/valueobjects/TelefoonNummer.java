package be.plantenshop.valueobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TelefoonNummer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name= "telefoon")
	private long telefoonNummer;
	
	protected TelefoonNummer() {
	}
	
	public TelefoonNummer(long telefoonNummer) {
		this.telefoonNummer = telefoonNummer;
	}

	public long getTelefoonNummer() {
		return telefoonNummer;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (telefoonNummer ^ (telefoonNummer >>> 32));
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
		TelefoonNummer other = (TelefoonNummer) obj;
		if (telefoonNummer != other.telefoonNummer)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "telefoonNummer=" + telefoonNummer;
	}
	
}
