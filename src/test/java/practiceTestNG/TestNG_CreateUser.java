package practiceTestNG;

import org.testng.annotations.Test;

import com.BuyKart.GenericUtility.BaseClass;

public class TestNG_CreateUser  extends BaseClass{
@Test
public void createUser() {
	System.out.println("--Created User--");
}

@Test
public void editUser() {
	System.out.println("--Edited User");
}
}
