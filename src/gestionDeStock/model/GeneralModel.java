
package gestionDeStock.model;


import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GeneralModel {
	private final StringProperty matricule = new SimpleStringProperty();
	private final StringProperty libelle = new SimpleStringProperty();
	private StringProperty quantite =new SimpleStringProperty();
	private  ObjectProperty<Date> DateDeLivraison = new SimpleObjectProperty<>();
	private StringProperty prix =new SimpleStringProperty();
	private final StringProperty Fournisseur = new SimpleStringProperty();
	private String formatdate;
	
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
	

	public final StringProperty quantiteProperty() {
		return this.quantite;
	}
	

	public final String getQuantite() {
		return this.quantiteProperty().get();
	}
	

	public final void setQuantite(final String quantite) {
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
	

	public final StringProperty prixProperty() {
		return this.prix;
	}
	

	public final String getPrix() {
		return this.prixProperty().get();
	}
	

	public final void setPrix(final String prix) {
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

	
	 
	 
	 public String getFormatDate() {
	        Date date = getDateDeLivraison();
	        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	        String format = df.format(date);
	        return format;
	    }

	    public void setFormatdate(String formatdate) {
	        this.formatdate = formatdate;
	    }

	 
	
}
