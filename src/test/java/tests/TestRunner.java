package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Login_Page_Tests.class, Home_Page_Tests.class, Burger_Menu_Page_Tests.class, 
	Cart_Page_Tests.class, Checkout_Page_Tests.class, Checkout_Page_Two_Tests.class, 
	Checkout_Complete_Page_Tests.class})

public class TestRunner {

}
