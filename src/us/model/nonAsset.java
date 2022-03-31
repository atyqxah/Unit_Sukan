package us.model;

public class nonAsset extends item {
	private String nonAssetID;
	private String locations;
	private String conditions;
	
	public nonAsset() {
		super();
	}
	
	public nonAsset (String productCode, String description, String brand, String model, String note, String buydate,int quantity,double price, String type, boolean valid, String nonAssetID, String locations, String conditions)
	{
		super(productCode, description, brand, model, note, buydate, quantity, price,type);
		this.nonAssetID = nonAssetID;
		this.locations = locations;
		this.conditions = conditions;
	}
	
	public String getNonAssetID() {
		return nonAssetID;
	}

	public void setNonAssetID(String nonAssetID) {
		this.nonAssetID = nonAssetID;
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	

}
