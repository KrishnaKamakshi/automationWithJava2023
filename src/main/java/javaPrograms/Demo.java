package javaPrograms;

@FunctionalInterface
interface A {
	void show();

	String toString();

	}

class B extends Object implements A{

public void show()
{
	System.out.println("hi");

}

}

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A obj = new B();
		obj.show();

	}

}
