package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/random/res")
public class RandResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RandResServlet() {
        super();
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int min = Integer.parseInt(request.getParameter("min"));
		int max = Integer.parseInt(request.getParameter("max"));
		ArrayList<String> values = new ArrayList<>(); 
		Random rand = new Random();
		
		for(int i=1; i<7; i++) {
			values.add(i + "번째 랜덤값 " + (rand.nextInt(max-min+1)+min));
		}

		request.setAttribute("values", values);
		RequestDispatcher dp = request.getRequestDispatcher("../randres.jsp");
		dp.forward(request, response);
	}

}
