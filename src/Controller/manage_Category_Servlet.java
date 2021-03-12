package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.manage_Category_DAO;
import DAO.manage_TradeMark_DAO;
import model.Image;

/**
 * Servlet implementation class manage_Category_Servlet
 */
@WebServlet("/manage_Category_Servlet")
public class manage_Category_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name="jdbc/cosmetic_web")
	private DataSource dataSource;
	private manage_Category_DAO manage;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
    	String jdbcURL = "jdbc:mysql://localhost/cosmetic_web";
    	String jdbcUsername = "root";
    	String jdbcPassword = "password";
    	manage = new manage_Category_DAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String value = request.getParameter("value");
			switch(value) {
				case "skincare":{
					manageSkincare(request,response);
					break;
				}
				case "makeup":{
					manageMakeup(request,response);
					break;
				}
				case "bodycare":{
					manageBodycare(request,response);
					break;
				}
				case "forman":{
					manageForman(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void manageForman(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Image> images = manage.getForman();
		String category = "forman";
		request.setAttribute("category", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/manageCategory.jsp");
										dispatcher.forward(request, response);
	}

	private void manageBodycare(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Image> images = manage.getBodycare();
		String category = "bodycare";
		request.setAttribute("category", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/manageCategory.jsp");
										dispatcher.forward(request, response);
	}

	private void manageMakeup(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Image> images = manage.getMakeup();
		String category = "makeup";
		request.setAttribute("category", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/manageCategory.jsp");
										dispatcher.forward(request, response);
	}

	private void manageSkincare(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Image> images = manage.getSkincare();
		String category = "skincare";
		request.setAttribute("category", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/manageCategory.jsp");
										dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
