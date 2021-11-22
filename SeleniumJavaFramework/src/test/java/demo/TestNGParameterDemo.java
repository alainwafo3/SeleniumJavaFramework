package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameterDemo {

	@Test
	@Parameters({"MyName"})
	public void test(String name) {
		System.out.println("My name is :"+name);

	}

	@Test
	@Parameters({"MySecondName"})
	public void test1(@Optional("Pascal") String name) {
		System.out.println("My second name is :"+name);

	}
}
