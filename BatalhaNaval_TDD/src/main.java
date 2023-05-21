

import java.util.Scanner;

import controller.JogoMultiplayer;

public class main {
	
    public static void main(String[] args){
        JogoMultiplayer jogo = new JogoMultiplayer();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("====================================\n");       
        System.out.println("   Bem-vindo ao jogo Batalha Naval\n"  );
        System.out.println("====================================\n");  
        System.out.println("Instruções: \n"+
                            "1- As jogadas vão alternar entre 2 jogadores\n"+
                            "2- Cada jogador deve escolher uma linha e uma coluna para fazer o bombardeio\n"+
                            "3- Existem 6 embarcações no tabuleiro sendo eles:\n"+
                            "4 de Submarino (1 casa), 2 Destroyers (2 casas), 2 Cruzador (3 casas) e 1 Porta-aviões (4 casas)\n"+
                            "5- Quando acertar uma parte de um navio ganhará 1 ponto e quando errar não ganhará ponto\n");
        
       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
       System.out.println("          Partida iniciada!        \n");
       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");

        String partida;
        do{
            //IMPRIME GABARITO
        	jogo.iniciarJogo();
            jogo.imprimirGabarito();
            //
            System.out.println("Digite o nome do jogador 1");
            String nomeJ1 = sc.next();
            jogo.escolherJogador1(nomeJ1);
            System.out.println("Digite o nome do jogador 2");
            String nomeJ2 = sc.next();
            jogo.escolherJogador2(nomeJ2);
            

            while(jogo.jogoValendo()){
                String jogadorDaVez = jogo.getJogadorDaVez() ? jogo.getJogador1().getNome() : jogo.getJogador2().getNome();
                System.out.println("Jogador atual: "+jogadorDaVez);
                
                System.out.println("Escolha uma linha entre A e J e uma coluna entre 0 e 9 (Ex: B4)");
                String coordenada = sc.next();
                try {
                	jogo.jogar(coordenada);                	
                }catch (Exception e) {
					System.out.println(e.getMessage());
				}
                
                System.out.println(String.format("Placar - %s-%d / %s-%d",
                jogo.getJogador1().getNome(),jogo.getJogador1().getPlacar(),
                jogo.getJogador2().getNome(),jogo.getJogador2().getPlacar()));
            }

            System.out.println("Deseja jogar novamente?S/N");
            partida = sc.next();
            partida.toLowerCase();
        }while(partida.equals("s"));
        
        sc.close();
    }
}

