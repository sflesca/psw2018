<%@page import="org.agenda.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>La tua Agenda</title>
</head>
<body>
<jsp:useBean id="persone" class="org.agenda.model.PersoneBean" scope="request"></jsp:useBean>
<h1>Persone nel gruppo <%=persone.getGroupName() %></h1>
<%if(persone.getPers().size()>0){ %>
<ul>
<% for(Persona p : persone.getPers()){ %>
	<li>Id: <%= p.getId() %> Name: <%= p.getNome() %> </li>
<% } %>
</ul>
<%} else { %>
Nessuna persona nel gruppo!
<%} %>

<%if(persone.getGroups().size()>0){ %>
<ul>
<% for(Gruppo g : persone.getGroups()){ %>
	<li><a href="?gid=<%= g.getId() %>">Id: <%= g.getId() %> Name: <%= g.getNome() %></a> </li>
<% } %>
</ul>
<%} else { %>
Nessun gruppo!
<%} %>

<form action="InserisciGruppo" method="get">
<h2>Inserisci nuovo Gruppo</h2>
Nome: <input type=text name=groupname>
<input type=submit value="Crea Gruppo"><br>
</form>
</body>
</html>