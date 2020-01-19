package labJUnit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MyTestRunner
{
    public static void main(String[] args)
    {
	Result result = JUnitCore.runClasses(MyLabJUnitTest.class);
	
	int failedTest = 0;
	
	for (Failure failure : result.getFailures())
	{
	    System.out.println(failure.toString());
	    failedTest++;
	}
	
	
	
	System.out.println("Run count: " + result.getRunCount());
	System.out.println("Fail count: " + failedTest);
	System.out.println("Pass count: " + (result.getRunCount()-failedTest));
    }

}
