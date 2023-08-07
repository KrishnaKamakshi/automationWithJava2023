package apiLearnings;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import payloadFiles.Payload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloadFiles.Payload;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class testSumOfOrders {

	@Test
	public void sumOfOrders() {
		JsonPath totalPurchaseOrder = new JsonPath(Payload.CoursePrice());
		int purchaseAmount = totalPurchaseOrder.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		int sum = 0;
		int c = totalPurchaseOrder.getInt("courses.size()");
		for (int i = 0; i < c; i++) {
			String courseNames = totalPurchaseOrder.get("courses[" + i + "].title");
			int priceOfBook = totalPurchaseOrder.get("courses[" + i + "].price");
			System.out.println("priceOfBook of the Book is " + priceOfBook + " Book Name " + courseNames);
			int totalCopiesSold = totalPurchaseOrder.get("courses[" + i + "].copies");
			int totalAmountEarned = totalCopiesSold * priceOfBook;
			sum = sum + totalAmountEarned;
			System.out.println(sum);		

		}		
		assertEquals(sum, purchaseAmount);

	}
	
	@Test
	public void restJIRA()
	{
		RestAssured.baseURI="http://localhost:8083";
		
	}

}
