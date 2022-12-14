package semana_3.refatorar_semana2;
import semana_3.refatorar_semana2.Rating;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestRating {

    private ArrayList<PlainRater> raterList = new ArrayList<>();
    private ArrayList<Rating> ratingList = new ArrayList<>();
    private Map<PlainRater, Rating> myRaters = new HashMap<>();

    private CSVParser linhas;
    private FileResource fr;
    EfficientRater er;

    public TestRating(FileResource fr){
        this.linhas = fr.getCSVParser();
        this.fr = fr;
        er.setRatingList(linhas);
    }

    public void testAllRaterRatings() {
        String rater_act;
        String rater_ant = null;

        for (PlainRater n : this.raterList) {
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

        for (PlainRater n : this.raterList) {
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

        for (PlainRater n : this.raterList) {
            //pegar id
            act_rater = n.getID();

            //contar ratings, continuar da posi????o do ??ltimo id contado
            if (!numeros.contains(Integer.parseInt(act_rater))){
                rept = countRepeticoes(act_rater, count);
                //salvar id num array para evitar loops desnecess??rios
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

//    public void testSpecificMovieRates(String movId){
//        int count = 0;
//        //ver se rater atual ?? igual id filme
//        for (Rating n : this.ratingList) {
//            if (n.getItem().equals(movId)){
//                count += 1;
//            }
//        }
//        //print
//        System.out.printf("N??mero de vezes que o filme de id %s foi avaliado foram %d"
//                , movId, count);
//    }

//    public void testMoviesRated(){
//        String mov_id = "";
//        String mov_ant = "";
//        ArrayList<String> movList = new ArrayList<>();
//        ArrayList<Integer> movRept = new ArrayList<>();
//        int rept = 0;
//
//        for (Rating n : this.ratingList) {
//            //pegar id do filme
//            mov_id = n.getItem();
//
//            if (!movList.contains(mov_id)){
//                movList.add(mov_id);
//                //contar quantas vezes apareceu
//                rept = countIDRepeticoes(mov_id);
//                movRept.add(rept);
//            }
//            rept = 0;
//        }
//        //print
//        System.out.println("A quantidade de repti????es para cada filme foram: ");
//        for (int i = 0; i < movList.size(); i++){
//            System.out.printf("Filme: %s  | qtd de ratings: %d \n", movList.get(i), movRept.get(i));
//        }
//    }

//    public int countIDRepeticoes(String mov_id) {
//        int count = 0;
//        for (Rating n : this.ratingList) {
//            if (n.getItem().equals(mov_id)) {
//                count += 1;
//            }
//        }
//        return count;
//    }
}
