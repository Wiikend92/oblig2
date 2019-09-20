package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/handle")
public class Handle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vare = request.getParameter("vare");
		
		ServletConfig c = this.getServletConfig();
		PrintWriter writer = response.getWriter();
		writer.append("Passord: ").append(c.getInitParameter("passord"));
		
		response.getWriter().append(vare);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String vare = request.getParameter("vare");
		
		response.getWriter().append(vare);
	}

}
