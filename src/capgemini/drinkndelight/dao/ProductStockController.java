package capgemini.drinkndelight.dao;

//import capgemini.CaseStudy.welcome.Product;
import capgemini.drinkndelight.beans.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Set;

public class ProductStockController implements ProductServiceInterface {
	   public static ProductStock p1;
	   public static ProductStock p2;
	   public static ProductStock p3;
	   public static ProductStock p4;
	   
      List<User> list=new ArrayList<>();
      List<ProductStock> list1=new ArrayList<>();
      public static HashMap<Integer,List<ProductStock>> hmap=new HashMap<>();
      public static ProductStockController psc=new ProductStockController();
      static Integer iD2=100;
      //add user to list 
     public void data() {
    	 list.add(new User("sk@123","1234","sachinkumar@gmail","9973456810"));
    	 list.add(new User("sh@1234","12345","shilpis@gmail.com","8750111789"));
    	 list.add(new User("Ro@123456","123456","rohansingh@gmail.com","9958597034"));
     }
//    validation of a user
     public boolean validation(String name,String password) {
    	 data();
    	 for(User user: list) {
    	 if(user.getUserName().equals(name) && (user.getPassword().equals(password))) {
    		 return true;
    	 }}
    	   
    	   	return false;}
    	 
    	 
		
//    	Returnig a hashmap	 
   public  HashMap<Integer,List<ProductStock>>  getHashMap(){
	   return hmap;
   } 	 
    	 
   
   
//Randomly Generate Order Id
  public int genOrderId() {
    	 return (int) Math.floor(Math.random()*1000000);
     }
  
//Setting wareHouseId     
public Integer wareHouseId() {
    	 return iD2--;
     } 
   

 //Instance of a ProductstockController
     public static ProductStockController getInstance() {
    	
    	 return psc;
     }
     

    
 // Add details in Database(i.e. Collections)
     public void addDetails() {
         p1=new ProductStock("Porter",genOrderId(),wareHouseId(),1000,50000,setDelieverDate(),setManufacturingDate(),setExpireDate(),"Good");
         p2=new ProductStock("BIRA",genOrderId(),wareHouseId(),100,5000,setDelieverDate(),setManufacturingDate(),setExpireDate(),"Good");
		 p3=new ProductStock("Kingfisher",genOrderId(),wareHouseId(),100,6500,setDelieverDate(),setManufacturingDate(),setExpireDate(),"Best");
         p4=new ProductStock("Heinkin",genOrderId(),wareHouseId(),105,450000,setDelieverDate(),setManufacturingDate(),setExpireDate(),"Best");
         list1.add(p1);
         hmap.put(p1.getOrderId(),list1);
         list1=new ArrayList<>();
         list1.add(p2);
         hmap.put(p2.getOrderId(),list1);
         list1=new ArrayList<>();
         list1.add(p3);
         hmap.put(p3.getOrderId(),list1);
         list1=new ArrayList<>();
         list1.add(p4);
         hmap.put(p4.getOrderId(),list1);
         list1=new ArrayList<>();
         
    
}

    //To Update Product Stocks after Product order is being pLaced 
 @Override     
 public long updateProductStock(Integer oId) {
    	long count=0;
    	
    	List<ProductStock> p=hmap.get(oId);
	    Iterator<ProductStock> i=p.iterator();
	    while(i.hasNext()) {
	    	ProductStock I=i.next();
	    	count=(long) (I.getQuantityUnit()+count);
	    	
	    }
	    return count;
    }



//To Set Dispatch Date
     public String setExitDate() {
	  SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	  Calendar c=Calendar.getInstance();
		c.add(Calendar.DATE,1);	  
	  Date date=c.getTime();
	  
	 return sdf.format(date);
  }   
  
     //To Set Dispatch Time

 //Check Product Orderid
 @Override  
   public boolean doesProductOrderIdExists(Integer oId) {
    	Set<Integer> set=hmap.keySet();
    	if(set.contains(oId)) {
    		return true;
    	}else {
    		return false;
    		}
    	}
    

 
 //Price to pAY
 public double priceToPay(Integer oId) {
 	double price = 0;
 	List<ProductStock> p=hmap.get(oId);
	    Iterator<ProductStock> i=p.iterator();
	    while(i.hasNext()) {
	    	ProductStock I=i.next();
	    	price= I.getPrice()+price;
	    	
	    }
	    return price;
 }

 //To set delivery date
public String setDelieverDate() {
    	 SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    	  Calendar c=Calendar.getInstance();
    	   c.add(Calendar.DATE, 5);
    	   String d=sdf.format(c.getTime());
		return d;
}
 
//  To set Delievery time 
    //To set Expiry Date 
   public String setExpireDate() {
   	 SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
   	  Calendar c=Calendar.getInstance();
   	   c.add(Calendar.DATE, 5);
   	   c.add(Calendar.YEAR, 2);
   	   c.add(Calendar.MONTH,3);
   	   String d=sdf.format(c.getTime());
		return d;
}
   

//Set a Manufacturing Date    
public String setManufacturingDate() {
   	 SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
   	  Calendar c=Calendar.getInstance();
   	   c.add(Calendar.DATE, -5);
   	   c.add(Calendar.YEAR, -2);
	   c.add(Calendar.MONTH,-3);
   	   String d=sdf.format(c.getTime());
		return d;
}
}

