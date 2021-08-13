package servlet;

import es.core.dao.AnimalesDAO;
import es.core.dao.ClienteDAO;
import es.core.dao.ProductosDAO;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PerfilServlet", urlPatterns = {"/perfil/*"})
public class PerfilServlet extends HttpServlet {

    @Inject 
    private ProductosDAO productoDAO;
    @Inject 
    private ClienteDAO clienteDAO;
    @Inject 
    private AnimalesDAO animalDAO;
    

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
//        String filtro=request.getParameter("filtro");//si viene como QueryParam
        String filtro=request.getPathInfo();
        request.setAttribute("filtro", filtro);
        if(filtro!=null){
            switch(filtro){
                case "/productos":
                    request.setAttribute("productosList",productoDAO.getAllProductos());
                    break;
                case "/clientes":
                    request.setAttribute("clientesList",clienteDAO.getAllClientes());
                    break;
                case "/animales":
                    request.setAttribute("animalesList",animalDAO.getAllAnimales());
                    break;
                case "/formulario1":
                    request.setAttribute("formularioList", animalDAO.getAllAnimales());
                    break;
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("/perfil.jsp");
        rd.forward(request, response);
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
}