package gestionDeStock.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class StatistiquesModel {
	private final StringProperty mat;
	private final StringProperty qte;
	
	
	
	public StatistiquesModel(String mat, int  qte) {
		
		this.mat = new SimpleStringProperty();
		this.qte = new SimpleStringProperty();
	}
	
public StatistiquesModel() {
		
		this.mat = new SimpleStringProperty();
		this.qte = new SimpleStringProperty();
	}

	public final StringProperty matProperty() {
		return this.mat;
	}
	
	public final String getMat() {
		return this.matProperty().get();
	}
	
	public final void setMat(final String mat) {
		this.matProperty().set(mat);
	}
	
	public final StringProperty qteProperty() {
		return this.qte;
	}
	
	public final String getQte() {
		return this.qteProperty().get();
	}
	
	public final void setQte(final String qte) {
		this.qteProperty().set(qte);
	}
	
	
	
}
