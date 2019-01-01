
package gestionDeStock.model;

import java.util.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GeneralModel {
	private final StringProperty matricule = new SimpleStringProperty();
	private final StringProperty libelle = new SimpleStringProperty();
	private IntegerProperty quantite =new SimpleIntegerProperty();
	private  ObjectProperty<Date> DateDeLivraison = new SimpleObjectProperty<>();
	private DoubleProperty prix =new SimpleDoubleProperty();
	 private final StringProperty Fournisseur = new SimpleStringProperty();
	
	 public GeneralModel() {
		 
	 }
	 
	public IntegerProperty getQuantite() {
		return quantite;
	}

	public void setQuantite(IntegerProperty quantite) {
		this.quantite = quantite;
	}

	public ObjectProperty<Date> getDateDeLivraison() {
		return DateDeLivraison;
	}
	public void setDateDeLivraison(ObjectProperty<Date> dateDeLivraison) {
		DateDeLivraison = dateDeLivraison;
	}
	
	public DoubleProperty getPrix() {
		return prix;
	}

	public void setPrix(DoubleProperty prix) {
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
