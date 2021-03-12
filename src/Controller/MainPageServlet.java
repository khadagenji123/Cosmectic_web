package Controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import org.json.JSONException;
import org.json.JSONObject;

import DAO.Login_Signup;
import DAO.partOfContact;
import DAO.showImage;
import model.Account;
import model.Contact;
import model.Image;
import model.TestException;

/**
 * Servlet implementation class TrangchuServlet
 */
@WebServlet("/MainPageServlet")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/cosmetic_web")
	private DataSource dataSource;
	private Login_Signup login_signup;
	private partOfContact contactcompany;
	private showImage showimage;
    /**
     * Default constructor. 
     */
	

    public void init(ServletConfig config) throws ServletException {
    	String jdbcURL = "jdbc:mysql://localhost/cosmetic_web";
    	String jdbcUsername = "root";
    	String jdbcPassword = "password";
    	login_signup = new Login_Signup(jdbcURL, jdbcUsername, jdbcPassword);
    	contactcompany = new partOfContact(jdbcURL, jdbcUsername, jdbcPassword);
    	showimage = new showImage(jdbcURL, jdbcUsername, jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String category = request.getParameter("category");
			String command = request.getParameter("command");
			if(command==null) {
				command="HOME";
			}
			switch(command) {
				case "HOME":{
					showHome(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			switch(command) {
				case "LOGIN":{
					loginAccount(request,response);
					break;
				}
				case "SIGNUP_BY_PHONE":{
					signupAccountByNumPhone(request,response);
					break;
				}
				case "SIGNUP_BY_EMAIL":{
					signupAccountByEmail(request,response);
					break;
				}
				case "CONTACT":{
					contactCompany(request,response);
					break;
				}
				case "SEARCH":{
					searchProduct(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String search = request.getParameter("name-product");
		List<Image> images = showimage.getSerachProduct(search);
		if(images.isEmpty()) {
			request.setAttribute("search", search);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/not-found.jsp");
											dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("search", search);
			request.setAttribute("list_image", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/search-product.jsp");
											dispatcher.forward(request, response);
		}
	}

	private void showHome(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Image> images = showimage.getImage();
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
										dispatcher.forward(request, response);
	}

	private void contactCompany(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name"); 
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String massage = request.getParameter("massage");
		
		Contact contact = new Contact(name,email,subject,massage);
		contactcompany.contactCompany(contact);
		
	}

	private void signupAccountByEmail(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String number_phone = request.getParameter("number-phone");
		String birthday = request.getParameter("birthday");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		
		Account theAccount = new Account(email,password,name,birthday,gender,address,number_phone);
		login_signup.signupAccountByEmail(theAccount);
		
		String url = "view/login-form.jsp";
		response.sendRedirect(url);
		
	}

	private void signupAccountByNumPhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String number_phone = request.getParameter("number-phone");
		String birthday = request.getParameter("birthday");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		int checkuser = 2;
		
		Account theAccount = new Account(username,password,name,birthday,gender,address,number_phone,checkuser);
		login_signup.signupAccountByPhone(theAccount);
		
		String url = "view/login-form.jsp";
		response.sendRedirect(url);
	}

	private void loginAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Account theAccount = new Account(username,password);
		int checkuser = login_signup.loginAccount(theAccount);
		
		response.setContentType("application/json");
		JSONObject obj = new JSONObject();
		obj.put("checkuser", checkuser);
		response.getWriter().write(obj.toString());
	}

}
