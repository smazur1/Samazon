package customcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBUtil;
import model.Product;

/**
 * Servlet implementation class StudentGradeName
 */
@WebServlet("/samazonservlet")
public class samazonservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Product> cart = new ArrayList<Product>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public samazonservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		if (request.getParameter("option").equals("1")) {
			// int studentid =
			// Integer.parseInt(request.getParameter("studentid"));
			List<Product> products = null;

			products = ProcessProducts.getAllProducts();

			// session.setAttribute("studentid", studentid);
			session.setAttribute("products", products);
			request.getRequestDispatcher("/productlist.jsp").forward(request, response);

		}

		else if (request.getParameter("option").equals("2")) {

			int productcode = Integer.parseInt(request.getParameter("productcode"));

			// Studentgrade st = null;
			List<Product> products = null;

			products = ProcessProducts.getProductByCode(productcode);
			//
			session.setAttribute("cartproductcode", productcode);
			session.setAttribute("products", products);
			request.getRequestDispatcher("/productdetail.jsp").forward(request, response);

		} else if (request.getParameter("option").equals("3")) {

			int productCode = Integer.parseInt(request.getParameter("cartproductcode"));
			// System.out.println(productCode);
			// int quantity=Integer.parseInt(request.getParameter("number"));

			List<Product> products = null;

			products = ProcessProducts.getProductByCode(productCode);

			cart.addAll(products);

			request.getRequestDispatcher("/productdetail.jsp").forward(request, response);

		} else if (request.getParameter("option").equals("4")) {

			session.setAttribute("cart", cart);

			request.getRequestDispatcher("/ShoppingCart.jsp").forward(request, response);

		} else if (request.getParameter("option").equals("5")) {
			double total = 0;
			for (Product product : cart) {
				total += product.getPrice().doubleValue();
			}
			session.setAttribute("total", total);
			request.getRequestDispatcher("/Confirmation.jsp").forward(request, response);

		}
	}
}
