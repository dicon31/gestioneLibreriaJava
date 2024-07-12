package gestioneAutori;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;

@WebServlet("/deleteAuthor")
public class DeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		//you are here
		try {
			int idAut = Integer.parseInt(request.getParameter("id"));
			
			PreparedStatement stmt = DB.getPreparedStmt("DELETE FROM author WHERE id = ?");
			stmt.setInt(1, idAut);
			
			int result = stmt.executeUpdate();
			if(result!=1) {
				throw new Exception();
			}  
			response.sendRedirect(request.getContextPath() + "/gestione-autori.jsp?s=1");
			 
		}
		catch (Exception e) {
			e.printStackTrace(); //in console lui ci stampa l'eccezione
			response.sendRedirect(request.getContextPath() + "/gestione-autori.jsp?e=1");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	} 
}