<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Update Page</title>
</head>
<body>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@page import="conne.Conne" %>
<%
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

%>
<form action="admin_delete_ser" method="post">
<div class="container mt-3">
 <table class="table table-striped">
 <tr>
<th>Enter pid to Delete</th><td><input type="text" name="pid"></td>
</tr>

<tr> 
<th><input type="submit" value="DELETE"></th>
</tr>
</table>
</div>
</form>

</body>
</html>