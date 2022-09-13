package semana_3;

import edu.duke.FileResource;
import semana_1.TestRating;


public class Main {
    public static void main(String[] args) {
        String movieFile = "exemplos/semana 1,2,3/ratedmovies_short.csv";
        String ratingFile = "exemplos/semana 1,2,3/ratings_short.csv";

        //testando classe após refatorar com interface
        TestRating tr = new TestRating(ratingFile);
        tr.setRatingList();
        tr.testAllRaterRatings();



    }
}
