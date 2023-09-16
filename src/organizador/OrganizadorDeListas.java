package organizador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizadorDeListas {

    public static Map<String, Integer> organizaLista(List<String> musicas) {

        Map<String, Integer> result = new HashMap<>();

        for (String musica : musicas) {

            if (result.containsKey(musica)) {
                int contagemAgual = result.get(musica);
                result.replace(musica, contagemAgual + 1);
            } else {
                result.put(musica, 1);
            }
        }

        return result;
    }

    public static Map<String, Integer> organizaListaComMerge(List<String> musicas) {

        Map<String, Integer> result = new HashMap<>();

        for (String musica : musicas) {
            result.merge(musica, 1, Integer::sum);
        }
        return result;
    }

    public static void main(String[] args) {

        List<String> musicasInformadas = List.of("Livin' on a prayer", "Livin' on a prayer", "Enter Sandman", "Cherry bomb", "Thunderstruck", "Livin' on a prayer", "Thunderstruck", "Enter Sandman", "Livin' on a prayer", "Thunderstruck", "Stairway to Heaven", "Enter Sandman");

        Map<String, Integer> nomesOrganizados = OrganizadorDeListas.organizaLista(musicasInformadas);

        System.out.println("Organização de listas sem o merge");
        for(Map.Entry<String, Integer> nome : nomesOrganizados.entrySet()) {
            System.out.println("Nome: " + nome.getKey() + " | Quantidade: " + nome.getValue());
        }

        System.out.println("--------------------------------------");

        System.out.println("Organização de listas com o merge");
        Map<String, Integer> nomesOrganizadosMerge = OrganizadorDeListas.organizaListaComMerge(musicasInformadas);

        for(Map.Entry<String, Integer> nome : nomesOrganizadosMerge.entrySet()) {
            System.out.println("Nome: " + nome.getKey() + " | Quantidade: " + nome.getValue());
        }
    }
}