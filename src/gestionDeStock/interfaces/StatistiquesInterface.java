/**
 * 
 */
package gestionDeStock.interfaces;
import gestionDeStock.model.StatistiquesModel;
import javafx.collections.ObservableList;
/**
 * @author GeekDjerbien
 *
 */
public interface StatistiquesInterface {
	ObservableList<StatistiquesModel> getMatricule();
	ObservableList<Object> afficheMatricule();
}
