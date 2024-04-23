package SingleTonUtilites;

public class MultThread extends Thread{
    public void run()
    {
        SingletonClass.getInstance();
    }
}
