package gestionDeStock.implementations;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import gestionDeStock.connexion.connexion;
import gestionDeStock.interfaces.GeneralInterface;
import gestionDeStock.model.GeneralModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class implGeneral implements GeneralInterface{

	connexion c ;
	@Override
	public ObservableList<GeneralModel> getAll() {
		 c = new connexion();
	        ObservableList<GeneralModel> listData = FXCollections.observableArrayList();
	        try {
	            String sql = "select * from articles";
	            ResultSet rs = c.connect().createStatement().executeQuery(sql);
	            while (rs.next()) {   
	                GeneralModel m = new GeneralModel();
	                m.setMatricule(rs.getString(1));
	                m.setLibelle(rs.getString(2));
	                m.setFournisseur(rs.getString(4));
	                m.setDateDeLivraison(rs.getDate(6));
	                listData.add(m);
	            }
	        } catch (Exception ex) {
	            Logger.getLogger(implGeneral.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return listData;
	}

	
	@Override
	public void insert(GeneralModel m) {
		 c = new connexion();
	        PreparedStatement ps;
	        try {
	            ps = c.connect().prepareStatement("insert into articles values(?,?,?,?)");
	            ps.setString(1, m.getMatricule());
	            ps.setString(2, m.getLibelle());
	            ps.setString(5, m.getFournisseur());
	            ps.setDate(6, (Date) m.getDateDeLivraison());
	            ps.execute();
	        } catch (Exception e) {
	            Logger.getLogger(implGeneral.class.getName()).log(Level.SEVERE, null, e);
	        }
	}

	@Override
	public void update(GeneralModel m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(GeneralModel m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ObservableList<GeneralModel> Recherche(String x) {
		 c = new connexion();
	        ObservableList<GeneralModel> listData = FXCollections.observableArrayList();
	        try {
	            String sql = "select * from articles where nom like '%"+x+"%'";
	            ResultSet rs = c.connect().createStatement().executeQuery(sql);
	            while (rs.next()) {   
	                GeneralModel m = new GeneralModel();
	                m.setMatricule(rs.getString(1));
	                m.setLibelle(rs.getString(2));
	                m.setFournisseur(rs.getString(4));
	                m.setDateDeLivraison(rs.getDate(6));
	                listData.add(m);
	            }
	        } catch (Exception ex) {
	            Logger.getLogger(implGeneral.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return listData;
	}



}
