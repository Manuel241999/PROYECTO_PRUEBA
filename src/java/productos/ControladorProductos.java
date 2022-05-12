package productos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author mordo
 */
@WebServlet(urlPatterns = {"/ControladorProductos"})
public class ControladorProductos extends HttpServlet {

    //Hicimos el llamado al modelo:
    private ModeloProductos modeloProductos;
    //Hacemos el llamado del pool de conexiones:
    @Resource(name="jdbc/pruebas")
    /*VOLVES A HACER EL POOL DE CONEXIONES*/
    private DataSource miPool;
    
    //metodo init(METODO DESDE EL CUAL ARRANCA LA APLICACION):

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
    //CONECTAMOS CON EL MODELO:
    
    try{
        /*AQUI LE MANDAS EL POOL AL OTRO POOL QUE TENES EN ModeloProductos:*/
    modeloProductos = new ModeloProductos(miPool);
    }catch(Exception e){
        throw new ServletException(e);
     }
    }
    
    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorProductos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProductos at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
       
      //OBTENER LA LISTA DE PRODUCTOS DESDE EL MODELO(OSEA LO QUE LE VAMOS A PEDIR AL MODELO):
      List<Productos> productos;//CREO UN ARRAY PARA ALMACENAR  EL ARRAY QUE TIENE YA TODAS LAS SENTENCIAS EN SQL
      try{
      //llamar al metodo getproductos:
      productos = modeloProductos.getProductos();//aqui llama al metodo para extraer los datos.
      
      //AGREGAR ESA LISTA DE PRODUCTOS AL REQUEST:
      request.setAttribute("LISTAPRODUCTOS", productos);//LE DAS NOMBRE AL ARRAY
      //ENVIAR ESE REQUEST A LA PAGINA JSP:
      RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaProductos.jsp");
      miDispatcher.forward(request, response);
      
      }catch(Exception e){
         e.printStackTrace();
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
        processRequest(request, response);
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
