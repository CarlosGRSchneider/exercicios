package criptografia;

public class CifraDeVignere {

    private static final String ALFABETO = "abcdefghijklmnopqrstuvwxyz";

    public String cifraDeVignere(String mensagem, String chaveCriptografica) {
        StringBuilder mensagemEncriptada = new StringBuilder();

        int indiceChave = 0;
        for (int i = 0; i < mensagem.length(); i++) {

            char charNaoEncriptado = mensagem.charAt(i);
            boolean caixaAlta = Character.isUpperCase(charNaoEncriptado);
            charNaoEncriptado = Character.toLowerCase(charNaoEncriptado);
            int posicao = ALFABETO.indexOf(charNaoEncriptado);

            if (posicao != -1) {
                char chaveDeEncriptacao = chaveCriptografica.charAt(indiceChave % chaveCriptografica.length());
                int posicaoDeEncriptacao = ALFABETO.indexOf(chaveDeEncriptacao);
                int indiceDeEncriptacao = (posicao + posicaoDeEncriptacao) % 26;
                char charEncriptado = ALFABETO.charAt(indiceDeEncriptacao);
                mensagemEncriptada.append(decideCaixaAlta(charEncriptado, caixaAlta));
                indiceChave++;
            } else {
                mensagemEncriptada.append(charNaoEncriptado);
            }
        }
        return mensagemEncriptada.toString();
    }

    public String decifraVignere(String mensagem, String chaveCriptografica) {
        StringBuilder mensagemEncriptada = new StringBuilder();

        int indiceChave = 0;
        for (int i = 0; i < mensagem.length(); i++) {

            char charEncriptado = mensagem.charAt(i);
            boolean caixaAlta = Character.isUpperCase(charEncriptado);
            charEncriptado = Character.toLowerCase(charEncriptado);
            int posicao = ALFABETO.indexOf(charEncriptado);

            if (posicao != -1) {
                char chaveDeEncriptacao = chaveCriptografica.charAt(indiceChave % chaveCriptografica.length());
                int posicaoDeEncriptacao = ALFABETO.indexOf(chaveDeEncriptacao);
                int indiceDeEncriptacao = (posicao - posicaoDeEncriptacao + 26) % 26;
                char charDecriptado = ALFABETO.charAt(indiceDeEncriptacao);
                mensagemEncriptada.append(decideCaixaAlta(charDecriptado, caixaAlta));
                indiceChave++;
            } else {
                mensagemEncriptada.append(charEncriptado);
            }
        }
        return mensagemEncriptada.toString();
    }

    private char decideCaixaAlta(char charEncriptado, boolean caixaAlta) {

        if (caixaAlta) {
            return Character.toUpperCase(charEncriptado);
        }
        return charEncriptado;
    }

    public static void main(String[] args) {
        CifraDeVignere cdv = new CifraDeVignere();
        String chaveCriptografica = "otorrinolaringologista";

        String fraseEncriptada = cdv.cifraDeVignere("Ola meus caros amigos, essa e a cifra de Vignere. Nesse tipo de cifra, a repeticao de letras nao e tao evidente quanto no caso da cifra de cesar, o que torna a decodificacao muito mais complexa.", chaveCriptografica);
        System.out.println(fraseEncriptada);
        String fraseDecriptada = cdv.decifraVignere(fraseEncriptada, chaveCriptografica );
        System.out.println(fraseDecriptada);
    }
}
