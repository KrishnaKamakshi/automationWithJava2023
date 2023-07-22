package javaPrograms;

public class Printer <T> {
	
	T thingsPrinter;
	public Printer(T thingsPrinter)
	{
		this.thingsPrinter = thingsPrinter;
	}
	
	public void print()

	{
		System.out.println(thingsPrinter);
	}
	

}
