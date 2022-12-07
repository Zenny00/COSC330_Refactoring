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
        String statement_result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
		// show figures for this rental
		statement_result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getAmountCharged()) + "\n";
        }

	//Use a function call rather than a temp variable
        statement_result += "Amount owed is " + String.valueOf(getTotalAmountCharged()) + "\n";
        statement_result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";

        return statement_result;
    }

    //New method to get the statement in HTML format
    public String htmlStatement()
    {
	//Local variable to hold the statement result in HTML
	String statement_result = "<h1>Rental record for <b>" + getName() + "</b></h1>\n";
        
	for (Rental rental : rentals)
		statement_result += "<p>" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getAmountCharged()) + "</p>\n";

	//Use a function call rather than a temp variable
        statement_result += "<p>Amount owed is <b>" + String.valueOf(getTotalAmountCharged()) + "</b></p>\n";
        statement_result += "<p>You earned <b>" + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points</b></p>";

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

    //Similar to the above method, we remove the local num_frequent_renter_points temp variable and have a method return the total
    public int getTotalFrequentRenterPoints()
    {
	//Initialize number of points to 0
	int num_frequent_renter_points = 0;
    	
	//Iterate through all the rentals and add the number of frequent renter points
        for (Rental rental : rentals)
		//Calculate the number of frequent renter points
		num_frequent_renter_points += rental.getFrequentRenterPoints();
    
	//Return the total number of frequent renter points
	return num_frequent_renter_points;
    }
}
