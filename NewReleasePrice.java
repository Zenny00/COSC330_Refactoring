package bad.robot.refactoring.chapter1;

public class NewReleasePrice extends Price {
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

        return daysRented * 3;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        return 1;
    }
}