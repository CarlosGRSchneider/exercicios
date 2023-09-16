package musica;

import java.util.*;

public class Playlist {

    private List<Faixa> faixasDaPlayList = new ArrayList<>();

    private List<Faixa> faixasAleatoriasTocadas = new ArrayList<>();
    private Random random = new Random();

    public Playlist() {
    }

    public Playlist(List<Faixa> faixasDaPlayList) {
        this.faixasDaPlayList = faixasDaPlayList;
    }

    public void adicionaNaPlayList(Faixa faixa) {
        faixasDaPlayList.add(faixa);
    }

    public void tocaMusicaAleatoria() {
        if (faixasDaPlayList.size() < 11) {
            throw new IllegalArgumentException("Não há musicas suficientes na playlist para função aleatoria!");
        }
        if (faixasDaPlayList.size() < 15) {
            tocaMusicaAleatoriaSimples();
        } else {
            tocaMusicaAleatoriaBalanceada();
        }
    }

    private void tocaMusicaAleatoriaSimples() {

        Faixa faixa = faixasDaPlayList.get(random.nextInt(faixasDaPlayList.size()));
        while (faixasAleatoriasTocadas.contains(faixa)) {
            faixa = faixasDaPlayList.get(random.nextInt(faixasDaPlayList.size()));
        }
        System.out.println("Tocando " + faixa.getTitulo() + " - " + faixa.getAutor());
        atualizaListaAleatoria(faixa);

    }

        private void tocaMusicaAleatoriaBalanceada() {

            Faixa faixa = faixasDaPlayList.get(random.nextInt(faixasDaPlayList.size()));
            while (faixasAleatoriasTocadas.contains(faixa) || !analiseBalanceada(faixa)) {
                faixa = faixasDaPlayList.get(random.nextInt(faixasDaPlayList.size()));
            }

            System.out.println("Tocando " + faixa.getTitulo() + " - " + faixa.getAutor());
            atualizaListaAleatoria(faixa);
        }


    private void atualizaListaAleatoria(Faixa faixa) {
        faixasAleatoriasTocadas.add(faixa);
        if (faixasAleatoriasTocadas.size() > 10) {
            faixasAleatoriasTocadas.remove(0);
        }
    }

    private boolean analiseBalanceada(Faixa possivelFaixa) {
        Set<String> autores = new HashSet<>();

        faixasDaPlayList.stream().forEach(faixa -> autores.add(faixa.getAutor()));
//        for(Faixa faixa : faixasDaPlayList) {
//            autores.add(faixa.getAutor());
//        }

        int maximoDeFaixas = calculaNumeroMaximoDeFaixas(autores.size());
        long totalDoAutor = faixasAleatoriasTocadas.stream().filter(faixa -> faixa.getAutor().equals(possivelFaixa.getAutor())).count();
//        int totalDoAutor = 0;
//        for(Faixa faixa : faixasAleatoriasTocadas) {
//            if(faixa.getAutor().equals(possivelFaixa.getAutor())) {
//                totalDoAutor++;
//            }
//        }

        return totalDoAutor < maximoDeFaixas;
    }

    private int calculaNumeroMaximoDeFaixas(int numeroDeAutores) {

        switch (numeroDeAutores) {
            case 1:
                return 10;
            case 2:
                return 9;
            case 3:
                return 8;
            case 4:
                return 7;
            case 5:
                return 6;
            case 6:
                return 5;
            case 7:
                return 4;
            case 8:
                return 3;
            case 9:
                return 2;
            default:
                return 1;
        }
    }
}
