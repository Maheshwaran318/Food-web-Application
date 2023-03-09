<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Product insert page</title>
</head>
<body >
<h1>PRODUCT INSERT </h1>
<form action="admin_insert_ser" method="post" >
<div class="container mt-3">
 <table class="table table-striped">
<tr>
<th>Enter the food image to add</th><td><input type="text" name="pimage"></td>
</tr>
<tr>
<th>Enter food name</th><td><input type="text" name="pname"></td>
</tr>
<tr>
<th>Enter food Quantity to add</th><td><input type="text" name="pqty"></td>
</tr>
<tr>
<th>Enter food price to add</th><td><input type="text" name="pprice"></td>
</tr>
<tr><td colspan="1"><input type="submit" value="Save"></td><td><a href="admin_prod_fpage.jsp"><input type="button" value="Back"></a></td></tr>
</table>
</div>
</form>

</body>
</html>