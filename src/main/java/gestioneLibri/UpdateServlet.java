package gestioneLibri;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;

@WebServlet("/updateBook") //specifico la rotta
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
		String titoloLibro = request.getParameter("titolo");
		float prezzoLibro  = Float.parseFloat(request.getParameter("prezzo"));
		//recuperiamo categoria e autore?
		int idAutore = Integer.parseInt(request.getParameter("autore"));
		int idCategoria = Integer.parseInt(request.getParameter("categoria"));
		int idBook = Integer.parseInt(request.getParameter("idBook"));
		
		//validiamo
		if(titoloLibro.isBlank() || prezzoLibro <= 0 || idBook <= 0 || idAutore <=0 || idCategoria <=0) {
			response.sendRedirect(request.getContextPath() + "/gestione-libri.jsp?e=1");
			return;
		}
		//inseriamo i dati nel db 
		
		try {
			//normalizzare i dati 
			titoloLibro= titoloLibro.trim(); 
			//preparo la query
			PreparedStatement stmt = DB.getPreparedStmt("UPDATE book set "
					+ "title = ?, "
					+ "price = ?, "
					+ "category_id = ?, "
					+ "author_id = ? "
					+ "WHERE id = ?  ");
	
			
			stmt.setString(1, titoloLibro);
			stmt.setFloat(2, prezzoLibro);
			stmt.setInt(3, idCategoria);
			stmt.setInt(4, idAutore); 
			stmt.setInt(5, idBook); 
			
			//la mando in esecuzione
			int result = stmt.executeUpdate();
			if(result!=1) {
				throw new Exception();
			} 
			//ritorno alla pagina degli autori
			response.sendRedirect(request.getContextPath() + "/gestione-libri.jsp?s=1");
		} 
		catch(Exception e) {
			//e.printStackTrace();
			 response.sendRedirect(request.getContextPath() + "/gestione-libri.jsp?e=2");
			return;
		}   
	} 
}