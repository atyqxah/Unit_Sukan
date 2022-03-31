package us.model;

public class item {
	
	private String productCode;
	private String description;
	private String brand;
	private String model;
	private String note;
	private String buydate;
	private int quantity;
	private double price;
	public boolean valid;
	private String type;
	private String supplier;
	
	
	public item() {
		super();
	}
	
	public item(String productCode, String description, String brand, String model, String note, String buydate, int quantity, double price, String type) {
		super();
		this.productCode = productCode;
		this.description = description;
		this.brand = brand;
		this.model = model;
		this.note = note;
		this.buydate = buydate;
		this.quantity = quantity;
		this.price = price;
		this.type = type;

	}
	
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getBuydate() {
		return buydate;
	}
	public void setBuydate(String buydate) {
		this.buydate = buydate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}


	

}
