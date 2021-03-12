package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Account;

public class Login_Signup {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection myConn;
	
	public Login_Signup(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
			myConn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
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
	
	public int loginAccount(Account theAccount) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		Statement myStm_email = null;
		ResultSet myRs_email = null;
		try {
			connect();
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery("select*from User");
			
			while(myRs.next()) {
				int checkuser = myRs.getInt("checkuser");
				String username = myRs.getString("username");
				String password = myRs.getString("password");
				if(theAccount.getUsername().equals(username) &&
						theAccount.getPassword().equals(password)) {
					if(checkuser==1) {
						return 1;
					}
					return 2;
				}
			}
			
			myStm_email = myConn.createStatement();
			myRs_email = myStm_email.executeQuery("select*from userEmail");
			
			while(myRs_email.next()) {
				String  email = myRs_email.getString("email");
				String password = myRs_email.getString("password");
				if(theAccount.getUsername().equals(email) && theAccount.getPassword().equals(password)) {
					return 2;
				}
			}
			
			return 0;
		}
		finally{
			close(myConn,myStm,myRs);
			close(myConn,myStm_email,myRs_email);
		}
	}

	public void signupAccountByPhone(Account theAccount) throws SQLException {
		PreparedStatement myPStm = null;
		try {
			connect();
			String sql = "insert into User "
						+"values(?,?,?,?,?,?,?,?)";
			
			myPStm = myConn.prepareStatement(sql);
			myPStm.setString(1, theAccount.getUsername());
			myPStm.setString(2, theAccount.getPassword());
			myPStm.setString(3, theAccount.getName());
			myPStm.setString(4, theAccount.getBirthday());
			myPStm.setString(5, theAccount.getGender());
			myPStm.setString(6, theAccount.getAddress());
			myPStm.setInt(7, theAccount.getCheckuser());
			myPStm.setString(8, theAccount.getNumber_phone());
			
			myPStm.execute();
			
		}
		finally {
			close(myConn, myPStm, null);
		}
	}

	public void signupAccountByEmail(Account theAccount) throws SQLException {
		PreparedStatement myPStm = null;
		
		try {
			connect();
			String sql = "insert into userEmail "
						+"values(?,?,?,?,?,?,?)";
			
			myPStm = myConn.prepareStatement(sql);
			myPStm.setString(1, theAccount.getEmail());
			myPStm.setString(2, theAccount.getPassword());
			myPStm.setString(3, theAccount.getNumber_phone());
			myPStm.setString(4, theAccount.getBirthday());
			myPStm.setString(5, theAccount.getName());
			myPStm.setString(6, theAccount.getGender());
			myPStm.setString(7, theAccount.getAddress());
			
			myPStm.execute();
			
		}
		finally {
			close(myConn,myPStm,null);
		}
		
	}
	
}
