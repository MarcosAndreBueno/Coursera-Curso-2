package semana_2;

import edu.duke.FileResource;
import semana_1.TestMovie;

public class Main {
    public static void main(String[] args) {
        String movieFile;
        String ratingFile;
        movieFile = ("exemplos/semana 1,2,3/ratedmovies_short.csv");
        ratingFile = ("exemplos/semana 1,2,3/ratings_short.csv");
//        movieFile = ("exemplos/semana 1,2,3/ratedmoviesfull.csv");
//        ratingFile = ("exemplos/semana 1,2,3/ratings.csv");
//        movieFile = ("exemplos/semana 1,2,3/week2_exam_ratedmovies.csv");
//        ratingFile = ("exemplos/semana 1,2,3/week2_exam_ratings.csv");


        SecondRatings sr = new SecondRatings(movieFile, ratingFile);
//        System.out.printf("\nQuantidade de filmes: %d", + sr.getMovieSize());
//        System.out.printf("\nQuantidade de raters: %d", + sr.getRaterSize());
//        System.out.printf("\nQuantidade média de ratings: %f ",sr.getAvarageRatings());
//        System.out.println(sr.getTitleByID("0068646"));
        MovieRunnerAverage mra = new MovieRunnerAverage(movieFile, ratingFile);
//        mra.printFileAverageRatings();
//        String movieID = sr.getIdByTitle("Vacation");
//        mra.printAverageRatingByMovieID(movieID, 0);
//        mra.printAllMoviesAverageRating(2);
    }
}
