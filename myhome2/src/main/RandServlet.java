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

@WebServlet("/random")
public class RandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RandServlet() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/rand.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int min = Integer.parseInt(request.getParameter("min"));
		int max = Integer.parseInt(request.getParameter("max"));
		ArrayList<String> values = new ArrayList<>(); 
		Random rand = new Random();
//		if(min > max) {
//			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/error/range.jsp");
//			request.setAttribute("message", "최소/최대값 범위 설정이 잘못되었습니다.");
//			dp.forward(request, response);
//		}
//		try {
//			for(int i=1; i<7; i++) {
//				values.add(i + "번째 랜덤값 " + (rand.nextInt(max-min+1)+min));
//			}
//		} catch(Exception e) {
//			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/error/range.jsp");
//			request.setAttribute("message", "최소/최대값 범위 설정이 잘못되었습니다.");
//			dp.forward(request, response);
//		}
		
		for(int i=1; i<7; i++) {
			values.add(i + "번째 랜덤값 " + (rand.nextInt(max-min+1)+min));
		}
		
		request.setAttribute("values", values);
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/randres.jsp");
		dp.forward(request, response);
	}
}
