package offersanddiscountapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import offersanddiscountapp.model.Product;
import offersanddiscountapp.util.ConnectionUtil;

public class ProductDAO {
	//This takes the product object
	public void save(Product product) {
		//Create connection and same as save method of CouponDao
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("insert into products (name,description,price) values(?,?,?)");
			statement.setString(1, product.getName());
			statement.setString(2, product.getDescription());
			statement.setBigDecimal(3, product.getPrice());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
