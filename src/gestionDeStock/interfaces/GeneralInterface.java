package gestionDeStock.interfaces;

import gestionDeStock.model.GeneralModel;
import javafx.collections.ObservableList;

/**
 * @author GeekDjerbien
 *
 */
public interface GeneralInterface {

	ObservableList<GeneralModel> getAll();
	void insert(GeneralModel m);
	void update(GeneralModel m);
	void delete(GeneralModel m);
	ObservableList<GeneralModel> Recherche(String x);

}
