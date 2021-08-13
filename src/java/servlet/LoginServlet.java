package servlet;

import com.example.Usuario;
import es.core.dao.LoginDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    
   @Inject 
   private  LoginDAO loginDAO;
  
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
        HttpSession sesion=request.getSession();
        String salir=request.getParameter("salir");
        if(salir!=null) {
            sesion.removeAttribute("username");
            response.sendRedirect(request.getContextPath()+"/");
        }else{
            if(sesion.getAttribute("username")==null){
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }else{
                response.sendRedirect(request.getContextPath()+"/perfil/");
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
//        processRequest(request, response);
          String nombre=request.getParameter("username");
         // String correo=request.getParameter("correo");
          String password=request.getParameter("password");
          Usuario u;
          
          try{
              u=loginDAO.getByEmailAndPassword(nombre, password);
          }catch (SQLException ex){
              u=null;
              //Hay q dejar constancia de la excepción con logger
          }
          
          if(u!=null){
              HttpSession sesion=request.getSession();
              sesion.setAttribute("usuario", u);
              response.sendRedirect(request.getContextPath()+"/perfil/");
          }else{
              request.setAttribute("mensaje", "Usuario o contraseña invalidos");
              RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
              rd.forward(request, response);
          }
    }
}