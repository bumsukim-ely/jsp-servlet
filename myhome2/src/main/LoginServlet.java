package main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/login.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String success_id = "ztely";
		String success_password = "123400*";
		
		if(success_id.equals(id) && success_password.equals(password)) {
			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/login_success.jsp");
			dp.forward(request, response);
		} else {
			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/error/login_fail.jsp");
			dp.forward(request, response);
		}
	}

}
