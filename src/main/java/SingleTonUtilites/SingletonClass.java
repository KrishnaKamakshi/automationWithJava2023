package SingleTonUtilites;

public class SingletonClass {
    //    //Eager initialization
//   static DBUtilSingleTon dbUtilSingleTon = new DBUtilSingleTon();
//
//    public static DBUtilSingleTon getInstance(){
//        return dbUtilSingleTon;
//    }

    static SingletonClass dbUtilSingleTon;

    //Lazy Init - where we can add a null check and create the new instance of a call
    // Thread Local - when we want to share 1 driver keep in 1 driver
    // Need to use the same for WebDriver Classes - this will overcome challenge of launching multiple instances
    public static synchronized SingletonClass getInstance() {
        if (dbUtilSingleTon == null) {
            dbUtilSingleTon = new SingletonClass();
        } else {
            System.out.println("DB Constructor already created");
        }
        return dbUtilSingleTon;
    }

    SingletonClass(){
        System.out.println("DBUtilSingleTon Constructor is called" + this.hashCode());
    }

    public void runQuery(String query)
    {
        System.out.println("Query entered "+query);
    }

    public static void method()
    {
        System.out.println("Query entered method");
    }
}
