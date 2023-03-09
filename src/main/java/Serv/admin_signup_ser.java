package Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
 * Servlet implementation class admin_signup_ser
 */
@WebServlet("/admin_signup_ser")
public class admin_signup_ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_signup_ser() {
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
		String s6=request.getParameter("ad");
		Bean b=new Bean(s,s1,s2,s3,s4,s5);
		b.setAddress(s6);
		ArrayList<String> al=new ArrayList<String>();
		al.add(b.getName());
		al.add(b.getEmail());
		al.add(b.getGender());
		al.add(b.getAddress());
		al.add(b.getPh());
		al.add(b.getPass());
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		if(s.isEmpty()||s1.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||StringUtils.isNullOrEmpty(s2)||s6.isEmpty())
		{
			pw.print("Some field is empty");
			RequestDispatcher rss1=request.getRequestDispatcher("admin_signup.jsp");
			rss1.include(request, response);
		}
		else
		{
			if(b.getPass().equals(b.getCpass()))
			{
				
				Connection conn=Conne.con();
				try {
					PreparedStatement ps=conn.prepareStatement("insert into admin(name,email,gender,address,ph,pass) values(?,?,?,?,?,?)");
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
						pw.print(" Register Succesfully");
						RequestDispatcher rss1=request.getRequestDispatcher("admin_login.jsp");
							rss1.include(request, response);	
					}
					else
					{
						pw.print(" unsuccessfully");
					RequestDispatcher rss1=request.getRequestDispatcher("admin_signup.jsp");
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
				RequestDispatcher rss1=request.getRequestDispatcher("admin_signup.jsp");
				rss1.include(request, response);	
			}		
		}
	
		
		
	}
	}


