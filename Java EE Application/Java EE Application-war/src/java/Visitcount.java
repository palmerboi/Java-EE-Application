/*
 * Servlet that uses the visitor count bean data to be
 * displayed in a jsp
 */

import beans.VisitorCountRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Reuben Palmer 1378847, Alex Alnaib 14874604
 */
public class Visitcount extends HttpServlet {

    @EJB
    private VisitorCountRemote visitorCount;
    int counter;

    public void init() {
        counter = 0;
    }

    //Puts the data from counter into a usuable request for the jsp to access
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            counter = visitorCount.countVisitor(counter);
            out.println("No of visitors is: " + counter);

            request.setAttribute("user_on_site", counter);

        } catch (Exception e) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
