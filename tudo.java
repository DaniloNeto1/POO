public interface Abastecer {
    void abastecer();
}

public interface Calibrar {
    void calibrarVeiculo();
}

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
            System.out.print(line);
        }
    }

    
    public void mover() {
        System.out.println("Bicicleta movendo...");
    }

    
    public String toString() {
        return "Bicicleta { " + super.toString() + " }";
    }
}

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
            System.out.print(line);
        }
    }

    
    public void mover() {
        System.out.println("Carro Popular movendo...");
    }

   
    public String toString() {
        return "CarroPopular { " + super.toString() + " }";
    }
}

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
            System.out.print(line);
        }
    }

    
    public void mover() {
        System.out.println("Motocicleta movendo...");
    }

    
    public String toString() {
        return "Motocicleta { " + super.toString() + " }";
    }
}

public class Roda {
    private boolean calibrada;

    public Roda() {
        this.calibrada = false;
    }

    public void calibrar() {
        this.calibrada = true;
    }

    public boolean isCalibrada() {
        return this.calibrada;
    }

    
    public String toString() {
        return this.calibrada ? "Calibrada" : "Não calibrada";
    }
}

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
                default:
                    System.out.println("Tipo de veículo inválido!");
                    return;
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

    // Novo método para calibrar todos os veículos
    public void calibrarTodos() {
        for (int i = 0; i < qtdVeiculos; i++) {
            veiculos[i].calibrarVeiculo();
        }
    }

    
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < qtdVeiculos; i++) {
            str.append(veiculos[i].toString()).append("\n");
        }
        return str.toString();
    }
}

public abstract class Veiculo {
    private int id;
    protected Roda[] rodas;
    
    public Veiculo(int id) {
        this.id = id;
        this.rodas = new Roda[4];  // ajustado para 4 rodas, pode ser alterado para outros tipos
        for (int i = 0; i < rodas.length; i++) {
            rodas[i] = new Roda();
        }
    }

    public int getID() {
        return id;
    }

    public Roda[] getRodas() {
        return rodas;
    }

    public abstract void desenhaVeiculo();

    public void calibrarVeiculo() {
        for (Roda roda : rodas) {
            roda.calibrar();
        }
    }

    public abstract void mover();

   
    public String toString() {
        StringBuilder rodasStr = new StringBuilder();
        for (Roda roda : rodas) {
            rodasStr.append(roda.isCalibrada() ? "Calibrada" : "Nao calibrada").append(", ");
        }
        return "ID: " + id + ", Rodas: [" + rodasStr.substring(0, rodasStr.length() - 2) + "]";
    }
}

import java.util.Random;

public abstract class VeiculoMotorizado extends Veiculo implements Abastecer, Calibrar {
    protected boolean tanqueCheio;
    private boolean pneusCalibrados;
    private Random random = new Random();

    public VeiculoMotorizado(int id) {
        super(id);
        this.tanqueCheio = random.nextBoolean(); // Abastecer aleatoriamente
        this.pneusCalibrados = random.nextBoolean(); // Calibragem aleatória
    }

    public boolean isTanqueCheio() {
        return tanqueCheio;
    }

    
    public void calibrarVeiculo() {
        super.calibrarVeiculo();
        this.pneusCalibrados = true; // Marca o pneu como calibrado
    }

    
    public void abastecer() {
        this.tanqueCheio = true;
    }

    
    public String toString() {
        return super.toString() + ", Tanque: " + (tanqueCheio ? "Cheio" : "Vazio") + 
               ", Pneus: " + (pneusCalibrados ? "Calibrados" : "Não calibrados");
    }
}

public class usaSimulador {
    public static void main(String[] args) {
        Simulador sim = new Simulador();

        sim.incluirVeiculo(1, 1001); // Bicicleta
        sim.incluirVeiculo(2, 1002); // Motocicleta
        sim.incluirVeiculo(3, 1003); // CarroPopular

        System.out.println("Calibrando veículos:");
        sim.calibrarTodos();

        System.out.println("Desenhando veículos inicialmente:");
        sim.desenharTodos();

        sim.moverTodos();

        System.out.println("Desenhando veículos após movimentação:");
        sim.desenharTodos();

        System.out.println(sim);
    }
}
