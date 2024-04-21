package SingleTonPatternTest;

import SingleTonUtilites.MultThread;
import SingleTonUtilites.SingletonClass;
import org.testng.annotations.Test;

public class testMultiThread {

    // Early - instance gets created whenever methods are created
    // Lazy - Tread Safe fails does it scale when we run multiple runs
    // Thread Safe - Time execution
    SingletonClass singletonClass = SingletonClass.getInstance();
    @Test
    public void testMultiThread(){
        for (int i=1; i<=1000;i++) {
            MultThread multiThread = new MultThread();
            multiThread.start();
        }
    }
}
