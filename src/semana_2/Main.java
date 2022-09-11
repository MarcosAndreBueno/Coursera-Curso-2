package semana_2;

import edu.duke.FileResource;
import semana_1.TestMovie;

public class Main {
    public static void main(String[] args) {
//        FileResource fr1 = new FileResource("exemplos/ratedmovies_short.csv");
//        FileResource fr2 = new FileResource("exemplos/ratings_short.csv");
        FileResource fr1 = new FileResource("exemplos/ratedmoviesfull.csv");
        FileResource fr2 = new FileResource("exemplos/ratings.csv");
//        FileResource fr1 = new FileResource("exemplos/week2_exam_ratedmovies.csv");
//        FileResource fr2 = new FileResource("exemplos/week2_exam_ratings.csv");


        SecondRatings sr = new SecondRatings(fr1,fr2);
//        sr.getMovieSize();
//        sr.getRaterSize();
//        sr.getAvarageRatings();
//        System.out.println(sr.getTitleByID("0068646"));
        MovieRunnerAverage mra = new MovieRunnerAverage(fr1,fr2);
//        mra.printFileAverageRatings();
//        String movieID = sr.getIdByTitle("Moneyball");
//        mra.printAverageRatingByMovieID(movieID, 0);
//        mra.printAllMoviesAverageRating(12);
    }
}
