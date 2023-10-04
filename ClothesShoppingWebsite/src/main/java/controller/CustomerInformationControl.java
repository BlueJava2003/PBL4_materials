package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;
import dao.CustomerDao;
import dao.JdbcAccountDao;
import dao.JdbcCustomerDao;
import persistence.Account;
import persistence.Customer;

/**
 * Servlet implementation class CustomerInformationControl
 */
@WebServlet("/signupinformation")
public class CustomerInformationControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerInformationControl() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		
		Account ac = (Account)session.getAttribute("ac");
		System.out.println(ac);
		String email = request.getParameter("customerEmail");
		String name = request.getParameter("customerName");
		String gender = request.getParameter("customerGender");
		String dateOfBirth = request.getParameter("customerDateOfBirth");
		String address = request.getParameter("customerAddress");
		String phoneNum = request.getParameter("customerPhoneNum");
		String link = request.getParameter("customerLinkSocial");
		
		AccountDao accountDao = new JdbcAccountDao();
		CustomerDao customerDao = new JdbcCustomerDao();
		
		 accountDao.createNewAccount(ac);
 		
		customerDao.createNewCustomer(new Customer(null, 
													name, 
													gender, 
													Date.valueOf(dateOfBirth), 
													address, 
													phoneNum, 
													link, 
													null, 
													email), ac);
		session.invalidate();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
