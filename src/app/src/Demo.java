import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class Demo extends HttpServlet {
  Connection con = null;

  static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
  static final String DB_URL = "jdbc:mariadb://db:3306/test";
  static final String USER = "root";
  static final String PASS = "root";
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String name = request.getParameter("name");
    String pass = request.getParameter("pass");
    out.print("<h2>Welcome to "+ name + " Servlet</h2>");
    out.print("<h2> Your password is "+pass + ".</h2>");

    try {
        Class.forName(JDBC_DRIVER);
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement st = con.createStatement();
        String sql = "select username, password from accounts";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) {
            out.print("<h2> Welcome "+rs.getString(1)+"</h2>");
        }
    }

    catch (SQLException e) {
        out.print(e);
    }
    catch(ClassNotFoundException e) {
        out.print(e);
    }



   }

}
