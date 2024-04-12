package BaseClass;

import driverClass.DriverFinal;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass1 {
    protected BaseClass1()
    {}

    @BeforeMethod
    public void setUp()
    {
        DriverFinal.initDriver();
    }

    @AfterMethod
    public void tearDown()
    {
        DriverFinal.quitDriver();
    }
}
