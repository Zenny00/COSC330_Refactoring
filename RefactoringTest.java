//JUnit testing for Java Battleship
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

//Import packages
import bad.robot.refactoring.chapter1.Movie;
import bad.robot.refactoring.chapter1.Customer;
import bad.robot.refactoring.chapter1.Rental;

public class RefactoringTest
{
	private final Movie movie_1 = new Movie("TEST TITLE 1", Movie.REGULAR);
	private final Movie movie_2 = new Movie("TEST TITLE 2", Movie.NEW_RELEASE);
	private final Movie movie_3 = new Movie("TEST TITLE 3", Movie.CHILDREN);

	private final Customer customer_1 = new Customer("Franklin");

	@Test
	public void testMovieCreation()
	{
		//Create new movie and test if it is created correctly
		assertEquals(movie_1.getTitle(), "TEST TITLE 1");
	}

	@Test
	public void baseChildrenRentalTest() 
	{
		//Add rental, discount shouldn't show up here
		customer_1.addRental(new Rental(movie_3, 2));
		//Check if the statement is correct
		assertThat(customer_1.statement(), is(expectedMessageFor("TEST TITLE 3", 1.5, 1.5, 1)));
	}

	private static String expectedMessageFor(String rental, double price, double total, int renterPointsEarned) {
        return "Rental record for Franklin\n\t" + rental + "\t" + price + "\nAmount owed is " + total + "\nYou earned " + renterPointsEarned + " frequent renter points";
    	}
}
