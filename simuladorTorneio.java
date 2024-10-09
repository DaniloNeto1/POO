import java.util.Scanner;

public class simuladorTorneio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // loop que permite a criação e execução de vários torneios
        while (running) {
            JogoDados jogoDados = new JogoDados();
            Torneio torneio = null;
            boolean torneioCriado = false;

            while (!torneioCriado) {
                System.out.print("Escolha o tipo de jogo (azar/bozo): ");
                String tipoJogo = scanner.next();
                torneio = new Torneio(tipoJogo); // cria um novo torneio com o tipo de jogo escolhido
                torneioCriado = true;
                System.out.println("Torneio do tipo '" + tipoJogo + "' criado.");
            }

            // loop para adicionar jogadores ao torneio
            while (true) {
                System.out.print("Adicionar jogador (maquina/humano)? ");
                String tipoJogador = scanner.next();
                Jogador jogador = new Jogador(Jogador.getContadorJogadores() + 1, tipoJogador, jogoDados);
                torneio.adicionarJogador(jogador);
                System.out.println("Jogador " + jogador.getId() + " adicionado.");

                System.out.print("Adicionar outro jogador? (s/n) ");
                String resposta = scanner.next();
                if (resposta.equalsIgnoreCase("n")) {
                    break;
                }
            }

            // menu interativo
            boolean menuAtivo = true;
            while (menuAtivo) {
                System.out.println("==== Menu ====");
                System.out.println("1 - Remover jogador");
                System.out.println("2 - Iniciar torneio");
                System.out.println("3 - Sair do programa");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o ID do jogador a ser removido: ");
                        int idRemover = scanner.nextInt();
                        torneio.removerJogador(idRemover);
                        break;
                    case 2:
                        torneio.iniciar();
                        break;
                    case 3:
                        menuAtivo = false;
                        running = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }

            System.out.print("Iniciar novo torneio? (s/n) ");
            String respostaTorneio = scanner.next();
            if (respostaTorneio.equalsIgnoreCase("n")) {
                running = false; // sai do loop principal encerrando o programa
            }
        }

        scanner.close(); // fecha o scanner para liberar
    }
}
