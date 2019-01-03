
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

	public final StringProperty matriculeProperty() {
		return this.matricule;
	}
	

	public final String getMatricule() {
		return this.matriculeProperty().get();
	}
	

	public final void setMatricule(final String matricule) {
		this.matriculeProperty().set(matricule);
	}
	

	public final StringProperty libelleProperty() {
		return this.libelle;
	}
	

	public final String getLibelle() {
		return this.libelleProperty().get();
	}
	

	public final void setLibelle(final String libelle) {
		this.libelleProperty().set(libelle);
	}
	

	public final IntegerProperty quantiteProperty() {
		return this.quantite;
	}
	

	public final int getQuantite() {
		return this.quantiteProperty().get();
	}
	

	public final void setQuantite(final int quantite) {
		this.quantiteProperty().set(quantite);
	}
	

	public final ObjectProperty<Date> DateDeLivraisonProperty() {
		return this.DateDeLivraison;
	}
	

	public final Date getDateDeLivraison() {
		return this.DateDeLivraisonProperty().get();
	}
	

	public final void setDateDeLivraison(final Date DateDeLivraison) {
		this.DateDeLivraisonProperty().set(DateDeLivraison);
	}
	

	public final DoubleProperty prixProperty() {
		return this.prix;
	}
	

	public final double getPrix() {
		return this.prixProperty().get();
	}
	

	public final void setPrix(final double prix) {
		this.prixProperty().set(prix);
	}
	

	public final StringProperty FournisseurProperty() {
		return this.Fournisseur;
	}
	

	public final String getFournisseur() {
		return this.FournisseurProperty().get();
	}
	

	public final void setFournisseur(final String Fournisseur) {
		this.FournisseurProperty().set(Fournisseur);
	}

	
	 
	 
	 
	 
	
}
