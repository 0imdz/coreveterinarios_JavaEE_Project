package servlet;

import static com.example.Cliente_.codigoPostal;
import static com.example.Cliente_.direccion;
import static com.example.Cliente_.dni;
import static com.example.Cliente_.email;
import static com.example.Cliente_.poblacion;
import static com.example.Cliente_.provincia;
import static com.example.Cliente_.telefono;
import com.example.Productos;
import es.core.dao.nuevoClienteDAO;
import es.core.dao.nuevoProductoDAO;
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

@WebServlet(name = "nuevoProductoServlet", urlPatterns = {"/nuevoProducto"})
public class nuevoProductoServlet extends HttpServlet {

    @Inject
    private nuevoProductoDAO nuevoProductoDAO;
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
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        
//        String correo = request.getParameter("correo");
//        if (nombre != null && (!nombre.equals("")) && (peso != null)) {
            Productos p = new Productos();
            p.setNombre(nombre);
            p.setDescripcion(descripcion);
            p.setPrecio(precio);
            p.setStock(stock);
            try {
//                registroDAO.addUsuario(usuario);
                nuevoProductoDAO.create(p);
            } catch (Exception e) {
               request.setAttribute("mensaje", "No válido." + e.getMessage());
                RequestDispatcher rd = request.getRequestDispatcher("/perfil/formulario1.jsp");
                rd.forward(request, response); 
                return;
            }
            if (p != null) {
                response.sendRedirect(request.getContextPath() + "/perfil/productos");
            } else {
                request.setAttribute("mensaje", "No válido.");
                RequestDispatcher rd = request.getRequestDispatcher("/nuevo_producto.jsp");
                rd.forward(request, response);
            }
//        }else{
//            request.setAttribute("mensaje", "No puede haber campos sin rellenar.");
//            RequestDispatcher rd = request.getRequestDispatcher("/registro.jsp");
//            rd.forward(request, response);
//        }
    }
}
