package com.rn.testdb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "TestDbServlet", value = "/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = "root";
        String password = "Welcome@123";

        String jdbcURL = "jdbc:mysql://localhost:3306/hibernate_crud";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            PrintWriter out = response.getWriter();
            out.println("connecting to DB: "+jdbcURL);
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(jdbcURL, user, password);
            out.println("Connection Successful");
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
