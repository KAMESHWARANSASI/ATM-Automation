package Atm_automaction;

import java.util.Scanner;

abstract class Bank{
	
	abstract boolean Usercheck(int UserID,int Password ) ;
	abstract void Withdraw(int money) ;
	abstract void Deposit(int money);
	abstract void balance();
}

class Atmcontrol extends Bank{
	private int UserID=12345;
	private int password=12345;
	private int balance=500;
	
	
	boolean Usercheck(int UserID,int Password ) 
	{
	  boolean a=false;
	  if(UserID==this.UserID && Password==this.password) 
		{
			 a=true;
		}
		return a;
	}
	
	void Withdraw(int money) 
	{
		if(this .balance>money)
		{
			this.balance-=money;
			System.out.println("collect money");
		}
		else
		{
			System.out.println("unsuffecient balance");
		}
	}
	
	void Deposit(int money)
	{
		this.balance+=money;
	}
	
	void balance()
	{
		System.out.println("Your balance is : "+this.balance);
	}
	
}



public class Atm_automaction
{
	public  boolean user()
	{	
	  Bank b=new Atmcontrol();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter your UserID");
		int UserID=sc.nextInt();
		
		System.out.println("Enter your Password");
		int Password=sc.nextInt(); 
		
		boolean a=false;
		
		if(b.Usercheck(UserID,Password)) 
		{
			 a=true;
		}
		return a;

    }
	
	

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Welcome to ATM");
		
		Atm_automaction a=new Atm_automaction();
		 Bank b=new Atmcontrol();
		
		
		
		
		int i=1;
		while(i!=0)
		{
			
			try {
				
				Thread.sleep(2000);
			   }
		catch(Exception e) 
			{
				System.out.println("haldle");
			  }
			System.out.println("1 : Withdraw Money");
			System.out.println("2 : Deposit Money");
			System.out.println("3 : Check balance ");
			System.out.println("4 : Exit ");
			System.out.println("Enter the opction");
			
			int opction=sc.nextInt();
			
			switch(opction)
			{
				case 1:{
				           	System.out.println(" Withdraw Money");
				           	
				           	if(a.user()) 
				           	{
				           		System.out.println(" Enter the withdraw money");
				           		int money=sc.nextInt();
				           		b.Withdraw(money);
				           	}
				           	else 
				           	{
				           		System.out.println("UserID and password is invalid");
				           	}
				       }
				       break;
				case 2:{
					       System.out.println(" Deposit Money");
					       
					       if(a.user()) 
				           	{
					    	   System.out.println(" Enter the Deposit money");
				           		int money=sc.nextInt();
				           		b.Deposit(money);
				           	}
				           	else 
				           	{
				           		System.out.println("UserID and password is invalid");
				           	}
			            }
				        break;
				case 3:{
					       System.out.println(" Check balance");
					       if(a.user()) 
				           	{
				           		b.balance();
				           	}
				           	else 
				           	{
				           		System.out.println("UserID and password is invalid");
				           	}
			           }
				       break;
				case 4:{
					    i--;
			           }
				       break;
				default:
					
					System.out.println("Chose currect opction");				
			}
			
			
		}		
		System.out.println("Thank you");
	}
	
	
}

