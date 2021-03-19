package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServlet
 */
@WebServlet("/home/getdata")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("service() 메서드 동작");
//		
//		super.service(request, response);
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String[] z = request.getParameterValues("z");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String html = "";
		html += "doGet()메서드 동작";
		html += "<br>파라메터값 x 추출 -> " + x;
		html += "<br>파라메터값 y 추출 -> " + y;
		html += "<br>파라메터값 z 길이 추출 -> " + z.length;
		html += "<br>파라메터값 z[0] 추출 -> " + z[0];
		html += "<br>파라메터값 z[1] 추출 -> " + z[1];
		out.println(html);
	}

}
