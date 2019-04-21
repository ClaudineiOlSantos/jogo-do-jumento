package jumento.oh;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claudinei
 */
public class Jumento {

    private String nome;

    private double defesa;
    private int idade;
    private double vida = 10000;
    private final List<Ataque> ataques = new ArrayList<>();//Lista de ataques

    public Jumento(String nome, int idade, double ataque, double defesa) {
        this.nome = nome;

        this.setIdade(idade);
        this.setDefesa(defesa);

        this.configAtaques(ataque);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDefesa() {
        return defesa;
    }

    /**
     * Após 10 anos de idade o jumento perde 30% de defesa por ano exedente.
     *
     * @param defesa
     */
    public void setDefesa(double defesa) {
        if (defesa > 0) {
            this.defesa = defesa;
        }
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return this.idade;
    }

    public double getVida() {
        return vida;
    }

    /**
     * A força do ataque é um número randomico que vai da defesa até a força do ataque recebido
     * @param ataque Força do do ataque
     */
    public void setAtaque(double ataque) {        
        double forcaAtaque = this.defesa + (Math.random() * (ataque + 1));
        this.vida -= (forcaAtaque > this.defesa ? forcaAtaque - this.defesa : 0);
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    @Override
    public String toString() {
        String txt = "\n\nnome=" + nome
                + "\ndefesa=" + defesa
                + "\nidade=" + idade
                + "\nvida=" + vida
                + "\n\nAtaques:";

        for (Ataque ataque : this.ataques) {
            txt += "\n" + ataque.getNome();
            txt += ", força = " + ataque.getForca();
        }

        return txt;
    }

    private void configAtaques(double ataqueBase) {
        this.ataques.add(new Ataque("Coice maldito", ataqueBase));
        this.ataques.add(new Ataque("Relinchada violenta", ataqueBase * 1.2));//O ataque 2 tem 20% a mais de força

        /**
         * Após 10 anos o jumento perde 30% de defesa
         */
        if (this.idade > 10) {
            this.defesa = this.defesa * 0.7;
        }
    }

}
