package Utility;

import org.testng.asserts.SoftAssert;

public class SoftAssertUtil
{
private static SoftAssert softassertion;


private	 SoftAssertUtil()
{

}

public static SoftAssert getInstance()
{
	if(softassertion==null)
	{
		softassertion=new SoftAssert();
	}
	return softassertion;
}

public static void assertsTrue(boolean condition,String message)
{
	getInstance().assertTrue(condition);
	getInstance().fail(message);
}

public static void assertsFalse(boolean condition,String message)
{
	getInstance().assertFalse(condition);
	getInstance().fail(message);
}
public static void assertsEquals(boolean Expectedcondition,boolean actualcondition,String message)
{
	getInstance().assertEquals(Expectedcondition, actualcondition);
	getInstance().fail(message);
}

}

	

