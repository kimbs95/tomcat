package sec03.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/json")
public class JsonServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException ,IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String jsonInfo = request.getParameter("jsonInfo");
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject =(JSONObject) jsonParser.parse(jsonInfo);
			System.out.println("*회원정보*");
		}
	}
	
	
	
	
	
	
	
	
}