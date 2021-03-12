package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contact;

public class partOfContact {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection myConn;
	
	public partOfContact(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		super();
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

	public void contactCompany(Contact contact) throws SQLException {
		PreparedStatement myPStm = null;
		
		try {
			connect();
			String sql = "insert into contact "
						+"(email,name,subject,massage) "
						+"values(?,?,?,?)";
			
			myPStm = myConn.prepareStatement(sql);
			myPStm.setString(1, contact.getEmail());
			myPStm.setString(2, contact.getName());
			myPStm.setString(3, contact.getSubject());
			myPStm.setString(4, contact.getMessage());
			
			myPStm.execute();
		}
		finally {
			close(myConn, myPStm, null);
		}
		
	}

	public List<String> getName() {
		Statement myStm = null;
		ResultSet myRs = null;
		List<String> names = new ArrayList<>();
		try {
			connect();
			String sql = "select name from contact";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 names.add(myRs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return names;
	}
		
}
