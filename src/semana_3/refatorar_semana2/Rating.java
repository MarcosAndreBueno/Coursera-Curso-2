package semana_3.refatorar_semana2;

// An immutable passive data object (PDO) to represent the rating data
public class Rating implements Comparable<Rating> {
    private double value;

    public Rating(double aValue) {
        value = aValue;
    }

    // Returns the value of this rating (as a number so it can be used in calculations)
    public double getValue () {
        return value;
    }

    // Returns a string of all the rating information
    public String toString () {
        return "[" + getValue() + "]";
    }

    public int compareTo(Rating other) {
        if (value < other.value) return -1;
        if (value > other.value) return 1;

        return 0;
    }
}
