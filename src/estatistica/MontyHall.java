package estatistica;

import java.text.DecimalFormat;
import java.util.Random;

public class MontyHall {

    private static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {

        double estrategiaDeManterAPorta = 0;
        double estrategiaDeTrocarAPorta = 0;

        Random random = new Random();

        for(int i = 0; i < 100000; i++) {

            //gerar portas e atribuir uma porta como vencedora
            int[] portas = {0, 0, 0};
            portas[random.nextInt(3)] = 1;

            // o jogador escolhe uma porta e o apresentador abre uma porta sem premio
            int portaEscolhidaPeloJogador = random.nextInt(3);
            int portaAbertaPeloApresentador = random.nextInt(3);

            // se a porta do apresentador for a mesma do jogador, ou for a porta premiada, nós trocamos ela por uma porta vazia
            while(portaEscolhidaPeloJogador == portaAbertaPeloApresentador || portas[portaAbertaPeloApresentador] == 1) {
                portaAbertaPeloApresentador = random.nextInt(3);
            }

            // agora as portas do jogador e do apresentador serão abertas
            // caso a porta tenha premio, ele marca 1 para a estratégia de manter a porta.
            // caso o premio está na porta não escolhida, ele marca 1 para a estratégia trocar a porta.
            estrategiaDeManterAPorta += portas[portaEscolhidaPeloJogador];
            estrategiaDeTrocarAPorta +=portas[3 - portaAbertaPeloApresentador - portaEscolhidaPeloJogador];

        }

        System.out.println("Taxa de vitorias para a estratégia de manter a porta: " + df.format((estrategiaDeManterAPorta/100000) * 100).concat("%"));
        System.out.println("taxa de vitorias para a estratégia de trocar a porta: " + df.format((estrategiaDeTrocarAPorta/100000) * 100).concat("%"));

    }
}
