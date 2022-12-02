//JUnit testing for Java Battleship
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

//Import packages
import bad.robot.refactoring.chapter1.Movie;

public class RefactoringTest
{
	@Test
	public void testMovieCreation()
	{
		//Create new movie and test if it is created correctly
		Movie movie = new Movie("TEST TITLE", 1);
		assertEquals(movie.getTitle(), "TEST TITLE");
	}	
}
