<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// questa JSP ha il compito di mostrare una alert di successo 
	// quando riceve un parametro GET di nome "s" e di errore quando "e"
%>

<% if(request.getParameter("s") != null && Integer.parseInt(request.getParameter("s")) == 1) { %>
	<div class="alert alert-success">
		<strong>Ok!</strong> Operazione completata
	</div>
<% } %>

<% if(request.getParameter("e") != null) { %>
	<div class="alert alert-danger">
		<strong>Attenzione</strong> Impossibile completare l'operazione
	</div>
<% } %>   