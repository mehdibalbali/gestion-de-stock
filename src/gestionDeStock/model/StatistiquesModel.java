package gestionDeStock.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class StatistiquesModel {
	private final StringProperty mat;
	private final IntegerProperty qte;
	private final StringProperty lib;
	
	
	public StatistiquesModel(String mat, int qte,String lib) {
		this.mat =  new SimpleStringProperty();
		this.qte =  new SimpleIntegerProperty();
		this.lib =  new SimpleStringProperty();
	}
	
	
	public StatistiquesModel() {
		this.mat =  new SimpleStringProperty();
		this.qte =  new SimpleIntegerProperty();
		this.lib =  new SimpleStringProperty();
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
	


	public final IntegerProperty qteProperty() {
		return this.qte;
	}
	


	public final int getQte() {
		return this.qteProperty().get();
	}
	


	public final void setQte(final int qte) {
		this.qteProperty().set(qte);
	}


	public final StringProperty libProperty() {
		return this.lib;
	}
	


	public final String getLib() {
		return this.libProperty().get();
	}
	


	public final void setLib(final String lib) {
		this.libProperty().set(lib);
	}
	
	
	
	
	
}
