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

        String statement_result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
		//Calculate the number of frequent renter points
		num_frequent_renter_points += rental.getFrequentRenterPoints();

		// show figures for this rental
		statement_result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getAmountCharged()) + "\n";

        }

	//Use a function call rather than a temp variable
        statement_result += "Amount owed is " + String.valueOf(getTotalAmountCharged()) + "\n";
        statement_result += "You earned " + String.valueOf(num_frequent_renter_points) + " frequent renter points";

        return statement_result;
    }

    //Calculate the total amount to be charged
    public double getTotalAmountCharged()
    {
	double totalAmountCharged = 0;
	//Loop through each rental and add its charge to the total
        for (Rental rental : rentals)
    		totalAmountCharged += rental.getAmountCharged(); //Add the amount charged for the current rental
    
    	return totalAmountCharged; //Return the total
    }
}
