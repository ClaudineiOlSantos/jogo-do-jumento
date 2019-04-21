package jumento.oh;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claudinei
 */
public class Duelo {

    private final List<Jumento> Jogadores = new ArrayList<>();
    private int rodadas;
    private Jumento Vencedor;

    public Duelo(Jumento jogador1, Jumento jogador2) {
        this.Jogadores.add(jogador1);
        this.Jogadores.add(jogador2);
    }

    /**
     * Apresenta os jogadores
     *
     * @return String
     */
    public String apresentacaoJogadores() {
        String apresentacao = "";
        for (int c = 0; c < this.Jogadores.size(); c++) {
            apresentacao += "\n\n************************************ player " + (c + 1) + " ************************************";

            apresentacao += "\nPlayer " + (c + 1) + ": " + this.Jogadores.get(c);

        }
        return apresentacao;
    }

    /**
     * Inicia o duelo
     *
     * @return String
     */
    public String iniciaDuelo() {
        //varáveis necessárias
        int playerAtaque;
        this.rodadas = 0;

        String batalha = "";

        //Batalha enquanto os dois tem vida positiva
        while (this.Jogadores.get(0).getVida() > 0 && this.Jogadores.get(1).getVida() > 0) {
            this.rodadas++;//incrementa a rodada

            batalha += ("\n\n************************************ Rodada " + this.rodadas + " ************************************");
            playerAtaque = (int) ((Math.random() * 2));//sorteia o jogador 0 ou 1

            //Verifica de quem é a vez de atacar
            if (playerAtaque == 1) {//player 1 começa
                batalha += playerAtaque(0, 1);
                batalha += playerAtaque(1, 0);

            } else {//player 2 começa
                batalha += playerAtaque(1, 0);
                batalha += playerAtaque(0, 1);
            }
        }
        //verifica quem é o vencedor
        batalha += vencedor();
        return batalha;
    }

    /**
     * Executa um ataque no oponente
     *
     * @param atacante Indice do atacante no arrayList
     * @param defensor Indice do defensor do atacante no arrayList
     * @return
     */
    private String playerAtaque(int atacante, int defensor) {
        int ataque;
        String ataqueResult = "";

        ataque = (int) ((Math.random() * 2));//sorteia o ataque 1 ou 2

        //executa ataque
        this.Jogadores.get(atacante).setAtaque(this.Jogadores.get(atacante).getAtaques().get(ataque).getForca());

        ataqueResult += ("\n\nJogador:" + this.Jogadores.get(atacante).getNome());
        ataqueResult += ("\nPlayer:" + (atacante + 1) + " " + this.Jogadores.get(atacante).getNome() + " ataca: " + this.Jogadores.get(defensor).getNome() + " Com ataque:" + this.Jogadores.get(atacante).getAtaques().get(ataque).getNome());
        ataqueResult += ("\nPlayer:" + (defensor + 1) + " " + this.Jogadores.get(defensor).getNome() + " agora tem " + this.Jogadores.get(defensor).getVida() + " de vida.");
        ataqueResult += ("\n\n-----------------------------------------------------------------------------------");

        return ataqueResult;

    }

    /**
     * Verifica quem é o vencedor
     *
     * @return String
     */
    private String vencedor() {
        String vencedor = "";

        if (this.Jogadores.get(0).getVida() > this.Jogadores.get(1).getVida()) {
            vencedor += ("\n\n\n********************* >>>>>>>>>>>>> CAMPEÃO!! <<<<<<<<<<<<< **********************");
            vencedor += ("\n\n********************* Player " + (1) + ":" + this.Jogadores.get(0).getNome() + " é campeão!! *********************");
            vencedor += ("\n\n-----------------------------------------------------------------------------------");
        } else {
            vencedor += ("\n\n\n********************* >>>>>>>>>>>>> CAMPEÃO!! <<<<<<<<<<<<< **********************");
            vencedor += ("\n\n********************* Player " + (2) + ":" + this.Jogadores.get(1).getNome() + " é campeão!! *********************");
            vencedor += ("\n\n-----------------------------------------------------------------------------------");

        }

        return vencedor;
    }

    /**
     * ************************************************************************
     * **************************GETTERS & SETTERS*****************************
     * ########################################################################
     */
    public int getRodadas() {
        return rodadas;
    }

    public Jumento getVencedor() {
        return Vencedor;
    }

    public void setVencedor(Jumento Vencedor) {
        this.Vencedor = Vencedor;
    }

    public void batalha() {

    }
}
