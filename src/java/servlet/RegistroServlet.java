package servlet;

import com.example.Usuario;
import es.core.dao.RegistroDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/registro"})
public class RegistroServlet extends HttpServlet {

    @Inject
    private RegistroDAO registroDAO;
    @Resource
    private UserTransaction ux;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String salir = request.getParameter("salir");
        if (salir != null) {
            sesion.removeAttribute("username");
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            if (sesion.getAttribute("username") == null) {
                RequestDispatcher rd = request.getRequestDispatcher("/registro.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/perfil");
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("username");
        String password = request.getParameter("password");
        String correo = request.getParameter("correo");
        if (nombre != null && (!nombre.equals(""))
                && correo != null && (!correo.equals(""))
                && password != null && (!password.equals(""))) {
            Usuario usuario = new Usuario();
            usuario.setCorreo(correo);
            usuario.setNombre(nombre);
            usuario.setPassword(password);
            try {
//                registroDAO.addUsuario(usuario);
                registroDAO.create(usuario);
            } catch (Exception e) {
               request.setAttribute("mensaje", "Usuario o contraseña no válido." + e.getMessage());
                RequestDispatcher rd = request.getRequestDispatcher("/registro.jsp");
                rd.forward(request, response); 
                return;
            }
            if (usuario != null) {
                response.sendRedirect(request.getContextPath() + "/login");
            } else {
                request.setAttribute("mensaje", "Usuario o contraseña no válido.");
                RequestDispatcher rd = request.getRequestDispatcher("/registro.jsp");
                rd.forward(request, response);
            }
        }else{
            request.setAttribute("mensaje", "No puede haber campos sin rellenar.");
            RequestDispatcher rd = request.getRequestDispatcher("/registro.jsp");
            rd.forward(request, response);
        }
    }
}
