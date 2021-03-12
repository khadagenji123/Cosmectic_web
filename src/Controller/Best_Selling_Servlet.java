package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import DAO.Login_Signup;
import DAO.partOfContact;
import DAO.showImage;
import model.Image;

/**
 * Servlet implementation class Best_Selling_Servlet
 */
@WebServlet("/Best_Selling_Servlet")
public class Best_Selling_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/cosmetic_web")
	private DataSource dataSource;
	private Best_Selling_DAO bestselling;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
    	String jdbcURL = "jdbc:mysql://localhost/cosmetic_web";
    	String jdbcUsername = "root";
    	String jdbcPassword = "password";
    	bestselling = new Best_Selling_DAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Image> images = bestselling.getImage();
			request.setAttribute("list_image", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/best-selling.jsp");
											dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
