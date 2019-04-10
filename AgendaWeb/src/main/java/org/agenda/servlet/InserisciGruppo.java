package org.agenda.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.agenda.ejb.CaricamentoDati;
import org.agenda.model.Gruppo;

/**
 * Servlet implementation class InserisciGruppo
 */
@WebServlet("/InserisciGruppo")
public class InserisciGruppo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	CaricamentoDati app;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciGruppo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeGruppo = request.getParameter("groupname");
		if (nomeGruppo!=null&& !nomeGruppo.equals("")) {
			Gruppo g = app.inserisciGruppo(nomeGruppo);
			request.setAttribute("gruppo", g);
			gotoPage("/nuovoGruppo.jsp",request,response);
		}else {
			response.getWriter().append("Specificare Nome");
		}
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
