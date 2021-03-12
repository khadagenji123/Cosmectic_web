package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.manage_BestSelling_Action_DAO;
import model.Image;

/**
 * Servlet implementation class manage_BestSelling_Action_Servlet
 */
@WebServlet("/manage_BestSelling_Action_Servlet")
public class manage_BestSelling_Action_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/cosmetic_web")
	private DataSource dataSource;
	private manage_BestSelling_Action_DAO manage;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
    	String jdbcURL = "jdbc:mysql://localhost/cosmetic_web";
    	String jdbcUsername = "root";
    	String jdbcPassword = "password";
    	manage = new manage_BestSelling_Action_DAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			switch(command) {
				case "DELETE":{
					deleteProduct(request,response);
					break;
				}
				case "LOAD":{
					loadProduct(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int theId = Integer.parseInt(request.getParameter("id"));
		Image theImage = manage.loadProduct(theId);
		
		request.setAttribute("theImage", theImage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/update-bestselling-form.jsp");
										dispatcher.forward(request, response);
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		manage.deleteProduct(id);
		
		String url = "manage_BestSelling_Servlet";
		response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			switch(command) {
				case "UPDATE":{
					updateProduct(request,response);
					break;
				}
				case "ADD":{
					addProduct(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String link = request.getParameter("link");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		float cost = Float.parseFloat(request.getParameter("cost"));
		float sale = Float.parseFloat(request.getParameter("sale"));
		float old_prime = Float.parseFloat(request.getParameter("old_prime"));
		
		Image image = new Image(link, title, description, cost, sale, old_prime);
		manage.addProduct(image);
		
		String url = "http://localhost:8081/Cosmetic-web/manage_BestSelling_Servlet";
		response.sendRedirect(url);
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("imageId"));
		String link = request.getParameter("link");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		float cost = Float.parseFloat(request.getParameter("cost"));
		float sale = Float.parseFloat(request.getParameter("sale"));
		float old_prime = Float.parseFloat(request.getParameter("old_prime"));
		
		Image image = new Image(id, link, title, description, cost, sale, old_prime);
		manage.updateProduct(image);
		
		String url = "http://localhost:8081/Cosmetic-web/manage_BestSelling_Servlet";
		response.sendRedirect(url);
	}

}
