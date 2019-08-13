import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String submitType = request.getParameter("submit");
        String submitType1=request.getParameter("check");
UserDAO ud =new UserMethod();
User u=ud.getUser(userName,password);
if(submitType.equals("login") && u.getUsername()!=null && u !=null){
    request.setAttribute("NAME", u.getUsername());

    request.setAttribute("money",u.getMoney());

request.getRequestDispatcher("/Welcome.jsp").forward(request,response);

}
 if(submitType1.equals("ch")) {
    request.setAttribute("Check", u.getMoney());
    request.getRequestDispatcher("/Check.jsp").forward(request,response);
}


else{
request.getRequestDispatcher("/Error.jsp").forward(request,response);
}





    }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
