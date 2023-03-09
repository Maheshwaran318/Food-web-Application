package Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conne.Conne;

/**
 * Servlet implementation class admin_insert_ser
 */
@WebServlet("/admin_insert_ser")
public class admin_insert_ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_insert_ser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1= request.getParameter("pimage");
		String s2=request.getParameter("pname");
		Integer s3= Integer.parseInt(request.getParameter("pqty"));
		Integer s4= Integer.parseInt(  request.getParameter("pprice"));
		response.setContentType("text/html");
		
		ArrayList <Object> al=new ArrayList<Object>();
		al.add(s1);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		PrintWriter pw=response.getWriter();
		if(s1.isEmpty()||s2.isEmpty()|s3==0||s4==0)
		{
			pw.print("<h1>Please enter all details in given below</h1>");
			RequestDispatcher rss=request.getRequestDispatcher("admin_insert.jsp");
			rss.include(request, response);
		}
		else{
			
		try {
							Connection con=Conne.con();
							int coun=1;
							PreparedStatement ps=con.prepareStatement("insert into prod(image,f_name,qty,price) values(?,?,?,?)");
							for(Object ob:al)
							{
							ps.setString(coun, ob.toString());
							coun+=1;
							}
							int rs=ps.executeUpdate();
						if(rs>0)
						{
							pw.print("Product Added to the list successfully");
							RequestDispatcher rss=request.getRequestDispatcher("user_wel.jsp");
							rss.include(request, response);				}
						else
						{
							pw.print(" unsuccessfully");
							RequestDispatcher rss=request.getRequestDispatcher("admin_insert.jsp");
							rss.include(request, response);	
						} 
						con.close();
			
		} 

		catch (Exception e) {

			e.printStackTrace();
		}

		}
	}

}
