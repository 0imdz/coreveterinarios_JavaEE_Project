package servlet;

import static com.example.Animales_.peso_gramos;
import com.example.Cliente;
import es.core.dao.nuevoAnimalDAO;
import es.core.dao.nuevoClienteDAO;
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

@WebServlet(name = "nuevoClienteServlet", urlPatterns = {"/nuevoCliente"})
public class nuevoClienteServlet extends HttpServlet {

    @Inject
    private nuevoClienteDAO nuevoClienteDAO;
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
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String dni = request.getParameter("dni");
        String poblacion = request.getParameter("poblacion");
        String provincia = request.getParameter("provincia");
        String codigoPostal = request.getParameter("codigopostal");
        
//        String correo = request.getParameter("correo");
//        if (nombre != null && (!nombre.equals("")) && (peso != null)) {
            Cliente c = new Cliente();
            c.setNombre(nombre);
            c.setEmail(email);
            c.setTelefono(telefono);
            c.setDireccion(direccion);
            c.setDni(dni);
            c.setPoblacion(poblacion);
            c.setProvincia(provincia);
            c.setCodigoPostal(codigoPostal);
            try {
//                registroDAO.addUsuario(usuario);
                nuevoClienteDAO.create(c);
            } catch (Exception e) {
               request.setAttribute("mensaje", "No válido." + e.getMessage());
                RequestDispatcher rd = request.getRequestDispatcher("/perfil/formulario1.jsp");
                rd.forward(request, response); 
                return;
            }
            if (c != null) {
                response.sendRedirect(request.getContextPath() + "/perfil/clientes");
            } else {
                request.setAttribute("mensaje", "No válido.");
                RequestDispatcher rd = request.getRequestDispatcher("/nuevoCliente.jsp");
                rd.forward(request, response);
            }
//        }else{
//            request.setAttribute("mensaje", "No puede haber campos sin rellenar.");
//            RequestDispatcher rd = request.getRequestDispatcher("/registro.jsp");
//            rd.forward(request, response);
//        }
    }
}
