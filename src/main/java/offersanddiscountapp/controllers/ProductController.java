package offersanddiscountapp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import offersanddiscountapp.dao.CouponDAO;
import offersanddiscountapp.dao.ProductDAO;
import offersanddiscountapp.model.Coupon;
import offersanddiscountapp.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/products")
public class ProductController extends HttpServlet {
	// Here we want both Dao class for save and then update product to the database
	CouponDAO couponDAO = new CouponDAO();
	ProductDAO productDAO = new ProductDAO();
	private static final long serialVersionUID = 1L;
       
    public ProductController() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// first thing same as usual get all the parameter out
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String couponCode = request.getParameter("couponCode");
		
		// Here we get the entire coupon/offer back
		Coupon coupon = couponDAO.findByCode(couponCode);
		
		// Also create a product object out of it
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		// this is where we will discount the price using the 'offer' we created
		// and converting the price to big decimal and '.subtract' method will deduct
		// and keep in mind we just take the discount from the coupon
		product.setPrice(new BigDecimal(price).subtract(coupon.getDiscount()));
		
		// this save and updates value for product in database
		productDAO.save(product);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Product Created</b>");
		out.print("<br/><a href = '/offersanddiscountapp'>Home</a>");
		
	}

}
