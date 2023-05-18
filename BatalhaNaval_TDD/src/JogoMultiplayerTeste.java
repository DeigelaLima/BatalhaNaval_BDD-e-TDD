import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.JogoMultiplayer;

class JogoMultiplayerTeste {
	
// Tipos de navios
// 1 de 1
// 2 de 2
// 2 de 3
// 1 de 4

	 @Test
	public void testEscolherJogadores() {
		
		JogoMultiplayer jogo = new JogoMultiplayer();
		
		jogo.iniciarJogo();
		
		String nomeJogador1 = "João";
		String nomeJogador2 = "Maria";
		
		jogo.escolherJogador1(nomeJogador1);
		jogo.escolherJogador2(nomeJogador2);
		
		assertEquals(nomeJogador1, jogo.getJogador1().getNome());
		assertEquals(nomeJogador2, jogo.getJogador2().getNome());
	}

	@Test
	public void testaJogadaErrada(){
		int linha = 0;
		int coluna = 1;

		JogoMultiplayer jogo = new JogoMultiplayer();
		jogo.iniciarJogo();
		// assertFalse(jogo.jogar(linha, coluna));

	}

	@Test
	public void testaJogadaCerta(){
		int linha = 0;
		int coluna = 0;

		JogoMultiplayer jogo = new JogoMultiplayer();
		jogo.iniciarJogo();
		// assertTrue(jogo.jogar(linha, coluna));

	}


}
