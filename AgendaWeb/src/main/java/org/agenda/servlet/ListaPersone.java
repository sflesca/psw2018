package org.agenda.servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.agenda.model.*;

/**
 * Servlet implementation class ListaPersone
 */
@WebServlet("/ListaPersone")
public class ListaPersone extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	EntityManager em;

    @Resource
    UserTransaction utx;
    
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
		try {
			utx.begin();
		} catch (NotSupportedException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String gidStr = request.getParameter("gid");
		PersoneBean pb = new PersoneBean();
		request.setAttribute("persone", pb);
		if(gidStr!=null) {
			long gid = Integer.parseInt(gidStr);
			Gruppo g = em.find(Gruppo.class, gid);
			pb.setGroup(g);
//			Query q = em.createNamedQuery("findPersonsByGroupId");
//			q.setParameter("groupid", g.getId());
//			List<Persona> lp =q.getResultList();
//			for( Persona p: lp) {
			for( Persona p: g.getPersona()) {
				pb.getPers().add(p);
			}
		}else {
		Query q = em.createNamedQuery("findAllPersons");
		List<Persona> lp =q.getResultList();
		for( Persona p: lp) {
			pb.getPers().add(p);
		}
		}
		Query q = em.createNamedQuery("findAllGroups");
		List<Gruppo> lg =q.getResultList();
		for( Gruppo g: lg) {
			pb.getGroups().add(g);
		}
		try {
			utx.commit();
		} catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
				| HeuristicRollbackException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gotoPage("/Persone.jsp",request,response);
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

