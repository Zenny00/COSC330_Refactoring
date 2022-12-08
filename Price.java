package bad.robot.refactoring.chapter1;

public abstract class Price {
    abstract int getPriceCode();

    public double getCharge(int daysRented) {
        double amount = 0;
        switch (getPriceCode()) {
            case Movie.NEW_RELEASE:
                amount += daysRented * 3;
                break;
        }
        return amount;
    }
}