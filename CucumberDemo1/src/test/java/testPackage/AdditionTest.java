package testPackage;

import org.junit.Assert;
import org.junit.Test;

public class AdditionTest {
	
	@Test
	public void addtest() {
		AddTwoNumber aTwoNumber=new AddTwoNumber();
		int result= aTwoNumber.addTwo(10, 20);
		int expected=30;
	    Assert.assertEquals("StepFail: Expected result is not match with actual",expected, result);
	    System.out.println("StepPass: Addition is successfull ");
	}

}
