package auth;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DB;
@WebServlet("/loginUser")
public class LoginServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String email	= request.getParameter("email");
		String pass	= request.getParameter("password");
		//preparo i dati
		pass=Authentication.MD5(pass);
		
		//verifico se l utente sia nel dp
		//eseguo una select su user
		try {
			
		
		PreparedStatement stmtUser = DB.getPreparedStmt("SELECT * from user WHERE email = ? and password = ?");
		stmtUser.setString(1,email);
		stmtUser.setString(2,pass);
		
		ResultSet rs = stmtUser.executeQuery();
		
		if(rs.next()) {
			User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getString("email"));
			// creo una sessione                                                             
			HttpSession session = request.getSession();   //recupera e lo mette su session 
			// lo metto in sessione si salva con passare chiave e valore
			session.setAttribute(User.USERKEY,u);
			// redirect -> /app
			response.sendRedirect(request.getContextPath() + "/index.jsp");
					 
		}else {
			 response.sendRedirect(request.getContextPath() + "/registrazione.jsp?e=2");
				
		}
		}
		catch(Exception e) {
			//e.printStackTrace();
			 response.sendRedirect(request.getContextPath() + "/registrazione.jsp?e=2");
			return;
		}  
		//se si attivo la sessione
		
		//se no lo rimando in login
	
	
	}
}
