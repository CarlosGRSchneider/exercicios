package recursividade;

public class AlgoritmosRecursivos {

    public long fatorial(int num) {
//        condição clara de saída
        if (num == 1) {
            return 1;
        }
//        versão simplificada do problema
        return num * fatorial(num - 1);
    }

    public boolean isPalindromoIterativo(String frase) {

        String fraseSemEspaco = frase.replace(" ", "");
        int tamanho = fraseSemEspaco.length();

        for (int i = 0; i < tamanho / 2; i++) {
            if (fraseSemEspaco.charAt(i) != fraseSemEspaco.charAt(tamanho - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindromo(String frase) {
        return verificaPalindromo(frase.replace(" ", ""));
    }

    private boolean verificaPalindromo(String frase) {

        int tamanho = frase.length();
        if (tamanho <= 1) {
            return true;
        }
        if (frase.charAt(0) != frase.charAt(tamanho - 1)) {
            return false;
        }

        return verificaPalindromo(frase.substring(1, tamanho - 1));
    }

    public void iteracaoComFor() {

        for (int i = 0; i < 20; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public void iteracaoRecursiva(int i) {

        if (i < 20) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
            iteracaoRecursiva(++i);
        }
    }

    public void stackOverflow(int i) {

        if (i < 20) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
//            sempre vai dar erro porque i++ é um incremento pós chamada
            stackOverflow(i++);
        }
    }

    public static void main(String[] args) {
        recursividade.AlgoritmosRecursivos algR = new recursividade.AlgoritmosRecursivos();

//        System.out.println(algR.fatorial(5));
//        algR.iteracaoComFor();
//        algR.iteracaoRecursiva(0);
//        algR.stackOverflow(0);
//
//        System.out.println(algR.isPalindromo("abcdeedcba"));
//        System.out.println(algR.isPalindromoIterativo("abcdeedcba"));

    }
}
