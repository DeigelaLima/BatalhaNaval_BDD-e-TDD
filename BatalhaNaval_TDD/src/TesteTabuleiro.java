import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Tabuleiro;

public class TesteTabuleiro {

	private Tabuleiro tabuleiro;

	@Before
	public void setup() {
		this.tabuleiro = new Tabuleiro();
		char[][] matriz = { { 'A', 'B', 'C', 'D', '~', '~', '~', '~', '~', '~' },
				{ 'A', 'B', 'C', 'D', '~', '~', '~', '~', '~', '~' },
				{ 'A', 'B', 'C', 'D', '~', '~', '~', '~', '~', '~' },
				{ 'A', 'B', 'C', 'D', '~', '~', '~', '~', '~', '~' },
				{ 'A', 'B', 'C', 'D', '~', '~', '~', '~', '~', '~' },
				{ 'A', 'B', 'C', 'D', '~', '~', '~', '~', '~', '~' },
				{ 'A', 'B', 'C', 'D', '~', '~', '~', '~', '~', '~' },
				{ 'A', 'B', 'C', 'D', '~', '~', '~', '~', '~', '~' },
				{ 'A', 'B', 'C', 'D', '~', '~', '~', '~', '~', '~' },
				{ 'A', 'B', 'C', 'D', '~', '~', '~', '~', '~', '~' } };

		tabuleiro.setTabuleiroGabarito(matriz);
	}

	@Test
	public void testaAfundarNavio() {
		// configurar
		Tabuleiro tabuleiro = new Tabuleiro();
		int resultadoEsperado = 5;
		// exercitar
		tabuleiro.afundarNavio();
		// verificar
		assertEquals(resultadoEsperado, tabuleiro.getQuantidadeNaviosRestantes());
	}

	@Test
	public void testaPosicaoValida() {
		// configurar
		Tabuleiro tabuleiro = new Tabuleiro();
		boolean resultadoEsperado = true;

		// exercitar
		boolean res = tabuleiro.posicaoValida(1, 1);

		// verificar
		assertEquals(resultadoEsperado, res);

	}

	@Test
	public void testaPosicaoInvalida() {
		// configurar
		Tabuleiro tabuleiro = new Tabuleiro();
		boolean resultadoEsperado = false;

		// exercitar
		boolean res = tabuleiro.posicaoValida(10, 10);

		// verificar
		assertEquals(resultadoEsperado, res);
	}

	@Test
	public void testGetTipoNavioA() {

		int linha = 0;
		int coluna = 0;

		int tamanhoNavio = tabuleiro.getTipoNavio(linha, coluna);

		assertEquals(1, tamanhoNavio);
	}

	@Test
	public void testGetTipoNavioB() {

		int linha = 0;
		int coluna = 1;

		int tamanhoNavio = tabuleiro.getTipoNavio(linha, coluna);

		assertEquals(2, tamanhoNavio);
	}

	@Test
	public void testGetTipoNavioC() {

		int linha = 0;
		int coluna = 2;

		int tamanhoNavio = tabuleiro.getTipoNavio(linha, coluna);

		assertEquals(3, tamanhoNavio);
	}

	@Test
	public void testGetTipoNavioD() {

		int linha = 0;
		int coluna = 3;

		int tamanhoNavio = tabuleiro.getTipoNavio(linha, coluna);

		assertEquals(4, tamanhoNavio);
	}

	@Test
	public void testAtualizarTiposNaviosRestantes() {

		tabuleiro.atualizarTiposNaviosRestantes();

		List<Character> tiposNaviosEsperados = Arrays.asList('A', 'B', 'C', 'D');
		assertEquals(tiposNaviosEsperados, tabuleiro.getTiposNaviosRestantes());
	}

	@Test
	public void testAtualizarTiposNaviosRestantesSemNaviosRestantes() {
		tabuleiro.setTabuleiroGabarito(new char[][] { { '~', '~', '~' }, { '~', '~', '~' }, { '~', '~', '~' } });

		tabuleiro.atualizarTiposNaviosRestantes();

		List<Character> tiposNaviosEsperados = Collections.emptyList();
		assertEquals(tiposNaviosEsperados, tabuleiro.getTiposNaviosRestantes());
	}

	@Test
	public void testaTemNavioExistente() {
		// configurar
		boolean resultadoEsperado = true;
		// exercitar
		boolean temNavio = tabuleiro.temNavio(0, 0);
		// verificar
		assertEquals(resultadoEsperado, temNavio);
	}

	@Test
	public void testaTemNavioNaoExistente() {
		// configurar
		boolean resultadoEsperado = false;
		// exercitar
		boolean temNavio = tabuleiro.temNavio(0, 4);
		// verificar
		assertEquals(resultadoEsperado, temNavio);
	}

	@Test
	public void testVerificarAfundamentoHorizontal() {
		char[][] matriz = new char[][] { { 'B', 'B', '~' }, 
										 { '~', '~', '~' }, 
										 { '~', '~', '~' } };

		char[][] tabuleiroJogador = new char[][] { { 'O', 'O', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		tabuleiro.setTabuleiroGabarito(matriz);
		tabuleiro.setTabuleiroJogador(tabuleiroJogador);
		boolean afundamentoHorizontal = tabuleiro.verificarAfundamentoHorizontal(matriz, 0, 0, 'B');
		assertTrue(afundamentoHorizontal);
	}

	@Test
	public void testVerificarAfundamentoHorizontalFalso() {
		char[][] matriz = new char[][] { { 'B', 'B', '~' }, 
										 { '~', '~', '~' }, 
										 { '~', '~', '~' } };

		char[][] tabuleiroJogador = new char[][] { { 'O', ' ', ' ' }, 
												   { ' ', ' ', ' ' }, 
												   { ' ', ' ', ' ' } };
		tabuleiro.setTabuleiroGabarito(matriz);
		tabuleiro.setTabuleiroJogador(tabuleiroJogador);
		boolean afundamentoHorizontal = tabuleiro.verificarAfundamentoHorizontal(matriz, 0, 0, 'B');
		assertFalse(afundamentoHorizontal);
	}

	@Test
	public void testVerificarAfundamentoVertical() {
		char[][] matriz = new char[][] { { 'B', '~', '~' }, 
										 { 'B', '~', '~' }, 
										 { '~', '~', '~' } };
										 
		char[][] tabuleiroJogador = new char[][] { { 'O', ' ', ' ' }, 
													{ 'O', ' ', ' ' }, 
													{ ' ', ' ', ' ' } };
		tabuleiro.setTabuleiroGabarito(matriz);
		tabuleiro.setTabuleiroJogador(tabuleiroJogador);
		boolean afundamentoVertical = tabuleiro.verificarAfundamentoVertical(matriz, 0, 0, 'B');
		assertTrue(afundamentoVertical);
	}

	@Test
	public void testVerificarAfundamentoVerticalFalso() {
		char[][] matriz = new char[][] { { 'B', 'B', '~' }, 
										 { '~', '~', '~' }, 
										 { '~', '~', '~' } };
		char[][] tabuleiroJogador = new char[][] { { 'O', 'O', ' ' }, 
												   { ' ', ' ', ' ' }, 
												   { ' ', ' ', ' ' } };
		tabuleiro.setTabuleiroGabarito(matriz);
		tabuleiro.setTabuleiroJogador(tabuleiroJogador);
		boolean afundamentoVertical = tabuleiro.verificarAfundamentoVertical(matriz, 0, 0, 'B');
		assertFalse(afundamentoVertical);
	}

	@Test
	public void testPreencherTabuleiro() {
		int TAMANHO_TABULEIRO = 3;
		char[][] exTabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
		char valor = 'O';

		tabuleiro.preencherTabuleiro(exTabuleiro, valor);

		for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
			for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
				assertEquals(valor, exTabuleiro[i][j]);
			}
		}
	}
	
	 private static final int TAMANHO_TABULEIRO_ = 10;

    @Test
    public void testPodeInserirNavioVertical() {
//        char[][] exTabuleiro = new char[TAMANHO_TABULEIRO_][TAMANHO_TABULEIRO_];
        char[][] matriz = new char[][] { { '~', '~', 'A' }, 
			 							 { '~', '~', '~' }, 
			 							 { '~', '~', '~' } };
        int linha = 0;
        int coluna = 0;
        boolean vertical = true;
        char navio = 'B';

        boolean podeInserirNavio = tabuleiro.podeInserirNavio(matriz, linha, coluna, vertical, navio);

        assertTrue(podeInserirNavio);
    }

	@Test
    public void testPodeInserirNavioHorizontal() {
		char[][] matriz = new char[][] { { '~', '~', 'A' }, 
			 							 { '~', '~', '~' }, 
			 							 { '~', '~', '~' } };
        int linha = 0;
        int coluna = 0;
        boolean vertical = false;
        char navio = 'B';

        boolean podeInserirNavio = tabuleiro.podeInserirNavio(matriz, linha, coluna, vertical, navio);

        assertTrue(podeInserirNavio);
    }
	
	@Test
    public void testPodeInserirNavioComColisao() {
        char[][] exTabuleiro = new char[TAMANHO_TABULEIRO_][TAMANHO_TABULEIRO_];
        exTabuleiro[0][0] = 'A';
        int linha = 0;
        int coluna = 0;
        boolean vertical = false;
        char navio = 'B';

        boolean podeInserirNavio = tabuleiro.podeInserirNavio(exTabuleiro, linha, coluna, vertical, navio);

        assertFalse(podeInserirNavio);
    }
	
	 @Test
    public void testPodeInserirNavioForaDoTabuleiro() {
        char[][] exTabuleiro = new char[TAMANHO_TABULEIRO_][TAMANHO_TABULEIRO_];
        int linha = 8;
        int coluna = 8;
        boolean vertical = true;
        char navio = 'C';

        boolean podeInserirNavio = this.tabuleiro.podeInserirNavio(exTabuleiro, linha, coluna, vertical, navio);

        assertFalse(podeInserirNavio);
    }
	 
	@Test
    public void testInserirNavioVertical() {
        char[][] exTabuleiro = new char[TAMANHO_TABULEIRO_][TAMANHO_TABULEIRO_];
        int linha = 0;
        int coluna = 0;
        boolean vertical = true;
        char navio = 'A';

        tabuleiro.inserirNavio(exTabuleiro, linha, coluna, vertical, navio);

        for (int i = linha; i < linha + navio - 'A' + 1; i++) {
            assertEquals(navio, exTabuleiro[i][coluna]);
        }
    }
	
	@Test
    public void testInserirNavioHorizontal() {
        char[][] exTabuleiro = new char[TAMANHO_TABULEIRO_][TAMANHO_TABULEIRO_];
        int linha = 0;
        int coluna = 0;
        boolean vertical = false;
        char navio = 'A';

        tabuleiro.inserirNavio(exTabuleiro, linha, coluna, vertical, navio);

        for (int j = coluna; j < coluna + navio - 'A' + 1; j++) {
            assertEquals(navio, exTabuleiro[linha][j]);
        }
    }
	
//	private JogoBatalhaNaval jogo;
//
//    @Before
//    public void setUp() {
//        jogo = new JogoBatalhaNaval();
//    }

    @Test(expected = IllegalArgumentException.class)
    public void testJogarPosicaoJaEscolhida() {
        char[][] tabuleiroJogador = {
                {'O', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'O'}
        };
        tabuleiro.setTabuleiroJogador(tabuleiroJogador);

        int i = 0;
        int j = 0;

        tabuleiro.jogar(i, j);
    }
	
	 @Test
    public void testJogarAcertouNavio() {
        char[][] tabuleiroGabarito = {
                {'~', '~', '~', '~'},
                {'~', 'B', '~', '~'},
                {'~', '~', '~', '~'},
                {'~', '~', '~', '~'}
        };
        char[][] tabuleiroJogador = {
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '}
        };
        tabuleiro.setTabuleiroGabarito(tabuleiroGabarito);
        tabuleiro.setTabuleiroJogador(tabuleiroJogador);

        int i = 1;
        int j = 1;

        boolean acertouNavio = tabuleiro.jogar(i, j);

        assertTrue(acertouNavio);
        assertEquals('O', tabuleiro.getTabuleiroJogador()[i][j]);
    }
	
	    @Test
    public void testJogarErrouNavio() {
        char[][] tabuleiroGabarito = {
                {'~', '~', '~', '~'},
                {'~', 'B', '~', '~'},
                {'~', '~', '~', '~'},
                {'~', '~', '~', '~'}
        };
        tabuleiro.setTabuleiroGabarito(tabuleiroGabarito);

        char[][] tabuleiroJogador = {
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '}
        };
        tabuleiro.setTabuleiroJogador(tabuleiroJogador);

        int i = 0;
        int j = 1;

        boolean acertouNavio = tabuleiro.jogar(i, j);

        assertFalse(acertouNavio);
        assertEquals('~', tabuleiro.getTabuleiroJogador()[i][j]);
    }

	@Test
    public void testExibirTabuleiro() {
        char[][] exTabuleiro = {
                {'O', ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
                
        };
        
        tabuleiro.setTabuleiroGabarito(exTabuleiro);
        tabuleiro.exibirTabuleiro(exTabuleiro);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);
	
		tabuleiro.exibirTabuleiro(exTabuleiro);
		
		String expectedOutput = "     0      1      2      3      4      5      6      7      8      9  \n" +
								"A  | O |  |   |  |   |  | O |  |   |  |   |  |   |  |   |  |   |  |   |" +"\n"+
								"   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----\n" +
								"B  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |\n" +
								"   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----\n" +
								"C  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |\n" +
								"   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----\n" +
								"D  |   |  |   |  |   |  | O |  |   |  |   |  |   |  |   |  |   |  |   |\n" +
								"   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----\n" +
								"E  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |\n" +
								"   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----\n" +
								"F  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |\n" +
								"   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----\n" +
								"G  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |\n" +
								"   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----\n" +
								"H  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |\n" +
								"   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----\n" +
								"I  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |\n" +
								"   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----\n" +
								"J  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |\n" +
								"   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----\n"+"\n";
		
		assertEquals(expectedOutput, outputStream.toString());
	}
//	  private static final int TAMANHO_TABULEIRO = 10;
//	  private char[][] tabuleiroJogador;
//	
//	  @Before
//	  public void setup() {
//	      tabuleiroJogador = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
//	  }
	
	  @Test
	  public void testImprimir() {
	      // Configurar o tabuleiro de exemplo
		  int TAMANHO_TABULEIRO = 3;
		  char[][] tabuleiroJogador = new char[3][9];
		  tabuleiro.preencherTabuleiro(tabuleiroJogador, ' ');
	      tabuleiroJogador[0][0] = 'O';
	      tabuleiroJogador[1][1] = 'X';
	      tabuleiroJogador[2][2] = '~';
	      
	
	      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	      PrintStream printStream = new PrintStream(outputStream);
	      System.setOut(printStream);
	
	      Tabuleiro tabuleiro = new Tabuleiro();
	      tabuleiro.setTabuleiroJogador(tabuleiroJogador);
	      tabuleiro.imprimir();
	
	      String expectedOutput = "     0      1      2      3      4      5      6      7      8      9  \n" +
	              "A  | O |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  \n" +
	              "   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----\n" +
	              "B  |   |  | X |  |   |  |   |  |   |  |   |  |   |  |   |  |   |  \n" +
	              "   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----\n" +
	              "C  |   |  |   |  | ~ |  |   |  |   |  |   |  |   |  |   |  |   |  \n" +
	              "   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----\n";
	
	      assertEquals(expectedOutput, outputStream.toString());
	  }
}

//public  void exibirTabuleiro(char[][] tabuleiro) {
//	
//	System.out.println("     0      1      2      3      4      5      6      7      8      9  "); // Cabeçalho das colunas
//
//    for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
//		System.out.print( (char)(i + 65) + " "); // Número da linha
//
//        for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
//            System.out.print( " | " + tabuleiro[i][j]  + " | ");
//        }
//		System.out.print("\n   -----  -----  -----  -----  -----  -----  -----  -----  -----  -----");
//
//        System.out.println(); // Próxima linha
//    }
//}





