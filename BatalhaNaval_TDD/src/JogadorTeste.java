import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Jogador;

class JogadorTeste {

	@Test
	void testaAumentaPlacar() {
		//Configurar
		Jogador jogador = new Jogador("Fulano");
		int placarEsperado = 1;
		
		//exercitar
		jogador.aumentaPlacar();
		
		//verificar
		
		assertEquals(placarEsperado, jogador.getPlacar());
	}

}
