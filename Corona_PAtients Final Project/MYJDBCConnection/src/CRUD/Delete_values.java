package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connector.DB_Connection;
import com.connector.User_Bean;


public class Delete_values {
public boolean canDeleteValue(String sl_no){
	DB_Connection obj_DB_Connection=new DB_Connection();

	try {
		Connection connection = obj_DB_Connection.get_connection();
		
	    Read_Values readValue = new Read_Values();
	    User_Bean userBean = readValue.getUserBean(sl_no);
	    
		if(userBean==null || userBean.getSl_no()==null) {
			return false;
		}
		
	 String querry="delete from users where sl_no=?";
	 PreparedStatement ps =connection.prepareStatement(querry);		
	 ps.setString(1, sl_no);
	 ps.executeUpdate();
	 return true;
	} catch (SQLException | ClassNotFoundException ex) {
	  System.out.println("Some database exception"+ex);
	  return false;
	}
	}
}