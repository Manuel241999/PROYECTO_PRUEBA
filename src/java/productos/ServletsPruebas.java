/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package productos;



import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;

import javax.sql.DataSource;
import java.sql.Statement;


/**
 *
 * @author mordo
 */
@WebServlet(name = "ServletsPruebas", urlPatterns = {"/ServletsPruebas"})
public class ServletsPruebas extends HttpServlet {

//Definir o establecer el dataSource    
    @Resource(name="jdbc/pruebas")
    private DataSource miPool;
    
   
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletsPruebas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>HOLA PUTA " + request.getContextPath() + "</h1>");
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
       //CREAR EL OBJETO printWritter
       
      PrintWriter salida = response.getWriter();
       
      response.setContentType("text/plain");
       
       //CREAR CONEXION CON BBDD
       
       Connection miConexion = null;
       Statement miStatement = null;
       ResultSet miResultset = null;
       
       try{
           miConexion = miPool.getConnection();
           String miSql="SELECT * FROM PRODUCTOS";
           miStatement = miConexion.createStatement();         
           miResultset = miStatement.executeQuery(miSql);
          
           while(miResultset.next()){
               String codigo_articulo=miResultset.getString(1);
               salida.print(codigo_articulo);
               salida.println("\t");
               
               String seccion=miResultset.getString(2);
                salida.print(seccion);
                salida.println("\t");
                
               String nombre_articulo=miResultset.getString(3);
                 salida.print(nombre_articulo);
                 salida.println("\t");
                 
               String precio=miResultset.getString(4);
                salida.print(precio);
                salida.println("\t");
               
               String fecha=miResultset.getString(5);
                salida.print(fecha);
                salida.println("\t");
               
               String importado=miResultset.getString(6);
                salida.print(importado);
                salida.println("\t");
               
               String pais_origen=miResultset.getString(7);
                salida.print(pais_origen);
               salida.println("\n");
           }
           
           
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
