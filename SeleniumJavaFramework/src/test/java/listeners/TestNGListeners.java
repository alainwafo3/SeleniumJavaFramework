package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener, ISuiteListener {
	//https://www.youtube.com/watch?v=WAyMslXOkLM&list=PLhW3qG5bs-L8oRay6qeS70vJYZ3SBQnFa&index=22
	//https://testng.org/doc/documentation-main.html

	public void onTestStart(ITestResult result) {
		System.out.println("********************Test Started: "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("********************Test is successful: "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("********************Test is failed: "+result.getName());
		//possibilité de prendre des screenshots
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("********************Test skipped: "+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		System.out.println("********************Test completed: "+context.getName());
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
	}


	
}
