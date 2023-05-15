package primos;

public class NumerosPrimos {

    public boolean avaliaSeNumeroEhPrimo(int numero) {

        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean avaliaSeNumeroEhPrimoRefatorado(int numero) {

        if (numero <= 2) {
            return true;
        }
        if (numero % 2 == 0) {
            return false;
        }

        int limitePrimo = (int) Math.sqrt(numero) + 1;
        for (int i = 3; i < limitePrimo; i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean avaliaSeNumeroEhPrimoRecursivo(int numero) {
        return avaliaPrimoRecursivo(numero, 2);
    }

    private boolean avaliaPrimoRecursivo(int numero, int divisor) {
        if (numero <= 2) {
            return true;
        }
        if (numero % 2 == 0) {
            return false;
        }

        if (numero % divisor == 0) {
            return false;
        }

        if (divisor * divisor > numero) {
            return true;
        }

        return avaliaPrimoRecursivo(numero, divisor + 2);
    }


    public static void main(String[] args) {
        NumerosPrimos nup = new NumerosPrimos();

        System.out.println("Avaliação de numero primo simples");
        System.out.print("Para o caso de 1.000.000: ");
        System.out.println(nup.avaliaSeNumeroEhPrimo(1000000));
        System.out.print("Para o caso de 1.000.003: ");
        System.out.println(nup.avaliaSeNumeroEhPrimo(1000003));
        System.out.println("------------------------------------");
        System.out.println("Avaliação de numero primo refatorado");
        System.out.print("Para o caso de 1.000.000: ");
        System.out.println(nup.avaliaSeNumeroEhPrimoRefatorado(1000000));
        System.out.print("Para o caso de 1.000.003: ");
        System.out.println(nup.avaliaSeNumeroEhPrimoRefatorado(1000003));
        System.out.println("------------------------------------");
        System.out.println("Avaliação de numero primo recursivo");
        System.out.print("Para o caso de 1.000.000: ");
        System.out.println(nup.avaliaSeNumeroEhPrimoRecursivo(1000000));
        System.out.print("Para o caso de 1.000.003: ");
        System.out.println(nup.avaliaSeNumeroEhPrimoRecursivo(1000003));
        System.out.println("------------------------------------");
    }
}
