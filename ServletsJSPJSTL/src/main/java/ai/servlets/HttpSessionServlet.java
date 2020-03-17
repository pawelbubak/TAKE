package ai.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "HttpSessionServlet", urlPatterns = {"/HttpSessionServlet"})
public class HttpSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList notes = (ArrayList) session.getAttribute("notes");
        if (notes == null) {
            notes = new ArrayList();
            session.setAttribute("notes", notes);
        }

        String note = request.getParameter("note");
        if (note != null)
            notes.add(note);

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<h1>My notes</h1>");
        out.println("<ul>");

        for (Object o : notes) out.println("<li>" + o);

        out.println("</ul>");

        out.println("<form action='HttpSessionServlet'>");
        out.println("<input type='text' name='note'/><br/>");
        out.println("<input type='submit' value='Add note'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
