
package gestionDeStock.model;

import java.util.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GeneralModel {
	private final StringProperty matricule = new SimpleStringProperty();
	private final StringProperty libelle = new SimpleStringProperty();
	private int quantite ;
	private  ObjectProperty<Date> DateDeLivraison = new SimpleObjectProperty<>();
	private Double prix;
	 private final StringProperty Fournisseur = new SimpleStringProperty();
	
	 public GeneralModel() {
		 
	 }
	 public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public ObjectProperty<Date> getDateDeLivraison() {
		return DateDeLivraison;
	}
	public void setDateDeLivraison(ObjectProperty<Date> dateDeLivraison) {
		DateDeLivraison = dateDeLivraison;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public StringProperty getMatricule() {
		return matricule;
	}
	public StringProperty getLibelle() {
		return libelle;
	}
	public StringProperty getFournisseur() {
		return Fournisseur;
	}
	 
	 
	
}
