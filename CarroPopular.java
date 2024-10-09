public class CarroPopular extends VeiculoMotorizado {
    private static final String[] CARRO_POPULAR_DRAWING = {
        "   _______\n",
        " _/\\______\\\\__\n",
        "/ ,-. -|-  ,-.`-.\n",
        "( o )----( o )-'\n",
        " `-'      `-'\n"
    };

    public CarroPopular(int id) {
        super(id);
    }

    public void desenhaVeiculo() {
        System.out.println("Desenhando Carro Popular ID " + getID());
        for (String line : CARRO_POPULAR_DRAWING) {
            System.out.println(line);
        }
    }

    public void mover() {
        System.out.println("Carro Popular movendo...");
    }

    @Override
    public String toString() {
        return "CarroPopular { " + super.toString() + " }";
    }
}