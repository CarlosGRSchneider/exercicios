package nome;

public class ContadorDeNome {

    public void contaNomeRuim() {

        System.out.println("Carlos Guilherme");
        System.out.println("Carlos Guilherme");
        System.out.println("Carlos Guilherme");
        // mais 997 vezes esse print
        System.out.println("Carlos Guilherme");
    }

    public void contaNomeRecursivo() {
        imprimeNomeRecursivo("Carlos Guilherme", 1000);
    }

    private void imprimeNomeRecursivo(String nome, int totalDeVoltas) {
        if (totalDeVoltas == 0) {
            return;
        }
        System.out.println(nome);
        imprimeNomeRecursivo(nome, totalDeVoltas - 1);
    }

    public void contaNomeRespostaJava() {

        String nome = "XXXXXXXXXX";
        nome = nome.replace("X", "XXXXXXXXXX");
        nome = nome.replace("X", "XXXXXXXXXX");
        nome = nome.replace("X", "Carlos Guilherme \n");
        System.out.println(nome);
    }

    public static void main(String[] args) {
        ContadorDeNome contador = new ContadorDeNome();

//      contador.contaNomeRuim();
//      contador.contaNomeRecursivo();
//      contador.contaNomeRespostaJava();
    }

}
