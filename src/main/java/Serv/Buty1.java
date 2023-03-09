package Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conne.Conne;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Buty1
 */
@WebServlet("/Buty1")
public class Buty1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int qty=(Integer)session.getAttribute("qty");
		int pid=(Integer)session.getAttribute("pid");
		
	int price=0;
	response.setContentType("text/html");
	ResultSet rs;
	PrintWriter pw=response.getWriter();

	try {
		response.setContentType("text/html");
					Connection conn=Conne.con();
						PreparedStatement ps=conn.prepareStatement("select * from prod where pid=?");
						
						ps.setInt(1, pid);
						rs=ps.executeQuery();
					
					pw.print("<html><body><table>");
					pw.print("<tr><th></th> <th>Product_id  </th> <th>  Qty  </th> <th>Foodname</th> <th> price</th><th> Total</th> </tr>");
			
					while(rs.next())
					{
							price=rs.getInt(5);
							int total=qty*price;
					
						pw.print("<tr><td><img src="+rs.getString(2)+" width=100></td> <td>"+rs.getInt(1)+"</td><td>"+qty+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(5)+"</td><td>"+total +" </td></tr>");
						
						pw.print("</table><p>Purchased Successfully</p></body>");
					}
					
				
				
					pw.print("<a href=User_view_page.jsp>back</a></html>"); 
				
		
	} 

	catch (Exception e) {

		e.printStackTrace();
	}
		
	}

}
/*	else
{
	pw.print("<h3>User name and Password is incorrect</h3>");
	RequestDispatcher rss=request.getRequestDispatcher("user_log.jsp");
	rss.include(request, response);
}*/
