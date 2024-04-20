package SingleTonUtilites;

public class SingletonClass {

    //    //Eager initialization
//    static DBUtilSingleTon dbUtilSingleTon = new DBUtilSingleTon();
//
//    public static DBUtilSingleTon getInstance(){
//        return dbUtilSingleTon;
//    }

    static SingletonClass dbUtilSingleTon;

    public static SingletonClass getInstance(){
        if(dbUtilSingleTon == null) {
            dbUtilSingleTon = new SingletonClass();
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
