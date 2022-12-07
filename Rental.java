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
	    //Initialize local variable to 0
	    int num_frequent_renter_points = 0;
	    
	    // add frequent renter points
	    num_frequent_renter_points++;
	    
	    // add bonus for a two day new release rental
	    if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1)
		    num_frequent_renter_points++;

	    //Return the total number of frequent renter points
	    return num_frequent_renter_points;
    }
}
