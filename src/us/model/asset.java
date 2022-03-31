package us.model;

import us.model.item;

public class asset extends item {
	private String assetID;
	private String expiredDate;
	
	public asset() {
		super();
	}
	
	public asset (String productCode, String description, String brand, String model, String note, String buydate,int quantity,double price, String type, boolean valid, String assetID, String expiredDate)
	{
		super(productCode, description, brand, model, note, buydate, quantity, price,type);
		this.assetID = assetID;
		this.expiredDate = expiredDate;
	}
	
	public String getAssetID() {
		return assetID;
	}

	public void setAssetID(String assetID) {
		this.assetID = assetID;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}


}
