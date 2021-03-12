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

import DAO.Login_Signup;
import DAO.detail_Product_DAO;
import DAO.partOfContact;
import DAO.showImage;
import model.Account;
import model.Image;

/**
 * Servlet implementation class buyProduct_Servlet
 */
@WebServlet("/buyProduct_Servlet")
public class buyProduct_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/cosmetic_web")
	private DataSource dataSource;
	private Login_Signup login_signup;
	private detail_Product_DAO detail;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
    	String jdbcURL = "jdbc:mysql://localhost/cosmetic_web";
    	String jdbcUsername = "root";
    	String jdbcPassword = "password";
    	login_signup = new Login_Signup(jdbcURL, jdbcUsername, jdbcPassword);
    	detail = new detail_Product_DAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String category = request.getParameter("category");
			switch(category) {
				case "product-index":{
					buyProduct_Index(request,response);
					break;
				}
				case "new-products":{
					buyNew_Product(request,response);
					break;
				}
				case "best-selling":{
					buyBest_Selling(request,response);
					break;
				}
				case "skincare":{
					buySkincare(request,response);
					break;
				}
				case "bodycare":{
					buyBodyCare(request,response);
					break;
				}
				case"makeup":{
					buyMakeUp(request,response);
					break;
				}
				case "forman":{
					buyForMan(request,response);
					break;
				}
				case "product-user":{
					buyProduct_User(request,response);
					break;
				}
				case "nivea":{
					buyNivea(request,response);
					break;
				}
				case "loreal":{
					buyLoreal(request,response);
					break;
				}
				case "neutrogena":{
					buyNeutrogena(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}


	private void buyNeutrogena(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int checkuser= loginAccount(request, response);
		int  theId = Integer.parseInt(request.getParameter("id"));
		if(checkuser==2) {
			List<Image> images = detail.getNeutrogena(theId);
			request.setAttribute("list_image", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/buy-product.jsp");
											dispatcher.forward(request, response);
		}
		else {
			String category = "neutrogena";
			request.setAttribute("cate", category);
			request.setAttribute("id", theId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login-again.jsp");
											dispatcher.forward(request, response);
		}
	}

	private void buyLoreal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int checkuser= loginAccount(request, response);
		int  theId = Integer.parseInt(request.getParameter("id"));
		if(checkuser==2) {
			List<Image> images = detail.getLoreal(theId);
			request.setAttribute("list_image", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/buy-product.jsp");
											dispatcher.forward(request, response);
		}
		else {
			String category = "loreal";
			request.setAttribute("cate", category);
			request.setAttribute("id", theId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login-again.jsp");
											dispatcher.forward(request, response);
		}
	}

	private void buyNivea(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int checkuser= loginAccount(request, response);
		int  theId = Integer.parseInt(request.getParameter("id"));
		if(checkuser==2) {
			List<Image> images = detail.getNivea(theId);
			request.setAttribute("list_image", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/buy-product.jsp");
											dispatcher.forward(request, response);
		}
		else {
			String category = "nivea";
			request.setAttribute("cate", category);
			request.setAttribute("id", theId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login-again.jsp");
											dispatcher.forward(request, response);
		}
	}

	private void buyProduct_User(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int  theId = Integer.parseInt(request.getParameter("id"));
		List<Image> images = detail.getProductUser(theId);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/buy-product.jsp");
										dispatcher.forward(request, response);
	}

	private void buyForMan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int checkuser= loginAccount(request, response);
		int  theId = Integer.parseInt(request.getParameter("id"));
		if(checkuser==2) {
			List<Image> images = detail.getForMan(theId);
			request.setAttribute("list_image", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/buy-product.jsp");
											dispatcher.forward(request, response);
		}
		else {
			String category = "forman";
			request.setAttribute("cate", category);
			request.setAttribute("id", theId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login-again.jsp");
											dispatcher.forward(request, response);
		}
	}

	private void buyMakeUp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int checkuser= loginAccount(request, response);
		int  theId = Integer.parseInt(request.getParameter("id"));
		if(checkuser==2) {
			List<Image> images = detail.getMakeUp(theId);
			request.setAttribute("list_image", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/buy-product.jsp");
											dispatcher.forward(request, response);
		}
		else {
			String category = "makeup";
			request.setAttribute("cate", category);
			request.setAttribute("id", theId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login-again.jsp");
											dispatcher.forward(request, response);
		}
	}

	private void buyBodyCare(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int checkuser= loginAccount(request, response);
		int  theId = Integer.parseInt(request.getParameter("id"));
		if(checkuser==2) {
			List<Image> images = detail.getBodyCare(theId);
			request.setAttribute("list_image", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/buy-product.jsp");
											dispatcher.forward(request, response);
		}
		else {
			String category = "bodycare";
			request.setAttribute("cate", category);
			request.setAttribute("id", theId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login-again.jsp");
											dispatcher.forward(request, response);
		}
	}

	private void buySkincare(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int checkuser= loginAccount(request, response);
		int  theId = Integer.parseInt(request.getParameter("id"));
		if(checkuser==2) {
			List<Image> images = detail.getSkinCare(theId);
			request.setAttribute("list_image", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/buy-product.jsp");
											dispatcher.forward(request, response);
		}
		else {
			String category = "skincare";
			request.setAttribute("cate", category);
			request.setAttribute("id", theId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login-again.jsp");
											dispatcher.forward(request, response);
		}
	}

	private void buyBest_Selling(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int checkuser= loginAccount(request, response);
		int  theId = Integer.parseInt(request.getParameter("id"));
		if(checkuser==2) {
			List<Image> images = detail.getBestSelling(theId);
			request.setAttribute("list_image", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/buy-product.jsp");
											dispatcher.forward(request, response);
		}
		else {
			String category = "best-selling";
			request.setAttribute("cate", category);
			request.setAttribute("id", theId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login-again.jsp");
											dispatcher.forward(request, response);
		}
	}

	private void buyNew_Product(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int checkuser= loginAccount(request, response);
		int  theId = Integer.parseInt(request.getParameter("id"));
		if(checkuser==2) {
			List<Image> images = detail.getNewProduct(theId);
			request.setAttribute("list_image", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/buy-product.jsp");
											dispatcher.forward(request, response);
		}
		else {
			String category = "new-products";
			request.setAttribute("cate", category);
			request.setAttribute("id", theId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login-again.jsp");
											dispatcher.forward(request, response);
		}
	}

	private void buyProduct_Index(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int checkuser= loginAccount(request, response);
		int  theId = Integer.parseInt(request.getParameter("id"));
		if(checkuser==2) {
			List<Image> images = detail.getProductImage(theId);
			request.setAttribute("list_image", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/buy-product.jsp");
											dispatcher.forward(request, response);
		}
		else {
			String category = "product-index";
			request.setAttribute("cate", category);
			request.setAttribute("id", theId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login-again.jsp");
											dispatcher.forward(request, response);
		}
		
	}



	private int loginAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Account theAccount = new Account(username,password);
		int checkuser = login_signup.loginAccount(theAccount);
		if(checkuser==2) {
			return 2;
		}
		else {
			return 0;
		}
	}

}
