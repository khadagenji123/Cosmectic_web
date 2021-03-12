package Controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
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

import DAO.Best_Selling_DAO;
import DAO.category_DAO;
import model.Image;

/**
 * Servlet implementation class Category_Servlet
 */
@WebServlet("/Category_Servlet")
public class Category_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/cosmetic_web")
	private DataSource dataSource;
	private category_DAO category;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
    	String jdbcURL = "jdbc:mysql://localhost/cosmetic_web";
    	String jdbcUsername = "root";
    	String jdbcPassword = "password";
    	category = new category_DAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String value = request.getParameter("value");
			switch(value) {
				case "skincare":{
					skinCare(request,response);
					break;
				}
				case "makeup":{
					makeUp(request,response);
					break;
				}
				case "bodycare":{
					bodyCare(request,response);
					break;
				}
				case "forman":{
					forMan(request,response);
					break;
				}
				default:{
					showHome(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	
	
	private void showHome(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = "MainPageServlet";
		response.sendRedirect(url);
		
	}

	private void forMan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Image> images = category.getImageForman();
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/for-man.jsp");
										dispatcher.forward(request, response);
		
	}

	private void bodyCare(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Image> images = category.getImageBodycare();
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/body-care.jsp");
										dispatcher.forward(request, response);
	}

	private void makeUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Image> images = category.getImageMakeup();
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/make-up.jsp");
										dispatcher.forward(request, response);
		
	}

	

	private void skinCare(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
		List<Image> images = category.getImageSkincare();
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/skincare.jsp");
										dispatcher.forward(request, response);
	}

}
