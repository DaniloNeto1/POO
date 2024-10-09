import java.io.FileWriter;
import java.io.IOException;

public class Torneio {
    private Jogador[] jogadores; // arranjo para armazenar os jogadores no torneio
    private int numeroJogadores; // numero de jogadores no torneio
    private String tipoJogo; // tipo de jogo: azar ou bozo

    // construtor do torneio, que recebe o tipo de jogo como parametro
    public Torneio(String tipoJogo) {
        this.jogadores = new Jogador[10]; // torneio pode ter até 10 jogadores
        this.numeroJogadores = 0;
        this.tipoJogo = tipoJogo;
    }

    // metodo para adicionar um jogador ao torneio
    public void adicionarJogador(Jogador jogador) {
        if (numeroJogadores < jogadores.length) {
            jogadores[numeroJogadores++] = jogador;
        } else {
            System.out.println("Número máximo de jogadores atingido.");
        }
    }

    // metodo para remover um jogador do torneio
    public void removerJogador(int id) {
        int index = -1;
        for (int i = 0; i < numeroJogadores; i++) {
            if (jogadores[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < numeroJogadores - 1; i++) {
                jogadores[i] = jogadores[i + 1];
            }
            jogadores[--numeroJogadores] = null;
            System.out.println("Jogador " + id + " removido.");
        } else {
            System.out.println("Jogador com ID " + id + " não encontrado.");
        }
    }

    // metodo para iniciar o torneio
    public void iniciar() {
        int rodada = 1;
        while (numeroJogadores > 1) {
            System.out.println("Rodada " + rodada++);
            novaRodada(); // nova rodada de jogo
            removerJogadoresEliminados(); // remove jogadores com saldo zero ou negativo

            if (numeroJogadores == 1) {
                System.out.println("Vencedor: Jogador " + jogadores[0].getId());
            } else if (numeroJogadores == 0) {
                System.out.println("Todos os jogadores foram eliminados.");
                break;
            }
        }
    }

    // metodo que executa uma nova rodada de jogos
    private void novaRodada() {
        Jogador[] vencedores = new Jogador[10]; // array para armazenar os vencedores da rodada
        int numVencedores = 0;
        int maiorPontuacao = Integer.MIN_VALUE;
        int[] resultados = new int[numeroJogadores]; // armazena os resultados dos jogos

        for (int i = 0; i < numeroJogadores; i++) {
            Jogador jogador = jogadores[i];
            jogador.apostar();
            resultados[i] = (tipoJogo.equals("azar")) ? jogador.jogarAzar() : jogador.jogarBozo();
            System.out.println("Jogador " + jogador.getId() + " apostou " + jogador.getValorAposta() + " e obteve " + resultados[i]);

            if (resultados[i] > maiorPontuacao) {
                numVencedores = 0;
                vencedores[numVencedores++] = jogador;
                maiorPontuacao = resultados[i];
            } else if (resultados[i] == maiorPontuacao) {
                vencedores[numVencedores++] = jogador;
            }
        }

        int totalApostasPerdidas = 0;
        for (int i = 0; i < numeroJogadores; i++) {
            if (resultados[i] < maiorPontuacao) {
                totalApostasPerdidas += jogadores[i].getValorAposta();
            }
        }

        int premio = totalApostasPerdidas / numVencedores;
        for (int i = 0; i < numVencedores; i++) {
            vencedores[i].atualizarSaldo(premio + vencedores[i].getValorAposta() * 2);
        }

        // Grava os dados do torneio em um arquivo
        gravarDadosTorneio();
    }

    // metodo para remover jogadores que foram eliminados
    private void removerJogadoresEliminados() {
        int index = 0;
        for (int i = 0; i < numeroJogadores; i++) {
            if (jogadores[i].getSaldo() > 0) {
                jogadores[index++] = jogadores[i];
            } else {
                jogadores[i] = null;
            }
        }
        numeroJogadores = index; // atualiza o numero de jogadores
    }

    // metodo getter para obter o numero atual de jogadores no torneio
    public int getNumeroJogadores() {
        return numeroJogadores;
    }

    // metodo para gravar os dados do torneio em um arquivo
    private void gravarDadosTorneio() {
        try (FileWriter writer = new FileWriter("dados_torneio.txt")) {
            writer.write("Tipo de Jogo: " + tipoJogo + "\n");
            writer.write("Número de Jogadores: " + numeroJogadores + "\n");
            for (int i = 0; i < numeroJogadores; i++) {
                Jogador jogador = jogadores[i];
                writer.write("Jogador ID: " + jogador.getId() + ", Tipo: " + jogador.getTipo() +
                             ", Saldo: " + jogador.getSaldo() + ", Valor da Aposta: " + jogador.getValorAposta() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao gravar dados do torneio: " + e.getMessage());
        }
    }
}
