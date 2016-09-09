package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOImpl;

/**
 * Servlet implementation class Remove
 */
@WebServlet("/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
			double price=0;
			
			HttpSession hs=request.getSession(false);
			Object o=hs.getAttribute("unm");
		String btn1=request.getParameter("r");
		String btn2=request.getParameter("pay");
		
			if("Remove".equals(btn1))
			{
				
			
			DAOImpl impl=new DAOImpl();
		String bids[]=request.getParameterValues("c");
		
		HashMap<String, Double> hm=impl.Remove(bids);
	
		request.getRequestDispatcher("cart").include(request, response);
		
			
			}
			System.out.println(btn2);
			System.out.println("before btn2");
			if("Pay".equals(btn2)){
				System.out.println("In btn2");
				
				out.println("Thank you "  +o+"</br>");
				out.println("your ammount is paid"+request.getSession(false).getAttribute("pr"));
				
			}
			out.print("</form></body></html>");
	}

}
