package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Login", urlPatterns= {"/login"})
public class Login extends HttpServlet {

	String passord;

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		ServletConfig config = getServletConfig();;
		passord = config.getInitParameter("passord");
		System.out.println("Passordet : " + passord);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		writer.append(passord);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		writer.append(passord);

	}

}
