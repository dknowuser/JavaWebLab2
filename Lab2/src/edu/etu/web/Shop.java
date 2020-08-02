package edu.etu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Shop
 */
@WebServlet("/Shop")
public class Shop extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// «адание типа кодировки дл€ параметров запроса
		request.setCharacterEncoding("utf-8");
		// «адание типа содержимого дл€ ответа (в том числе кодировки)
		response.setContentType("text/html;charset=UTF-8");
		// ѕолучение потока дл€ вывода ответа
		PrintWriter out = response.getWriter();
		//„тение параметров запроса
		String lang = request.getParameter("lang");
		if(lang == null) {
			response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "Parameter \"lang\" expected.");
			return;
		}
		
		if(!"en".equalsIgnoreCase(lang) && !"ru".equalsIgnoreCase(lang)) {
			response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "Parameter \"lang\" should be equal to \"ru\" or \"en\".");
			return;
		}
		
		// ”становка локализации в соответствии с выбором пользовател€
		ResourceBundle res = ResourceBundle.getBundle("Shop", "en".equalsIgnoreCase(lang) ? Locale.ENGLISH : Locale.getDefault());
		
		try {
			// —оздание HTML-страницы
			out.println("<html>");
			out.println("<head><title>");
			out.println(res.getString("title"));
			out.println("</title></head><body><h1>");
			out.println(res.getString("title"));
			out.println("</h1><table border='1'>");
			out.println("<tr><td><b>");
			out.println(res.getString("name"));
			out.println("</b></td><td><b>");
			out.println(res.getString("price"));
			out.println("</b></td><td><b>");
			out.println(res.getString("sale"));
			out.println("</b></td></tr>");
			out.println("<tr><td>");
			out.println(res.getString("apples"));
			out.println("</td><td>100</td><td>");
			out.println(res.getString("y"));
			out.println("</td></tr>");
			out.println("<tr><td>");
			out.println(res.getString("oranges"));
			out.println("</td><td>60</td><td>");
			out.println(res.getString("n"));
			out.println("</td></tr>");
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			// «акрытие потока вывода
			out.close();
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		processRequest(request, response);
	}

}
