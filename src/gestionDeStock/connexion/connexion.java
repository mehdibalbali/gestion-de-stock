package gestionDeStock.connexion;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class connexion {
   
	private Connection con;
    
	public Connection connect(){
        if(con == null){
            MysqlDataSource db = new MysqlDataSource();
            db.setDatabaseName("GestionDeStock");
            db.setUser("root");
            db.setPassword("");
            try {
                con = db.getConnection();
            } catch (SQLException e) {
            }
        }
        return con;
    }
    
}
