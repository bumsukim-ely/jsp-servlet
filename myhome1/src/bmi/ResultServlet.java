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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String html = "";
		String[] bmi = request.getParameterValues("bmi");
		double tall = Double.parseDouble(bmi[0]);
		double weight = Double.parseDouble(bmi[1]);
		double bmires = weight / ((tall/100) * (tall/100)); 
		String bmi_type = "";
		
		if(bmires < 18.5) {
			bmi_type = "저체중";
		} else if(bmires >= 18.5 && bmires < 23) {
			bmi_type = "정상";
		} else if(bmires >= 23 && bmires <25) {
			bmi_type= "과체중";
		} else {
			bmi_type= "비만";
		}
		
		html += "<!DOCTYPE html>";
		html += "<head>";
		html += "    <meta charset=\"UTF-8\">";
		html += "    <title>Document</title>";
		html += "</head>";
		html += "<body>";
		html += "    <h2>키 : " + tall + "cm</h2>";
		html += "    <h2>체중 : " + weight + "kg</h2>";
		html += "    <h2>BMI 결과 값 : " + bmires + "</h2>";
		html += "    <h2>BMI 구분 값 : " + bmi_type + "</h2>";
		html += "</body>";
		html += "</html>";

		out.println(html);
	}

}
