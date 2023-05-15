package bob;

public class BobClass {

    public int BobCount(String bobFrase) {
        int contador = 0;
        if (bobFrase == null || bobFrase.length() < 3) {
            return contador;
        }

        bobFrase = bobFrase.toLowerCase();

        for (int i = 0; i < bobFrase.length() - 2; i ++) {
            String possivelBob = bobFrase.substring(i, i + 3);
//            System.out.println(possivelBob);
            if(possivelBob.equals("bob")) {
                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        BobClass bobClass = new BobClass();

        System.out.println(bobClass.BobCount(null));
        System.out.println(bobClass.BobCount("bobob, ola, eu sou o Bob, meu amigo, aqui não tem bo"));
    }
}
