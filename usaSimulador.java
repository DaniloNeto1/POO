public class usaSimulador {
    public static void main(String[] args) {
        Simulador sim = new Simulador();

        sim.incluirVeiculo(1, 1001); // Bicicleta
        sim.incluirVeiculo(2, 1002); // Motocicleta
        sim.incluirVeiculo(3, 1003); // CarroPopular

        System.out.println("Desenhando veículos inicialmente:");
        sim.desenharTodos();

        sim.moverTodos();

        System.out.println("Desenhando veículos após movimentação:");
        sim.desenharTodos();

        System.out.println(sim);
    }
}