package bmi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bmi/res")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ResultServlet() {
        super();
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String html = "";
		String[] bmi = request.getParameterValues("bmi");
		double height = Double.parseDouble(bmi[0]);
		double weight = Double.parseDouble(bmi[1]);
		
		html += "<!DOCTYPE html>";
		html += "<head>";
		html += "    <meta charset=\"UTF-8\">";
		html += "    <title>Document</title>";
		html += "</head>";
		html += "<body>";
		html += "    <h2>키 : " + height + "cm</h2>";
		html += "    <h2>체중 : " + weight + "kg</h2>";
		html += "    <h2>BMI 결과 값 : </h2>";
		html += "    <h2>BMI 구분 값 : </h2>";
		html += "</body>";
		html += "</html>";

		out.println(html);
	}

}
