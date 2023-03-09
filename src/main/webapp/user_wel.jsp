<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Admin login</title>
</head>
<body>
<form action="view" method="post">
<table>
<tr>
<th><a href="admin_insert.jsp" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">INSERT</a></th>
</tr>
<tr>
<th><a href="admin_delete.jsp" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">DELETE</a></th>
</tr>
<tr>
<th><a href="admin_update.jsp" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">UPDATE</a></th>
</tr>
<tr>
<th><a href="view" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">VIEW</a></th>
</tr>
<tr>
<td><a href="admin_login.jsp"><button type="button" value="view" formaction="view" >back</button></a></td>
</tr>
</table>
</form>

</body>
</html>