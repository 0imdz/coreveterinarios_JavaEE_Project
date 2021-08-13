package servlet;

import com.example.Usuario;
import es.core.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuarios"})
public class UsuarioServlet extends HttpServlet {

    @Inject
    private UsuarioDAO usuarioDAO;
    @Resource
    private UserTransaction ux;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombre = request.getParameter("username");
        String password = request.getParameter("password");
        String correo = request.getParameter("correo");

        try (PrintWriter out = response.getWriter()) {

            if (nombre != null && password != null) {
                Usuario usuario = new Usuario(nombre, correo, password);
                try {
                    ux.begin();
                    usuarioDAO.addNewUsuario(usuario);
                    ux.commit();
                } catch (Exception e) {
                    out.println(e);
                }
            }

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuariosServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(nombre);
            out.println("<h1>Servlet UsuariosServlet at " + request.getContextPath() + "</h1>");
            
                for (Usuario usuario : usuarioDAO.getAllUsuarios()) {
                    out.println("<p>");
                    out.println(usuario.getId() + " - " + usuario.getNombre());
                    out.println("</p>");
                }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        //processRequest(request, response);

        String nombre = request.getParameter("username");
        String password = request.getParameter("password");
        if (nombre!=null && nombre.equals("Emilio")) {
            response.sendRedirect(request.getContextPath() + "/perfil");
        } else {
            response.sendRedirect(request.getContextPath());
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}