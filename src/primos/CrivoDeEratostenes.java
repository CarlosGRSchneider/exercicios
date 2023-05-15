package primos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CrivoDeEratostenes {

    public List<Integer> geraCrivoDeEratostenes(int tamanhoMaximo) {

        List<Integer> listaDeInteiros = new ArrayList<>();
        IntStream.rangeClosed(1, tamanhoMaximo).forEach(listaDeInteiros::add);
//        Essa linha acima faz a mesma coisa que esse bloco de codigo
//        for(int i = 1; i <= tamanhoMaximo; i++) {
//            listaDeInteiros.add(i);
//        }

        int limite = (int) Math.sqrt(tamanhoMaximo) + 1;
        for(int i = 2; i < tamanhoMaximo; i++) {
            for(int j = i * i; j <= tamanhoMaximo; j+=i) {
                listaDeInteiros.remove(Integer.valueOf(j));
            }
        }
    return listaDeInteiros;
    }

    public static void main(String[] args) {
        CrivoDeEratostenes crivo = new CrivoDeEratostenes();

        List<Integer> primosAteCem = crivo.geraCrivoDeEratostenes(50);
        primosAteCem.stream().forEach(System.out::println);
    }
}
