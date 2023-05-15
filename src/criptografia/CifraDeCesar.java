package criptografia;

public class CifraDeCesar {

    private static final String ALFABETO = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALFABETO_ENCRIPTADO = "defghijklmnopqrstuvwxyzabc";

    public String cifraDeCesarTradicional(String mensagem) {
        mensagem = mensagem.toLowerCase();
        StringBuilder mensagemEncriptada = new StringBuilder();

        for(int i = 0; i < mensagem.length(); i++) {
            char charNaoEncriptado = mensagem.charAt(i);

            int posicao = ALFABETO.indexOf(charNaoEncriptado);

            if(posicao != -1) {
                char charEncriptado = ALFABETO_ENCRIPTADO.charAt(posicao);
                mensagemEncriptada.append(charEncriptado);
            } else {
                mensagemEncriptada.append(charNaoEncriptado);
            }
        }

        return mensagemEncriptada.toString();
    }

    public String decifraCesarTradicional(String mensagemEncriptada) {
        mensagemEncriptada = mensagemEncriptada.toLowerCase();
        StringBuilder mensagemDecriptada = new StringBuilder();

        for(int i = 0; i < mensagemEncriptada.length(); i++) {
            char charEncriptado = mensagemEncriptada.charAt(i);

            int posicao = ALFABETO_ENCRIPTADO.indexOf(charEncriptado);

            if(posicao != -1) {
                char charDecriptado = ALFABETO.charAt(posicao);
                mensagemDecriptada.append(charDecriptado);
            } else {
                mensagemDecriptada.append(charEncriptado);
            }
        }

        return mensagemDecriptada.toString();
    }

    public String cifraDeCesarLivre(String mensagem, int variacao) {
        mensagem = mensagem.toLowerCase();
        StringBuilder mensagemEncriptada = new StringBuilder();

        for(int i = 0; i < mensagem.length(); i++) {
            char charNaoEncriptado = mensagem.charAt(i);

            int posicao = ALFABETO.indexOf(charNaoEncriptado);

            if(posicao != -1) {
                int novaPosicao = (posicao + variacao)%26;
                char charEncriptado = ALFABETO.charAt(novaPosicao);
                mensagemEncriptada.append(charEncriptado);
            } else {
                mensagemEncriptada.append(charNaoEncriptado);
            }
        }
        return mensagemEncriptada.toString();
    }

    public String decifraCesarLivre(String mensagemEncriptada, int variacao) {
        mensagemEncriptada = mensagemEncriptada.toLowerCase();
        StringBuilder mensagemDecriptada = new StringBuilder();

        int variacaoContraria = 26 - variacao;
        for(int i = 0; i < mensagemEncriptada.length(); i++) {
            char charNaoEncriptado = mensagemEncriptada.charAt(i);

            int posicao = ALFABETO.indexOf(charNaoEncriptado);

            if(posicao != -1) {
                int novaPosicao = (posicao + variacaoContraria)%26;
                char charEncriptado = ALFABETO.charAt(novaPosicao);
                mensagemDecriptada.append(charEncriptado);
            } else {
                mensagemDecriptada.append(charNaoEncriptado);
            }
        }
        return mensagemDecriptada.toString();
    }

    public static void main(String[] args) {

        CifraDeCesar cdc = new CifraDeCesar();

        String fraseEncriptada = cdc.cifraDeCesarTradicional("Ola a todos que estao vendo esta mensagem!");
        System.out.println(fraseEncriptada);
        String fraseDecriptada = cdc.decifraCesarTradicional(fraseEncriptada);
        System.out.println(fraseDecriptada);

        System.out.println("------------------------------------------------------");

        String fraseEncriptadaLivre = cdc.cifraDeCesarLivre("Ola a todos que estao vendo esta mensagem!", 4);
        System.out.println(fraseEncriptadaLivre);
        String fraseDecriptadaLivre = cdc.decifraCesarLivre(fraseEncriptadaLivre, 4);
        System.out.println(fraseDecriptadaLivre);
    }
}
