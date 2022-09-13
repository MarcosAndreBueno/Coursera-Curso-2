package semana_1;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestRating {
    private ArrayList<Rater> raterList = new ArrayList<>();
    private ArrayList<Rating> ratingList = new ArrayList<>();
    private Map<Rater, Rating> myRaters = new HashMap<>();
    private int count = 0;
    private CSVParser linhas;
    private FileResource fr;
    public TestRating(String ratingFile){
        this.fr = new FileResource(ratingFile);;
        this.linhas = fr.getCSVParser();
    }

    public Map<Rater, Rating> setRatingList() {
        String rater_id = "";
        String movie_id = "";
        double rating = 0.0;
        String time = "";
        String rater_at = "";

        for (CSVRecord linha : linhas) {
            //dados dos raters
            rater_id = linha.get(0);
            movie_id = linha.get(1);
            rating = Double.parseDouble(linha.get(2));
            time = linha.get(3);

            //criar objetos Rater com os dados extraídos
            Rater rt = new Rater(rater_id);
            rt.addRating(rater_id, rating);

            //criar objetos Rating com os dados extraídos
            Rating rtg = new Rating(movie_id, rating);

            //salvar objetos em lista
            this.raterList.add(rt);
            this.ratingList.add(rtg);
            this.count += 1;

            //HashMap para usar na semana 2
            this.myRaters.put(rt, rtg);
        }
        return this.myRaters;
    }

    public void testAllRaterRatings() {
        String rater_act;
        String rater_ant = null;

        for (Rater n : this.raterList) {
            rater_act = n.getID();

            //se id atual diferente id anterior print rater id em outra linha
            if ((!rater_act.equals(rater_ant)) || (rater_ant == null)) {
                System.out.printf("\nRater id : %s | rating: ", rater_act);
            }
            //print rating do id atual
            System.out.printf("%4s, ", n.getRating(rater_act));

            rater_ant = rater_act;
        }
    }

    public void testSpecifRaterRatings(String rater_inp) {
        String rater_act = null;
        int count = 1;

        for (Rater n : this.raterList) {
            rater_act = n.getID();
            //print enquanto id for igual
            if ((rater_act.equals(rater_inp)) || ((rater_act == null))) {
                System.out.printf("\n%2do: | rating: %s ", count, n.getRating(rater_act));
                count += 1;
            }
        }
    }

    public void testMaximumRatingByRaters(){
        String act_rater;
        String actFin = "";
        ArrayList<Integer> numeros = new ArrayList<>();
        int count = 0;
        int rept = 0;
        int reptFin = 0;

        for (Rater n : this.raterList) {
            //pegar id
            act_rater = n.getID();

            //contar ratings, continuar da posição do último id contado
            if (!numeros.contains(Integer.parseInt(act_rater))){
                rept = countRepeticoes(act_rater, count);
                //salvar id num array para evitar loops desnecessários
                numeros.add(Integer.parseInt(act_rater));
            }

            //verificar se maior que o rating final
            if (rept > reptFin){
                reptFin = rept;
                actFin = act_rater;
            }
        }
        //print
        System.out.printf("O id que mais apareceu foi o %s, ele apareceu: %d vezes", actFin, reptFin);
    }
    public int countRepeticoes(String act_rater, int count){
        for (Rater n : this.raterList) {
            if (n.getID().equals(act_rater)){
                count += 1;
            }
        }
        return count;
    }

    public void testSpecificMovieRates(String movId){
        int count = 0;
        //ver se rater atual é igual id filme
        for (Rating n : this.ratingList) {
            if (n.getItem().equals(movId)){
                count += 1;
            }
        }
        //print
        System.out.printf("Número de vezes que o filme de id %s foi avaliado foram %d"
                , movId, count);
    }

    public void testMoviesRated(){
        String mov_id = "";
        String mov_ant = "";
        ArrayList<String> movList = new ArrayList<>();
        ArrayList<Integer> movRept = new ArrayList<>();
        int rept = 0;

        for (Rating n : this.ratingList) {
            //pegar id do filme
            mov_id = n.getItem();

            if (!movList.contains(mov_id)){
                movList.add(mov_id);
                //contar quantas vezes apareceu
                rept = countIDRepeticoes(mov_id);
                movRept.add(rept);
            }
            rept = 0;
        }
        //print
        System.out.println("A quantidade de reptições para cada filme foram: ");
        for (int i = 0; i < movList.size(); i++){
            System.out.printf("Filme: %s  | qtd de ratings: %d \n", movList.get(i), movRept.get(i));
        }
    }

    public int countIDRepeticoes(String mov_id) {
        int count = 0;
        for (Rating n : this.ratingList) {
            if (n.getItem().equals(mov_id)) {
                count += 1;
            }
        }
        return count;
    }
}
