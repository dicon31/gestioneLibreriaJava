<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="anagrafiche.*"%>

<!doctype html>
<html lang="it">
<head>

<style>
.box{
	margin: 0 auto;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>

	<div class="container">
		<jsp:include page="template/header.jsp"></jsp:include>

		<!-- main content -->

			<div class="col-12 col-md-6 box">
				<h2>Modifica Autore</h2>
				 <%Author autori = Author.getAuthorById(Integer.parseInt(request.getParameter("id"))); %>
				<h5> Stai modificando <%=autori.getNome() + " " + autori.getCognome() %></h5>
				<form method="post" action="./updateAuthor"> 
				
					<div class="mb-3">
						<label for="nome">Nome</label>
						<input type="text" name="nome" id="nome_v" class="form-control" value="<%= autori.getNome() %>" required>
					</div>
					<div class="mb-3">
						<label for="cognome">Cognome</label>
						<input type="text" name="cognome" id="cognome_v" class="form-control" value="<%= autori.getCognome() %>" required>
					</div> 
					<div class="mb-3">
						<input type="hidden" value="<%=autori.getId()%>" name="idAutore">
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
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>
