package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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

		response.setContentType("text/html; charset=UTF-8");

		String vare = request.getParameter("vare");
		PrintWriter writer = response.getWriter();

		writer.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Handleliste</title>\r\n" + "</head>\r\n");
		writer.println("<body>\r\n" + "	<h1>Min handleliste</h1>\r\n");
		writer.println("<form action=\"handle\" method=\"post\">\r\n" + "\r\n" + "			<p>\r\n"
				+ "				<input type=\"submit\" value=\"Legg til\" />\r\n"
				+ "				<input type=\"text\" name=\"vare\" />\r\n" + "			</p>\r\n" + "	</form>");

		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			Enumeration<String> attributes = sesjon.getAttributeNames();
			while (attributes.hasMoreElements()) {
				String attribute = (String) attributes.nextElement();
				if (!(attribute.equals("login"))) {
					writer.println("<form action='handle' method='post'>");
					writer.print("<input type='hidden' value='" + attribute + "' name='slett' />");
					writer.print("<p><input type='submit' value='Slett' />");
					writer.println(request.getSession().getAttribute(attribute) + "</p>");
					writer.println("</form>");

				}
			}
		}

		// writer.println("<p><input type='button'
		// onclick=\"location.href='login?logout=1';\" value='Log ut' /></p>");
		writer.println("</body>\r\n" + "</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		checkLogin(request, response);

		HttpSession sesjon = request.getSession(false);
		String slett = request.getParameter("slett");
		String vare = request.getParameter("vare");

		if (sesjon != null) {
			if (vare != null) {
				sesjon.setAttribute(vare, vare);
			}

			if (slett != null) {
				sesjon.removeAttribute(slett);
			}
			response.sendRedirect("handle");
		}
		
	}

	protected void checkLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			if (!(sesjon.getAttribute("login").equals(1))) {
				response.sendRedirect("login");
			}
		} else {
			response.sendRedirect("login");
		}
		return;
	}

}
