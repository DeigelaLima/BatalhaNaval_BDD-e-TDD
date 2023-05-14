package model;
import java.util.*;

public class Tabuleiro {
	private int dimensao = 10;
    private char[][] tabuleiro = new char[dimensao][dimensao];
    private int qtdNavios;
    private int qtdNaviosRestantes;
    private ArrayList<Character> tipoNavios = new ArrayList<>(List.of('A', 'B','C','D'));
	private ArrayList<Character> tiposNaviosRestantes = new ArrayList();
	
	public void criarTabuleiro() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean posicaoValida(int linha, int coluna) {
		if((linha < dimensao) && (coluna < dimensao)){
			return true;
		}
		return false;
	}
	
	private String getTipoNavio(int linha, int coluna) {
	    char tipo = tabuleiro[linha][coluna];
	    int tamanhoNavio = 0;
	    
	    if (tipo == 'A') {
	        tamanhoNavio = 1;
	    } else if (tipo == 'B') {
	        tamanhoNavio = 2;
	    } else if (tipo == 'C') {
	        tamanhoNavio = 3;
	    } else if (tipo == 'D') {
	        tamanhoNavio = 4;
	    }
	    
	    return tipo + "(" + tamanhoNavio + ")";
	}


	public void atualizarTiposNaviosRestantes() {
		// TO-DO dois tabuleiros: 1 é o gabarito e o outro é do jogador
		// a O quer dizer a bomba jogada em uma parte do navio
		// no tabuleiro do gabarito terá somente os tipos A, B, C ou D
		// Passo a passo:
		// Quando encontrar O verifica o tipo do navio no gabarito
		// Verifica se ja foi afundado no tabuleiro do jogador
		// Se foi afundado, atualiza o contador de navios restantes
		
	    tiposNaviosRestantes.clear(); // Limpa a lista de tipos de navios restantes
	    // Percorre a matriz de tabuleiro e adiciona os tipos de navios restantes à lista
	    for (int i = 0; i < dimensao; i++) {
	        for (int j = 0; j < dimensao; j++) {
	            char tipoNavio = tabuleiro[i][j];
	            if (tipoNavio != ' ' && !tiposNaviosRestantes.contains(tipoNavio)) {
	                tiposNaviosRestantes.add(tipoNavio);
	            }
	        }
	    }
	    // Ordena a lista de tipos de navios restantes em ordem crescente
	    Collections.sort(tiposNaviosRestantes);
	}
	

	public int getQuantidadeNaviosRestantes() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void jogar(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void imprimir() {
		// TODO Auto-generated method stub
		
	}
    
    public ArrayList<Character> getTipoNavios(){
        return tipoNavios;
    }
}
