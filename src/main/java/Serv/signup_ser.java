package Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.util.StringUtils;

import beanclass.Bean;
import conne.Conne;
/**
 * Servlet implementation class signup_ser
 */
@WebServlet("/signup_ser")
public class signup_ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup_ser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s=request.getParameter("n");
		String s1=request.getParameter("e");
		String s2=request.getParameter("gen");
		String s3=request.getParameter("ph");
		String s4=request.getParameter("p");
		String s5=request.getParameter("cp");
		Bean b=new Bean(s,s1,s2,s3,s4,s5);
		ArrayList<String> al=new ArrayList<String>();
		al.add(b.getName());
		al.add(b.getEmail());
		al.add(b.getGender());
		al.add(b.getPh());
		al.add(b.getPass());
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		if(s.isEmpty()||s1.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||StringUtils.isNullOrEmpty(s2))
		{
			pw.print("Some field is empty");
			RequestDispatcher rss1=request.getRequestDispatcher("signup.jsp");
			rss1.include(request, response);
		}
		else
		{
			if(b.getPass().equals(b.getCpass()))
			{
				
				Connection conn=Conne.con();
				try {
					PreparedStatement ps=conn.prepareStatement("insert into signup(name,email,gender,ph,pass) values(?,?,?,?,?)");
					int inc=1;
					int i=0;
					for(String ss:al)
					{
						ps.setString(inc,ss);
						inc+=1;
					}
					 i=ps.executeUpdate();
					if(i>0)
					{
						pw.print(" successfully Register");
						RequestDispatcher rss1=request.getRequestDispatcher("user_login.jsp");
							rss1.include(request, response);	

					}
					else
					{
						pw.print(" unsuccessfully");
					RequestDispatcher rss1=request.getRequestDispatcher("signup.jsp");
						rss1.include(request, response);	
					}
					conn.close();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			else
			{
				pw.print("password mismatch please enter correct password");
				RequestDispatcher rss1=request.getRequestDispatcher("signup.jsp");
				rss1.include(request, response);	
			}		
		}
	
		
		
	}

}
