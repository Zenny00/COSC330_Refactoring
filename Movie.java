package bad.robot.refactoring.chapter1;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
   
    //Get the amount 
    public double getAmountCharged(int days_rented)
    {
	    double amount_charged = 0; //Local variable to hold the amount from each movie
	    //Switch statement to find the correct amount for each movie using the PriceCode
	    switch (getPriceCode()) {
                case Movie.REGULAR:
                    amount_charged += 2;
                    if (days_rented > 2)
                        amount_charged += (days_rented - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    amount_charged += days_rented * 3;
                    break;
                case Movie.CHILDREN:
                    amount_charged += 1.5;
                    if (days_rented > 3)
                        amount_charged += (days_rented - 3) * 1.5;
                    break;
            }

	    return amount_charged; //Return the amount found            
    }

    //Get the total number of frequent renter points awarded
    public int getFrequentRenterPoints(int days_rented)
    {
	//Initialize local variable to 0
	    int num_frequent_renter_points = 0;
	    
	    // add frequent renter points
	    num_frequent_renter_points++;
	    
	    // add bonus for a two day new release rental
	    if (priceCode == Movie.NEW_RELEASE && days_rented > 1)
		    num_frequent_renter_points++;

	    //Return the total number of frequent renter points
	    return num_frequent_renter_points;
    }
}
