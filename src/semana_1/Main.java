package semana_1;

import edu.duke.FileResource;

public class Main {
    public static void main(String[] args) {

        /* TESTE DE RATED_MOVIES*/
        FileResource fr = new FileResource("exemplos/ratedmoviesfull.csv");
        TestMovie tm = new TestMovie(fr);
        tm.setMovieList();

//        tm.testMovies();
//        tm.testeComedyGenres();
        tm.testMovieLength(150);
//        tm.testMaximumDirectorsInOneMovie();
//        tm.testGetMovieById("0068646");

        /* TESTE DE RATING*/
        fr = new FileResource("exemplos/ratings.csv");
        TestRating tr = new TestRating(fr);
        tr.setRatingList();
//        tr.testAllRaterRatings();
//        tr.testSpecifRaterRatings("40");
//        tr.testMaximumRatingByRaters();
//        tr.testSpecificMovieRates("0068646");
//        tr.testMoviesRated();
    }
}
