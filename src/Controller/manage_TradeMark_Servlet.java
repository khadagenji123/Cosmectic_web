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

import org.json.JSONObject;

import DAO.Best_Selling_DAO;
import DAO.manage_TradeMark_DAO;
import model.Image;

/**
 * Servlet implementation class manage_TradeMark_Servlet
 */
@WebServlet("/manage_TradeMark_Servlet")
public class manage_TradeMark_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/cosmetic_web")
	private DataSource dataSource;
	private manage_TradeMark_DAO manageTM;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
    	String jdbcURL = "jdbc:mysql://localhost/cosmetic_web";
    	String jdbcUsername = "root";
    	String jdbcPassword = "password";
    	manageTM = new manage_TradeMark_DAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String value = request.getParameter("value");
			switch(value) {
				case "nivea":{
					manage_TMNivea(request,response);
					break;
				}
				case "loreal":{
					manage_TMLoreal(request,response);
					break;
				}
				case "neutrogena":{
					manage_TMNeutrogena(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void manage_TMNeutrogena(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Image> images = manageTM.getNeutrogena();
		String category = "neutrogena";
		request.setAttribute("category", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/manageTM.jsp");
										dispatcher.forward(request, response);
	}

	private void manage_TMLoreal(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Image> images = manageTM.getLoreal();
		String category = "loreal";
		request.setAttribute("category", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/manageTM.jsp");
										dispatcher.forward(request, response);
	}

	private void manage_TMNivea(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Image> images = manageTM.getNivea();
		String category = "nivea";;
		request.setAttribute("category", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/manageTM.jsp");
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
