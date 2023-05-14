package model;

public class Jogador {
	
    private String nome;
    private int placar;

    public Jogador(String nome){
        setNome(nome);
        setPlacar(0);
    }

    public String getNome(){
        return nome;
    }

    public int getPlacar(){
        return placar;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setPlacar(int placar){
        this.placar = placar;
    }
}
