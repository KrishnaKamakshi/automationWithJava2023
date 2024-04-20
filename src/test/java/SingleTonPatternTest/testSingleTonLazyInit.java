package SingleTonPatternTest;

import SingleTonUtilites.SingletonClass;
import org.testng.annotations.Test;

public class testSingleTonLazyInit {

    // Early - instance gets created whenever methods are created
    // Lazy - Tread Safe fails does it scale when we run multiple runs
    // Thread Safe - Time execution
    SingletonClass singletonClass = SingletonClass.getInstance();
    @Test
    public void testDbUtil(){
        SingletonClass dbUtilSingleTon = SingletonClass.getInstance();
        dbUtilSingleTon.runQuery("feawf");
        SingletonClass.method();
    }

    @Test
    public void dbTest2(){
        SingletonClass dbUtilSingleTon = SingletonClass.getInstance();
        dbUtilSingleTon.runQuery("select * from item");
    }

    @Test
    public void dbTest3(){
        SingletonClass dbUtilSingleTon = SingletonClass.getInstance();
        dbUtilSingleTon.runQuery("select * from item");
    }

    @Test
    public void dbTest4(){
        SingletonClass dbUtilSingleTon = SingletonClass.getInstance();
        dbUtilSingleTon.runQuery("select * from item");
    }

    @Test
    public void dbTest5(){
        SingletonClass dbUtilSingleTon = SingletonClass.getInstance();
        dbUtilSingleTon.runQuery("select * from item");
    }
}
