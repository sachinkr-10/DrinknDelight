package capgemini.drinkndelight.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import capgemini.drinkndelight.dao.ProductStockController;
import capgemini.drinkndelight.exception.TrackOrderException;
import capgemini.drinkndelight.beans.ProductStock;
import capgemini.drinkndelight.dao.*;
import capgemini.drinkndelight.beans.*;
public class UserImpl implements UserInterface {
	Scanner sc;
//login credentials
	 public void login(String name,String password) {
    	
    	 if(ProductStockController.getInstance().validation(name,password)) {
    		 operation	();
    	 }else {
    		 try {
    			 throw new TrackOrderException("Invalid User!!!!ENter a valid Email Id");
    		 }catch(TrackOrderException e) {
    			 System.out.println(e.getMessage());
    		 }
    	 }
     }
	//  Product Order Interface   
	 public void productInterface(Scanner s) {
	   
	    	ProductStockController.getInstance().addDetails();
	         while(true) {
	    	 System.out.println("What Do you want to perform:\n1.Place Product order\n2.Display Product order\n3.TrackProduct Order\n4.Update product stock\n 5.DIsplay distributor details");
	         int choice=s.nextInt();
	         switch(choice) {
	         case 1:System.out.println("Succesfully placed\n");   
	         break;
	         case 2:display();
	         break;
	         case 3:trackProductOrder();
	         
	                return;
	         case 4:System.out.println("succesful");break;
	         case 5:System.out.println("Successfull");break;
	         default:try{throw new TrackOrderException("!!!!!!!Invalid Input!!!!!!Select a valid one");}
	         catch(TrackOrderException e) {
	        	 System.out.println(e.getMessage());
	         }
	         }}
	     }
	 
	 public void operation() {
	   	 System.out.println("\nWelcome Controller:");
	   	 System.out.println("Select Your Operations to Perform\n 1.Operations on Raw Materials\n 2.Operations on Product");
	   	 sc=new Scanner(System.in);
	   	 int choice;
	   	 choice=sc.nextInt();
	   	 switch(choice) {
	   	 case 1:System.out.println("\nYou are in RaW Materials stock");
	   	 break;
	   	 case 2:System.out.println("\nYou are in Product Stock");
	   	 productInterface(sc);
	   	 break;
	   	 default:try{
	   		 throw new TrackOrderException("Errorr !!!Select a Valid Operation");
	   	 }catch(TrackOrderException e) {
	   		 System.out.println(e.getMessage());
	   	 };
	   	 
	   	 }
	   	  
	    }

	

	 
	 
	 public void display() {
    	 System.out.println("You succesfully placed: "+ProductStockController.getInstance().p1.getName()+" your oder id: "+ProductStockController.getInstance().p1.getOrderId());
    	 System.out.println("You succesfully placed: "+ProductStockController.getInstance().p2.getName()+" your oder id: "+ProductStockController.getInstance().p2.getOrderId());
    	 System.out.println("You succesfully placed: "+ProductStockController.getInstance().p3.getName()+" your oder id: "+ProductStockController.getInstance().p3.getOrderId());
    	 System.out.println("You succesfully placed: "+ProductStockController.getInstance().p4.getName()+" your oder id: "+ProductStockController.getInstance().p4.getOrderId());
     }
	
	 // Tracking ProductOrder 

	 public void trackProductOrder() {
	    	 
		 System.out.println("Enter your order id for tracking:\n");
	     Scanner id=new Scanner(System.in);
	     Integer oId=id.nextInt();
	    	 
	    	 if(ProductStockController.getInstance().doesProductOrderIdExists(oId)) {
	    		 System.out.println("*************Please Waitt,Fetching Your Data*******************\n");
	    		 try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
	 	    List<ProductStock> p=ProductStockController.getInstance().getHashMap().get(oId);
	    	    Iterator<ProductStock> i=p.iterator();
	    	    while(i.hasNext()) {
	    	    	ProductStock I=i.next();
	    	    	System.out.println("\nName:"+I.getName()+"\nExpiry Date: "+I.getExpiryDate()+"\nManufacturing Date: "+I.getManufacturingDate()+"\nPrice: "+I.getPrice()+"\nProdcut Quality: "+I.getQuality()+"\nWareHouseId: "+I.getWarehouseId()+"\nOrderId:"+I.getOrderId()+"\nQuantity"+I.getQuantityUnit());
	    	        
	    	    }
	    	    System.out.println("Your order is being dispatched on: "+ProductStockController.getInstance().setExitDate());
	    	    try {
	    			Thread.sleep(2500);
	    			System.out.println("\n******************PLEASE WAIT******************************");
	    			Thread.sleep(2500);
	    			System.out.println("\nProduct Stock is being updated");
	    			Thread.sleep(2000);
	    			System.out.println("\nYou are Getting Total "+ProductStockController.getInstance().updateProductStock(oId)+" Products \nIt will be delieverd To u On:"+ProductStockController.getInstance().setDelieverDate());
	    			System.out.println("\n******************Please Wait******************************");
	    			Thread.sleep(2500);
	    			System.out.println("\nTotal Amount to be paid: "+ProductStockController.getInstance().priceToPay(oId));
//	    			System.out.println("\nProduct Available on Stock will be\n"+(updateProductStock(oId)+1000));
	    			
	    		} catch (InterruptedException e) {
	    			
	    			e.printStackTrace();
	    		}
	    	 }else {
	    		 try {
	    		 throw new TrackOrderException("OrderId Not found!!!Pleasse Enter a valid oID");
	    	 }catch(TrackOrderException e) {
	    		 System.out.println(e.getMessage());}
	    	 }
	     }


	
}
