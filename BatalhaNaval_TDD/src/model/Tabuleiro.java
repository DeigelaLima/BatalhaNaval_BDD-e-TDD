package model;
import java.util.*;


//private int quantidadeNavios;
//private int naviosRestantes;
//
//// Construtor da classe BatalhaNaval
//public BatalhaNaval(int quantidadeNavios) {
//    this.quantidadeNavios = quantidadeNavios;
//    this.naviosRestantes = quantidadeNavios;
//}
//
//// Método para obter a quantidade de navios restantes
//public int getQuantidadeNaviosRestantes() {
//    return naviosRestantes;
//}
//
//// Método para registrar o afundamento de um navio
//public void afundarNavio() {
//    naviosRestantes--;
//}
// Tipos de navios
// 1 de 1
// 2 de 2
// 2 de 3
// 1 de 4

    
public class Tabuleiro {
	private int dimensao = 10;
    private char[][] tabuleiroJogador = new char[dimensao][dimensao];
	private char[][] tabuleiroGabarito = new char[dimensao][dimensao];
    private int qtdNavios;
    private int qtdNaviosRestantes;
    private ArrayList<Character> tipoNavios = new ArrayList<>(List.of('A', 'B','C','D'));
	private ArrayList<Character> tiposNaviosRestantes = new ArrayList<>();
	
	public Tabuleiro(){
		this.qtdNavios = 6;
		this.qtdNaviosRestantes = 6;
	}


	public void criarTabuleiro() {
		
		
	}

	public void afundarNavio() {
		this.qtdNaviosRestantes--;
	}
	
	public boolean posicaoValida(int linha, int coluna) {
		if((linha < dimensao) && (coluna < dimensao)){
			return true;
		}
		return false;
	}
	
	private int getTipoNavio(int linha, int coluna) {
	    char tipo = tabuleiroGabarito[linha][coluna];
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
	    
	    return tamanhoNavio;
	}


	public void atualizarTiposNaviosRestantes() {
		
	    tiposNaviosRestantes.clear(); // Limpa a lista de tipos de navios restantes
	    // Percorre a matriz de tabuleiro e adiciona os tipos de navios restantes à lista
	    for (int i = 0; i < dimensao; i++) {
	        for (int j = 0; j < dimensao; j++) {
	            char tipoNavio = tabuleiroGabarito[i][j];
	            if (tipoNavio != ' ' && !tiposNaviosRestantes.contains(tipoNavio)) {
	                tiposNaviosRestantes.add(tipoNavio);
	            }
	        }
	    }
	    // Ordena a lista de tipos de navios restantes em ordem crescente
	    Collections.sort(tiposNaviosRestantes);
	}
	

	public int getQuantidadeNaviosRestantes() {
		// TO-DO dois tabuleiros: 1 é o gabarito e o outro é do jogador
		// a O quer dizer a bomba jogada em uma parte do navio
		// no tabuleiro do gabarito terá somente os tipos A, B, C ou D
		// Passo a passo:
		// Quando encontrar O verifica o tipo do navio no gabarito
		// Verifica se ja foi afundado no tabuleiro do jogador
		// Se foi afundado, atualiza o contador de navios restantes
		return this.qtdNaviosRestantes;
	}

	public boolean verificarAfundamento(char[][] matriz, int linha, int coluna) {
		char navio = matriz[linha][coluna];

		// Verifica se o navio já foi completamente afundado na horizontal
		if (verificarAfundamentoHorizontal(matriz, linha, coluna, navio)) {
			return true;
		}

		// Verifica se o navio já foi completamente afundado na vertical
		if (verificarAfundamentoVertical(matriz, linha, coluna, navio)) {
			return true;
		}

		return false;
	}

	private boolean verificarAfundamentoHorizontal(char[][] matriz, int linha, int coluna, char navio) {
		int tamanho = 0;

		// Percorre para a esquerda
		for (int j = coluna; j >= 0; j--) {
			if (matriz[linha][j] == navio && matriz[linha][j] != 'O') {
				tamanho++;
			} else {
				break;
			}
		}

		// Percorre para a direita
		for (int j = coluna + 1; j < matriz[0].length; j++) {
			if (matriz[linha][j] == navio && matriz[linha][j] != 'O') {
				tamanho++;
			} else {
				break;
			}
		}

		return tamanho == navio - 'A' + 1;
	}

	private boolean verificarAfundamentoVertical(char[][] matriz, int linha, int coluna, char navio) {
		int tamanho = 0;

		// Percorre para cima
		for (int i = linha; i >= 0; i--) {
			if (matriz[i][coluna] == navio && matriz[i][coluna] != 'O') {
				tamanho++;
			} else {
				break;
			}
		}

		// Percorre para baixo
		for (int i = linha + 1; i < matriz.length; i++) {
			if (matriz[i][coluna] == navio && matriz[i][coluna] != 'O') {
				tamanho++;
			} else {
				break;
			}
		}

		return tamanho == navio - 'A' + 1;
	}


	// Método para verificar se um navio foi afundado
//	public boolean verificaNavioAfundado(int i, int j) {
//
//		// Verifica se a posição informada está dentro dos limites da matriz
//		if (i < 0 || i >= tabuleiroGabarito.length || j < 0 || j >= tabuleiroGabarito[0].length) {
//			return false;
//		}
//
//		// Verifica se a posição contém um navio
//		if (temNavio(i,j)) {
//			// Verifica se o navio já foi completamente afundado
//			// Cria uma nova matriz com as mesmas dimensões da matriz original
//			char[][] matrizCopia = new char[dimensao][dimensao];
//
//			// Copia os elementos da matriz original para a matriz de destino
//			for (int x = 0; x < dimensao; x++) {
//				for (int y = 0; y < dimensao; y++) {
//					matrizCopia[x][y] = tabuleiroGabarito[x][y];
//				}
//			}
//			if (verificarAfundamentoRecursivo(matrizCopia, i, j, matrizCopia[i][j])) {
//				return true;
//			}
//		}
//
//		return false;

//		int tamanhoNavio = getTipoNavio(i, j);

//		// Verificar se as coordenadas estão dentro dos limites do tabuleiro
//		if (i < 0 || i >= tabuleiroGabarito.length || j < 0 || j >= tabuleiroGabarito.length) {
//			throw new IllegalArgumentException("Coordenadas inválidas.");
//		}
//		
//		// Verificar se já foi feito um ataque nessa posição
//		if (tabuleiroJogador[i][j]=='O') {
//			// Verificar se há um navio na posição e se ele ainda não foi afundado
//			if (temNavio(i,j) && !verificaAdjacentes(i, j)) {
//				return true; // O navio foi afundado
//			}
//		}

//		return false; // O navio ainda não foi afundado
//	}

//	private boolean verificarAfundamentoRecursivo(char[][] matriz, int linha, int coluna, char tipo) {
//		// Verifica se a posição está dentro dos limites da matriz
//		if (linha < 0 || linha >= matriz.length || coluna < 0 || coluna >= matriz[0].length) {
//			return true; // Retorna true para indicar que todas as casas adjacentes foram verificadas
//		}
//
//		char navio = matriz[linha][coluna];
//		
//		// Verifica se a posição contém o mesmo navio
//		if (navio == tipo) {
//			matriz[linha][coluna] = '.'; // Marca a posição como afundada
//
//			// Verifica as casas adjacentes recursivamente
//			return verificarAfundamentoRecursivo(matriz, linha - 1, coluna) && // acima
//				verificarAfundamentoRecursivo(matriz, linha + 1, coluna) && // abaixo
//				verificarAfundamentoRecursivo(matriz, linha, coluna - 1) && // esquerda
//				verificarAfundamentoRecursivo(matriz, linha, coluna + 1);   // direita
//		}
//
//		return true; // Retorna true para indicar que todas as casas adjacentes foram verificadas
//	}

	public boolean temNavio(int i, int j){
		return tipoNavios.contains(tabuleiroGabarito[i][j]);
	}

	// Método auxiliar para verificar se todos os navios adjacentes a uma posição foram afundados
	private boolean verificaAdjacentes(int i, int j) {
		int tamanhoNavio = getTipoNavio(i, j);

		// Verificar se as coordenadas estão dentro dos limites do tabuleiro
		if (i < 0 || i >= tabuleiroGabarito.length || j < 0 || j >= tabuleiroGabarito.length) {
			return false;
		}

		//percorre na horizontal
		for(int x=tamanhoNavio; x>0; x++){

		}
		//percorre na vertical
		for(int x=tamanhoNavio; x>0; x++){
			// Verificar se há um navio adjacente não afundado na posição acima
			if (i > 0 && temNavio(i-1, j) && tabuleiroJogador[i - 1][j]!='O') {
				return false;
			}
		}

		// Verificar se há um navio adjacente não afundado na posição acima
		if (i > 0 && temNavio(i-1, j) && tabuleiroJogador[i - 1][j]!='O') {
			return false;
		}

		// Verificar se há um navio adjacente não afundado na posição abaixo
		if (i < tabuleiroGabarito.length - 1  && temNavio(i+1,j) && tabuleiroJogador[i + 1][j]!='O') {
			return false;
		}
		
		// Verificar se há um navio adjacente não afundado na posição a esquerda
		if (j > 0 && temNavio(i,j-1) && tabuleiroGabarito[i][j - 1]!='O') {
			return false;
		}

		// Verificar se há um navio adjacente não afundado na posição a direita
		if (j < tabuleiroGabarito.length - 1 && temNavio(i, j+1) && tabuleiroJogador[i][j + 1]!='O') {
			return false;
		}

		return true; // Todos os navios adjacentes foram afundados
	}


	public boolean jogar(int i, int j) {
		
		// olha no gabarito a posição i,j
		// se tiver embarcação (A,B,C,D) retorne True
		// se não retorne False

		if(tipoNavios.contains(tabuleiroGabarito[i][j])){
			if(verificarAfundamento(tabuleiroJogador,i,j)){
				afundarNavio();
			}	
			return true;
		}else{
			return false;
		}
	}

	

	public void imprimir() {
		
		
	}
    
    public ArrayList<Character> getTipoNavios(){
        return tipoNavios;
    }

	private static final int TAMANHO_TABULEIRO = 10;
    private static final char[] NAVIOS = {'A', 'B', 'C', 'D'};

	public static char[][] gerarTabuleiro() {
        char[][] tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        preencherTabuleiro(tabuleiro, '~'); // preenche o tabuleiro com '~' (representando água)

        Random random = new Random();
        for (char navio : NAVIOS) {
            boolean inserido = false;
            while (!inserido) {
                int linha = random.nextInt(TAMANHO_TABULEIRO);
                int coluna = random.nextInt(TAMANHO_TABULEIRO);
                boolean vertical = random.nextBoolean();

                if (podeInserirNavio(tabuleiro, linha, coluna, vertical, navio)) {
                    inserirNavio(tabuleiro, linha, coluna, vertical, navio);
                    inserido = true;
                }
            }
        }

        return tabuleiro;
    }

    public static boolean podeInserirNavio(char[][] tabuleiro, int linha, int coluna, boolean vertical, char navio) {
        int tamanhoNavio = navio - 'A' + 1;
        int linhaFinal = vertical ? linha + tamanhoNavio - 1 : linha;
        int colunaFinal = vertical ? coluna : coluna + tamanhoNavio - 1;

        if (linhaFinal >= TAMANHO_TABULEIRO || colunaFinal >= TAMANHO_TABULEIRO) {
            return false; // o navio estaria fora do tabuleiro
        }

        for (int i = linha; i <= linhaFinal; i++) {
            for (int j = coluna; j <= colunaFinal; j++) {
                if (tabuleiro[i][j] != '~') {
                    return false; // há uma colisão com outro navio
                }
            }
        }

        return true;
    }

    public static void inserirNavio(char[][] tabuleiro, int linha, int coluna, boolean vertical, char navio) {
        int tamanhoNavio = navio - 'A' + 1;

        for (int i = 0; i < tamanhoNavio; i++) {
            if (vertical) {
                tabuleiro[linha + i][coluna] = navio;
            } else {
                tabuleiro[linha][coluna + i] = navio;
            }
        }
    }

    public static void preencherTabuleiro(char[][] tabuleiro, char valor) {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                tabuleiro[i][j] = valor;
            }
        }
    }

    public static void exibirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
}
