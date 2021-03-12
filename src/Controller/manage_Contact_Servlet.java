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

import DAO.manage_Contact_DAO;
import DAO.manage_MemberShip_DAO;
import model.Account;
import model.Contact;

/**
 * Servlet implementation class manage_Contact_Servlet
 */
@WebServlet("/manage_Contact_Servlet")
public class manage_Contact_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/cosmetic_web")
	private DataSource dataSource;
	private manage_Contact_DAO manage;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
    	String jdbcURL = "jdbc:mysql://localhost/cosmetic_web";
    	String jdbcUsername = "root";
    	String jdbcPassword = "password";
    	manage = new manage_Contact_DAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Contact> contacts = manage.getContact();
			request.setAttribute("list_contact", contacts);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/manageContact.jsp");
											dispatcher.forward(request, response);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
