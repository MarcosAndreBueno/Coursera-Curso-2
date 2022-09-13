package semana_1;

import edu.duke.FileResource;

public class Main {
    public static void main(String[] args) {

        /* TESTE DE RATED_MOVIES*/
        String movieFile = "exemplos/semana 1,2,3/ratedmoviesfull.csv";
        TestMovie tm = new TestMovie(movieFile);
        tm.setMovieList();

//        tm.testMovies();
//        tm.testeComedyGenres();
//        tm.testMovieLength(150);
//        tm.testMaximumDirectorsInOneMovie();
//        tm.testGetMovieById("0068646");

        /* TESTE DE RATING*/
        TestRating tr = new TestRating("exemplos/semana 1,2,3/ratings_short.csv");
        tr.setRatingList();
//        tr.testAllRaterRatings();
//        tr.testSpecifRaterRatings("1");
//        tr.testMaximumRatingByRaters();
//        tr.testSpecificMovieRates("0068646");
//        tr.testMoviesRated();

    }
}
