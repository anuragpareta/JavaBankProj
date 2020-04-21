package account_Pkg1;

import java.awt.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class Account_Main {
	
	static ArrayList<String> lst;
	static Scanner sc = new Scanner(System.in);
	static Customer cust;
	static int acct_option;
	

	public static void main(String[] args) {
		
		lst = new ArrayList<String>();
		
		acct_Option();
		
//******************		
		}
	
	public static void acct_Option() {
		
			
		System.out.println("Please select the option (1/2/3): 1.Create New Account 2.Delete Account 3.Display Account Details");
			
		try {	
		acct_option = sc.nextInt();	
		}
		
		catch(Exception e)
		{
			System.out.println("Not valid input");
			System.out.println("Try again>>>>Wrong Input...Session Terminated<<<<<");
			System.exit(0);
			
		}
		
		if(acct_option ==1) {
			loopMethod();
			
		}
		else if (acct_option ==2){
			delAcct();
		}
		else if (acct_option ==3){
			System.out.println(lst.size());
			print();
		}
		else {
			if(acct_option!=0 || acct_option !=1 || acct_option !=2 || acct_option !=3)
			{
			System.out.println("Incorrect input! ");
			System.exit(0);
			
			}
			
		
		}
		
		
			
	}

	
	public static void loopMethod() {
		while(true) {
			Scanner sc3=new Scanner(System.in);
			Scanner sc5=new Scanner(System.in);
			cust = new Customer();
			
			System.out.println("Please enter account type(1/2): 1.Saving  2.Current ");
			try {
			cust.setAccountType(sc.nextInt());
			}
			
			 catch(Exception e) { System.out.println("Try again>>>>Wrong Input...Session Terminated<<<<<");
			 System.exit(0);
			 }
			 
			/*
			 * finally { cust.setAccountType(sc3.nextInt());
			 * 
			 * }
			 */
			if(cust.getAccountType() == 1){
				lst.add("Saving");
				System.out.println("Your account type is: Saving");
				
			}
			else if (cust.getAccountType() == 2) {
				lst.add("Current");
				System.out.println("Your account type is: Current");
			}
			else {
				if(cust.getAccountType() != 0) {
				System.out.println("Incorrect account type!");
				continue;
				}
				
			}
			sc.nextLine();
			System.out.println("Please enter customer name: ");
			cust.setCustomerName(sc.nextLine());
			if(cust.getCustomerName() != null && cust.getCustomerName().length()>0 && cust.getCustomerName().matches("^[a-z A-Z]*$")) {
				lst.add(cust.getCustomerName());
				System.out.println("Customer name is: "+cust.getCustomerName());
		
			}
			else {
				System.out.println("Incorrect customer name!");
				lst.remove(lst.size()-1);
				continue;
			}
				
			System.out.println("Please enter Account No: ");
			
			try {
			cust.setAccountNumber(sc.nextBigInteger());
			}
			catch(Exception e)
			{
				System.out.println("Try again>>>>Wrong Input...Session Terminated<<<<<");
				System.exit(0);
				}
				
			
		
			System.out.println("");
			if(lst.contains(cust.getAccountNumber()+"")) {
				System.out.println("Account is already exists...");
				lst.remove(lst.size()-1);
				lst.remove(lst.size()-2);
				continue;
				
			}
			else if(cust.getAccountNumber().toString().length()>15 && cust.getAccountNumber().toString().length()<17 ) {
				lst.add(cust.getAccountNumber()+"");
				System.out.println("Account no is: "+cust.getAccountNumber());
		
			}
			else {
				System.out.println("Incorrect account number!");
				lst.remove(lst.size()-2);
				lst.remove(lst.size()-1);
				continue;
			}
			
			System.out.println("Please enter currency:(USD/INR) ");
			sc.nextLine();
			cust.setCurrency(sc.nextLine());
			
			if(cust.getCurrency() !=null && cust.getCurrency().equalsIgnoreCase("USD") || cust.getCurrency().equalsIgnoreCase("INR")) {
				lst.add(cust.getCurrency().toUpperCase());
				System.out.println("Your currency is: "+cust.getCurrency().toUpperCase());
		
			}
			else {
				System.out.println("Invalid currency type!");
//				System.out.println(lst.size());
//				System.out.println(lst.get(0)+"    "+lst.get(1)+"    "+lst.get(2)+"    "+lst.get(3)+"    "+lst.get(4)+"    "+lst.get(5)+"    "+lst.get(6)+"    "+lst.get(7)+"    "+lst.get(8)+"    ");
//				System.out.println("*****************");
				lst.remove(lst.size()-3);
				lst.remove(lst.size()-2);
				lst.remove(lst.size()-1);
				continue;
			}
			System.out.println("Please enter the initial amount: ");
			cust.setAmount(sc.nextFloat());
			
			if(cust.getAmount() != 0.0f) {
				lst.add(cust.getAmount()+"");
				System.out.println("Amount is: "+cust.getAmount());
		
			}
			else {
				System.out.println("Incorrect amount!");
				lst.remove(lst.size() - 4);
				lst.remove(lst.size() - 3);
				lst.remove(lst.size() - 2);
				lst.remove(lst.size() - 1);
				continue;
			}
			
			System.out.println("Press 1 for deposite amount / Press 2 for withdraw amount / Press 3 for exit  ");
			int tranInput = sc.nextInt();
			
			if(tranInput == 1){
				System.out.println("Enter amount to deposite: ");
				cust.setDepAmount(sc.nextFloat());
				float totAmt =cust.getAmount()+cust.getDepAmount();
				lst.add(totAmt+"");
				System.out.println(cust.getCurrency().toUpperCase() + " "+ cust.getDepAmount()+ " Credited" );
				acct_Option();
				
			}
			else if (tranInput == 2) {
				System.out.println("Enter amount to withdraw: ");
				cust.setWitAmount(sc.nextFloat());
				float totAmt =cust.getAmount()-cust.getWitAmount();
				lst.add(totAmt+"");
				System.out.println(cust.getCurrency().toUpperCase() + " "+ cust.getWitAmount()+ " Debited" );
				acct_Option();
			}
			else if (tranInput == 3) {
				cust.setWitAmount(0.0f);
				float totAmt =cust.getAmount()-cust.getWitAmount();
				lst.add(totAmt+"");
				acct_Option();
				
				}
				else {
					System.out.println("Incorrect input! ");
					lst.remove(lst.size() - 5);
					lst.remove(lst.size() - 4);
					lst.remove(lst.size() - 3);
					lst.remove(lst.size() - 2);
					lst.remove(lst.size() - 1);
					continue;
		}
		}
	}
	

	private static void delAcct() {

			System.out.println("Are you sure to delete any account: Y/N");
			
			String delAcct = sc.next();
			
			if(delAcct.equalsIgnoreCase("Y")) {
				
				System.out.println("Enter the account no which you want to delete: ");
				
				cust.setAccountNumber(sc.nextBigInteger());
				System.out.println();
				if(lst.contains(cust.getAccountNumber()+"")) {
					int index =lst.indexOf(cust.getAccountNumber()+"");
					System.out.println("lst size"+lst.size());
					System.out.println(lst.indexOf(cust.getAccountNumber()+""));
					lst.remove(index+3);
					lst.remove(index+2);
					lst.remove(index+1);
					lst.remove(index);
					lst.remove(index-1);
					lst.remove(index-2);
					
					System.out.println("Account : "+cust.getAccountNumber()+" has been deleted..");
					acct_Option();
			
				}
				else {
					System.out.println("Given account number not found in the system!");
					acct_Option();
				}
				
				
			}
			else if (delAcct.equalsIgnoreCase("N")) {
				print();
			}
			else {
				System.out.println("Invalid option!");
				print();
			}
		
	}
	
	
	public static void print() {
		
		if(lst.size()==0) {
			System.out.println("No accounts availabe in system !");
		}
		else {
			System.out.println("\n"+"Below accounts have been created: "+"\n");

			for(int x=0; x<=lst.size()-1;x+=6) {
				System.out.println("Account Type: "+lst.get(x)+"\n"+
						           "Customer Name: "+lst.get(x+1)+"\n"+
						           "Account No: "+lst.get(x+2)+"\n"+
						           "Available Amount: "+lst.get(x+3)+" "+lst.get(x+5)+"\n\n");
				
				
		}
			System.exit(0);
	
	}	
	}
	


}


