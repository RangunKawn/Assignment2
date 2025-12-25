<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.myprofileAdam.ProfileBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile Saved</title>
    <style>
       
        .btn { padding: 10px; background: #007bff; color: white; text-decoration: none; border-radius: 5px; }
    </style>
</head>
<body>
<div class="card">
    <h1>Profile Saved Successfully!</h1>
    
    <% 
        ProfileBean user = (ProfileBean) request.getAttribute("userProfile");
        if(user != null) { 
    %>
        <p><span class="label">Name:</span> <span class="value"><%= user.getName() %></span></p>
        <p><span class="label">ID:</span> <span class="value"><%= user.getStudentID() %></span></p>
        <p><span class="label">Program:</span> <span class="value"><%= user.getProgram() %></span></p>
        <p><span class="label">Hobbies:</span> <span class="value"><%= user.getHobbies() %></span></p>
    <% } %>
    
    <br><br>
    <a href="ViewServlet" class="btn">View All Profiles</a>
</div>
</body>
</html>