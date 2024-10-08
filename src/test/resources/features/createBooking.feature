Feature: Create a new Booking through Parameterization
  Scenario Outline: Token should be generated based on the user information
    Given  API got valid all validae details with "<firstname>"  "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>", "<additionalneeds>"
    When   Validate if the end point is hit with valid returns as status code and id
    Then   validate the response

    Examples:
      | firstname                    | lastname   | totalprice        |  depositpaid| checkin | checkout | additionalneeds |
      |Krishna                       |Brahma      |670            |true |2023-02-23       |2013-02-29|TestQA           |

  Scenario Outline: Delete the booking which was made in the above scenarios
    Given Bearer Token is generated with using auth API with "<Username>" and "<Password>" and it is passed as cookie value
    When  There is a bookingid created pass the above token as Cookie with the booking id as 2050
    Then  Delete the BookingID and validate the status code

    Examples:
    |Username   |   Password|
    |admin           | password123          |