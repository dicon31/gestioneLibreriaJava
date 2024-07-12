package gestioneAutori;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;

@WebServlet("/updateAuthor") //specifico la rotta
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
		String nomeAutore 		= request.getParameter("nome");
		String cognomeAutore 	= request.getParameter("cognome");
		
		int idAutore			= Integer.parseInt(request.getParameter("idAutore"));
		
		//validiamo i dati
		if(nomeAutore.isBlank()|| cognomeAutore.isBlank() || idAutore <= 0) {
			response.sendRedirect(request.getContextPath() + "/gestione-autori.jsp?e=1");
			return; 
		}
		//inseriamo i dati nel db 
		try {
			//normalizzare i dati
			nomeAutore = nomeAutore.trim();
			nomeAutore = nomeAutore.substring(0, 1).toUpperCase() + nomeAutore.substring(1).toLowerCase();
			
			cognomeAutore = cognomeAutore.trim(); //tolgo i spazi vuoti
			cognomeAutore = cognomeAutore.substring(0, 1).toUpperCase() + cognomeAutore.substring(1).toLowerCase();
										//piranDeLlo -> P				+		//irandello		 = Pirandello			
			//preparo la query
			PreparedStatement stmt = DB.getPreparedStmt("UPDATE author SET name = ?, lastname = ? where id = ? ");
			stmt.setString(1, nomeAutore);
			stmt.setString(2, cognomeAutore);
			stmt.setInt(3, idAutore);
			
			//la mando in esecuzione
			int result = stmt.executeUpdate();
			if(result!=1) {
				throw new Exception();
			} 
			//ritorno alla pagina degli autori
			response.sendRedirect(request.getContextPath() + "/gestione-autori.jsp?s=1");
		} 
		catch(Exception e) {
			//e.printStackTrace();
			 response.sendRedirect(request.getContextPath() + "/gestione-autori.jsp?e=2");
			return;
		}  
	} 
}
