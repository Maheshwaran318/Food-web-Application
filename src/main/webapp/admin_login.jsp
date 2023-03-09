<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <style>
  div{
 	clor:blue;
  }
  </style>
</head>
<body id="form">

<div class="container mt-3">
<h1>SWIZO</h1>
  <h3>Admin Login page</h3>
    
  <form action="admin_login_ser" class="was-validated" method="post" >
  <table>
  <tr>
    <div class="mb-3 mt-3">
     <td> 
     <label for="uname" class="form-label">Email:</label>
      <input type="email"  id="uname" placeholder="Enter Email" name="e" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div></td>
    </div>
    </tr>
    <tr>
    <div class="mb-3">
      <td><label for="pwd" class="form-label">Password:</label>
      <input type="password"  id="pwd" placeholder="Enter password" name="p" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div></td>
    </div>
    </tr>
    <tr>
    <div class="form-check mb-3">
      <td><input class="form-check-input" type="checkbox" id="myCheck"  name="remember" required>
      <label class="form-check-label" for="myCheck">Click this check box to continue.</label>
      <div class="valid-feedback">Valid.</div></td>
      
    </div>
    </tr>
    <tr>
  <td><button type="submit" class="btn btn-primary">Submit</button></td><td><a href="admin_signup.jsp"><button type="button" class="btn btn-primary">Admin SignUp</button></a></td>
  </tr>
  <tr>
  <td><a href="user_login.jsp"><button type="button" class="btn btn-primary">User Login</button></a></td>
  </tr>
  </table>
  </form>
</div>

</body>
</html>