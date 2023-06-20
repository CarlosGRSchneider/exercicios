package organizador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizadorDeListas {

    public static Map<String, Integer> organizaLista(List<String> nomes) {

        Map<String, Integer> result = new HashMap<>();

        for (String nome : nomes) {

            if (result.containsKey(nome)) {
                int contagemAgual = result.get(nome);
                result.replace(nome, contagemAgual + 1);
            } else {
                result.put(nome, 1);
            }
        }

        return result;
    }

    public static Map<String, Integer> organizaListaComMerge(List<String> nomes) {

        Map<String, Integer> result = new HashMap<>();

        for (String nome : nomes) {
            result.merge(nome, 1, Integer::sum);
        }
        return result;
    }

    public static void main(String[] args) {

        List<String> nomesInformados = List.of("Livin' on a prayer", "Livin' on a prayer", "Enter Sandman", "Cherry bomb", "Thunderstruck", "Livin' on a prayer", "Thunderstruck", "Enter Sandman", "Livin' on a prayer", "Thunderstruck", "Stairway to Heaven", "Enter Sandman");

        Map<String, Integer> nomesOrganizados = OrganizadorDeListas.organizaLista(nomesInformados);

        for(Map.Entry<String, Integer> nome : nomesOrganizados.entrySet()) {
            System.out.println("Nome: " + nome.getKey() + " | Quantidade: " + nome.getValue());
        }

        System.out.println("--------------------------------------");
        Map<String, Integer> nomesOrganizadosMerge = OrganizadorDeListas.organizaListaComMerge(nomesInformados);

        for(Map.Entry<String, Integer> nome : nomesOrganizadosMerge.entrySet()) {
            System.out.println("Nome: " + nome.getKey() + " | Quantidade: " + nome.getValue());
        }
    }
}