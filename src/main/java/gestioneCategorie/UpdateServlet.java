package gestioneCategorie;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;

@WebServlet("/updateCategory") //specifico la rotta
public class UpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recuperiamo i dati
		String nomeCategoria    = request.getParameter("nome"); 
		int idCategoria 		= Integer.parseInt(request.getParameter("idCategoria"));
		//validiamo i dati
		if(nomeCategoria.isBlank() || idCategoria <= 0) {
			response.sendRedirect(request.getContextPath() + "/gestione-categorie.jsp?e=1");
			return; 
		}
		//inseriamo i dati nel db 
		try {
			//normalizzare i dati
			nomeCategoria = nomeCategoria.trim();
			nomeCategoria = nomeCategoria.substring(0, 1).toUpperCase() + nomeCategoria.substring(1).toLowerCase();
			
			//preparo la query
			PreparedStatement stmt = DB.getPreparedStmt("UPDATE category set name = ? WHERE id = ?");
			stmt.setString(1, nomeCategoria); 
			stmt.setInt(2,idCategoria);
			//la mando in esecuzione
			int result = stmt.executeUpdate();
			if(result!=1) {
				throw new Exception();
			} 
			//ritorno alla pagina degli autori
			response.sendRedirect(request.getContextPath() + "/gestione-categorie.jsp?s=1");
		} 
		catch(Exception e) {
			//e.printStackTrace();
			 response.sendRedirect(request.getContextPath() + "/gestione-categorie.jsp?e=2");
			return;
		}  
	} 
}
