package gestionDeStock.implementations;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import gestionDeStock.connexion.connexion;



public class implLogin {
	connexion c ;
	
	public Boolean log(String x, String y) {
		 c = new connexion();
		 boolean v =false;
		try {
			 String sql = "select * from user where (username like '"+x+"')and (password like '"+y+"')";
	         ResultSet rs = c.connect().createStatement().executeQuery(sql);
	         int rowCount = 0;
	         while ( rs.next() )
	         {
	             
	             rowCount++;
	             
	         }
	         
	         if(rowCount==1) {
	        	 System.out.println("login succses");
	        	 v= true;
	         }else {
	        	 System.out.println("password or login are wrong !!");
	        	 v= false;
	         }
		}catch (Exception ex) {
            Logger.getLogger(implLogin.class.getName()).log(Level.SEVERE, null, ex);
		}
		return v;
	}
}
