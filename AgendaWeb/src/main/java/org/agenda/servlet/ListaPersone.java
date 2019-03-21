package org.agenda.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.agenda.model.*;

/**
 * Servlet implementation class ListaPersone
 */
@WebServlet("/ListaPersone")
public class ListaPersone extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	EntityManager em;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaPersone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().println(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<title>Elenco Prodotti</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<h1>Persone</h1>");
		Query q = em.createNamedQuery("findAll");
		List<Persona> l =q.getResultList();
		response.getWriter().println("<ul>");
		for( Persona p: l) {
			response.getWriter().println("<li>id:"+p.getId()+" nome:"+p.getNome()+"</li>");
		}
		response.getWriter().println("</ul>");
		response.getWriter().println(
				"</body>\n" + 
				"</html>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
