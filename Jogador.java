public class Jogador {
    private int id;
    private String tipo; // tipo do jogador: maquina ou "humano"
    private int saldo;
    private int valorAposta;
    private JogoDados jogo;
    private static int contadorJogadores = 0;

    // construtor do jogador, que recebe um ID, tipo
    public Jogador(int id, String tipo, JogoDados jogo) {
        this.id = id;
        this.tipo = tipo;
        this.saldo = 100; // cada jogador começa com 100 unidades de saldo
        this.jogo = jogo;
        contadorJogadores++;
    }

    // metodo getter
    public int getSaldo() {
        return saldo;
    }

    // metodo setter
    public void setValorAposta(int valorAposta) {
        this.valorAposta = valorAposta;
    }

    // metodo para definir o valor da aposta e atualizar o saldo do jogador
    public void apostar() {
        if (tipo.equals("maquina")) {
            valorAposta = Math.min(saldo, saldo / 5); // a máquina aposta até 20% do saldo
        } else {
            valorAposta = Math.min(saldo, valorAposta); // o humano pode escolher quanto quer apostar, até o limite do saldo
        }
        saldo -= valorAposta; // subtrai a aposta do saldo
    }

    // metodos para jogar os jogos de azar ou Bozo
    public int jogarAzar() {
        return jogo.jogarAzar();
    }

    public int jogarBozo() {
        return jogo.jogarBozo();
    }

    // metodo para atualizar o saldo do jogador após a rodada
    public void atualizarSaldo(int valor) {
        saldo += valor;
    }

    // metodos getter
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValorAposta() {
        return valorAposta;
    }

    public static int getContadorJogadores() {
        return contadorJogadores;
    }
}
