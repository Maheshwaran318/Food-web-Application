package Serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class user_confirm
 */
@WebServlet("/user_confirm")
public class user_confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		int pid= Integer.parseInt((request.getParameter("pid")))   ;
		int qty= Integer.parseInt((request.getParameter("qty")))   ;
		
		HttpSession session=request.getSession();
		session.setAttribute("pid", pid);
		session.setAttribute("qty",qty);
		RequestDispatcher res=request.getRequestDispatcher("user_delete");
		res.include(request, response);
		pw.print("<a href=user_delete>Click to continue payment process</a><br>");
		pw.print("<a href=User_view_page.jsp>Back</a>");

	}

}
