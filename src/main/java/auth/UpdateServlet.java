package auth;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;

@WebServlet("/modificaPassword") //specifico la rotta
public class UpdateServlet {
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
		String pass	= request.getParameter("password");
		
		int idUser			= Integer.parseInt(request.getParameter("idUser"));
		
		//validiamo i dati
		if( pass.isBlank() || idUser <= 0) {
			response.sendRedirect(request.getContextPath() + "/Modifica.jsp?e=1");
			return; 
		}
		//inseriamo i dati nel db 
		try {
			//codifico in md5
			pass = Authentication.MD5(pass);
			
				
			//preparo la query
			PreparedStatement stmt = DB.getPreparedStmt("UPDATE user SET password = ?");
			stmt.setString(1, pass);
			
			
			//la mando in esecuzione
			int result = stmt.executeUpdate();
			if(result!=1) {
				throw new Exception();
			} 
			//ritorno alla pagina degli autori
			response.sendRedirect(request.getContextPath() + "/login.jsp?s=1");
		} 
		catch(Exception e) {
			//e.printStackTrace();
			 response.sendRedirect(request.getContextPath() + "/Modifica.jsp?e=2");
			return;
		}  
	} 
}
