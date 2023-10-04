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
 * Servlet implementation class ProductDetail
 */
@WebServlet("/productdetail")
public class ProductDetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailControl() {
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
		
		int pId = Integer.parseInt(request.getParameter("pId"));
		
		ProductDao productDao = new JdbcProductDao();
		ProductGroupDao productGroupDao = new JdbcProductGroupDao();
		List<ProductGroup> listGroup = productGroupDao.getAll();
		Product newestProduct = productDao.getNewestProduct();
		Product p = productDao.getProductById(pId);
		
		request.setAttribute("newestP", newestProduct);
		request.setAttribute("listPG", listGroup);
		request.setAttribute("p", p);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProductJsp/productDetail.jsp");
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
