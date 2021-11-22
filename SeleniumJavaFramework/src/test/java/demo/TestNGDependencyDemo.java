package demo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {

	@Test(dependsOnMethods = {"test2","test3"})
	public void test1() {
		System.out.println("I am inside Test 1");

	}

	@Test
	public void test2() {
		System.out.println("I am inside Test 2");

	}

	@Test(groups = {"sanityTest"})
	public void test3() {
		System.out.println("I am inside Test 3");

	}


	@Test(dependsOnGroups ={"sanityTest.*"} )
	public void test4() {
		System.out.println("I am inside Test 4");

	}

	@Test(groups = {"sanityTest2"})
	public void test5() {
		System.out.println("I am inside Test 5");

	}
}
