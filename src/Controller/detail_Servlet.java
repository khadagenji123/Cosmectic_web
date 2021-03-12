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

import DAO.Login_Signup;
import DAO.detail_Product_DAO;
import DAO.partOfContact;
import DAO.showImage;
import model.Image;

/**
 * Servlet implementation class detail_Servlet
 */
@WebServlet("/detail_Servlet")
public class detail_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/cosmetic_web")
	private DataSource dataSource;
	private Login_Signup login_signup;
	private partOfContact contactcompany;
	private detail_Product_DAO detail;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 public void init(ServletConfig config) throws ServletException {
	    	String jdbcURL = "jdbc:mysql://localhost/cosmetic_web";
	    	String jdbcUsername = "root";
	    	String jdbcPassword = "password";
	    	login_signup = new Login_Signup(jdbcURL, jdbcUsername, jdbcPassword);
	    	contactcompany = new partOfContact(jdbcURL, jdbcUsername, jdbcPassword);
	    	 detail = new detail_Product_DAO(jdbcURL, jdbcUsername, jdbcPassword);
	    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			switch(command) {
				case "product-index":{
					detailProductIndex(request,response);
					break;
				}
				case "new-product":{
					detailNewProduct(request,response);
					break;
				}
				case "best-selling":{
					detailBestSelling(request,response);
					break;
				}
				case "skincare":{
					detailSkinCare(request,response);
					break;
				}
				case "bodycare":{
					detailBodyCare(request,response);
					break;
				}
				case"makeup":{
					detailMakeUp(request,response);
					break;
				}
				case "forman":{
					detailForMan(request,response);
					break;
				}
				case "product-user":{
					detailProductUser(request,response);
					break;
				}
				case "nivea":{
					detailNivea(request,response);
					break;
				}
				case "loreal":{
					detailLoreal(request,response);
					break;
				}
				case "neutrogena":{
					detailNeutrogena(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void detailNeutrogena(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int theId = Integer.parseInt(request.getParameter("id"));
		String category = "neutrogena";
		List<Image> images = detail.getNeutrogena(theId);
		request.setAttribute("cate", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/detail.jsp");
										dispatcher.forward(request, response);
	}

	private void detailLoreal(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int theId = Integer.parseInt(request.getParameter("id"));
		String category = "loreal";
		List<Image> images = detail.getLoreal(theId);
		request.setAttribute("cate", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/detail.jsp");
										dispatcher.forward(request, response);
		
	}

	private void detailNivea(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int theId = Integer.parseInt(request.getParameter("id"));
		String category = "nivea";
		List<Image> images = detail.getNivea(theId);
		request.setAttribute("cate", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/detail.jsp");
										dispatcher.forward(request, response);
	}

	private void detailProductUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int theId = Integer.parseInt(request.getParameter("id"));
		String category = "product-user";
		List<Image> images = detail.getProductUser(theId);
		request.setAttribute("cate", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/detail-user.jsp");
										dispatcher.forward(request, response);
	}

	private void detailForMan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int theId = Integer.parseInt(request.getParameter("id"));
		String category = "forman";
		List<Image> images = detail.getForMan(theId);
		request.setAttribute("cate", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/detail.jsp");
										dispatcher.forward(request, response);
	}

	private void detailMakeUp(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int theId = Integer.parseInt(request.getParameter("id"));
		String category = "makeup";
		List<Image> images = detail.getMakeUp(theId);
		request.setAttribute("cate", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/detail.jsp");
										dispatcher.forward(request, response);
	}

	private void detailBodyCare(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int theId = Integer.parseInt(request.getParameter("id"));
		String category = "bodycare";
		List<Image> images = detail.getBodyCare(theId);
		request.setAttribute("cate", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/detail.jsp");
										dispatcher.forward(request, response);
	}

	private void detailSkinCare(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int theId = Integer.parseInt(request.getParameter("id"));
		String category = "skincare";
		List<Image> images = detail.getSkinCare(theId);
		request.setAttribute("cate", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/detail.jsp");
										dispatcher.forward(request, response);
	}

	private void detailNewProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int theId = Integer.parseInt(request.getParameter("id"));
		String category = "new-products";
		List<Image> images = detail.getNewProduct(theId);
		request.setAttribute("cate", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/detail.jsp");
										dispatcher.forward(request, response);
	}

	private void detailBestSelling(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int theId = Integer.parseInt(request.getParameter("id"));
		String category = "best-selling";
		List<Image> images = detail.getBestSelling(theId);
		request.setAttribute("cate", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/detail.jsp");
										dispatcher.forward(request, response);
	}

	private void detailProductIndex(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int theId = Integer.parseInt(request.getParameter("id"));
		String category = "product-index";
		List<Image> images = detail.getProductImage(theId);
		request.setAttribute("cate", category);
		request.setAttribute("list_image", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/detail.jsp");
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
