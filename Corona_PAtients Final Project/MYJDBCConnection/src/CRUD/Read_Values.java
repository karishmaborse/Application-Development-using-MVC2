package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.connector.DB_Connection;
import com.connector.User_Bean;
public class Read_Values {

	public User_Bean getUserBean(String sl_no) 
	{
		 DB_Connection obj_DB_Connection=new DB_Connection();
		 
		 try {
		 Connection connection=obj_DB_Connection.get_connection();
		
		String query="select * from student.users where sl_no=?";
	
		 PreparedStatement ps =connection.prepareStatement(query);
	
		 ps.setString(1, sl_no);
		 ResultSet rs = ps.executeQuery();
		 
		 User_Bean user_bean = new User_Bean();
		 while(rs.next()) {
			user_bean.setUser_name( rs.getString("user_name"));
			user_bean.setEmail(rs.getString("email_id"));
			user_bean.setMobile(rs.getString("mobile"));
			user_bean.setSl_no(rs.getString("sl_no"));
		 }
		return user_bean;
		 }
		 catch(Exception ex) {
			 System.err.println(ex);
			 return new User_Bean();
		 }
	
	}
}