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

import model.Book;
import model.DAOImpl;

/**
 * Servlet implementation class select
 */
@WebServlet("/select")
public class select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	String cate=request.getParameter("r");
	DAOImpl impl=new DAOImpl();
	HashMap<String,Book> hm=impl.select(cate);
	HttpSession hs=request.getSession(false);
	Object o=hs.getAttribute("unm");
	Set<String> set=hm.keySet();
	Iterator<String> i=set.iterator();
	out.println("Welcome "+o+"</br>");
	out.println("<html><body><form action='cart'><table border='2'>"
			+ "<tr><th>Sr No</th><th>BookID</th><th>BookName</th><th>Price</th><th>Author</th></tr>");
	while(i.hasNext())
	{
		String k=i.next();
		Book b=hm.get(k);
		out.println("<tr><td><input type='checkbox' name='c' value='"+k+"'></td><td>"+
		b.getBid()+"</td><td>"+b.getBname()+"</td><td>"+
		b.getPrice()+"</td><td>"+b.getBauthor()+"</td></tr>");
	}
	out.print("</table><input type='submit' value='Add to Cart'/><a href='logout'>logout</a></form>"
			+ "</body></html>");
	
	}

}
