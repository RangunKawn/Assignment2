package com.myprofileAdam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

   
    private static final String DB_URL = "jdbc:derby://localhost:1527/student_profiles";
    private static final String DB_USER = "app";
    private static final String DB_PASS = "app";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        
        String name = request.getParameter("name");
        String studentID = request.getParameter("studentID");
        String program = request.getParameter("program");
        String email = request.getParameter("email");
        String hobbies = request.getParameter("hobbies");
        String intro = request.getParameter("intro");

        
        ProfileBean profile = new ProfileBean();
        profile.setName(name);
        profile.setStudentID(studentID);
        profile.setProgram(program);
        profile.setEmail(email);
        profile.setHobbies(hobbies);
        profile.setIntro(intro);

        
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            
            String sql = "INSERT INTO profile (name, studentID, program, email, hobbies, intro) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, profile.getName());
            statement.setString(2, profile.getStudentID());
            statement.setString(3, profile.getProgram());
            statement.setString(4, profile.getEmail());
            statement.setString(5, profile.getHobbies());
            statement.setString(6, profile.getIntro());
            
            statement.executeUpdate();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }

       
        request.setAttribute("userProfile", profile);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}