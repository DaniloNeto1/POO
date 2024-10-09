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

    @Override
    public String toString() {
        return this.calibrada ? "Calibrada" : "Não calibrada";
    }
}