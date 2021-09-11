package offersanddiscountapp.model;

import java.math.BigDecimal;

/*  This model class represents Coupon database table 
	that has id,code,discount,expireDate  */
public class Coupon {
	private int id;
	private String code;
	private BigDecimal discount; // In the database it's a decimal
									// so we represents as a BigDecimal

	private String expireDate;

	
	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	//To String Method
	@Override
	public String toString() {
		return "<h2>Offer Details</h2><br/>Coupon id: " + id + "<br/>  code: " + code + "<br/>  discount: " + discount
				+ "<br/> expireDate: " + expireDate;
	}

}
