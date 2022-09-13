package semana_3;

import java.util.*;
import org.apache.commons.csv.*;
import edu.duke.FileResource;
import semana_1.Movie;
import semana_1.TestMovie;
import semana_3.Filter;

public class MovieDatabase {
    private static HashMap<String, Movie> ourMovies;

    public static void initialize(String moviefile) {
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            setMovie(moviefile);
        }
    }

    private static void initialize() {
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            setMovie("exemplos/semana 1,2,3/ratedmovies_full.csv");
        }
    }


    private static void setMovie(String movieFile) {
        TestMovie tm = new TestMovie(movieFile);
        ArrayList<Movie> list = tm.setMovieList();
        for (Movie m : list) {
            ourMovies.put(m.getID(), m);
        }
    }

    public static boolean containsID(String id) {
        initialize();
        return ourMovies.containsKey(id);
    }

    public static int getYear(String id) {
        initialize();
        return ourMovies.get(id).getYear();
    }

    public static String getGenres(String id) {
        initialize();
        return ourMovies.get(id).getGenres();
    }

    public static String getTitle(String id) {
        initialize();
        return ourMovies.get(id).getTitle();
    }

    public static Movie getMovie(String id) {
        initialize();
        return ourMovies.get(id);
    }

    public static String getPoster(String id) {
        initialize();
        return ourMovies.get(id).getPoster();
    }

    public static int getMinutes(String id) {
        initialize();
        return ourMovies.get(id).getMinutes();
    }

    public static String getCountry(String id) {
        initialize();
        return ourMovies.get(id).getCountry();
    }

    public static String getDirector(String id) {
        initialize();
        return ourMovies.get(id).getDirector();
    }

    public static int size() {
        return ourMovies.size();
    }

    public static ArrayList<String> filterBy(Filter f) {
        initialize();
        ArrayList<String> list = new ArrayList<String>();
        for(String id : ourMovies.keySet()) {
            if (f.satisfies(id)) {
                list.add(id);
            }
        }

        return list;
    }

}
