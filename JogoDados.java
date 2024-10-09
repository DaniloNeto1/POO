public class JogoDados {
    private Dado dado;

    public JogoDados() {
        this.dado = new Dado();
    }

    public JogoDados(Dado dado) {
        this.dado = dado;
    }

    // metodo para jogar o jogo de azar
    public int jogarAzar() {
        int soma = dado.lancar() + dado.lancar();
        System.out.println("Primeiro lançamento, soma: " + soma);

        if (soma == 7 || soma == 11) {
            return 1;
        } else if (soma == 2 || soma == 3 || soma == 12) {
            return -1;
        }

        int alvo = soma;
        System.out.println("Alvo definido: " + alvo);

        while (true) {
            soma = dado.lancar() + dado.lancar();
            System.out.println("Novo lançamento, soma: " + soma);
            if (soma == alvo) {
                return 1;
            } else if (soma == 7) {
                return -1;
            }
        }
    }

    // metodo para jogar o jogo Bozo, que é basicamente lançar 5 dados e tentar obter a maior pontuação possível
    public int jogarBozo() {
        int[] dados = new int[5];
        int pontuacaoMaxima = 0;

        for (int tentativa = 0; tentativa < 3; tentativa++) {
            for (int i = 0; i < 5; i++) {
                dados[i] = dado.lancar();
            }
            int pontuacaoAtual = calcularPontuacao(dados);
            pontuacaoMaxima = Math.max(pontuacaoMaxima, pontuacaoAtual);
        }
        return pontuacaoMaxima;
    }

    // metodo que calcula a pontuação obtida no Bozo com base nos valores dos dados lançados
    private int calcularPontuacao(int[] dados) {
        int[] contagem = new int[6];
        for (int num : dados) {
            contagem[num - 1]++;
        }

        int pontuacao = 0;
        boolean temDupla = false;
        boolean temTrio = false;
        boolean temSequencia = false;

        for (int cont : contagem) {
            if (cont == 2) temDupla = true;
            if (cont == 3) temTrio = true;
            if (cont == 4) pontuacao = 40;
            if (cont == 5) pontuacao = 50;
        }

        if (temDupla && temTrio) pontuacao = 25;

        if (contagem[0] == 1 && contagem[1] == 1 && contagem[2] == 1 && contagem[3] == 1 && contagem[4] == 1) {
            temSequencia = true;
        } else if (contagem[1] == 1 && contagem[2] == 1 && contagem[3] == 1 && contagem[4] == 1 && contagem[5] == 1) {
            temSequencia = true;
        }

        if (temSequencia) pontuacao = 30;

        if (pontuacao == 0) {
            for (int i = 0; i < contagem.length; i++) {
                pontuacao += contagem[i] * (i + 1);
            }
        }

        return pontuacao;
    }
}
