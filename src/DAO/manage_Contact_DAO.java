package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.Contact;

public class manage_Contact_DAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection myConn;
	
	public manage_Contact_DAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	protected void connect() throws SQLException {
		if(myConn==null || myConn.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
		}
		myConn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	private void close(Connection myConn, Statement myStm, ResultSet myRs) throws SQLException {
		try {
			if(myConn!=null && !myConn.isClosed()) {
				myConn.close();
			}
			if(myStm!=null && !myStm.isClosed()) {
				myStm.close();
			}
			if(myRs!=null && !myRs.isClosed()) {
				myRs.close();
			}
		}
		catch(Exception e) {
			throw new SQLException(e);
		}
	}
	
	public List<Contact> getContact() throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		List<Contact> concatenations = new ArrayList<>();
		try {
			connect();
			String sql = "select email,name,subject,massage from contact";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 String email = myRs.getString("email");
				 String name = myRs.getString("name");
				 String subject = myRs.getString("subject");
				 String massage = myRs.getString("massage");
				 Contact contact = new Contact(name, email, subject, massage);
				 concatenations.add(contact);
			}
			return concatenations;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}
}
