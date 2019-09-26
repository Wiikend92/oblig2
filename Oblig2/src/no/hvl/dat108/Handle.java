package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/handle")
public class Handle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		checkLogin(request, response);

		String vare = request.getParameter("vare");
		PrintWriter writer = response.getWriter();
		writer.println("<a href='login?logout=1'>Log ut</a>");
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		checkLogin(request, response);

		String vare = request.getParameter("vare");

		response.getWriter().append(vare);
	}

	protected void checkLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			if (!(sesjon.getAttribute("login").equals(1))) {
				response.sendRedirect("login");
			}
		}else {
			response.sendRedirect("login");
		}
		return;
	}
	

}
