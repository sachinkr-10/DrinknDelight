package capgemini.drinkndelight.beans;

public class ProductStock {
	
	Integer orderId;
	Integer warehouseId;
    double quantityUnit;
    double price;
     String delieveryDate;
     String name;
	 String manufacturingDate;
	 String expiryDate;
	 String quality;

     public ProductStock() {
    	 
     }
	public ProductStock(String name,Integer orderId, Integer warehouseId,double quantityUnit, double price, String delieveryDate,  String manufacturingDate,
			String expiryDate,String quality) {
		this.orderId = orderId;
		this.warehouseId = warehouseId;
		this.quantityUnit = quantityUnit;
		this.price = price;
		this.delieveryDate = delieveryDate;
		this.name = name;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.quality=quality;
	}


	

	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	public double getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(double quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDelieveryDate() {
		return delieveryDate;
	}
	public void setDelieveryDate(String delieveryDate) {
		this.delieveryDate =delieveryDate ;
	}
	public String getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate =manufacturingDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate =expiryDate ;
	}

}
