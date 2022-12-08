package bad.robot.refactoring.chapter1;

public class ChildrensPrice extends Price {
    public int getPriceCode() {
        return Movie.CHILDREN;
    }

    public double getAmountCharged(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }
}