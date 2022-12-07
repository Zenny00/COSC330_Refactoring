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

    //This method is too long, lets move the switch statement to a separate function
    public String statement() {
	int num_frequent_renter_points = 0;
	int statement_amount = 0;

        String statement_result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
		//Calculate the number of frequent renter points
		num_frequent_renter_points += rental.getFrequentRenterPoints();

		// show figures for this rental
		statement_result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getAmountCharged()) + "\n";

		statement_amount += rental.getAmountCharged();
        }

        statement_result += "Amount owed is " + String.valueOf(statement_amount) + "\n";
        statement_result += "You earned " + String.valueOf(num_frequent_renter_points) + " frequent renter points";

        return statement_result;
    }
}
