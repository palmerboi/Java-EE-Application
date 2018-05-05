/*
 * Servlet that accesses data from the BankAccount bean and is
 * used to search up a users bank account then sends the user
 * to the correct JSP
 */

import beans.Account;
import beans.BankAccount;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Reuben Palmer 1378847, Alex Alnaib 14874604
 */
@WebServlet(urlPatterns = {"/accountLookupServlet"})
public class accountLookupServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet accountLookupServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet accountLookupServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        String accountID = request.getParameter("bankID");
        //BankAccount bean made to display the data on to the accountFound JSP
        BankAccount bankAccount = new BankAccount();
        Account account;
        try {
            account = bankAccount.lookupAccount(Integer.parseInt(accountID));
            HttpSession session = request.getSession(true);
            session.setAttribute("account", account);
            if (account.getAccountID() == Integer.parseInt(accountID)) {
                RequestDispatcher dispatcher = getServletContext().
                        getRequestDispatcher("/accountFound.jsp");
                dispatcher.forward(request, response);
            } else {
                //If the bank account is not found then the user is sent to the accountNotFound JSP
                RequestDispatcher dispatcher = getServletContext().
                        getRequestDispatcher("/accountNotFound.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/accountNotFound.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/accountNotFound.jsp");
            dispatcher.forward(request, response);
        }
    }

}
