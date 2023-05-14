import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Test;

import model.Tabuleiro;

public class TesteTabuleiro {
	
	   @Test
	    public void testAtualizarTabuleiro() {
		   
	        Tabuleiro tabuleiro = new Tabuleiro();
	        tabuleiro.criarTabuleiro();
	        
	        int quantidadeNavios = tabuleiro.getQuantidadeNaviosRestantes();
	        ArrayList<String> tiposNavios = tabuleiro.getTipoNavios();
	        
	        tabuleiro.jogar(0, 0);
	        tabuleiro.imprimir();
	        
	        assertEquals(quantidadeNavios - 1, tabuleiro.getQuantidadeNaviosRestantes());
	        assertFalse(tabuleiro.getTipoNavios().contains(tiposNavios.get(0)));
	    }

}
