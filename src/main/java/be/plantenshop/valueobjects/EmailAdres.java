package be.plantenshop.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EmailAdres implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static final String REG_EXPR= "^.+@.+\\.[a-z]+$";
	
	private  final String emailAdres;
	
	
	protected EmailAdres() {
		this.emailAdres = null;
	}
	
	public EmailAdres(String emailAdres) {
		if (!emailAdres.matches(REG_EXPR)) {
			throw new IllegalArgumentException("Verkeerd e-mailadres");
		}
		this.emailAdres = emailAdres;
	}
	
	public String getEmailAdres() {
		return emailAdres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((emailAdres == null) ? 0 : emailAdres.hashCode());
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
		EmailAdres other = (EmailAdres) obj;
		if (emailAdres == null) {
			if (other.emailAdres != null)
				return false;
		} else if (!emailAdres.equals(other.emailAdres))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmailAdres [emailAdres=" + emailAdres + "]";
	}
	
}
