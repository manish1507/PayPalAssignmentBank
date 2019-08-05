import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 */

/**
 * @author mbreddy
 *
 */
interface details{
	String username();
	long phonenumber();
	int eid();
	ArrayList<String> address();
	
}
interface loan{
	long homeloan(bankAccount ba,long amountreq);
	long educationloan(bankAccount ba,long amountreq,long fatherba);
	long personalloan(bankAccount ba,long amountreq);
	long travelloan(bankAccount ba,long amountreq);
}
class bankAccount{
	long AccountNumber;
	private persondetailsforbank persondetail;
	private long balance;
	
	long getBalance(){
		return balance;
	}
	void setpersondetail(persondetailsforbank p1){
		this.persondetail=p1;
	}
	void setBalance(){
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter the starting balance: ");
		this.balance=s1.nextLong();
	}
	bankAccount(){
		setBalance();
	}
	
}
class loancalculator implements loan{
	public  long homeloan(bankAccount ba,long amountreq){
		if(ba.getBalance()>=(long)1000000&&amountreq<=10000000){
			return (long)(amountreq)*(int)Math.pow((1+(6/5)),5);
		}
		else
			return -1;
	}
	public long educationloan(bankAccount ba,long amountreq,long fatherbalance){
		if(fatherbalance>=(long)500000&&amountreq<=10000000){
			return (long)(amountreq)*(int)Math.pow((1+(8/6)),6);
		}
		else
			return -1;
	}
	public long personalloan(bankAccount ba,long amountreq){
		if(amountreq<=10000000)
			return (long)(amountreq)*(int)Math.pow((1+(5/1)),1);
		else
			return -1;
	}
	public long travelloan(bankAccount ba,long amountreq){
		if(ba.getBalance()>=(long)5000000&&amountreq<=10000000){
			return (long)(amountreq)*(int)Math.pow((1+(6/5)),5);
		}
		else
			return -1;
	}
}
class persondetailsforbank implements details{
	Scanner sc=new Scanner(System.in);
	public String username(){
		System.out.println("Enter your first  name");
		String firstname=sc.next();
		System.out.println("Enter your last  name");
		String lastname=sc.next();
		int firstnamelength=firstname.length();
		int lastnamelength=lastname.length();
		if(firstnamelength+lastnamelength<=16)
			return firstname+" "+lastname;
		else
			return firstname+" "+lastname.substring(0,16-firstnamelength);
	}
	public String fathername(){
		{
			System.out.println("Enter father name");
			String father=sc.next();
			return father;
			
		}
	}
	public long phonenumber(){
		System.out.println("Enter mobile no: ");
		long phoneno=sc.nextLong();
		int remainder= (int)(phoneno/(int)1000000000);
		while(remainder<0&&remainder>9){
			System.out.println("Enter valid mobile no: ");
			 phoneno=sc.nextLong();
		 remainder= (int)(phoneno/(int)1000000000);
		}
			//return -1;
		return phoneno ;
		
	}
	public int eid(){
		System.out.println("Enter employee id:");
		int emoplyeeid=sc.nextInt();
		int length=String.valueOf(emoplyeeid).length();
		while(length!=5){
			System.out.println("Enter valid employee id:");
			 emoplyeeid=sc.nextInt();
			 length=String.valueOf(emoplyeeid).length();
		}
		return emoplyeeid;
	}
	public ArrayList<String> address(){
		ArrayList<String> personAddress=new ArrayList<>();
		System.out.println("Enter hno: ");
		personAddress.add(sc.next());
		System.out.println("Enter colony: ");
		personAddress.add(sc.next());
		System.out.println("Enter city: ");
		personAddress.add(sc.next());
		System.out.println("Enter state: ");
		personAddress.add(sc.next());
		System.out.println("Enter 6 digit pincode: ");
		int pincode=sc.nextInt();
		while(String.valueOf(pincode).length()!=6){
			System.out.println("Enter valid pincode: ");
			pincode=sc.nextInt();}
		personAddress.add(String.valueOf(pincode));
		return personAddress;
	}
	public persondetailsforbank() {
		// TODO Auto-generated constructor stub
		username();
		fathername();
		phonenumber();
		eid();
		address();
	}
	
}
public class ManishBank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		persondetailsforbank person1=new persondetailsforbank();
		bankAccount person1Bank=new bankAccount();
		person1Bank.setpersondetail(person1);
		person1Bank.AccountNumber=(long)Math.random()*100000000;
		loancalculator loancal=new loancalculator();
		System.out.println("Enter 1 for house loan ");
		System.out.println("Enter 2 for education loan");
		System.out.println("Enter 3 for personal loan");
		System.out.println("Enter 4 for travel loan");
		Scanner sc1=new Scanner(System.in);
		int inp=sc1.nextInt();
		System.out.println("Enter the amount required ");
		long amount=sc1.nextLong();
		switch (inp) {
		case 1:
			long outhome=loancal.homeloan(person1Bank, amount);
			if(outhome==-1)
				System.out.println("you are not eligible for home loan");
			else
				System.out.println("you have to pay "+outhome+" after 5 years");
			break;
		case 2:
			System.out.println("Enter the father account balance ");
			long fbalance=sc1.nextLong();
			long outeduc=loancal.educationloan(person1Bank, amount, fbalance);
			if(outeduc==-1)
				System.out.println("you are not eligible for home loan");
			else
				System.out.println("you have to pay "+outeduc+" after 5 years");
			break;
		case 3:
			long outperson=loancal.personalloan(person1Bank, amount);
			if(outperson==-1)
				System.out.println("you are not eligible for home loan");
			else
				System.out.println("you have to pay "+outperson+" after 5 years");
			break;
		case 4:
			long outtravel=loancal.travelloan(person1Bank, amount);
			if(outtravel==-1)
				System.out.println("you are not eligible for home loan");
			else
				System.out.println("you have to pay "+outtravel+" after 5 years");
			break;	
		default:
			break;
		}
		
		
		
		
	}

}
