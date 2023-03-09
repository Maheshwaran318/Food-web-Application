package Serv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conne.Conne;

/**
 * Servlet implementation class admin_delete_ser
 */
@WebServlet("/admin_delete_ser")
public class admin_delete_ser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int s=Integer.parseInt(request.getParameter("pid"));	
		HashMap<Integer,ArrayList<Object>> hm=new HashMap<Integer,ArrayList<Object>>();
		Connection conn=Conne.con();
		try {
		PreparedStatement ps=conn.prepareStatement("select * from prod");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			ArrayList<Object> al=new ArrayList<Object>();
			al.add(rs.getString(2));
			al.add(rs.getString(3));
			al.add(rs.getInt(4));
			al.add(rs.getInt(5));
			hm.put(rs.getInt(1), al);
		}
	
		PreparedStatement ps1=conn.prepareStatement("delete from prod where pid=?");

	
		 for(Map.Entry<Integer, ArrayList<Object>> map : hm.entrySet())
		 {
			if(map.getKey()==s)
			{
			 ps1.setInt(1, map.getKey());
			}
			
		 }	 
		 int ii=ps1.executeUpdate();
		 if(ii>0)
		 {
			 hm.remove(s);
			 response.sendRedirect("admin_delete.jsp");
		 }
		
		}
		catch(Exception e)
		{
			
		}
	}
	}


