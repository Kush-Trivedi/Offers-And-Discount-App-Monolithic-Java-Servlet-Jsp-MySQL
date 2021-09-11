package offersanddiscountapp.model;

import java.math.BigDecimal;
/*  This model class represents Product database table 
	that has id,name,description,price,couponCode  */
public class Product {
	private int id;
	private String name;
	private String description;
	private BigDecimal price;
	private String couponCode; // This doesn't exists in Product Table
							//	But when the user sends a Product Creation 
							//	request he will Send a couponCode : 
							//  using that we 
							//	will apply discount for a particular product
							// thats why we added couponCode as well

	
	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	//toString method
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", couponCode=" + couponCode + "]";
	}

}
