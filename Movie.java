package bad.robot.refactoring.chapter1;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price priceCode;

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
        switch (priceCode) {
            case CHILDREN:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case REGULAR:
                price = new RegularPrice();
                break;
        }
    }
   
    //Get the amount 
    public double getAmountCharged(int days_rented)
    {
        return price.getAmountCharged(days_rented);
    }

    //Get the total number of frequent renter points awarded
    public int getFrequentRenterPoints(int days_rented)
    {
        return price.getFrequentRenterPoints(days_rented);
    }
}
