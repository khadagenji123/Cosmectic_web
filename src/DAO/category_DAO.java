package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Image;

public class category_DAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection myConn;
	
	public category_DAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	
	public List<Image> getImageSkincare() throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,cost,sale,old_prime from skincare";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int id = myRs.getInt("id");
				 String link = myRs.getString("image");
				 String title = myRs.getString("title");
				 float cost = myRs.getFloat("cost");
				 float sale = myRs.getFloat("sale");
				 float old_prime = myRs.getFloat("old_prime");
				 Image image = new Image(id,link,title,cost,sale,old_prime);
				 images.add(image);
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}
	public List<Image> getImageMakeup() throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,cost,sale,old_prime from makeup";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int id = myRs.getInt("id");
				 String link = myRs.getString("image");
				 String title = myRs.getString("title");
				 float cost = myRs.getFloat("cost");
				 float sale = myRs.getFloat("sale");
				 float old_prime = myRs.getFloat("old_prime");
				 Image image = new Image(id,link,title,cost,sale,old_prime);
				 images.add(image);
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}
	
	public List<Image> getImageBodycare() throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,cost,sale,old_prime from bodycare";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int id = myRs.getInt("id");
				 String link = myRs.getString("image");
				 String title = myRs.getString("title");
				 float cost = myRs.getFloat("cost");
				 float sale = myRs.getFloat("sale");
				 float old_prime = myRs.getFloat("old_prime");
				 Image image = new Image(id,link,title,cost,sale,old_prime);
				 images.add(image);
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}
	
	public List<Image> getImageForman() throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,cost,sale,old_prime from forman";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int id = myRs.getInt("id");
				 String link = myRs.getString("image");
				 String title = myRs.getString("title");
				 float cost = myRs.getFloat("cost");
				 float sale = myRs.getFloat("sale");
				 float old_prime = myRs.getFloat("old_prime");
				 Image image = new Image(id,link,title,cost,sale,old_prime);
				 images.add(image);
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}
	
}
