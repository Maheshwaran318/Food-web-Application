package Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanclass.Bean;
import conne.Conne;

/**
 * Servlet implementation class admin_login_ser
 */
@WebServlet("/admin_login_ser")
public class admin_login_ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_login_ser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s=request.getParameter("e");
		String s1=request.getParameter("p");
		Bean b=new Bean();
		b.setEmail(s);
		b.setPass(s1);
		ArrayList<String> al=new ArrayList<String>();
		al.add(b.getEmail());
		al.add(b.getPass());
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		if(s.isEmpty()||s1.isEmpty())
		{
			pw.print("Some field is empty");
			RequestDispatcher rss1=request.getRequestDispatcher("admin_login.jsp");
			rss1.include(request, response);
		}
		else
		{
			
				Connection conn=Conne.con();
				try {
					PreparedStatement ps=conn.prepareStatement("select email,pass from admin where email=? and pass=?");
					int inc=1;
					int i=0;
					for(String ss:al)
					{
						ps.setString(inc,ss);
						inc+=1;
					}
					 ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
						pw.print("Welcome to Admin Page");
						RequestDispatcher rss1=request.getRequestDispatcher("user_wel.jsp");
							rss1.include(request, response);
					}
					else
					{
						pw.print("Email or Password is incorrect");
					RequestDispatcher rss1=request.getRequestDispatcher("admin_login.jsp");
						rss1.include(request, response);	
					}
					conn.close();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}	
	}
	}


