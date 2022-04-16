package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.istack.internal.logging.Logger;

import DAO.Crud;
import model.Usuario;

/**
 * Servlet implementation class ServletAuth
 */
@WebServlet("/Servleta")
public class Servleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servleta() {
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
		try(PrintWriter out = response.getWriter()){
    		Usuario user = new Usuario();
    		Crud log = new Crud();
    		int rspta = 0;
    		String rut = "";
    		if(request.getParameter("btn-login") != null) {
    			String usuario = request.getParameter("txtusuario");
    			String contraseña = request.getParameter("txtclave");
    			try {
    				rut = log.validar(usuario, contraseña);
    			} catch (Exception ex) {
    				System.out.println(ex);    				
    			}
    			if(rut == ""  || rut == null) {
    				response.sendRedirect("/LoginEva/login.jsp?rspta=" + rspta);
    			}else{
    				user = log.Read(rut);
    				request.setAttribute("nombre", user.getNombre());
    				request.setAttribute("apellido", user.getApellido());
    				request.setAttribute("rut", user.getRut());
    				request.getRequestDispatcher("loginSucces.jsp").forward(request, response);
    				response.sendRedirect("/LoginEva/loginSucces.jsp?rspta=" + rspta);
    			}
    		}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
