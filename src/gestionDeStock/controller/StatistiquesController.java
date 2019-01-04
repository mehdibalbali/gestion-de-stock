package gestionDeStock.controller;


import java.net.URL;
import java.util.ResourceBundle;

import gestionDeStock.implementations.implStatistiques;
import gestionDeStock.interfaces.StatistiquesInterface;
import gestionDeStock.model.StatistiquesModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StatistiquesController  implements Initializable {
	@FXML
	private TableView tableDetail;
	@FXML
	private TableColumn<StatistiquesModel, String> colQte;
	@FXML
	private TableColumn<StatistiquesModel, String> colMat;
	@FXML
	 private StackedBarChart bar;
	 @FXML
	 private NumberAxis barY;
	 @FXML
	 private CategoryAxis barX;
	 @FXML
	 private Button btnActualiser;
	StatistiquesInterface crudStatisitiques = new implStatistiques();
	ObservableList<Object> dataGraphe = FXCollections.observableArrayList();
	ObservableList<StatistiquesModel> details = FXCollections.observableArrayList();
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colQte.setCellValueFactory((TableColumn.CellDataFeatures<StatistiquesModel, String> cellData) -> cellData.getValue().qteProperty().asString());
		colMat.setCellValueFactory((TableColumn.CellDataFeatures<StatistiquesModel, String> cellData) -> cellData.getValue().matProperty());
		 affichage();
	}
	 private void affichage(){
	        details = crudStatisitiques.getMatricule();
	        dataGraphe = crudStatisitiques.afficheMatricule();
	        bar.setData(dataGraphe);
	        tableDetail.setItems(details);
	    }
	 
	@FXML
    private void Actualiser(ActionEvent e){
        bar.setAnimated(true);
        barY.setAnimated(true);
        barX.setAnimated(false);
        affichage();
    }
}
