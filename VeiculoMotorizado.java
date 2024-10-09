import java.util.Random;

public abstract class VeiculoMotorizado extends Veiculo implements Abastecer {
    protected boolean tanqueCheio;
    protected double calibragemPneus;
    private Random random = new Random();

    public VeiculoMotorizado(int id) {
        super(id);
        this.tanqueCheio = random.nextBoolean(); // Abastecer aleatoriamente
        this.calibragemPneus = random.nextDouble() * 2 + 1; // entre 1 e 3
    }

    public boolean isTanqueCheio() {
        return tanqueCheio;
    }

    public double getCalibragemPneus() {
        return calibragemPneus;
    }

    @Override
    public void abastecer() {
        this.tanqueCheio = true;
    }

    @Override
    public String toString() {
        return "Tanque: " + (tanqueCheio ? "Cheio" : "Vazio") + ", Calibragem dos pneus: " + calibragemPneus;
    }
}