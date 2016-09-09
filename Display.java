package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOImpl;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		DAOImpl impl=new DAOImpl();
		String uid=request.getParameter("uid");
		HttpSession hs=request.getSession();
		
		String unm=impl.login(uid);
		hs.setAttribute("unm", unm);
		out.println("Welcome "+unm+"</br>");
		out.print("Select the book category</br>");
		out.println("<html><body><form action='select'>"
				+ "<input type='radio' name='r' value='educational'>Educational</br>"
				+ "<input type='radio' name='r' value='story'>Story Books</br>"
				+ "<input type='radio' name='r' value='novel'>Novels</br>"
				+ "<input type='submit'  value='Select'><a href='logout'>logout</a>"
				+ "</form></body></html>");
		
	}

}
