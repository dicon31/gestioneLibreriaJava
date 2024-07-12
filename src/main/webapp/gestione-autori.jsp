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
  	 			<h2>Gestione Autori</h2>
  	 			<p>Contenuto principale</p> 
  	 			
  	 			<jsp:include page="include/alert.jsp"></jsp:include>
  	 			
  	 		</div>
  	 	</div>
  	 	
  	 	
  	 	
  	 	<div class="row">
  	 		<div class="col-12 col-md-6">
  	 			<h2>Autori presenti</h2> 
  	 			<!--  TABELLA  -->
  	 			<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Nome</th>
				      <th scope="col">Cognome</th> 
				      <th></th>
				      <th></th>
				    </tr>
				  </thead>
				  <tbody> 
  	 			<% 
  	 			//import della lista
  	 			ArrayList<Author> listAutori = Author.getAll(); 
  	 			%> 
  	 			<!-- devo stampare gli autori dentro una tabella --> 
  	 			<!--  ciclare sugli elementi della lista --> 
  	 			<% for(Author a : listAutori) { %>

						<tr>
							<td><%=a.getId()%></td>
							<td><%=a.getNome()%></td>
							<td><%=a.getCognome()%></td>
							<td><a href="deleteAuthor?id=<%=a.getId()%>"
								class="btn btn-outline-warning">Elimina</a></td>
							<td><a href="./update-autori.jsp?id=<%=a.getId()%>" class="btn btn-danger">Modifica</a></td>
						</tr>


						<%
						}
						%>
  	 			
  	 			</tbody>
				</table>
				
  	 		</div>
  	 		<div class="col-12 col-md-6">
  	 			<h2>Inserisci nuovo elemento</h2> 
  	 			<!--  FORM  -->
  	 			
  	 			<form method="post" action="./registerAuthor"> 
  	 				<div class="mb-3">
						<label for="nome">Nome</label>
						<input type="text" name="nome" id="nome" class="form-control" required>
					</div>
					<div class="mb-3">
						<label for="cognome">Cognome</label>
						<input type="text" name="cognome" id="cognome" class="form-control" required>
					</div> 
					<div class="mb-3"> 
						<input type="submit" value="Salva" class="btn btn-primary">
					</div> 
  	 			</form> 

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