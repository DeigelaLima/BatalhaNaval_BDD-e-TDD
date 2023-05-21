import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

	public static void preencherTabuleiro(char[][] tabuleiro, char valor) {
		for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
			for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
				tabuleiro[i][j] = valor;
			}
		}
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

	private static final int TAMANHO_TABULEIRO = 3;

	@Test
	public void testPreencherTabuleiro() {
		char[][] exTabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
		char valor = 'O';

		tabuleiro.preencherTabuleiro(exTabuleiro, valor);

		for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
			for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
				assertEquals(valor, exTabuleiro[i][j]);
			}
		}
	}

}
//	
//		@Test	
//		public void testaImpressaoTabuleiroJogador(){
//			Tabuleiro tab = new Tabuleiro();
//			tab.imprimir();
//		}
//
//		@Test	
//		public void testaImpressaoTabuleiroGabarito(){
//			Tabuleiro tab = new Tabuleiro();
//			tab.imprimirGabarito();
//		}
//	   @Test
//	    public void testAtualizarTabuleiro() {
//		   
//	        Tabuleiro tabuleiro = new Tabuleiro();
//	        
//	        int quantidadeNavios = tabuleiro.getQuantidadeNaviosRestantes();
//	        ArrayList<Character> tiposNavios = tabuleiro.getTipoNavios();
//	        
//	        tabuleiro.jogar(0, 0);
//	        tabuleiro.imprimir();
//	        
//	        assertEquals(quantidadeNavios - 1, tabuleiro.getQuantidadeNaviosRestantes());
//	        assertFalse(tabuleiro.getTipoNavios().contains(tiposNavios.get(0)));
//	    }
//
//		@Test
//		public void testaJogar(){
//			Tabuleiro tabuleiro = new Tabuleiro();
//			assertTrue(tabuleiro.jogar(1,1));
//		}
//		
