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

import DAO.category_DAO;
import DAO.tradeMark_DAO;
import model.Image;

/**
 * Servlet implementation class tradeMark_Servlet
 */
@WebServlet("/tradeMark_Servlet")
public class tradeMark_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/cosmetic_web")
	private DataSource dataSource;
	private tradeMark_DAO trademark;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
    	String jdbcURL = "jdbc:mysql://localhost/cosmetic_web";
    	String jdbcUsername = "root";
    	String jdbcPassword = "password";
    	trademark = new tradeMark_DAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String value = request.getParameter("value");
			switch(value) {
				case "nivea":{
					tradeMarkNivea(request,response);
					break;
				}
				case "loreal":{
					tradeMarkLoreal(request,response);
					break;
				}
				case "neutrogena":{
					tradeMarkNeutrogena(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void tradeMarkNeutrogena(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Image> images = trademark.getImageNeutrogena();
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/neutrogena.jsp");
										dispatcher.forward(request, response);
		
	}

	private void tradeMarkNivea(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Image> images = trademark.getImageNivea();
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/nivea.jsp");
										dispatcher.forward(request, response);
		
	}

	private void tradeMarkLoreal(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Image> images = trademark.getImageLoreal();
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/loreal.jsp");
										dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
