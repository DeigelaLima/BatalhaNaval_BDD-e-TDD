# Desenvolvimento orientado por comportamento (BDD)

**H01** - Como jogador, quero ser capaz de jogar contra outro jogador.

**Título do cenário:** Escolhendo o jogador

**Given:** que dois jogadores querem jogar.

**When:** o programa for executado.

Then: será solicitado o nome dos jogadores.

=====================================================================================================<p>
**H02** - Como computador, quero permitir apenas dois participantes no jogo.

**Título do cenário:** Solicitando nome de dois jogadores

**Given:** que o programa solicita o nome dos jogadores.

**When:** os jogadores informarem seus nomes.

**Then:** guarde o nome dos jogadores com seus placares zerados.

=====================================================================================================<p>
**H03** - Como computador, quero posicionar as embarcações no tabuleiro para criar o jogo.

**Título do cenário:** Criando o jogo

**Given:** um tabuleiro 10x10.

**When:** sortear as posições das embarcações.

**Then:** guarde as posições das embarcações.

=====================================================================================================<p>
**H04** - Como computador, quero mostrar o tabuleiro, a quantidade e tipo de navios presentes.

**Título do cenário:** Imprimindo o tabuleiro, a quantidade e tipo de navios presentes.

**Given:** o tabuleiro, a quantidade e tipo de navios restantes.

**When:** o jogador fizer uma jogada.

**Then:** atualize o tabuleiro, a quantidade e tipo de navios restantes.

=====================================================================================================<p>
**H05** - Como jogador, quero ver o tabuleiro, a quantidade e tipo de navios presentes.

**Título do cenário:** Visualização do tabuleiro, quantidade e tipos de navios.

**Given:** o tabuleiro, a quantidade e tipo de navios para os jogadores.

**When:** iniciar o jogo.

**Then:** mostrar a quantidade e tipos de navios.

=====================================================================================================<p>
**H06** - Como jogador, quero escolher uma linha e uma coluna para lançar a bomba para afundar uma embarcação inimiga.

**1 - Título do cenário:** Jogando bomba em uma embarcação

**Given:** Dado o valor da linha e da coluna no tabuleiro

**When:** Quando a posição tiver uma parte de uma embarcação

**Then:** Aumente o placar do jogador em uma unidade
And imprima o tabuleiro

**2 - Título do cenário:** Jogando bomba em uma posição sem embarcação

**Given:** Dado o valor da linha e da coluna no tabuleiro

**When:** Quando a posição não tiver uma parte de uma embarcação

**Then:** Mantenha o placar do jogador
And imprima o tabuleiro

======================================================================================================<p>
**H07** - Como computador, quero receber o valor da linha e da coluna no tabuleiro para jogar a bomba do jogador atual.

**Título do cenário:** Recebendo valores da posição da bomba a ser jogada.

**Given:** O tabuleiro, os navios presentes no tabuleiro.

**When:** O usuário inserir os valores de linha e coluna.

**Then:** Atualize o placar e o tabuleiro com a nova posição descoberta.

=======================================================================================================<p>
**H08** - Como computador, quero imprimir na tela o tabuleiro e o placar após um lance para que o usuário fique informado.

**1 - Título do cenário:** Atualizando estado do jogo após acertar a posição de uma embarcação

**Given:** Posição que o usuário informou, tabuleiro, navios presentes e suas posições.

**When:** Houver embarcação na posição informada

**Then:** Imprima o tabuleiro atualizado com a parte da embarcação descoberta e imprima o placar com uma unidade a mais.

**2 - Título do cenário:** Atualizando estado do jogo após errar a posição de uma embarcação

**Given:** Posição que o usuário informou, tabuleiro, navios presentes e suas posições.

**When:** Não houver embarcação na posição informada

**Then:** Imprima o tabuleiro atualizado com a posição da água descoberta e imprima o mesmo placar.

========================================================================================================<p>
**H09** -  Como jogador, quero receber feedback visual sobre meus lances e acertos no tabuleiro, para que eu possa acompanhar o progresso do jogo e planejar meus próximos lances com mais eficácia.

**1 - Título do cenário:** Feedback de lance correto

**Given:** O jogo foi iniciado; o jogador atual deseja realizar seu palpite

**When:** Jogador atual digita uma coordenada do tabuleiro como input

**Then:** Jogador visualiza a mensagem “você atingiu uma embarcação” e o tabuleiro é exibido, atualizado com o último lance do jogador; o campo do tabuleiro cujo palpite foi dado como input agora exibe a parte da embarcação atingida; 

**2 - Título do cenário:** Feedback de lance incorreto

**Given:** O jogo foi iniciado; o jogador atual deseja realizar seu palpite

**When:** Jogador atual digita uma coordenada do tabuleiro como input

**Then:** Jogador visualiza a mensagem “você não atingiu nenhuma embarcação” e o tabuleiro é exibido, atualizado com o último lance do jogador; o campo do tabuleiro cujo palpite foi dado como input agora exibe a letra X; 

**3 - Título do cenário:** Feedback de lance inválido

**Given:** O jogo foi iniciado; o jogador atual deseja realizar seu palpite

**When:** Jogador atual digita uma coordenada inválida como input, ou seja, o input não obedece o formato linha x coluna estabelecido ou não está dentro do limite disponível estabelecido no tabuleiro

**Then:** Jogador visualiza a mensagem “seu palpite não corresponde a nenhum dos campos do tabuleiro, por favor tente novamente digitando uma coordenada válida” ; o tabuleiro é exibido e não há nada a ser atualizado no tabuleiro; o sistema aguardará novo input do jogador

**4 - Título do cenário:** Feedback de lance repetido

**Given:** O jogo foi iniciado; o jogador atual deseja realizar seu palpite

**When:** Jogador atual digita uma coordenada já usada anteriormente na partida

**Then:** Jogador visualiza a mensagem “a coordenada inserida já foi atingida, tente novamente”; o tabuleiro é exibido e não há nada a ser atualizado no tabuleiro; o sistema aguardará novo input do jogador

=====================================================================================================<p>
**H10** - Como jogador, quero saber o meu placar e do meu adversário para saber quem está ganhando o jogo.

**Título do cenário:** Exibindo placar do jogo

**Given:** O jogo foi iniciado; 

**When:** Qualquer jogador faz um lance correto;

**Then:** O placar será exibido, juntamente com o feedback do lance.

=====================================================================================================<p>
**H11** - Como computador, quero informar qual jogador está jogando agora.

**Título do cenário:** Jogo do tabuleiro com dois jogadores.

**Given:** que o jogo está em andamento com dois jogadores.

**When:** O computador é solicitado a informar qual jogador está jogando agora.

**Then:** O computador exibe na tela as informações do jogador atual em sua vez de jogar.

=====================================================================================================<p>
**H12** - Como jogador, quero ser informado quando o jogo acabar.

**Título do cenário:** Disputa dois jogadores no jogo de tabuleiro.

**Given:** que o jogo está em andamento e os jogadores estão fazendo suas jogadas.

**When:** O jogo acabar os jogadores querem ser informados sobre isso.

**Then:** Quando o jogo terminar, o computador exibirá uma mensagem clara e visível na tela, indicando que o jogo acabou.

========================================================================================================<p>
**H13** - Como computador, quero informar que o jogo acabou quando não houver embarcações restantes.

**Título do cenário:** O jogo da batalha naval acabou.

**Given:** que o jogo está em andamento e há várias embarcações posicionadas no tabuleiro.

**When:** Não houver mais embarcações restantes no jogo, o computador informará aos jogadores.

**Then:** Quando todas as embarcações forem destruídas e não houver mais nenhuma no tabuleiro, o computador exibirá uma mensagem na tela informando que o jogo acabou.





