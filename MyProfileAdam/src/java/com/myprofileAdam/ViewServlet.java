package com.myprofileAdam;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ViewServlet", urlPatterns = {"/ViewServlet"})
public class ViewServlet extends HttpServlet {

   
    private static final String DB_URL = "jdbc:derby://localhost:1527/student_profiles";
    private static final String DB_USER = "app";
    private static final String DB_PASS = "app";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<ProfileBean> list = new ArrayList<>();
        String search = request.getParameter("search");
        
        try {
           
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            
            String sql;
            PreparedStatement ps;
            
            
            if (search != null && !search.isEmpty()) {
                sql = "SELECT * FROM profile WHERE name LIKE ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + search + "%");
            } else {
                sql = "SELECT * FROM profile";
                ps = conn.prepareStatement(sql);
            }

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ProfileBean p = new ProfileBean();
                
                p.setName(rs.getString("name"));
                p.setStudentID(rs.getString("studentID"));
                p.setProgram(rs.getString("program"));
                p.setHobbies(rs.getString("hobbies"));
                
                list.add(p);
            }
            conn.close();
            
        } catch (Exception e) { 
            e.printStackTrace(); 
        }

        request.setAttribute("profileList", list);
        request.getRequestDispatcher("/viewProfiles.jsp").forward(request, response);
    }
}