package exam;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exam/random")
public class RandomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RandomServlet() {
        super();
    }
    
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		
//		Random rand = new Random();
//		String html = "";
//		int result = rand.nextInt(100)+1;
//		
//		html += "<!DOCTYPE html>";
//		html += "<head>";
//		html += "    <meta charset=\"UTF-8\">";
//		html += "    <title>Document</title>";
//		html += "</head>";
//		html += "<body>";
//		html += "<h2>" + result + "</h2>";
//		if(result>=1 && result <=20) {
//			html += "	<p style=\"color:#F85615\">" + result + "</p>";
//		} else if (result>=21 && result <=40) {
//			html += "	<p style=\"color:#F8156C\">" + result + "</p>";
//		} else if (result>=41 && result <=60) {
//			html += "	<p style=\"color:#159DF8\">" + result + "</p>";
//		} else if (result>=61 && result <=80) {
//			html += "	<p style=\"color:#4AF815\">" + result + "</p>";
//		} else {
//			html += "	<p style=\"color:#F8E115\">" + result + "</p>";
//		}
//		html += "</body>";
//		html += "</html>";
//		out.println(html);
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String[] range = request.getParameterValues("range");
		Random rand = new Random();
		
		int result = rand.nextInt(Integer.parseInt(range[1])-Integer.parseInt(range[0]))+Integer.parseInt(range[0]);
		
		response.sendRedirect("random/res?rs="+result+"&mn="+range[0]+"&mx="+range[1]);
	}

}
