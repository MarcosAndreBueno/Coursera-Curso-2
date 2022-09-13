package semana_2;

import edu.duke.FileResource;
import semana_1.*;

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private Map<Rater, Rating> myRaters = new HashMap<>();
    private FileResource fr1;
    private FileResource fr2;

    public SecondRatings(String movieFile, String ratingFile) {
        this.fr1 = new FileResource(movieFile);
        this.fr2 = new FileResource(ratingFile);

        this.myMovies = new TestMovie(movieFile).setMovieList();
        //key: myID e myRating //value movieID e rating
        this.myRaters = new TestRating(ratingFile).setRatingList();
    }

    public int getMovieSize(){
        /*for (Movie m : this.myMovies){
            System.out.printf("Filme: %50s | size: %d minutos \n", m.getTitle(), m.getMinutes());
        }*/
        return this.myMovies.size();
    }

    public int getRaterSize(){
        ArrayList<String> myID = new ArrayList<>();
        String id;
        for (Map.Entry<Rater, Rating> entry: this.myRaters.entrySet()){
            id = entry.getKey().getID();
            if (!myID.contains(id)){
                myID.add(id);
            }
        }
        return myID.size();
    }

    public Double getAvarageRatings(){
        ArrayList<Double> rating = new ArrayList<>();
        Double media = 0.0;

        //extrair lista de rating de dentro do hashmap
        for (Rating value : this.myRaters.values()){
            rating.add(value.getValue());
        }

        for (Double r : rating){
            media += r;
        }

        media = media/rating.size();

        return media;
    }

    //retorna a média de rating de um movieID, desde que tenha um mínimo de raters
    public Double getAverageRatingByMovieID(String movieID, int minimalRaters){
        Double media = 0.0;
        ArrayList<Double> rating = new ArrayList<>();

        //se id atual == id movie
        for (Rating value : this.myRaters.values()){
            if (value.getItem().equals(movieID)){
                rating.add(value.getValue());
            }
        }

        if (rating.size() >= minimalRaters){
            for (Double r : rating){
                media += r;
            }
        }

        media = media/rating.size();

        return media;
    }

    public String[][] getAllMoviesAverageRating(int minimalRaters) {
        ArrayList<String> filmesID = new ArrayList<>();
        ArrayList<Double> filmesAvaliacaoMedia = new ArrayList<>();
        String movieID;
        Double media;

        //obter média de cada filme
        for (Rating value : this.myRaters.values()) {
            movieID = value.getItem();
            //retornar average rating para cada filme
            if (!filmesID.contains(movieID)) {
                media = getAverageRatingByMovieID(movieID, minimalRaters);
                //se filme tinha minimo de raters
                if (media != 0.0) {
                    filmesID.add(movieID);
                    filmesAvaliacaoMedia.add(media);
                }
            }
        }

        Double valorAtual;
        Double valorMaior;
        String movieIDAtual;
        String movieIDMaior;
        //colocar em ordem crescente
        for (int i = filmesAvaliacaoMedia.size()-1; i >= 0; i--) {
            valorAtual = filmesAvaliacaoMedia.get(i);
            movieIDAtual = filmesID.get(i);
            for (int j = i; j >= 0 ; j--) {
                //trocar último valor atual se menor que penúltimo
                if (valorAtual < filmesAvaliacaoMedia.get(j)){
                    valorMaior = filmesAvaliacaoMedia.get(j);
                    movieIDMaior = filmesID.get(j);
                    filmesAvaliacaoMedia.set(j, valorAtual);
                    filmesAvaliacaoMedia.set(i, valorMaior);
                    //também trocar movieID da outra lista
                    filmesID.set(j, movieIDAtual);
                    filmesID.set(i, movieIDMaior);
                    //se trocou, refazer lógica acima partindo do penúltimo
                    valorAtual = valorMaior;
                    movieIDAtual = movieIDMaior;
                    j += 1;
                }
            }
        }

//        ArrayList<String> filmesComAvaliacao = new ArrayList<>();
        String[][] filmesComAvaliacao = new String[filmesAvaliacaoMedia.size()][2];
        for (int i = 0; i < filmesAvaliacaoMedia.size(); i++) {
          filmesComAvaliacao[i][0] = filmesID.get(i);
            filmesComAvaliacao[i][1] = filmesAvaliacaoMedia.get(i).toString();
        }

        return filmesComAvaliacao;
    }


    public String getTitleByID(String movieID){
        String title = "";
        for (Movie m : this.myMovies){
            if (m.getID().equals(movieID)){
                title = m.getTitle();
            }
        }
        return title;
    }

    public String getIdByTitle(String movName){
        String movieID = "";
        for (int i = 0; i < this.myMovies.size(); i++) {
            String title = this.myMovies.get(i).getTitle();
            if (this.myMovies.get(i).getTitle().equals(movName)){
                movieID = this.myMovies.get(i).getID();
                return movieID;
            }
        }
        return movieID;
    }
}