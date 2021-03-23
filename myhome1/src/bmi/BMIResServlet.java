package bmi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bmi/res/view")
public class BMIResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BMIResServlet() {
        super();
     
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Double tall = (Double)request.getAttribute("tall");
		Double weight = (Double)request.getAttribute("weight");
		Double bmi = (Double)request.getAttribute("bmi");
		String bmi_type = (String)request.getAttribute("bmi_type");
		
		PrintWriter out = response.getWriter();
		String html = "";
		html += "<!DOCTYPE html>";
		html += "<head>";
		html += "    <meta charset=\"UTF-8\">";
		html += "    <title>Document</title>";
		html += "</head>";
		html += "<body>";
		html += "    <h2>키 : " + tall + "cm</h2>";
		html += "    <h2>체중 : " + weight + "kg</h2>";
		html += "    <h2>BMI 결과 값 : " + bmi + "</h2>";
		html += "    <h2>BMI 구분 값 : " + bmi_type + "</h2>";
		html += "</body>";
		html += "</html>";

		out.println(html);
	}

}
