package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest5
 */
@WebServlet("/login12")
public class SessionTest5 extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request , response);
	}
	private void doHandle(HttpServletRequest request , HttpServletResponse response) throws ServletException ,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session =request.getSession();
		String user_id =request.getParameter("user_id");
		String user_pw =request.getParameter("user_pw");
		if(session.isNew()) {
			if(user_id != null ) {
				session.setAttribute("user_id", user_id);
				String url =response.encodeURL("login12");
				out.println("<a href ="+url+">??????????????? ??????</a>");
			}else {
				out.print("<a href='login2.html'>?????? ????????? ????????? !!</a>");
				session.invalidate();
			}
		}else {
				user_id = (String) session.getAttribute("user_id");
				if(user_id !=null && user_id.length() !=0) {
					out.print("??????????????? " + user_id + "???!!");
				}else {
					out.print("<a href ='login2.html'> ????????????????????????!!</a>");
					session.invalidate();
				}
		}
		
	}

}
