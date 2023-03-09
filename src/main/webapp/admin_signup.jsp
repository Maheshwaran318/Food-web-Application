<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Admin Sign up</title>
</head>
<body>
<h1>SWIZO FOOD APP</h1>
<h2>ADMIN PAGE SIGN UP</h2>

<form action="admin_signup_ser" method="post">
<div class="container mt-3">
 <table class="table table-striped">
<tr>
<th>Name</th><td><input type="text" name="n"></td>
</tr>
<tr>
<th>Email</th><td><input type="email" name="e"></td>
</tr>
<tr>
<th>Gender</th><td><input type="radio" name="gen" value="Male"/>Male<input type="radio" name="gen" value="Female">Female<input type="radio" name="gen" value="Other">Other</td>
</tr>
<tr>
<th>Address</th><td><input type="text" name="ad"></td>
</tr>
<tr>
<th>Phone No</th><td><input type="text" name="ph"></td>
</tr>
<tr>
<th>Password</th><td><input type="password" name="p"></td>
</tr>
<tr>
<th>Confirm Password</th><td><input type="password" name="cp"></td>
</tr>
<tr>
<th><input type="submit" value="Signup"></th><td><a href="admin_login.jsp"><input type="button" value="back"></a></td>
</tr>
</table>
</div>
</form>
</body>
</html>

