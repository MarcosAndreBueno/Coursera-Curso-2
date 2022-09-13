package semana_2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class MovieRunnerAverage {
    String movieFile;
    String ratingFile;
    public MovieRunnerAverage(String movieFile, String ratingFile){
        this.movieFile = movieFile;
        this.ratingFile = ratingFile;
    }

    public void printFileAverageRatings(){
        SecondRatings sr = new SecondRatings(movieFile,ratingFile);
        System.out.printf("\nA média de ratings foi: %f",sr.getAvarageRatings());
    }

    public void printAverageRatingByMovieID(String movieID, int minimalRaters){
        SecondRatings sr = new SecondRatings(movieFile,ratingFile);
        System.out.printf("\nA média de ratings para o filme %s foi %f", movieID,
                sr.getAverageRatingByMovieID(movieID, minimalRaters));
    }

    public void printAllMoviesAverageRating(int minimalRaters){
        SecondRatings sr = new SecondRatings(movieFile,ratingFile);
        String[][] filmesComAvaliacao;
        filmesComAvaliacao = sr.getAllMoviesAverageRating(minimalRaters);
        String title;

        for (int i = 0; i < filmesComAvaliacao.length; i++) {
            title = sr.getTitleByID(filmesComAvaliacao[i][0]);
            System.out.printf("\nFilme: %20s | rating: %s ", title, filmesComAvaliacao[i][1]);
        }
        System.out.printf("\nQuantidade de filmes: %d", filmesComAvaliacao.length);
    }
}
