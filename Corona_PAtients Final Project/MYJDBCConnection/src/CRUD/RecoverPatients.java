package CRUD;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connector.DB_Connection;
import com.connector.User_Bean;
	public class RecoverPatients {
		
		
		
	public void addRecoveredPatient(User_Bean userBean) 
	{
		try{
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
	    String query="insert into recovered(sl_no,user_name) values (?,?)";
	    PreparedStatement ps=connection.prepareStatement(query);
		 ps.setString(1, userBean.getSl_no());
		 ps.setString(2, userBean.getUser_name());
		 ps.executeUpdate();
	
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
} 


