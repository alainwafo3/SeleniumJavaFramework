package demo;

import org.testng.Assert;
import org.testng.annotations.Test;


//https://www.youtube.com/watch?v=9eUKJ5Nb7ag&list=PLhW3qG5bs-L8oRay6qeS70vJYZ3SBQnFa&index=29
//https://testng.org/doc/documentation-main.html#rerunning
//java -classpath testng.jar;%CLASSPATH% org.testng.TestNG -d test-outputs testng.xml
//java -classpath testng.jar;%CLASSPATH% org.testng.TestNG -d test-outputs test-outputs\testng-failed.xml
//consulte la classe RetryAnalyzer du package listeners

public class TestNGRetryFailedDemo {

	@Test
	public void test1() {
		System.out.println("I am inside Test 1");
	}


	@Test
	public void test2() {
		System.out.println("I am inside Test 2");
		//int i=1/0;
	}

	//consulte la classe RetryAnalyzer du package listeners

	@Test(retryAnalyzer = listeners.RetryAnalyzer.class )
	public void test3() {
		System.out.println("I am inside Test 3");
		Assert.assertTrue(0>1);
	}
}
