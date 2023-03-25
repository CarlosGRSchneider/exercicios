package matematica;

public class MultiplicacaoEDivisao {

    public int multiplicacao(int x, int y) {
        if(y == 0 ) {
            return 0;
        }
        int resultado = x;
        return x + multiplicacao(x, y - 1);
    }

    public int multiplicacaoIterativa(int x, int y) {
        if(y == 0) {
            return 0;
        }

        int resultado = 0;
        while(y > 0) {
            resultado+=x;
            y--;
        }

        return resultado;
    }

    public int divisao(int x, int y) {

        if( y == 0) {
            throw new ArithmeticException("não é possivel realizar divisão por 0");
        }

        if(x < y) {
            System.out.println("Resto = " + x);
            return x;
        }

        return 1 + divisao(x - y, y);
    }

    public int divisaoIterativa(int x, int y) {

        if( y == 0) {
            throw new ArithmeticException("não é possivel realizar divisão por 0");
        }

        int resultado = 0;
        while(x >= y) {
            resultado++;
            x -= y;
        }
        System.out.println("Resto = " + x);
        return resultado;
    }


    public static void main(String[] args) {
        MultiplicacaoEDivisao mEd = new MultiplicacaoEDivisao();

        System.out.println(mEd.multiplicacao(8, 4));
        System.out.println(mEd.multiplicacaoIterativa(8, 4));

        System.out.println(mEd.divisao(32, 4));
        System.out.println(mEd.divisaoIterativa(35, 4));
    }
}
