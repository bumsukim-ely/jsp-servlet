package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exam/random/res")
public class RandomResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RandomResServlet() {
        super();
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String html = "";
		String rs = request.getParameter("rs");
		String mn = request.getParameter("mn");
		String mx = request.getParameter("mx");
		
		html += "<!DOCTYPE html>";
		html += "<head>";
		html += "    <meta charset=\"UTF-8\">";
		html += "    <title>Document</title>";
		html += "</head>";
		html += "<body>";
		html += "<h2>" + "최소: " + mn + "</h2><br>";
		html += "<h2>" + "최대: " + mx + "</h2><br>"; 
		html += "<h2>" + rs + "</h2>";
		html += "</body>";
		html += "</html>";
		out.println(html);
	}

}
