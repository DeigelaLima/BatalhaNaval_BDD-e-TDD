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
		tabuleiroGabarito = gerarTabuleiro();
		preencherTabuleiro(tabuleiroJogador, ' ');
	}
	// TO-DO dois tabuleiros: 1 é o gabarito e o outro é do jogador
	// a O quer dizer a bomba jogada em uma parte do navio
	// no tabuleiro do gabarito terá somente os tipos A, B, C ou D
	// Passo a passo:
	// Quando encontrar O verifica o tipo do navio no gabarito
	// Verifica se ja foi afundado no tabuleiro do jogador
	// Se foi afundado, atualiza o contador de navios restantes


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

	


	public boolean jogar(int i, int j) {
		
		if (i < 0 || i >= tabuleiroGabarito.length || j < 0 || j >= tabuleiroGabarito[0].length) {
			throw new IllegalArgumentException("Coordenadas inválidas. Tente novamente!");
		}
		if(tabuleiroJogador[i][j]=='O' || tabuleiroJogador[i][j]=='~' ){
			System.out.println("***************************************************************************");
			throw new IllegalArgumentException("Essa posição já foi escolhida. Por favor tente novamente!\n");

		}
		if(tipoNavios.contains(tabuleiroGabarito[i][j])){
			tabuleiroJogador[i][j] = 'O';
			if(verificarAfundamento(tabuleiroJogador,i,j)){
				afundarNavio();
			}	
			//exibirTabuleiro(tabuleiroJogador);
			imprimir();
			return true;
		}else{
			tabuleiroJogador[i][j] = '~';
			//exibirTabuleiro(tabuleiroJogador);
			imprimir();
			return false;
		}
	}

	
    
    public ArrayList<Character> getTipoNavios(){
        return tipoNavios;
    }

	private static final int TAMANHO_TABULEIRO = 10;
    private static final char[] NAVIOS = {'A', 'B', 'B', 'C', 'C', 'D'};

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
		System.out.println("     0      1      2      3      4      5      6      7      8      9  "); // Cabeçalho das colunas

        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
			System.out.print( (char)(i + 65) + " "); // Número da linha

            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                System.out.print( " | " + tabuleiro[i][j]  + " | ");
            }
			System.out.print("\n   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----");
	
	        System.out.println(); // Próxima linha
        }
    }

	public void imprimir(){
		//exibirTabuleiro(tabuleiroJogador);
		System.out.println("     0      1      2      3      4      5      6      7      8      9  "); // Cabeçalho das colunas

	    for (int i = 0; i < dimensao; i++) {
	        System.out.print( (char)(i + 65) + " "); // Número da linha
			
	        for (int j = 0; j < tabuleiroJogador[i].length; j++) {
	            System.out.print( " | " + tabuleiroJogador[i][j] + " | "); // Valor da posição
	        }

			System.out.print("\n   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----");
	
	        System.out.println(); // Próxima linha
	    }
	}

	public void imprimirGabarito(){
		exibirTabuleiro(tabuleiroGabarito);
	}

	
}
