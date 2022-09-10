package semana_1;

import java.util.ArrayList;

//confere se o CSV possui mais de um valor na mesma coluna que estão separados por vírgulas.
public class MultiplosDados {
    public ArrayList<String> temVirgula(String dados) {
        int startIndex = 0;
        ArrayList<String> dadosArrayCorrigido = new ArrayList<>();

        for(int i = 0; i < dados.length(); ++i) {
            if (!dados.contains(",")) {
                dadosArrayCorrigido.add(dados);
                return dadosArrayCorrigido;
            }

            if (dados.substring(i, i + 1).equals(",") && !dadosArrayCorrigido.contains(dados.substring(startIndex, i))) {
                dadosArrayCorrigido.add(dados.substring(startIndex, i));
                startIndex = i + 2;
                if (!dados.substring(startIndex).contains(",") && !dadosArrayCorrigido.contains(dados.substring(startIndex, dados.length()))) {
                    dadosArrayCorrigido.add(dados.substring(startIndex));
                    break;
                }
            }
        }

        return dadosArrayCorrigido;
    }
}

