package CRUD;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connector.DB_Connection;
import com.connector.User_Bean;
	public class Insert_Values {
		
	public boolean insert_values(String sl_no,String user_name,String email,String mobile) throws ClassNotFoundException, SQLException
	{
		 DB_Connection obj_DB_Connection=new DB_Connection();
		 Connection connection=obj_DB_Connection.get_connection();
		 
		 Read_Values readValue = new Read_Values();
		    User_Bean userBean = readValue.getUserBean(sl_no);
		    
			if(userBean!=null && userBean.getSl_no()!=null) {
				return false;
			}
		
		String query="insert into student.users(sl_no,user_name,email_id,mobile) values(?,?,?,?)";
	
		PreparedStatement ps =connection.prepareStatement(query);
	
		 ps.setString(1, sl_no);
		 ps.setString(2, user_name);
		 ps.setString(3, email);
		 ps.setString(4, mobile);
		 ps.executeUpdate();
		 
		 return true;
	
	}
	}


