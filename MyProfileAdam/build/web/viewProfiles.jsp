<%-- 
    Document   : viewProfiles
    Created on : Dec 24, 2025, 3:16:13 PM
    Author     : adaam
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.myprofileAdam.ProfileBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Profiles</title>
    <style>
        body { font-family: Arial; padding: 20px; background: #e8f0fe; }
        table { width: 100%; border-collapse: collapse; background: white; }
        th, td { padding: 12px; border: 1px solid #ddd; text-align: left; }
        th { background-color: #4CAF50; color: white; }
        .search-box { margin-bottom: 20px; }
        input[type="text"] { padding: 8px; width: 300px; }
        .btn { padding: 8px 15px; background: #4CAF50; color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>

    <h2>Class Profiles</h2>

    <div class="search-box">
        <form action="ViewServlet" method="GET">
            <input type="text" name="search" placeholder="Search by name...">
            <button type="submit" class="btn">Search</button>
            <a href="index.html" style="margin-left: 20px;">Add New Profile</a>
        </form>
    </div>

    <table>
        <tr>
            <th>Name</th>
            <th>Student ID</th>
            <th>Program</th>
            <th>Hobbies</th>
        </tr>
        <% 
            ArrayList<ProfileBean> list = (ArrayList<ProfileBean>) request.getAttribute("profileList");
            if (list != null) {
                for (ProfileBean p : list) {
        %>
        <tr>
            <td><%= p.getName() %></td>
            <td><%= p.getStudentID() %></td>
            <td><%= p.getProgram() %></td>
            <td><%= p.getHobbies() %></td>
        </tr>
        <% 
                }
            } 
        %>
    </table>

</body>
</html>
