public class Bicicleta extends Veiculo {
    private static final String[] BICICLETA_DRAWING = {
        "   __o\n",
        " _`\\<,_\n",
        "(*)/ (*)\n\n"
    };

    public Bicicleta(int id) {
        super(id);
        rodas = new Roda[2];  // ajustado para 2 rodas
        for (int i = 0; i < rodas.length; i++) {
            rodas[i] = new Roda();
        }
    }

    public void desenhaVeiculo() {
        System.out.println("Desenhando Bicicleta ID " + getID());
        for (String line : BICICLETA_DRAWING) {
            System.out.println(line);
        }
    }

    public void mover() {
        System.out.println("Bicicleta movendo...");
    }

    @Override
    public String toString() {
        return "Bicicleta { " + super.toString() + " }";
    }
}