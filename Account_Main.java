package account_Pkg1;

import java.awt.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Account_Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Customer cust;
		
		ArrayList<String> lst = new ArrayList<String>();
		
		
		while(true) {
			cust = new Customer();
			
			System.out.println("Please enter account type(1/2): 1.Saving  2.Current ");
			cust.setAccountType(sc.nextInt());
			
			if(cust.getAccountType() == 1){
				lst.add("Saving");
				System.out.println("Your account type is: Saving");
				
			}
			else if (cust.getAccountType() == 2) {
				lst.add("Current");
				System.out.println("Your account type is: Current");
			}
			else {
				System.out.println("Incorrect account type!");
				continue;
			}
			sc.nextLine();
			System.out.println("Please enter customer name: ");
			cust.setCustomerName(sc.nextLine());
			if(cust.getCustomerName() != null && cust.getCustomerName().length()>0) {
				lst.add(cust.getCustomerName());
				System.out.println("Customer name is: "+cust.getCustomerName());
		
			}
			else {
				System.out.println("Incorrect customer name!");
				continue;
			}
				
			System.out.println("Please enter Account No: ");
			cust.setAccountNumber(sc.nextBigInteger());
			System.out.println();
			if(cust.getAccountNumber().toString().length()>15 && cust.getAccountNumber().toString().length()<17 ) {
				lst.add(cust.getAccountNumber()+"");
				System.out.println("Account no is: "+cust.getAccountNumber());
		
			}
			else {
				System.out.println("Incorrect account number!");
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
				continue;
			}
			System.out.println("Please enter the amount: ");
			cust.setAmount(sc.nextFloat());
			
			if(cust.getAmount() != 0.0f) {
				lst.add(cust.getAmount()+"");
				System.out.println("Amount is: "+cust.getAmount());
		
			}
			else {
				System.out.println("Incorrect amount!");
				continue;
			}
			
				System.out.println("Do you want to add new account: Y/N ");
				String newAcct = sc.next();
				
				if(newAcct.equalsIgnoreCase("Y")) {
					continue;
				}
				else if (newAcct.equalsIgnoreCase("N")){
					System.out.println("\n"+"Below accounts have been created: "+"\n");
					for(int x=0; x<=lst.size()-1;x+=5) {
						System.out.println("Account Type: "+lst.get(x)+"\n"+
								           "Customer Name: "+lst.get(x+1)+"\n"+
								           "Account No: "+lst.get(x+2)+"\n"+
								           "Amount: "+lst.get(x+3)+"\n"+
								           "Currency Type: "+lst.get(x+4)+"\n\n");
						
					}
					System.exit(0);
				}
				else {
					System.out.println("Invalid option");
				}
		}
		
		
	}

}


