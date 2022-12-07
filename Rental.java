package bad.robot.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Rental {

    Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    //Get the amount, use delegation
    public double getAmountCharged()
    { 
	    return movie.getAmountCharged(daysRented); //Return the amount found            
    }

    //Move method to get the number of frequent renter points
    public int getFrequentRenterPoints()
    {
	return movie.getFrequentRenterPoints(daysRented); //Return the number of frequent renter points using delegation	    
    }
}
