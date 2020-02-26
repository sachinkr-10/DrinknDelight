package capgemini.drinkndelight.ui;

import java.util.Scanner;

//import capgemini.drinkndelight.dao.ProductStockController;
//import capgemini.drinkndelight.exception.TrackOrderException;
import capgemini.drinkndelight.service.*;

public class Main {
    public static UserImpl userIntf;
    Scanner sc;
    public static void main(String[] args) {
    	userIntf=new UserImpl();
    	Main m=new Main();
    	m.loginOpr();
    }

    //    To perform login Operations
	public void loginOpr() {
		  sc= new Scanner(System.in);
	    	 System.out.println("Welcome to Drink n Delight\n");
	    	 System.out.println("Enter your login id\n");
	    	 String name=sc.next();
	    	 System.out.println("Enter Your password");
	    	 String password=sc.next();
		      userIntf.login(name, password);
	}}
    
	