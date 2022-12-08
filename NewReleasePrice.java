package bad.robot.refactoring.chapter1;

public class NewReleasePrice extends Price {
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    public double getAmountCharged(int daysRented) {
        return daysRented * 3;
    }
}