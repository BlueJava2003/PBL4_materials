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
 * Servlet implementation class ProductGroupControl
 */
@WebServlet("/productgroup")
public class ProductGroupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductGroupControl() {
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
		
		int id = Integer.parseInt( request.getParameter("pgId"));
		ProductDao productDao = new JdbcProductDao();
		ProductGroupDao productGroupDao = new JdbcProductGroupDao();
		
		List<Product> list = productDao.getListProductsByPGId(id);
		List<ProductGroup> listGroup = productGroupDao.getAll();
		Product newestProduct = productDao.getNewestProduct();
		
		request.setAttribute("listP", list);
		request.setAttribute("listPG", listGroup);
		request.setAttribute("newestP", newestProduct);
		request.setAttribute("tag", id);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
