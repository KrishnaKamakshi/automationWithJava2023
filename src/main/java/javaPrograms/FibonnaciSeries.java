package javaPrograms;

public class FibonnaciSeries {
    static int n1=0, n2=1, n3=0;
    static  void print(int count)
    {
        if(count>0)
        {
            n3=n1+n2;
            n1=n2;
            n2=n3;
            System.out.print(" "+n3);
            print(count-1);
        }
    }

    public static void main(String[] args) {
        int count= 5;
        System.out.print(n1+" "+n2);//printing 0 and 1
        print(count-2);
    }
}
