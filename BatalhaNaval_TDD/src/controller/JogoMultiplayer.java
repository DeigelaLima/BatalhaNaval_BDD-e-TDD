package controller;

import model.Jogador;
import model.Tabuleiro;

public class JogoMultiplayer {
    private Jogador jogador1;
    private Jogador jogador2;
	private Tabuleiro tabuleiro;
	private boolean jogadorDaVez;// false - J1 / true - J2

	public void iniciarJogo() {
		this.tabuleiro = new Tabuleiro();
		this.jogadorDaVez = true;
		
	}

	public void escolherJogador1(String nomeJogador1) {
        Jogador jogador = new Jogador(nomeJogador1);
        this.jogador1 = jogador;
	}

    public void escolherJogador2(String nomeJogador2) {
		Jogador jogador = new Jogador(nomeJogador2);
		this.jogador2 = jogador;
		
	}
	
	public Jogador getJogador1() {
		return this.jogador1;
	}

    public Jogador getJogador2() {
		return this.jogador2;
	}

	public boolean jogoValendo(){
		if(tabuleiro.getQuantidadeNaviosRestantes()==0){
			if(jogador1.getPlacar()>jogador2.getPlacar()){
				System.out.println("Jogador 1 ganhou!");
			}else{
				System.out.println("Jogador 2 ganhou!");
			}
			System.out.println(String.format("Pontuação: Jogador 1 - %d / Jogador 2 - %d", 
				jogador1.getPlacar(),jogador2.getPlacar()));

			return false;
		}else{
			return true;
		}
	}

	public void jogar(String i, String j){
		i.toUpperCase();
        int posLinha = i.charAt(0)-'A';

		int posColuna = 0;
		try{
			posColuna = Integer.parseInt(j);
		}catch(Exception e){
			System.out.println("Coluna inválida! Tente novamente...");
		}

		if (posLinha < 0 || posLinha >= 10 || posColuna < 0 || posColuna >= 10) {
			throw new IllegalArgumentException("Coordenadas inválidas. Tente novamente!");
		}
		
		boolean acertou = tabuleiro.jogar(posLinha, posColuna);

		if(acertou){
			if(getJogadorDaVez()){
				jogador1.aumentaPlacar();
			}else{
				jogador2.aumentaPlacar();
			}
			this.jogadorDaVez = !this.jogadorDaVez;
		}else{
			this.jogadorDaVez = !this.jogadorDaVez;
		}

	}

	public boolean getJogadorDaVez(){
		return this.jogadorDaVez;
	}

	public void imprimirGabarito(){
		tabuleiro.imprimirGabarito();
	}
}
