package gestionDeStock.controller;


import java.net.URL;
import java.util.ResourceBundle;
import gestionDeStock.model.StatistiquesModel;
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
	
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colQte.setCellValueFactory((TableColumn.CellDataFeatures<StatistiquesModel, String> cellData) -> cellData.getValue().qteProperty().asString());
		colMat.setCellValueFactory((TableColumn.CellDataFeatures<StatistiquesModel, String> cellData) -> cellData.getValue().matProperty());
	}
}
