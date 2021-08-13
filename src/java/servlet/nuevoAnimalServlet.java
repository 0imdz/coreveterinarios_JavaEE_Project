package servlet;

import com.example.Animales;
import es.core.dao.nuevoAnimalDAO;
import java.io.IOException;
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

@WebServlet(name = "nuevoAnimalServlet", urlPatterns = {"/nuevoAnimal"})
public class nuevoAnimalServlet extends HttpServlet {

    @Inject
    private nuevoAnimalDAO nuevoAnimalDAO;
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
                RequestDispatcher rd = request.getRequestDispatcher("/nuevo_animal.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/formulario1");
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

        String nombre = request.getParameter("nombre");
        int peso_gramos = Integer.parseInt(request.getParameter("peso"));
//        String correo = request.getParameter("correo");
//        if (nombre != null && (!nombre.equals("")) && (peso != null)) {
            Animales a = new Animales();
            a.setNombre(nombre);
            a.setPeso_gramos(peso_gramos);
            try {
//                registroDAO.addUsuario(usuario);
                nuevoAnimalDAO.create(a);
            } catch (Exception e) {
               request.setAttribute("mensaje", "No válido." + e.getMessage());
                RequestDispatcher rd = request.getRequestDispatcher("/perfil/formulario1.jsp");
                rd.forward(request, response); 
                return;
            }
            if (a != null) {
                response.sendRedirect(request.getContextPath() + "/perfil/animales");
            } else {
                request.setAttribute("mensaje", "No válido.");
                RequestDispatcher rd = request.getRequestDispatcher("/nuevoAnimal.jsp");
                rd.forward(request, response);
            }
//        }else{
//            request.setAttribute("mensaje", "No puede haber campos sin rellenar.");
//            RequestDispatcher rd = request.getRequestDispatcher("/registro.jsp");
//            rd.forward(request, response);
//        }
    }
}
