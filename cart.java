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
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart() {
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
		
		DAOImpl impl=new DAOImpl();
	String bids[]=request.getParameterValues("c");
	HashMap<String, Double> hm=impl.cart(bids);
	Set<String> set=hm.keySet();
	Iterator<String> i=set.iterator();
	out.println("Welcome "+o+"</br>");
	out.print("<html><body><form action='Remove'>");
	while(i.hasNext())
	{
		String k=i.next();
		double p=hm.get(k);
		price=price+p;
		
		out.println("<input type='checkbox' name='c' value='"+k+"'/>"+k+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+p+"</br>");
	
	}
HttpSession hs1=request.getSession();
hs1.setAttribute("pr", price);
	out.println("Total Price="+price+"</br>"
			+ "<input type='submit' name='r' value='Remove'/>"
			+ "<input type='submit' name='pay' value='Pay'/><a href='logout'>logout</a>"
			+ "</form></body></html>");
	
	
	
	}

}
