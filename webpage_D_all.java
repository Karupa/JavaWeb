/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wad29
 */
@WebServlet(urlPatterns = {"/webpage_D_all"})
public class webpage_D_all extends HttpServlet {

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
            out.println("<title>Servlet webpage_D_all</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet webpage_D_all at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        
         Connection connection;
        String url = "jdbc:postgresql://localhost:5432/emp";
        String user = "postgres";
        String password = "root";
        String _firstname = request.getParameter("fname");
        String _lastname = request.getParameter("lname");
        String email = request.getParameter("email");
        String exp = request.getParameter("exp");
        String age =request.getParameter("age");
        String phone =request.getParameter("phone");
        String gender =request.getParameter("gender");
        String emp_id =request.getParameter("emp_id");
       // out.println(gender);
        
        
        try {        
            Class.forName("org.postgresql.Driver");    
        } catch(ClassNotFoundException e ){
              //e.getMessage();
              out.println(e.getMessage());
        }    
        
        // response.setContentType("text/html>");
         out.println("<html><body>");
        try {
                connection = DriverManager.getConnection(url, user, password);
                out.println("Connected");
                Statement stmt = connection.createStatement();                
                ResultSet rs = stmt.executeQuery("select * from employ ");//where emp_id='"+ emp_id +"';");
                //out.println(i);
                 
                out.println("<table border=1 >");  
                out.println("<tr><th>emp_id</th><th>fname</th><th>lname</th><th>email</th><th>experience</th><th>age</th><th>phone</th><th>gender</th><tr>");  
                while (rs.next()) 
                {  
                String n = rs.getString("emp_id");  
                String n1 = rs.getString("fname"); 
                String n2 = rs.getString("lname"); 
                String n3 = rs.getString("email"); 
                String n4 = rs.getString("exp"); 
                String n5 = rs.getString("age");
                String n6 = rs.getString("phone"); 
                String n7 = rs.getString("gender"); 
                
                
                
                
                
                 //out.println(n2);
                
               // int s = rs.getInt("sal");   
                out.println("<tr><td>" + n + "</td><td>" + n1 + "</td><td>" + n2 + "</td><td>"+ n3 + "</td><td>"+ n4 + "</td><td>"+ n5 + "</td><td>"+ n6 + "</td><td>"+ n7 +"</td></tr>");   
                }  
                out.println("</table>"); 
               
                out.println("</body></html>");  
                
                
                
                
                
                 //out.println(n2);
                
                connection.close();
        } catch (SQLException ex) {
        out.println(ex.getMessage());        
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
