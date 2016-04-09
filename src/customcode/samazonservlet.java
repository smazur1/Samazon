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

		}  else if (request.getParameter("option").equals("5")) {
			
		
			
			double total = 0;
			
			long orderid = 0;
			long cartid = 0;
			long userid = 0;
			userid = (long) session.getAttribute("userid");
			double cartprice = 0;
			
			cartid = ProcessOrder.getNewCartId();
			
			System.out.println("cart id = " + cartid);
			
			for (Product product : cart) {
				
				
				// insert cart into samazon order
				// select max order id from samazon order   getNewOrderID
				// select max cartid from samazon order     getNewCartID
				
				// get userid from session
				// get productcode, productname, price from cart
				// call method passing in above parameters to insert into samazonorder
				orderid = ProcessOrder.getNewOrderId();
				
				System.out.println("order id = " + orderid);
				cartprice = product.getPrice();
				
				ProcessOrder.insertSamazonOrder(orderid, cartid, userid, product.getProductcode(), 
						product.getProductname(), cartprice);
				
				// end insert
				
				
	//			total += product.getPrice().doubleValue();
				total += product.getPrice();

				
			}
			session.setAttribute("total", total);
			System.out.println("userid = " + session.getAttribute("userid"));
					
			request.getRequestDispatcher("/Confirmation.jsp").forward(request, response);

		}  else if (request.getParameter("option").equals("6")) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
            long count = 0;
            String joe = "0";
            long userid = 0;
            
            count = ProcessUser.getUser(username, password);
			
			if (count == 1) {
			
				
			  userid = ProcessUser.getUserId(username, password);	
			  session.setAttribute("userid", userid);	
			  joe = "1";
			  session.setAttribute("joe", joe);
			  request.getRequestDispatcher("/ShoppingCart.jsp").forward(request, response);
			} else {
			
				session.setAttribute("joe", joe);
			request.getRequestDispatcher("/login.jsp").forward(request, response); 
			}

		} else if (request.getParameter("option").equals("7")) {
			
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}
	}
}
