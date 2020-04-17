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
			
			int accountType = sc.nextInt();
			if(accountType == 1){
				lst.add("Saving");
				System.out.println("Your account type is: Saving");
				
				cust.setAccountType(accountType);
			}
			else if (accountType == 2) {
				lst.add("Current");
				System.out.println("Your account type is: Current");
			}
			else {
				System.out.println("Incorrect account type!");
				continue;
			}
			sc.nextLine();
			System.out.println("Please enter customer name: ");
			String customerName = sc.nextLine();
			
			if(customerName != null && customerName.length()>0) {
				lst.add(customerName);
				System.out.println("Customer name is: "+customerName);
				cust.setCustomerName(customerName);
			}
			else {
				System.out.println("Incorrect customer name!");
				continue;
			}
				
			System.out.println("Please enter Account No: ");
			BigInteger accountNumber = sc.nextBigInteger();
			
			if(accountNumber.bitLength()>15 && accountNumber.bitLength()>17 ) {
				lst.add(accountNumber+"");
				System.out.println("Account no is: "+accountNumber);
				cust.setAccountNumber(accountNumber);
			}
			else {
				System.out.println("Incorrect account number!");
				continue;
			}
			
			System.out.println("Please enter currency:(USD/INR) ");
			sc.nextLine();
			String currency = sc.nextLine();
			
			if(currency !=null &&  currency.equalsIgnoreCase("USD") || currency.equalsIgnoreCase("INR")) {
				lst.add(currency.toUpperCase());
				System.out.println("Your currency is: "+currency.toUpperCase());
				cust.setCurrency(currency);
			}
			else {
				System.out.println("Invalid currency type!");
				continue;
			}
			System.out.println("Please enter the amount: ");
			float amount = sc.nextFloat();
			
			if(amount != 0.0f) {
				lst.add(amount+"");
				System.out.println("Amount is: "+amount);
				cust.setAmount(amount);
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


