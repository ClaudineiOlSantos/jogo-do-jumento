package jumento.oh;

/**
 *
 * @author claudinei
 */
public class Ataque {

    private String nome;
    private double forca;

    public Ataque(String nome, double forca) {
        this.nome = nome;
        this.setForca(forca);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getForca() {
        return forca;
    }

    public void setForca(double forca) {
        if (forca > 0) {
            this.forca = forca;
        }
    }

}
