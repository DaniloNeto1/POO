import java.util.Arrays;

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

    @Override
    public String toString() {
        String rodasStr = "";
        for (Roda roda : rodas) {
            rodasStr += roda.isCalibrada() ? "Calibrada" : "Nao calibrada";
            rodasStr += ", ";
        }
        return "ID: " + id + ", Rodas: [" + rodasStr.substring(0, rodasStr.length() - 2) + "]";
    }
}