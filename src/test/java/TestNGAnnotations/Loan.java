package TestNGAnnotations;

import org.testng.annotations.Test;

public class Loan {
	
	
	@Test(groups = {"loan"}) 
	public void mobileLoan()
	{
		System.out.println("this is mobile Loan");
	}
	
	@Test(groups = {"insurance"})
	public void carLoan()
	{
		System.out.println("this is car Loan");
	}
	
	@Test(groups = {"loan","insurance"})
	public void bikeLoan()
	{
		System.out.println("this is bikeLoan");
	}

}
