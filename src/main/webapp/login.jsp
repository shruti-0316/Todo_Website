<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<%@include file="component/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f2">
<%@include file="component/login_nav.jsp" %>
  <div class="container">
  <div class="row p-5">
  <div class="col-md-6 offset-md-3"> 
  
  <h3 class="text-center">Login for Todo</h3>
  <div class="card">
  <div class="card-body">
  <form>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>
  
  </div>
  </div>
  </div>
  </div>
  </div>

</body>
</html>