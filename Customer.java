package bad.robot.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    //We make this method private as it will never be called outside of the statement method
    //Using extract method we are moving the switch statement to a separate method
    private double getAmount(Rental current_rental)
    {
    	//Delegation, have the current rental return the amount charged
	return current_rental.getAmountCharged();	    
    }

    //This method is too long, lets move the switch statement to a separate function
    public String statement() {
	int num_frequent_renter_points = 0;
	int statement_amount = 0;

        String statement_result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
		//Local variable to hold the value of the amount on each rental
		double rental_amount = getAmount(rental);

           	// add frequent renter points
            	num_frequent_renter_points++;

		// add bonus for a two day new release rental
		if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
			num_frequent_renter_points++;

		// show figures for this rental
		statement_result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental_amount) + "\n";

		statement_amount += rental_amount;
        }

        statement_result += "Amount owed is " + String.valueOf(statement_amount) + "\n";
        statement_result += "You earned " + String.valueOf(num_frequent_renter_points) + " frequent renter points";

        return statement_result;
    }
}
