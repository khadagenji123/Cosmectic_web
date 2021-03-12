package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test_Servlet
 */
@WebServlet("/test_Servlet")
public class test_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String category = request.getParameter("category");
			switch(category) {
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

	private void buyNeutrogena(HttpServletRequest request, HttpServletResponse response) {
		String theId = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"-"+password+"-"+theId);
		
	}

}
