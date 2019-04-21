/*
 *Joguinho do Jumento
 */
package jumento.oh;

/**
 *
 * @author claudinei
 */
public class JumentoOh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Duelo duelo = new Duelo(new Jumento("Jumento Celestino", 8, 1000, 500),
                new Jumento("Jumento Bengala", 12, 1000, 500));

        System.out.println(duelo.apresentacaoJogadores());
        System.out.println(duelo.iniciaDuelo());

        System.out.println(duelo.apresentacaoJogadores());

    }

}
