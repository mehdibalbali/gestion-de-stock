package gestionDeStock.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;

import gestionDeStock.implementations.implGeneral;
import gestionDeStock.interfaces.GeneralInterface;
import gestionDeStock.model.GeneralModel;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class GeneralController implements Initializable{
	   @FXML
	    private Tab tabGS;
	    @FXML
	    private TextField tfmat;
	    @FXML
	    private TextField tflib;
	    @FXML
	    private TextField tfdeal;
	    @FXML
	    private TextField tfprix;
	    @FXML
	    private Spinner<GeneralModel> qte;
	    @FXML
	    private DatePicker dateDelivraison;
	    @FXML
	    private Button btnEnregistrer;
	    @FXML
	    private TableView<GeneralModel> tableData;
	    @FXML
	    private TableColumn<GeneralModel, String> colMat;
	    @FXML
	    private TableColumn<GeneralModel, String> colLib;
	    @FXML
	    private TableColumn<GeneralModel,String > colQte;
	    @FXML
	    private TableColumn<GeneralModel, String> colDeal;
	    @FXML
	    private TableColumn<GeneralModel, String> colPrix;
	    @FXML
	    private TableColumn<GeneralModel, Date> colDate;
	    @FXML
	    private TableColumn colAction;
	    @FXML
	    private TextField chercher;
	    @FXML
	    private Button btnActualiser;
	    @FXML
	    private AnchorPane paneLoadGrafik;
	    GeneralInterface crudData = new implGeneral();
	    private String StatusCode,statusclic;
	    ObservableList<GeneralModel> listData;
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			colMat.setCellValueFactory((TableColumn.CellDataFeatures<GeneralModel, String> celldata)-> celldata.getValue().matriculeProperty());
			colLib.setCellValueFactory((TableColumn.CellDataFeatures<GeneralModel, String> celldata)-> celldata.getValue().libelleProperty());
	    	colPrix.setCellValueFactory((TableColumn.CellDataFeatures<GeneralModel, String> celldata)->  celldata.getValue().prixProperty());
			colDeal.setCellValueFactory((TableColumn.CellDataFeatures<GeneralModel, String> celldata)-> celldata.getValue().FournisseurProperty());
			colQte.setCellValueFactory((TableColumn.CellDataFeatures<GeneralModel,String> celldata)-> celldata.getValue().quantiteProperty());
			colDate.setCellValueFactory(new PropertyValueFactory("formatDate"));
          colAction.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Object, Boolean>,
            ObservableValue<Boolean>>() {
        @Override
        public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Object, Boolean> p) {
            return new SimpleBooleanProperty(p.getValue() != null);
        }
    });

    colAction.setCellFactory(new Callback<TableColumn<Object, Boolean>, TableCell<Object, Boolean>>() {
        @Override
        public TableCell<Object, Boolean> call(TableColumn<Object, Boolean> p) {
            return new ButtonCell(tableData);
        }
    });
    listData = FXCollections.observableArrayList();
    StatusCode = "0";
    statusclic = "0";
    tampilData();
    tableData.getSelectionModel().clearSelection();
       afficheStatistiques();
} 


private void dialog(Alert.AlertType alertType,String s){
    Alert alert = new Alert(alertType,s);
    alert.initStyle(StageStyle.UTILITY);
    alert.setTitle("informations");
    alert.showAndWait();
}

private void clear(){
    tfmat.clear();
    tflib.clear();
    tfdeal.clear();
    tfprix.clear();
    qte.getEditor().setText("0");
    chercher.clear();
  
    StatusCode = "0";
}

private void tampilData(){
    listData = crudData.getAll();
    tableData.setItems(listData);
}



@FXML
private void save(ActionEvent event) {
    GeneralModel m = new GeneralModel();
    m.setMatricule(tfmat.getText());
    m.setLibelle(tflib.getText());
    m.setFournisseur(tfdeal.getText());
    m.setPrix(tfprix.getText());
    m.setQuantite(qte.getEditor().getText());
    m.setDateDeLivraison(Date.valueOf(dateDelivraison.getValue()));
    if (StatusCode.equals("0")) {
        crudData.insert(m);
    }else{
        crudData.update(m);
    }
    dialog(Alert.AlertType.INFORMATION, "Donn�es sauvegard�es");
    tampilData();
    clear();
    
}

@FXML
private void klikTableData(MouseEvent event) {
    if (statusclic.equals("1")) {
        StatusCode = "1";
        try {
            GeneralModel clic = tableData.getSelectionModel().getSelectedItems().get(0);
            tfmat.setText(clic.getMatricule());
            tflib.setText(clic.getLibelle());
            qte.getEditor().setText(clic.getQuantite());
            tfprix.setText(clic.getPrix());
            tfdeal.setText(clic.getFournisseur());
            dateDelivraison.setValue(LocalDate.parse(clic.getDateDeLivraison().toString()));
        } catch (Exception e) {
        }
    }
    
}

@FXML
private void rechercher(KeyEvent event) {
    listData = crudData.Recherche(chercher.getText());
    tableData.setItems(listData);
}

@FXML
private void refresh(ActionEvent event) {
    clear();
    tampilData();
   
}

private class ButtonCell extends TableCell<Object, Boolean> {
    final Hyperlink cellButtonDelete = new Hyperlink("Supprimer");
    final Hyperlink cellButtonEdit = new Hyperlink("Editer");
    final HBox hb = new HBox(cellButtonDelete,cellButtonEdit);
    ButtonCell(final TableView tblView){
        hb.setSpacing(4);
        
        cellButtonDelete.setOnAction((ActionEvent t) -> {
            statusclic = "1";
            int row = getTableRow().getIndex();
            tableData.getSelectionModel().select(row);
            klikTableData(null);
            GeneralModel m = new GeneralModel();
            m.setMatricule(tfmat.getText());
            crudData.delete(m);
            tampilData();
            clear();
            dialog(Alert.AlertType.INFORMATION, "L'article a �t� bien supprim�es");
            statusclic = "0";
            StatusCode = "0";
        });
        
        cellButtonEdit.setOnAction((ActionEvent event) -> {
            statusclic = "1";
            int row = getTableRow().getIndex();
            tableData.getSelectionModel().select(row);
            klikTableData(null);
            statusclic = "0";
        });
    }

    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if(!empty){
            setGraphic(hb);
        }else{
            setGraphic(null);
        }
    }

}
	private void afficheStatistiques(){
		try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent p = fxmlLoader.load(getClass().getResourceAsStream("/gestionDeStock/view/Statistiques.fxml"));
            paneLoadGrafik.getChildren().add(p);   
        } catch (IOException e) {
        }   
	}
}
