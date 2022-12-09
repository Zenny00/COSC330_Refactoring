package bad.robot.refactoring.chapter1;

public abstract class Price {
    abstract int getPriceCode();
    abstract double getAmountCharged(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
