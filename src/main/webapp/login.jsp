<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="anagrafiche.Author" %>
    
<!doctype html>
<html lang="it">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
  	
  	<div class="container"> 
  	 	<jsp:include page="template/header.jsp"></jsp:include> 
  	 	
  	 	<!-- main content -->
  	 	
  	 	<div class="row">
  	 		<div class="col-12">
  	 			<h2>Login</h2>
  	 			<p>Accedi alla libreria</p>
  	 			<jsp:include page="include/alert.jsp"></jsp:include>
  	 			
  	 		</div>
  	 		<div class="col-12 col-md-5">
				<h2>Inserisci nuovo elemento</h2>
				<!--  FORM  -->
				<form method="post" action="./loginUser">
					<div class="mb-3">
						<label for="email">Email</label> <input type="email" min="0.0"
							step="0.01" name="email" id="email_val" class="form-control"
							required>
					</div>
					<div class="mb-3">
						<label for="password">Password</label> <input type="password" min="0.0"
							step="0.01" name="password" id="password_val" class="form-control"
							required>
					</div>
					<div class="mb-3">
						<input type="submit" value="Registrati" class="btn btn-primary">
					</div>
					<div>
					<a href="./update-password.jsp">Password dimenticata?</a></div>
				</form>


			</div>
		</div>
  	 		
  	
  	 	</div>
  	 	
  	 	<!-- end main content -->
  	 	
  	 	<jsp:include page="template/footer.jsp"></jsp:include> 
  	</div> 

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html> 