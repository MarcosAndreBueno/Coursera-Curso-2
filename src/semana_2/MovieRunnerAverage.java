package semana_2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class MovieRunnerAverage {
    FileResource fr1;
    FileResource fr2;
    public MovieRunnerAverage(FileResource fr1, FileResource fr2){
        this.fr1 = fr1;
        this.fr2 = fr2;
    }

    public void printFileAverageRatings(){
        SecondRatings sr = new SecondRatings(fr1,fr2);
        System.out.printf("\nA média de ratings foi: %.4f",sr.getAvarageRatings());
    }

    public void printAverageRatingByMovieID(String movieID, int minimalRaters){
        SecondRatings sr = new SecondRatings(fr1,fr2);
        System.out.printf("\nA média de ratings para o filme %s foi %.4f", movieID,
                sr.getAverageRatingByMovieID(movieID, minimalRaters));
    }

    public void printAllMoviesAverageRating(int minimalRaters){
        SecondRatings sr = new SecondRatings(fr1,fr2);
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
