public class Motocicleta extends VeiculoMotorizado {
    private static final String[] MOTOCICLETA_DRAWING = {
        "        _\n",
        "        _\\D\n",
        " _.-,_./_)\\\n",
        "' (o)'--' (o)\n\n"
    };

    public Motocicleta(int id) {
        super(id);
        rodas = new Roda[2];  // ajustado para 2 rodas
        for (int i = 0; i < rodas.length; i++) {
            rodas[i] = new Roda();
        }
    }

    public void desenhaVeiculo() {
        System.out.println("Desenhando Motocicleta ID " + getID());
        for (String line : MOTOCICLETA_DRAWING) {
            System.out.println(line);
        }
    }

    public void mover() {
        System.out.println("Motocicleta movendo...");
    }

    @Override
    public String toString() {
        return "Motocicleta { " + super.toString() + " }";
    }
}