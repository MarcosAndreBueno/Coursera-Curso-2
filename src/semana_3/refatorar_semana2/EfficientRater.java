package semana_3.refatorar_semana2;

import com.sun.jdi.Value;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import semana_3.refatorar_semana2.Rating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EfficientRater implements Rater {
    private String myID;
    private HashMap<String,Rating> myRatings;

    //construtor
    public EfficientRater (String id) {
        myID = id;
    }

    public void setRatingList(CSVParser linhas) {
        for (CSVRecord linha : linhas) {
            addRating(linha.get(1), (Double.parseDouble(linha.get(0))));
        }
    }

    //adiciona a uma lista os ratings de um mesmo id.
    public void addRating(String item, double rating) {
        myRatings.put(item, new Rating(rating));
    }

    public boolean hasRating(String item) {
        //myRatings.get(item);
        return false;
    }

    public String getID() {
        return myID;
    }

    public double getRating(String item) {
        // implement
        return -1;
    }

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        List<String> list = new ArrayList<>(myRatings.values()).stream().map(Objects::toString).collect(Collectors.toList());
        return (ArrayList<String>) list;
    }
}
