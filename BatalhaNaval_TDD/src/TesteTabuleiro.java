import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.Tabuleiro;

public class TesteTabuleiro {
	
	   @Test
	    public void testAtualizarTabuleiro() {
		   
	        Tabuleiro tabuleiro = new Tabuleiro();
	        tabuleiro.criarTabuleiro();
	        
	        int quantidadeNavios = tabuleiro.getQuantidadeNaviosRestantes();
	        ArrayList<Character> tiposNavios = tabuleiro.getTipoNavios();
	        
	        tabuleiro.jogar(0, 0);
	        tabuleiro.imprimir();
	        
	        assertEquals(quantidadeNavios - 1, tabuleiro.getQuantidadeNaviosRestantes());
	        assertFalse(tabuleiro.getTipoNavios().contains(tiposNavios.get(0)));
	    }

		@Test
		public void testaJogar(){
			Tabuleiro tabuleiro = new Tabuleiro();
			assertTrue(tabuleiro.jogar(1,1));
		}
		
		@Test
		public void gerarTabuleiro() {
			
			Tabuleiro tabuleiro = new Tabuleiro();
			
			char matriz[][] = tabuleiro.gerarTabuleiro();
			
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {
					System.out.print(matriz[x][y]);
				}
				System.out.print("\n");
			}
			
			
		}
		
}
