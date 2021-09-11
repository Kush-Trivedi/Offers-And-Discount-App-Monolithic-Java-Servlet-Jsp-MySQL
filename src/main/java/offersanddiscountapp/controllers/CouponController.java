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
import offersanddiscountapp.model.Coupon;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/offers")

public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// it is a Instance for a save method to invoke 'dao' shown bellow
	// When we use Spring and use dependency injection we don't create this here
	// Meaning just create a field Spring will automatically create in runtime
    private CouponDAO dao = new CouponDAO();  
    
    public CouponController() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Here we are handling the creating of the coupon and finding a coupon
		// by defining name as 'action' with hidden field in different jsp files.
		String action = request.getParameter("action");
		if(action.equals("create")) {
		createCoupon(request, response);
		}else if(action.equals("find")) {
			findCoupon(request, response);
		}
	}


	private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// first Take out coupon data 
		// by requesting incoming request for couponCode,discount and expireDate
		String cuponCode = request.getParameter("couponCode"); // should be similar 
															// to name declare in html part
		String discount = request.getParameter("discount");
		String expireDate = request.getParameter("expireDate");
		
		// using above 3 filed we have create coupon object(Model Object)
		Coupon coupon = new Coupon();
		// So Now the coupon object will setCode.....
		coupon.setCode(cuponCode); // should be similar to local variable name
		coupon.setDiscount(new BigDecimal(discount));// have use BigDecimal Constructor
													// and passing string and then converting 
													// big decimal
		coupon.setExpireDate(expireDate);
		
		// This saves the data into database
		dao.save(coupon);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Offer Created</b>");
		out.print("<br/><a href = '/offersanddiscountapp'>Home</a>");
	}
	
	public void findCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// getting the parameter that the user is sending in form in findCoupon.jsp
		String cuponCode = request.getParameter("couponCode");
		Coupon coupon = dao.findByCode(cuponCode);// this gets us the entire Coupon object
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(coupon);
		out.print("<br/><br/><a href = '/offersanddiscountapp'>Home</a>");
	}

}
