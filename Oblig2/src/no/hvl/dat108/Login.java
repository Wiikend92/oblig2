package no.hvl.dat108;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

	String passord;

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		passord = getServletConfig().getInitParameter("passord");
		ServletConfig minkonfig = getServletConfig();

		System.out.println("Passordet er: " + passord);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String input = request.getParameter("passord");

		getServletConfig().getInitParameter("passord");

		response.getWriter().append(passord);
	}

}
