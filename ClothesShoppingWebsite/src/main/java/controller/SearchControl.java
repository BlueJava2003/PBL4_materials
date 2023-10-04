package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JdbcProductDao;
import dao.JdbcProductGroupDao;
import dao.ProductDao;
import dao.ProductGroupDao;
import persistence.Product;
import persistence.ProductGroup;

/**
 * Servlet implementation class SearchControl
 */
@WebServlet("/search")
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ProductDao productDao = new JdbcProductDao();
		ProductGroupDao productGroupDao = new JdbcProductGroupDao();
		
		String searchName = request.getParameter("search");
		
		List<ProductGroup> listGroup = productGroupDao.getAll();
		Product newestProduct = productDao.getNewestProduct();
		List<Product> list = productDao.getProductByName(searchName);
		
		request.setAttribute("newestP", newestProduct);
		request.setAttribute("listPG", listGroup);
		request.setAttribute("listP", list);
		request.setAttribute("searchName", searchName);
		System.out.println("OK");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
