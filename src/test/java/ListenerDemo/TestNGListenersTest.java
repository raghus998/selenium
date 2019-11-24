package ListenerDemo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listener.class)
public class TestNGListenersTest
{
	@Test
	public void testA()
	{
		Reporter.log("testA.......",true);
	}
	
	@Test
	public void testB()
	{
		Reporter.log("testB.....",true);
		Assert.fail();
	}
}
