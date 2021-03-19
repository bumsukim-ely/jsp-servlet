package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanServlet
 */
@WebServlet("/exam/gugudan")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GugudanServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String dan = request.getParameter("dan");

		
		PrintWriter out = response.getWriter(); 
		String html = "";
		
		html += "<table border=\"1\">";
		html += "	<caption>" + dan + "단 </caption>";
		html += "	<tr>";
		for(int i=1; i<10; i++) {
			html += "		<td>" + dan + " * " + i + " = " + Integer.parseInt(dan)*i + "</td>";
		}
		html += "</table>";
		
//		for(int i=1; i<10; i++) {
//			html += "    <table border=\"1\">";
//			html += "		 <caption>" + i + "단 </caption>";
//			html += "        <tr>";
//			for(int j=1; j<10; j++) {
//				html += "            <td>" + i + " * " + j + " = " + i*j + "</td>";
//			}
//			html += "        </tr>";
//			html += "    </table>";
//		}
		out.println(html);
	}

}
