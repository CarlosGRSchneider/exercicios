package musica;

import java.util.List;

public class MusicaMain {

    public static void main(String[] args) throws InterruptedException {


        List<Faixa> faixas = List.of(new Faixa("A lenda", "Sandy e Junior", 272),
                new Faixa("As quatro estações", "Sandy e Junior", 248),
                new Faixa("Era uma vez", "Sandy e Junior", 193),
                new Faixa("Vamo pula!", "Sandy e Junior", 271),
                new Faixa("Imortal", "Sandy e Junior", 256),
                new Faixa("Dig-dig-joy", "Sandy e Junior", 200),
                new Faixa("Quando você passa(turu turu)", "Sandy e Junior", 220),
                new Faixa("Maria Chiquinha", "Sandy e Junior", 234),
                new Faixa("Desperdiçou", "Sandy e Junior", 216),
                new Faixa("A arte do coração", "Sandy e Junior", 278),
                new Faixa("Enter Sandman", "Metallica", 331),
                new Faixa("Fear of the dark", "Iron Maiden", 439),
                new Faixa("Black widow's web", "Angra", 369),
                new Faixa("Stairway to heaven", "Led Zeppelin", 483),
                new Faixa("Immigrant song", "Led Zeppelin", 147),
                new Faixa("Highway to hell", "AC/DC", 209));

        Playlist playlist = new Playlist(faixas);

        for (int i = 0; i < 20; i++) {
            playlist.tocaMusicaAleatoria();
            Thread.sleep(2000);
            System.out.println();
        }

    }
}
