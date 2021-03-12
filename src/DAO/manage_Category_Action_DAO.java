package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Image;

public class manage_Category_Action_DAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection myConn;
	
	public manage_Category_Action_DAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	
	public void deleteProduct(int id, String category) throws SQLException {
		PreparedStatement myStm = null;
		try {
			connect();
			String sql = "delete from "+ category +" where id=?";
			myStm = myConn.prepareStatement(sql);
			myStm.setInt(1, id);
			myStm.execute();
		}
		finally{
			close(myConn,myStm,null);
		}
	}

	public Image loadProduct(int theId, String category) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		Image image = null;
		try {
			connect();
			String sql = "select id,image,title,description,cost,sale,old_prime"+
						" from "+category;
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int id = myRs.getInt("id");
				 String link = myRs.getString("image");
				 String title = myRs.getString("title");
				 String description = myRs.getString("description");
				 float cost = myRs.getFloat("cost");
				 float sale = myRs.getFloat("sale");
				 float old_prime = myRs.getFloat("old_prime");
				 if(theId == id) {
					 image = new Image(id,link,title,description,cost,sale,old_prime);
					 break;
				 }
			}
			return image;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}

	public void updateProduct(Image image,String category) throws SQLException {
		PreparedStatement myStm = null;
		
		try {
			connect();
			String sql = "update "+category+
					" set image=?, title=?, description=?, cost=?, sale=?, old_prime=?"+
					" where id=?";	
			myStm = myConn.prepareStatement(sql);
			
			// set params
			myStm.setString(1, image.getLink());
			myStm.setString(2, image.gettitle());
			myStm.setString(3, image.getDescription());
			myStm.setFloat(4, image.getCost());
			myStm.setFloat(5, image.getSale());
			myStm.setFloat(6, image.getOld_prime());
			myStm.setInt(7, image.getId());
			
			myStm.execute();
		}
		finally {
			close(myConn,myStm,null);
		}
	}
	
	public void addProduct(Image image, String category) throws SQLException {
		PreparedStatement myStm =null;
		
		try {
			connect();
			String sql = "insert into "+category+
					" (image,title,description,cost,sale,old_prime)"+
					" values(?,?,?,?,?,?)";
					
			myStm = myConn.prepareStatement(sql);
			myStm.setString(1, image.getLink());
			myStm.setString(2, image.gettitle());
			myStm.setString(3, image.getDescription());
			myStm.setFloat(4, image.getCost());
			myStm.setFloat(5, image.getSale());
			myStm.setFloat(6, image.getOld_prime());
			
			myStm.execute();
			
		}
		finally {
			close(myConn,myStm,null);
		}
	}
}
