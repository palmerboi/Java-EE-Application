/*
 * Servlet that accesses the data from the BankAccount bean 
 * and decides on what jsp to display depending on conditions
 * of user input.
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
@WebServlet(urlPatterns = {"/accountCreateServlet"})
public class accountCreateServlet extends HttpServlet {

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
            out.println("<title>Servlet accountCreateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet accountCreateServlet at " + request.getContextPath() + "</h1>");
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
        String accountID = request.getParameter("accountID");
        String branchID = request.getParameter("branchID");
        String balance = request.getParameter("balance");
        try {
            //BankAccount bean created to display the information in the accountCreated JSP
            BankAccount bankAccount = new BankAccount();
            boolean accountCreated = bankAccount.createAccount(Integer.parseInt(accountID),
                    Integer.parseInt(branchID), Float.parseFloat(balance));
            if (accountCreated) {
                Account account = new Account();
                account.setAccountID(Integer.parseInt(accountID));
                account.setBranchID(Integer.parseInt(branchID));
                account.setBalance(Float.parseFloat(balance));
                HttpSession session = request.getSession(true);
                session.setAttribute("account", account);
                RequestDispatcher dispatcher = getServletContext().
                        getRequestDispatcher("/accountCreated.jsp");
                dispatcher.forward(request, response);
            } else {
                //If an error occurs and the account is not created then user gets sent to accountNotCreated JSp
                RequestDispatcher dispatcher = getServletContext().
                        getRequestDispatcher("/accountNotCreated.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/accountNotCreated.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/accountNotCreated.jsp");
            dispatcher.forward(request, response);
        }

    }

}
