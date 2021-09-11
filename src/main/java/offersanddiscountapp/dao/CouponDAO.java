package offersanddiscountapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import offersanddiscountapp.model.Coupon;
import offersanddiscountapp.util.ConnectionUtil;

public class CouponDAO {
	//Save method that takes the Coupon Object and gets the value of it and 
	//Insert the value in the database
	public void save(Coupon coupon) {
		//Establishing Connection from Context.xml file
		Connection connection = ConnectionUtil.getConnection();
		try {
			//Using the connection and inserting data
			// id field is not require because it's auto incremented
			PreparedStatement statement = connection.prepareStatement("insert into coupon(code,discount,exp_date) values(?,?,?)");
			// setting the fields on Coupon object 
			statement.setString(1, coupon.getCode());
			statement.setBigDecimal(2, coupon.getDiscount());
			statement.setString(3, coupon.getExpireDate());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//This below  method finds a Coupon in the database by its code and this will 
	// be later on used by ProductController to apply discount for a 
	//particular product.
	
	// This guy returns entire Coupon Object back
	public Coupon findByCode(String code) {
		// Creating a Coupon Object that need to be return from this method
		Coupon coupon = new Coupon();
		// Now we will create a connection and will create a prepareSatement
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from coupon where code = ?");
			// Setting the code on the statement
			// once it's executed this guy return a result set.
			statement.setString(1, code);
			
			ResultSet resultSet = statement.executeQuery();
			
			// Taking the result set and looping in while loop
			// because as we loop through we should only get one
			// coupon with unique id and so and so forth
			while(resultSet.next()) {
				coupon.setId(resultSet.getInt(1));
				coupon.setCode(resultSet.getString(2));
		//This is the important one that we need in product implementation
				coupon.setDiscount(resultSet.getBigDecimal(3));
				coupon.setExpireDate(resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coupon;
	}

}
