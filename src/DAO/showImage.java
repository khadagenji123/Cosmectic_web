package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Image;

public class showImage {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection myConn;
	
	public showImage(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	
	public List<Image> getImage() throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql = "select id,image,title,cost,sale,old_prime from pictures_index";
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

	public List<Image> getSerachProduct(String search) throws SQLException {
		Statement myStm_index = null;
		ResultSet myRs_index = null;
		
		Statement myStm_makeup = null;
		ResultSet myRs_makeup = null;
		
		Statement myStm_bestselling = null;
		ResultSet myRs_bestselling = null;
		
		Statement myStm_newproduct = null;
		ResultSet myRs_newproduct = null;
		
		Statement myStm_skincare = null;
		ResultSet myRs_skincare = null;
		
		Statement myStm_bodycare = null;
		ResultSet myRs_bodycare = null;
		
		Statement myStm_forman = null;
		ResultSet myRs_forman = null;
		
		Statement myStm_nivea = null;
		ResultSet myRs_nivea = null;
		
		Statement myStm_loreal = null;
		ResultSet myRs_loreal = null;
		
		Statement myStm_neutrogena = null;
		ResultSet myRs_neutrogena = null;
		
		
		List<Image> images = new ArrayList<>();
		try {
			connect();
			String sql_index = "select id,image,title,cost,sale,old_prime from pictures_index "
						+"where title like '%"+search+"%'";
			myStm_index = myConn.createStatement();
			myRs_index = myStm_index.executeQuery(sql_index);
			while(myRs_index.next()) {
				int id = myRs_index.getInt("id");
				 String link = myRs_index.getString("image");
				 String title = myRs_index.getString("title");
				 float cost = myRs_index.getFloat("cost");
				 float sale = myRs_index.getFloat("sale");
				 float old_prime = myRs_index.getFloat("old_prime");
				 String category = "pictures-index";
				 Image image = new Image(id,link,title,cost,sale,old_prime,category);
				 images.add(image);
			}
			
			
			String sql_makeup = "select id,image,title,cost,sale,old_prime from makeup "
						+"where title like '%"+search+"%'";
			myStm_makeup = myConn.createStatement();
			myRs_makeup = myStm_makeup.executeQuery(sql_makeup);
			while(myRs_makeup.next()) {
				int id = myRs_makeup.getInt("id");
				 String link = myRs_makeup.getString("image");
				 String title = myRs_makeup.getString("title");
				 float cost = myRs_makeup.getFloat("cost");
				 float sale = myRs_makeup.getFloat("sale");
				 float old_prime = myRs_makeup.getFloat("old_prime");
				 String category = "makeup";
				 Image image = new Image(id,link,title,cost,sale,old_prime,category);
				 images.add(image);
			}
			
			String sql_bestselling = "select id,image,title,cost,sale,old_prime from best_selling "
					+"where title like '%"+search+"%'";
			myStm_bestselling = myConn.createStatement();
			myRs_bestselling = myStm_bestselling.executeQuery(sql_bestselling);
			while(myRs_bestselling.next()) {
				int id = myRs_bestselling.getInt("id");
				 String link = myRs_bestselling.getString("image");
				 String title = myRs_bestselling.getString("title");
				 float cost = myRs_bestselling.getFloat("cost");
				 float sale = myRs_bestselling.getFloat("sale");
				 float old_prime = myRs_bestselling.getFloat("old_prime");
				 String category = "best-selling";
				 Image image = new Image(id,link,title,cost,sale,old_prime,category);
				 images.add(image);
			}
			
			String sql_newproduct = "select id,image,title,cost,sale,old_prime from new_products "
					+"where title like '%"+search+"%'";
			myStm_newproduct = myConn.createStatement();
			myRs_newproduct = myStm_newproduct.executeQuery(sql_newproduct);
			while(myRs_newproduct.next()) {
				int id = myRs_newproduct.getInt("id");
				 String link = myRs_newproduct.getString("image");
				 String title = myRs_newproduct.getString("title");
				 float cost = myRs_newproduct.getFloat("cost");
				 float sale = myRs_newproduct.getFloat("sale");
				 float old_prime = myRs_newproduct.getFloat("old_prime");
				 String category = "new-product";
				 Image image = new Image(id,link,title,cost,sale,old_prime,category);
				 images.add(image);
			}
			
			String sql_skincare = "select id,image,title,cost,sale,old_prime from skincare "
					+"where title like '%"+search+"%'";
			myStm_skincare = myConn.createStatement();
			myRs_skincare = myStm_skincare.executeQuery(sql_skincare);
			while(myRs_skincare.next()) {
				int id = myRs_skincare.getInt("id");
				 String link = myRs_skincare.getString("image");
				 String title = myRs_skincare.getString("title");
				 float cost = myRs_skincare.getFloat("cost");
				 float sale = myRs_skincare.getFloat("sale");
				 float old_prime = myRs_skincare.getFloat("old_prime");
				 String category = "skincare";
				 Image image = new Image(id,link,title,cost,sale,old_prime,category);
				 images.add(image);
			}
			
			String sql_bodycare = "select id,image,title,cost,sale,old_prime from bodycare "
					+"where title like '%"+search+"%'";
			myStm_bodycare = myConn.createStatement();
			myRs_bodycare = myStm_bodycare.executeQuery(sql_bodycare);
			while(myRs_bodycare.next()) {
				int id = myRs_bodycare.getInt("id");
				 String link = myRs_bodycare.getString("image");
				 String title = myRs_bodycare.getString("title");
				 float cost = myRs_bodycare.getFloat("cost");
				 float sale = myRs_bodycare.getFloat("sale");
				 float old_prime = myRs_bodycare.getFloat("old_prime");
				 String category = "bodycare";
				 Image image = new Image(id,link,title,cost,sale,old_prime,category);
				 images.add(image);
			}
			
			String sql_forman = "select id,image,title,cost,sale,old_prime from forman "
					+"where title like '%"+search+"%'";
			myStm_forman = myConn.createStatement();
			myRs_forman = myStm_forman.executeQuery(sql_forman);
			while(myRs_forman.next()) {
				int id = myRs_forman.getInt("id");
				 String link = myRs_forman.getString("image");
				 String title = myRs_forman.getString("title");
				 float cost = myRs_forman.getFloat("cost");
				 float sale = myRs_forman.getFloat("sale");
				 float old_prime = myRs_forman.getFloat("old_prime");
				 String category = "forman";
				 Image image = new Image(id,link,title,cost,sale,old_prime,category);
				 images.add(image);
			}
			
			String sql_nivea = "select id,image,title,cost,sale,old_prime from nivea "
					+"where title like '%"+search+"%'";
			myStm_nivea = myConn.createStatement();
			myRs_nivea = myStm_nivea.executeQuery(sql_nivea);
			while(myRs_nivea.next()) {
				int id = myRs_nivea.getInt("id");
				 String link = myRs_nivea.getString("image");
				 String title = myRs_nivea.getString("title");
				 float cost = myRs_nivea.getFloat("cost");
				 float sale = myRs_nivea.getFloat("sale");
				 float old_prime = myRs_nivea.getFloat("old_prime");
				 String category = "nivea";
				 Image image = new Image(id,link,title,cost,sale,old_prime,category);
				 images.add(image);
			}
			
			String sql_loreal = "select id,image,title,cost,sale,old_prime from loreal "
					+"where title like '%"+search+"%'";
			myStm_loreal = myConn.createStatement();
			myRs_loreal = myStm_loreal.executeQuery(sql_loreal);
			while(myRs_loreal.next()) {
				int id = myRs_loreal.getInt("id");
				 String link = myRs_loreal.getString("image");
				 String title = myRs_loreal.getString("title");
				 float cost = myRs_loreal.getFloat("cost");
				 float sale = myRs_loreal.getFloat("sale");
				 float old_prime = myRs_loreal.getFloat("old_prime");
				 String category = "loreal";
				 Image image = new Image(id,link,title,cost,sale,old_prime,category);
				 images.add(image);
			}
			
			String sql_neutrogena = "select id,image,title,cost,sale,old_prime from neutrogena "
					+"where title like '%"+search+"%'";
			myStm_neutrogena = myConn.createStatement();
			myRs_neutrogena = myStm_neutrogena.executeQuery(sql_neutrogena);
			while(myRs_neutrogena.next()) {
				int id = myRs_neutrogena.getInt("id");
				 String link = myRs_neutrogena.getString("image");
				 String title = myRs_neutrogena.getString("title");
				 float cost = myRs_neutrogena.getFloat("cost");
				 float sale = myRs_neutrogena.getFloat("sale");
				 float old_prime = myRs_neutrogena.getFloat("old_prime");
				 String category = "neutrogena";
				 Image image = new Image(id,link,title,cost,sale,old_prime,category);
				 images.add(image);
			}
			
			return images;
		}
		finally {
			close(myConn,myStm_index,myRs_index);
			close(myConn,myStm_makeup,myRs_makeup);
			close(myConn,myStm_bestselling,myRs_bestselling);
			close(myConn,myStm_newproduct,myRs_newproduct);
			close(myConn,myStm_skincare,myRs_skincare);
			close(myConn,myStm_bodycare,myRs_bodycare);
			close(myConn,myStm_forman,myRs_forman);
			close(myConn,myStm_nivea,myRs_nivea);
			close(myConn,myStm_loreal,myRs_loreal );
			close(myConn,myStm_neutrogena,myRs_neutrogena);
		}
	}
}
