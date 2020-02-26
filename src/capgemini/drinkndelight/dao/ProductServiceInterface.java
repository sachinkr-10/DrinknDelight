package capgemini.drinkndelight.dao;

public interface ProductServiceInterface {
	
	 
	public long updateProductStock(Integer oId);
	 
	 public String setExitDate();
	
	 public boolean doesProductOrderIdExists(Integer oId);

}
