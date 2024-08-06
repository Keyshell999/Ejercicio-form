/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class RecibeDatos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contraseña");
        String url = "jdbc:mysql://localhost:3306/mydb";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RecibeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        try {
            conexion = DriverManager.getConnection(url, "root", "");
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM `usuario` WHERE `correo` = '"+correo+"' AND `contraseña` = '"+contraseña+"'");

            if (rs.next()){
                request.getSession().setAttribute("correo", correo);
                response.sendRedirect("panel.jsp");
            }else {
                response.sendRedirect("index.html");
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecibeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
