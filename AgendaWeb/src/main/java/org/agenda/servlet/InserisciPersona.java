package org.agenda.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.agenda.ejb.*;
import org.agenda.model.Persona;

/**
 * Servlet implementation class InserisciPersona
 */
@WebServlet("/InserisciPersona")
public class InserisciPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	@EJB
	PersoneEJB pEJB;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("pname");
		String gidStr = request.getParameter("gid");
		if(nome!=null&&gidStr!=null) {
			long gid = Long.parseLong(gidStr);
			Persona p = pEJB.inserisciPersona(nome, gid);
			request.setAttribute("persona", p);
			gotoPage("/nuovaPersona.jsp",request,response);
		}else
			response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void gotoPage(String address, HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
}
