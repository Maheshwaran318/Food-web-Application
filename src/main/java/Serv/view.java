package Serv;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import conne.Conne;

/**
 * Servlet implementation class view
 */
@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw=response.getWriter();
		Connection conn=Conne.con();
		try {
			response.setContentType("text/html");
		PreparedStatement ps=conn.prepareStatement("select * from prod");
		ResultSet rs=ps.executeQuery();
		pw.print("<html><head><title>View Page</title>"
				+ "  <meta charset=\"utf-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "</head><body>\r\n"
				+ "\r\n"
				+ "<div class=\"container mt-3\"><div class=\"table-responsive\">\r\n"
				+ " <h1>SWIZO APP</h1>   <table class=\"table table-bordered\">");
		
		pw.print("<tr><th>Pid</th><th>Image   </th><th>Food Name    </th><th>qty   </th><th>Price    </th></tr>");
		while(rs.next())
		{
			pw.print("<tr>");
		pw.print("<td>"+rs.getString(1)+"</td>");
		pw.print("<td><img src="+rs.getString(2)+"width=100 height=100></td>");
		pw.print("<td>"+rs.getString(3)+"</td>");
		pw.print("<td>"+rs.getString(4)+"  </td>");
		pw.print("<td>"+rs.getString(5)+"   </td>");
		 pw.print("</tr>");
		}
		 pw.print(" </div> </div> </body> </table></html>");		
	}
		
		 
	catch(Exception e)
		{
		}
	}

}
