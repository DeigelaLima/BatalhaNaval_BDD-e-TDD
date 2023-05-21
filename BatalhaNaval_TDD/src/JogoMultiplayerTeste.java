import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import controller.JogoMultiplayer;
import model.Jogador;
import model.Tabuleiro;

class JogoMultiplayerTeste {
	
// Tipos de navios
// 1 de 1
// 2 de 2
// 2 de 3
// 1 de 4

	private JogoMultiplayer jogo;

    @Before
    public void setup() {
        jogo = new JogoMultiplayer();
    }
    
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
    public void testJogoValendo_NaviosRestantesJogador1Vence() {
    	JogoMultiplayer jogo = new JogoMultiplayer();
		
		jogo.iniciarJogo();
        // Configurar o jogo de exemplo
		jogo.getTabuleiro().setQuantidadeNaviosRestantes(0);
        jogo.escolherJogador1("Fulano");
        jogo.getJogador1().setPlacar(5);

        jogo.escolherJogador2("Beltrano");
        jogo.getJogador2().setPlacar(3);

        // Executar o método e verificar o resultado
        boolean resultado = jogo.jogoValendo();

        assertFalse(resultado);
//        assertEquals("Jogador 1 ganhou!\n" +
//                "Pontuação: Jogador 1 - 5 / Jogador 2 - 3\n", getConsoleOutput());
    }

    @Test
    public void testJogoValendo_NaviosRestantesJogador2Vence() {
        // Configurar o jogo de exemplo
    	JogoMultiplayer jogo = new JogoMultiplayer();
		
		jogo.iniciarJogo();
        jogo.escolherJogador1("Fulano");
        jogo.getJogador1().setPlacar(4);

        jogo.getTabuleiro().setQuantidadeNaviosRestantes(1);
        jogo.escolherJogador2("Beltrano");
        jogo.getJogador2().setPlacar(7);
        jogo.setJogadorDaVez(false);
        jogo.jogar("B4");
        jogo.getTabuleiro().afundarNavio();
        
        // Executar o método e verificar o resultado
        boolean resultado = jogo.jogoValendo();

        assertFalse(resultado);
//        assertEquals("Jogador 2 ganhou!\n" +
//                "Pontuação: Jogador 1 - 4 / Jogador 2 - 7\n", getConsoleOutput());
    }
    
   
    @Test
    public void testJogoValendo_JogoEmAndamento() {
    	JogoMultiplayer jogo = new JogoMultiplayer();
		
		jogo.iniciarJogo();
        // Configurar o jogo de exemplo
        jogo.getTabuleiro().setQuantidadeNaviosRestantes(2);
        jogo.escolherJogador1("Fulano");
        jogo.getJogador1().setPlacar(4);

        jogo.escolherJogador2("Beltrano");
        jogo.getJogador2().setPlacar(6);

        // Executar o método e verificar o resultado
        boolean resultado = jogo.jogoValendo();

        assertTrue(resultado);
        assertEquals("", getConsoleOutput());
    }

    // Método auxiliar para capturar a saída do console
    private String getConsoleOutput() {
        return ""; // Implemente a lógica para capturar a saída do console
    }
}
