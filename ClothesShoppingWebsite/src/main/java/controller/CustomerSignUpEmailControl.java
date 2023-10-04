package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.AccountDao;
import dao.JdbcAccountDao;
import persistence.Account;

/**
 * Servlet implementation class CustomerSignUpEmailControl
 */
@WebServlet("/signupemail")
public class CustomerSignUpEmailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerSignUpEmailControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("customerEmail");
		String password = request.getParameter("customerPassword");
		String rePassWord = request.getParameter("customerRePassword");
		
		
		AccountDao accountDao = new JdbcAccountDao();
		Account ac = accountDao.getAccountByEmail(email);
		
		if(ac != null) {
			request.setAttribute("messageError", "Email has already exists!");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/CustomerJsp/signUpEmail.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("enteredEmail", email);
			if(!password.equals(rePassWord)) {
				request.setAttribute("messageError", "Mật khẩu không khớp");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/CustomerJsp/signUpEmail.jsp");
				rd.forward(request, response);
			} else {
				HttpSession session = request.getSession();
				Account newAccount = new Account(email, password, 1, 0, null);
				session.setAttribute("ac", newAccount);
				System.out.println(newAccount);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/CustomerJsp/signUpInformation.jsp");
				rd.forward(request, response);
			}
		}
	}

}
