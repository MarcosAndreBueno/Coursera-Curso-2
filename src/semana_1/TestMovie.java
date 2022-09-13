package semana_1;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;

public class TestMovie {
    private ArrayList<Movie> movieList;
    private int count = 0;
    private MultiplosDados md = new MultiplosDados();
    private CSVParser linhas;
    private FileResource fr;
    public TestMovie(String movieFile) {
        this.fr = new FileResource(movieFile);
        this.linhas = fr.getCSVParser();
        this.movieList = new ArrayList<Movie>();
    }

    public ArrayList<Movie> setMovieList() {
        String id = "";
        String title = "";
        String year = "";
        String country = "";
        String genre = "";
        String director = "";
        int minutes = 0;
        String poster = "";

        for (CSVRecord linha : linhas) {
            id = linha.get(0);
            title = linha.get(1);
            year = linha.get(2);
            country = linha.get(3);
            genre = linha.get(4);
            director = linha.get(5);
            minutes = Integer.parseInt(linha.get(6));
            poster = linha.get(7);

            //salvar em lista
            this.movieList.add(new Movie(id, title, year, country, genre, director, minutes, poster));
            this.count += 1;
        }
        return this.movieList;
    }

    public void testMovies() {
        //forma 2 de salvar em lista os objetos: trabalhando dados
        for (int i = 0; i < this.movieList.size(); i++) {
            Movie mv = (this.movieList.get(i));

            System.out.println(mv.toString());
        }
        System.out.println("O total de filmes pesquisados foram: " + this.count);
    }

    public void testeComedyGenres() {
        ArrayList<String> generosList = new ArrayList<>();
        int count = 0;
        int qtdGeneros = 0;

        //obter todos os gêneros
        for (int i = 0; i < this.movieList.size(); i++) {
            Movie mv = (this.movieList.get(i));
            String genero = mv.getGenres();
            // conferir se há mais de um gênero na mesma coluna do csv e salvar no array generos.
            generosList = this.md.temVirgula(genero);
            // conta repetições do gênero
            qtdGeneros += countGeneros(generosList);
        }
        System.out.println("A quantidade de filmes de comédia foram: " + qtdGeneros);
        System.out.println("O total de filmes pesquisados foram: " + this.count);
    }

    public int countGeneros(ArrayList<String> generosList) {
        int count = 0;
        //checar se gêneros são iguais a comédia
        for (int i = 0; i < generosList.size(); i++) {
            String genero = generosList.get(i);
            if (genero.equals("Comedy")){
                count += 1;
            }
        }
        return count;
    }

    public void testMovieLength(double tamanho){
        int count = 0;

        for (int i = 0; i < this.movieList.size(); i++) {
            Movie mv = (this.movieList.get(i));
            double length = mv.getMinutes();

            if (length > tamanho) {
                count += 1;
            }
        }
        System.out.println("A quantidade de filmes com duração maior a " + tamanho + " foram " + count);
    }

    public void testMaximumDirectorsInOneMovie() {
        String director;
        ArrayList<String> dirAtLis = new ArrayList<>();
        ArrayList<String> dirFinLis = new ArrayList<>();

        //get array em colunas com mais de um diretor
        for (int i = 0; i < this.movieList.size(); i++) {
            Movie mv = (this.movieList.get(i));
            director = mv.getDirector();
            dirAtLis = this.md.temVirgula(director);

            //salvar cada um dos diretores em um novo array
            for (int j = 0; j < dirAtLis.size(); j++) {
                director = dirAtLis.get(j);
                dirFinLis.add(director);
            }
        }

        //contar diretores que mais aparecem
        int countAt = 0;
        int countFin = 0;
        String directorAt;
        String directorFin = "";
        for (int i = 0; i < dirFinLis.size(); i++) {
            directorAt = dirFinLis.get(i);
            countAt = countDirector(directorAt, dirFinLis);
            if (countAt > countFin){
                countFin = countAt;
                directorFin = directorAt;
            }
        }

        //print diretores que mais aparecem
        System.out.println("Diretor que mais apareceu foi "+directorFin+" apareceu "+countFin);
    }

    public int countDirector(String directorAt, ArrayList<String> dirFin){
        int count = 0;
        String directorAnt;
        for (int i = 0; i < dirFin.size(); i++) {
            directorAnt = dirFin.get(i);
            if (directorAt.equals(directorAnt)){
                count += 1;
            }
        }
        return count;
    }

    public String testGetMovieById(String movID){
        String movie = "";
        for (int i = 0; i < this.movieList.size(); i++) {
            if (this.movieList.get(i).getID().equals(movID)){
                movie = this.movieList.get(i).getTitle();
                return movie;
            }
        }
        return movie;
    }

    public String testGetIdByMovie(String movName){
        String movieID = "";
        for (int i = 0; i < this.movieList.size(); i++) {
            if (this.movieList.get(i).getTitle().equals(movName)){
                movieID = this.movieList.get(i).getTitle();
                return movieID;
            }
        }
        return movieID;
    }
}