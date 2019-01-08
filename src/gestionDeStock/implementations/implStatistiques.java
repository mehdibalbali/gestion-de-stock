package gestionDeStock.implementations;

import java.sql.ResultSet;
import gestionDeStock.connexion.connexion;
import gestionDeStock.interfaces.StatistiquesInterface;
import gestionDeStock.model.StatistiquesModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class implStatistiques implements StatistiquesInterface{
	connexion c ;
	
	@Override
	public ObservableList<StatistiquesModel> getMatricule() {
		c =new connexion();
		 ObservableList<StatistiquesModel> listData= FXCollections.observableArrayList();
		 try {
	            String sql = "select distinct(matricule) as mat, "
	                        + "sum(quantit�) as nombre,"
	                        +"libelle as lib "
	                        + "from articles "
	                        + "group by matricule "
	                        + "order by nombre DESC";
	            ResultSet rs = c.connect().createStatement().executeQuery(sql);
	            while (rs.next()) {       
	                StatistiquesModel m = new StatistiquesModel();
	                m.setMat(rs.getString("mat"));
	                m.setQte(rs.getInt("nombre"));
	                m.setLib(rs.getString("lib"));
	                listData.add(m);
	            }
	        } catch (Exception e) {
	        }
		 
		 
		 
		 return listData;
		
	}

	@Override
	public ObservableList<Object> afficheMatricule() {
		 ObservableList<Object> barCar = FXCollections.observableArrayList();
	        try {
	        	c =new connexion();
	              String sql = "select distinct(libelle) as mat, "
                        + "sum(quantit�) as nombre "
                        + "from articles "
                        + "group by matricule "
                        + "order by matricule";
	            ResultSet rs = c.connect().createStatement().executeQuery(sql);
	            while (rs.next()) {       
	                XYChart.Series<String, Integer> aSeries = new XYChart.Series<>();
	                aSeries.getData().add(new XYChart.Data(rs.getString("mat"), rs.getInt("nombre")));
	                barCar.add(aSeries);
	            }
	        } catch (Exception e) {
	        }
	        return barCar;
	}

}
