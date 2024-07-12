package gestioneCategorie;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerCategory") //specifico la rotta
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		//validiamo i dati
		if(nomeCategoria.isBlank()) {
			response.sendRedirect(request.getContextPath() + "/gestione-categorie.jsp?e=1");
			return; 
		}
		//inseriamo i dati nel db 
		try {
			//normalizzare i dati
			nomeCategoria = nomeCategoria.trim();
			nomeCategoria = nomeCategoria.substring(0, 1).toUpperCase() + nomeCategoria.substring(1).toLowerCase();
			
			//preparo la query
			PreparedStatement stmt = DB.getPreparedStmt("INSERT INTO category (name) VALUES (?)");
			stmt.setString(1, nomeCategoria); 
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
