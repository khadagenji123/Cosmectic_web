package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Image;

public class detail_Product_DAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection myConn;
	
	public detail_Product_DAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	
	public List<Image> getProductImage(int theId) throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,description,cost,sale,old_prime"+
						" from pictures_index";
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
					 Image image = new Image(id,link,title,description,cost,sale,old_prime);
					 images.add(image);
					 break;
				 }
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}
	
	public List<Image> getBestSelling(int theId) throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,description,cost,sale,old_prime from best_selling";
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
					 Image image = new Image(id,link,title,description,cost,sale,old_prime);
					 images.add(image);
					 break;
				 }
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}
	
	public List<Image> getNewProduct(int theId) throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,description,cost,sale,old_prime from new_products";
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
					 Image image = new Image(id,link,title,description,cost,sale,old_prime);
					 images.add(image);
					 break;
				 }
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}

	public List<Image> getSkinCare(int theId) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,description,cost,sale,old_prime from skincare";
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
					 Image image = new Image(id,link,title,description,cost,sale,old_prime);
					 images.add(image);
					 break;
				 }
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}

	public List<Image> getBodyCare(int theId) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,description,cost,sale,old_prime from bodycare";
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
					 Image image = new Image(id,link,title,description,cost,sale,old_prime);
					 images.add(image);
					 break;
				 }
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}

	public List<Image> getMakeUp(int theId) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,description,cost,sale,old_prime from makeup";
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
					 Image image = new Image(id,link,title,description,cost,sale,old_prime);
					 images.add(image);
					 break;
				 }
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}

	public List<Image> getForMan(int theId) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,description,cost,sale,old_prime from forman";
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
					 Image image = new Image(id,link,title,description,cost,sale,old_prime);
					 images.add(image);
					 break;
				 }
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}

	public List<Image> getProductUser(int theId) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,description,cost,sale,old_prime from product_user";
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
					 Image image = new Image(id,link,title,description,cost,sale,old_prime);
					 images.add(image);
					 break;
				 }
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}
	
	public List<Image> getNivea(int theId) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,description,cost,sale,old_prime from nivea";
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
					 Image image = new Image(id,link,title,description,cost,sale,old_prime);
					 images.add(image);
					 break;
				 }
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}
	
	public List<Image> getLoreal(int theId) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,description,cost,sale,old_prime from loreal";
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
					 Image image = new Image(id,link,title,description,cost,sale,old_prime);
					 images.add(image);
					 break;
				 }
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}
	
	public List<Image> getNeutrogena(int theId) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,description,cost,sale,old_prime from neutrogena";
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
					 Image image = new Image(id,link,title,description,cost,sale,old_prime);
					 images.add(image);
					 break;
				 }
			}
			return images;
		}
		finally {
			close(myConn,myStm,myRs);
		}
	}
	
}
