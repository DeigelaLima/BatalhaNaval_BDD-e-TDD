package controller;

import model.Jogador;
import model.Tabuleiro;

public class JogoMultiplayer {
    private Jogador jogador1;
    private Jogador jogador2;
	private Tabuleiro tabuleiro;

	public void iniciarJogo() {
		this.tabuleiro = new Tabuleiro();
		this.tabuleiro.criarTabuleiro();
		
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

//	public boolean jogar(int linha, int coluna){
//	
//		String[][] tabuleiro_aux = {{"<>","~"}};
		//if(tabuleiro.getTipoNavios().contains(tabuleiro_aux[linha][coluna])){
		//	return true;
		//}
		//return false;
		
//		 if(tabuleiro.posicaoValida(linha, coluna)) {
//		        if(tabuleiro[linha][coluna] == 'O') {
//		            // acertou um navio
//		            tabuleiro[linha][coluna] = 'X';
//	            	naviosRestantes--;
//		            tabuleiro.atualizarTiposNaviosRestantes();		            
//					System.out.println("Acertou um navio!");
//	        }else{
//		            // acertou água
//		            tabuleiro[linha][coluna] = '-';
//		            System.out.println("Errou!");
//		        }
//		    }else{
//		        System.out.println("Posição inválida!");
//		    }
		 
//	}

}
