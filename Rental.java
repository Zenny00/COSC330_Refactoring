package bad.robot.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Rental {

    private Movie movie;
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

    //Get the amount 
    public double getAmountCharged()
    {
	    double amount_charged = 0; //Local variable to hold the amount from each movie
            
	    //Switch statement to find the correct amount for each movie using the PriceCode
	    switch (getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    amount_charged += 2;
                    if (getDaysRented() > 2)
                        amount_charged += (getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    amount_charged += getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    amount_charged += 1.5;
                    if (getDaysRented() > 3)
                        amount_charged += (getDaysRented() - 3) * 1.5;
                    break;
            }

	    return amount_charged; //Return the amount found
    }
}
