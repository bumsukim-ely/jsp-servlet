package exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exam/lotto")
public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public LottoServlet() {
        super();
    }

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		String html = "";
//		
//		html += "<!DOCTYPE html>";
//		html += "<html lang=\"ko\">";
//		html += "<head>";
//		html += "	<meta charset=\"UTF-8\">";
//		html += "	<title>1 ~ 45 범위의 로또 번호 생성 </title>";
//		html += "</head>";
//		html += "<body>";
//		html += "	<h1>1 ~ 45 범위의 로또 번호 생성</h1>";
//		
//		ArrayList<Integer> lotto = new ArrayList();
//		while(lotto.size() < 6) {
//			int rand = (new Random()).nextInt(45) + 1;
//			if(!lotto.contains(rand)) {
//				lotto.add(rand);
//			}
//		}
//		for(int x: lotto) {
//			html += "	<span>" + x + "</span>";
//		}	
//
//		html += "</body>";
//		html += "</html>";
//		out.println(html);
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String set = request.getParameter("set");
		String html = "";
		
		html += "<!DOCTYPE html>";
		html += "<html lang=\"ko\">";
		html += "<head>";
		html += "	<meta charset=\"UTF-8\">";
		html += "	<title>1 ~ 45 범위의 로또 번호 생성 </title>";
		html += "</head>";
		html += "<body>";
		html += "	<h1>1 ~ 45 범위의 로또 번호 생성</h1>";
		
		html += "	<h2>"+ set +"세트 만큼의 로또번호를 생성합니다.</h2>";
		
		for(int i=0; i<Integer.parseInt(set); i++) {
			html += "	<h2>" + (i+1) + "Set</h2>";
			ArrayList<Integer> lotto = new ArrayList();
			while(lotto.size() < 6) {
				int rand = (new Random()).nextInt(45) + 1;
				if(!lotto.contains(rand)) {
					lotto.add(rand);
				}
			}
			for(int x: lotto) {
				html += "	<span>" + x + "</span>";
			}
		}
		
		html += "</body>";
		html += "</html>";
		out.println(html);
	}

}
