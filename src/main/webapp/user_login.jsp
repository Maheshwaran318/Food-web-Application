<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
<h1>SWIZO</h1>
  <h3>Login page</h3>
    
  <form action="user_login_ser" class="was-validated" method="post">
  <table>
  <tr>
    <div class="mb-3 mt-3">
      <td><label for="uname" class="form-label">Email:</label>
      <input type="email"  id="uname" placeholder="Enter Email" name="e" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div></td>
    </div>
    </tr>
    <div class="mb-3">
    <tr>
      <td><label for="pwd" class="form-label">Password:</label>
      <input type="password"  id="pwd" placeholder="Enter password" name="p" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div></td>
      </tr>
    </div>
    <div class="form-check mb-3">
    <tr>
      <td><input class="form-check-input" type="checkbox" id="myCheck"  name="remember" required>
      <label class="form-check-label" for="myCheck">Click this checkbox to continue.</label>
      <div class="valid-feedback">Valid.</div></td>
      </tr>
    </div>
    <tr>
  <td><button type="submit" class="btn btn-primary">Submit</button></td><td> <a href="signup.jsp"><button type="button" class="btn btn-primary">Signup</button> </a></td>
  </tr>
  <tr>
  <td><a href="admin_login.jsp"><button type="button" class="btn btn-primary">Admin Login</button> </a></td>
  </tr>
  </table>
  </form>
  
</div>

</body>
</html>