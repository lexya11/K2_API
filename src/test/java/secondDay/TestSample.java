package secondDay;

import app.CalculatorApp;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestSample {
//    @BeforeSuite
//    public void beforeSuite(){
//        System.out.println("Before Suite");
//    }
//    @BeforeClass
//    public void beforeClass(){
//        System.out.println("Before Class");
//    }
//    @BeforeTest
//    public void beforeTest(){
//        System.out.println("Before Test");
//    }
//    @BeforeMethod
//    public void beforeMethod(){
//        System.out.println("Before Method");
//    }
    @DataProvider(name = "SumDate")
    public Object[][] sumDate(){
        return new Object[][]{
                {1,2,3},
                {2,1,3}
        };
    }
    @Test(dataProvider = "SumDate")
    public void sumTest(int a, int b, int result){

        Assert.assertEquals(CalculatorApp.Sum(a,b),result);

    }

    @Test
    public void subTest(){
        Assert.assertEquals(CalculatorApp.Sub(5,2),3);

    }
    @Test
    public void mulTest(){
        Assert.assertEquals(CalculatorApp.Mul(1,3),3);

    }
    @Test
    public void divTest(){

        Assert.assertEquals(CalculatorApp.Div(1,1),1);
    }

//    @AfterSuite
//    public void afterSuite(){
//        System.out.println("After Suite");
//    }
//    @AfterClass
//    public void afterClass(){
//        System.out.println("After Class");
//    }
//    @AfterTest
//    public void afterTest(){
//        System.out.println("After Test");
//    }
//    @AfterMethod
//    public void afterMethod(){
//        System.out.println("After Method");
//    }

}
