package com.connector;

import java.io.IOException;
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CRUD.Delete_values;
import CRUD.Insert_Values;
import CRUD.Read_Values;
import CRUD.RecoverPatients;

public class JDBCServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String serialNumber = request.getParameter("slno");
		String emailId = request.getParameter("emailid");
		String userName = request.getParameter("username");
		String mobile = request.getParameter("mobile");
		
		 PrintWriter out = response.getWriter();

		
		Insert_Values insert = new Insert_Values();
		try {
			boolean valueInserted = insert.insert_values(serialNumber, userName, emailId, mobile);
			
			if(!valueInserted) {
				
				out.println (
		                  "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
		                      "http://www.w3.org/TR/html4/loose.dtd\">\n" +
		                  "<html> \n" +
		                    "<head> \n" +
		                      "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
		                        "charset=ISO-8859-1\"> \n" +
		                      "<title> MYConnection  </title> \n" +
		                    "</head> \n" +
		                    "<body> <div align='center'> \n" +
		                      "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
		                        "Cannot insert SLNO: " + serialNumber + " since it already exists <br>" +
		                    "</font></body> \n" +
		                  "</html>" 
		                ); 
				return;
			}
			
			
			out.println (
	                  "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
	                      "http://www.w3.org/TR/html4/loose.dtd\">\n" +
	                  "<html> \n" +
	                    "<head> \n" +
	                      "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
	                        "charset=ISO-8859-1\"> \n" +
	                      "<title> MYConnection  </title> \n" +
	                    "</head> \n" +
	                    "<body> <div align='center'> \n" +
	                      "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
	                        "SLNO: " + serialNumber + " <br> " + 
	                        "User Name:" + userName +
	                 
	                    "</font></body> \n" +
	                  "</html>" 
	                ); 
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		 
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
                  String serialNumber = request.getParameter("slno");

		           Read_Values readValue = new Read_Values(); 
		           User_Bean userBean = readValue.getUserBean(serialNumber);
		           
		           
                   Delete_values delete = new Delete_values();
                   boolean isdeletedRecord =  delete.canDeleteValue(serialNumber);
                   PrintWriter out = response.getWriter();

                   if(!isdeletedRecord) {
                	   out.println (
          	                  "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
          	                      "http://www.w3.org/TR/html4/loose.dtd\">\n" +
          	                  "<html> \n" +
          	                    "<head> \n" +
          	                      "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
          	                        "charset=ISO-8859-1\"> \n" +
          	                      "<title> MYConnection  </title> \n" +
          	                    "</head> \n" +
          	                    "<body> <div align='center'> \n" +
          	                      "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
          	                        " SlNo not found. <br> "+
          	                 
          	                    "</font></body> \n" +
          	                  "</html>" 
          	                );
                	   return;
                   }
                 
                 
     	        out.println (
     	                  "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
     	                      "http://www.w3.org/TR/html4/loose.dtd\">\n" +
     	                  "<html> \n" +
     	                    "<head> \n" +
     	                      "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
     	                        "charset=ISO-8859-1\"> \n" +
     	                      "<title> MYConnection  </title> \n" +
     	                    "</head> \n" +
     	                    "<body> <div align='center'> \n" +
     	                      "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
     	                        "SL No:" + serialNumber + " is a recovered patient. With great response to the treatments. <br> " + 
     	                        "UserName:" + userBean.getUser_name() +
     	                 
     	                    "</font></body> \n" +
     	                  "</html>" 
     	                );
     	        
     	     RecoverPatients  updateDatabase =new RecoverPatients();
     	     updateDatabase.addRecoveredPatient(userBean);

	}
}
	
