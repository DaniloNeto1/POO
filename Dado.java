import java.util.Random;

// classe dado, que pode ter um número variável de faces
public class Dado {
    private final int faces; // numero de faces do dado
    private Random random; // random para gerar números aleatórios

    // construtor cria um dado de 6 faces para o jogo
    public Dado() {
        this.faces = 6;
        this.random = new Random();
    }

    // construtor para especificar o número de faces
    public Dado(int faces) {
        this.faces = faces;
        this.random = new Random();
    }

    // metodo para lançar o dado, retornando um número aleatório entre 1 e o número de faces do dado
    public int lancar() {
        return random.nextInt(faces) + 1;
    }
}