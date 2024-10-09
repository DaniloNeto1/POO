public class Simulador {
    private Veiculo[] veiculos;
    private int qtdVeiculos;

    public Simulador() {
        veiculos = new Veiculo[10];
        qtdVeiculos = 0;
    }

    public void incluirVeiculo(int tipo, int id) {
        if (qtdVeiculos < 10) {
            switch (tipo) {
                case 1:
                    veiculos[qtdVeiculos] = new Bicicleta(id);
                    break;
                case 2:
                    veiculos[qtdVeiculos] = new Motocicleta(id);
                    break;
                case 3:
                    veiculos[qtdVeiculos] = new CarroPopular(id);
                    break;
            }
            qtdVeiculos++;
        } else {
            System.out.println("Simulador cheio!");
        }
    }

    public void moverTodos() {
        for (int i = 0; i < qtdVeiculos; i++) {
            veiculos[i].mover();
        }
    }

    public void desenharTodos() {
        for (int i = 0; i < qtdVeiculos; i++) {
            veiculos[i].desenhaVeiculo();
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < qtdVeiculos; i++) {
            str += veiculos[i].toString() + "\n";
        }
        return str;
    }
}