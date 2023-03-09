package Serv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conne.Conne;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class user_delete
 */
@WebServlet("/user_delete")
public class user_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int pid1=(Integer)session.getAttribute("pid");
		int qty1=(Integer)session.getAttribute("qty");
		Connection conn=Conne.con();
	
			try {
				PreparedStatement ps=conn.prepareStatement("update prod set qty=(qty-?) where pid=?");
				ps.setInt(1, qty1);
				ps.setInt(2, pid1);
				int i=ps.executeUpdate();
				if(i>0)
				{
					
					session.setAttribute("pid", pid1);
					session.setAttribute("qty",qty1);
					RequestDispatcher res=request.getRequestDispatcher("Buty1");
					res.include(request, response);
				}
				
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		
	}

}
