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

	@Test
	public void discountChildrenRentalTest() 
	{
		//Add rental, discount should show up here
		customer_1.addRental(new Rental(movie_3, 4));
		//Check if the statement is correct
		assertThat(customer_1.statement(), is(expectedMessageFor("TEST TITLE 3", 3.0, 3.0, 1)));
	}

	@Test
	public void basicNewReleaseRentalTest()
	{
		//Add new rental
		customer_1.addRental(new Rental(movie_2, 1));
		//Check if the new rental was correctly added
		assertThat(customer_1.statement(), is(expectedMessageFor("TEST TITLE 2", 3.0, 3.0, 1)));
	}

	@Test
	public void noDiscountNewReleaseRentalTestButShouldGetFrequentRenterPoints()
	{
		//Add new rental, should have frequent renter points
		customer_1.addRental(new Rental(movie_2, 4));
		//Check if the new rental was correctly added
		assertThat(customer_1.statement(), is(expectedMessageFor("TEST TITLE 2", 12.0, 12.0, 2)));
	}

	@Test
	public void addBasicRegularRentalTest()
	{
		//Add new regular rental, should have no discounts or frequent renter points
		customer_1.addRental(new Rental(movie_1, 2));
		//Check if the new rental was correctly added
		assertThat(customer_1.statement(), is(expectedMessageFor("TEST TITLE 1", 2.0, 2.0, 1)));
	}

	@Test
	public void addDiscountedRegularRental()
	{
		//Add new regular rental, should produce a discount
		customer_1.addRental(new Rental(movie_1, 4));
		//Check if the new rental was correctly added, if so it should give a discount
		assertThat(customer_1.statement(), is(expectedMessageFor("TEST TITLE 1", 5.0, 5.0, 1)));
	}

	@Test
	public void sumVariousRentalsTest()
	{
		//Add a bunch of new rentals
		customer_1.addRental(new Rental(movie_1, 1));
		customer_1.addRental(new Rental(movie_3, 2));
		customer_1.addRental(new Rental(movie_2, 3));

		assertThat(customer_1.statement(), is("Rental record for Franklin\n\tTEST TITLE 1\t2.0\n\tTEST TITLE 3\t1.5\n\tTEST TITLE 2\t9.0\nAmount owed is 12.5\nYou earned 4 frequent renter points"));
	}

	@Test
	public void createNewRentalGetMovie()
	{
		//Create new rental using movie_1
		Rental rental = new Rental(movie_1, 1);
		//Check if the correct movie is returned
		assertThat(rental.getMovie().getTitle(), is(movie_1.getTitle()));
	}

	@Test
	public void createNewRentalGetDaysRented()
	{
		//Create a new rental that will be rented for 8 days
		Rental rental = new Rental(movie_2, 8);
		//Check if the movie was rented for 8 days
		assertThat(rental.getDaysRented(), is(8));
	}

	@Test
	public void createNewMovieGetPriceCode()
	{
		//Create a new REGULAR movie
		Movie new_regular_movie = new Movie("TEST TITLE 4", Movie.REGULAR);
		//Check if the movie was created properly
		assertThat(new_regular_movie.getPriceCode(), is(Movie.REGULAR));
	}

	@Test
	public void createNewMovieSetPriceCode()
	{
		//Create a new REGULAR movie
		Movie new_regular_movie = new Movie("TEST TITLE 4", Movie.REGULAR);
		//Change the movie to a new release
		new_regular_movie.setPriceCode(Movie.NEW_RELEASE);
		//Check if the movie price code was changed
		assertThat(new_regular_movie.getPriceCode(), is(Movie.NEW_RELEASE));
	}

	//Helper function to create an expected output String for the customer statement
	private static String expectedMessageFor(String rental, double price, double total, int renterPointsEarned) {
        return "Rental record for Franklin\n\t" + rental + "\t" + price + "\nAmount owed is " + total + "\nYou earned " + renterPointsEarned + " frequent renter points";
    	}
}
