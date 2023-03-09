package Serv;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/admin_update_ser")
public class admin_update_ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int s=Integer.parseInt(request.getParameter("pid"));
		String s1=request.getParameter("img");
		String s2=request.getParameter("fname");
		int s3=Integer.parseInt(request.getParameter("qty"));
		int s4=Integer.parseInt(request.getParameter("price"));
		
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
		ArrayList<Object> al1=new ArrayList<Object>();
		al1.add(s1);
		al1.add(s2);
		al1.add(s3);
		al1.add(s4);
		hm.replace(s,al1 );//HashMap la change pandrathuku use pannaeruka  
		
		PreparedStatement ps1=conn.prepareStatement("update prod set image=?,f_name=?,qty=?,price=? where pid=?");
		
		int hh=1;
	
		 for(Map.Entry<Integer, ArrayList<Object>> map : hm.entrySet())
		 {
			if(map.getKey()==s)
			{
			 for(Object d:map.getValue())
			 {
				 
				 ps1.setString(hh, d.toString());
				 hh+=1;
			 } 
			 ps1.setInt(5, map.getKey());
			}
		 }	 
		 int ii=ps1.executeUpdate();
		 if(ii>0)
		 {
			 response.sendRedirect("admin_update.jsp");
		 }
		
		}
		catch(Exception e)
		{
			
		}
	}

}
