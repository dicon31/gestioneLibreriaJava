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

@WebServlet("/dimenticaPassword")
public class DimenticaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DimenticaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        try {
            PreparedStatement stmtUser = DB.getPreparedStmt("SELECT * FROM user WHERE email = ?");
            stmtUser.setString(1, email);
            ResultSet rs = stmtUser.executeQuery();

            if (rs.next()) {
                User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getString("email"));
                HttpSession session = request.getSession();
                session.setAttribute(User.USERKEY, u);
                response.sendRedirect(request.getContextPath() + "/Modifica.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/update-password.jsp?e=2");
            }
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/update-password.jsp?e=2");
        }
    }
}