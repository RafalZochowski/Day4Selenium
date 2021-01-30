package Day4;

import org.testng.annotations.*;

public class AnnotationsTest {

    @BeforeClass
    public void beforeAll(){
        System.out.println("to się wykonuje przed wszystkimi testami");
    }

    @AfterClass
    public void afterAll(){
        System.out.println("to się wykonuje po wszystkich testach");
    }

    @BeforeMethod
    public void  setup(){
        System.out.println("To się wykonuje przed każdym testem");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("To się wykorzystuje po kazdym teście");
    }

    @Test
    public void test1(){
        System.out.println("To jest pierwszy test");
    }
    @Test
    public void test2(){
        System.out.println("To jest pierwszy test");
    }
    @Test
    public void test3(){
        System.out.println("To jest pierwszy test");
    }
}
