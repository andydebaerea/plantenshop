package be.plantenshop.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import be.plantenshop.valueobjects.BestelbonLijn;

@Entity
@Table(name= "bestelbonnen")
public class BestelBon implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="BonNr")
	private long bonId;
	
	@ManyToOne
	@JoinColumn(name= "klant_code")
	private Klant klant;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date bestelbonDatum;
	
	@ElementCollection
	@CollectionTable(name = "bestelbonlijnen", joinColumns = @JoinColumn(name= "bonNr"))
	private Set<BestelbonLijn> bestelbonLijnen = new LinkedHashSet<>();
	
	protected BestelBon() {
		
	}
	

	public BestelBon(long bonId, Klant klant, Date bestelbonDatum) {
		super();
		this.bonId = bonId;
		this.klant = klant;
		this.bestelbonDatum = bestelbonDatum;
	}


	public long getBonId() {
		return bonId;
	}

	public Klant getKlant() {
		return klant;
	}

	public void setKlant(Klant klant) {
		this.klant = klant;
	}

	public Date getBestelbonDatum() {
		return bestelbonDatum;
	}

	public void setBestelbonDatum(Date bestelbonDatum) {
		this.bestelbonDatum = bestelbonDatum;
	}

	public Set<BestelbonLijn> getBestelbonLijnen() {
		return Collections.unmodifiableSet(bestelbonLijnen);
	}

	public void addBestelbonLijnen(BestelbonLijn bestelbonLijn) {
		this.bestelbonLijnen.add(bestelbonLijn);
	}
	
	public void removeBestelbonlijnen(BestelbonLijn bestelbonLijn) {
		this.bestelbonLijnen.remove(bestelbonLijn);
	}
}
