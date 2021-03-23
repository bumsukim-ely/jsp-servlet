package bmi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		request.setAttribute("tall", tall);
		request.setAttribute("weight", weight);
		request.setAttribute("bmi", bmires);
		request.setAttribute("bmi_type", bmi_type);
		
		RequestDispatcher dp = request.getRequestDispatcher("res/view");
		dp.forward(request, response);
	}

}
