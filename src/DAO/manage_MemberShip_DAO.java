package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Account;


public class manage_MemberShip_DAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection myConn;
	
	public manage_MemberShip_DAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	
	public List<Account> getUser() throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		List<Account> accounts = new ArrayList<>();
		try {
			connect();
			String sql = "select username,password,name,birthday,gender,address,number_phone,checkuser from User";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 String username = myRs.getString("username");
				 String password = myRs.getString("password");
				 String name = myRs.getString("name");
				 String birthday = myRs.getString("birthday");
				 String gender = myRs.getString("gender");
				 String address = myRs.getString("address");
				 int checkuser = myRs.getInt("checkuser");
				 String number_phone = myRs.getString("number_phone");
				 Account theAccount = new Account(username, password, name, birthday, gender, address, number_phone, checkuser);
				 
				 accounts.add(theAccount);
			}
			return accounts;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}
	
	public List<Account> getUserEmail() throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		List<Account> eaccounts = new ArrayList<>();
		try {
			connect();
			String sql = "select email,password,name,birthday,gender,address,number_phone from userEmail";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 String email = myRs.getString("email");
				 String password = myRs.getString("password");
				 String name = myRs.getString("name");
				 String birthday = myRs.getString("birthday");
				 String gender = myRs.getString("gender");
				 String address = myRs.getString("address");
				 String number_phone = myRs.getString("number_phone");
				 Account theAccount = new Account(email, password, name, birthday, gender, address, number_phone);
				 
				 eaccounts.add(theAccount);
			}
			return eaccounts;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}
}
