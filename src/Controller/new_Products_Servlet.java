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

import DAO.Best_Selling_DAO;
import DAO.new_Products_DAO;
import model.Image;

/**
 * Servlet implementation class new_Products_Servlet
 */
@WebServlet("/new_Products_Servlet")
public class new_Products_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/cosmetic_web")
	private DataSource dataSource;
	private new_Products_DAO newproducts;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
    	String jdbcURL = "jdbc:mysql://localhost/cosmetic_web";
    	String jdbcUsername = "root";
    	String jdbcPassword = "password";
    	newproducts = new new_Products_DAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Image> images = newproducts.getImage();
			request.setAttribute("list_image", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/new-product.jsp");
											dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}


}
