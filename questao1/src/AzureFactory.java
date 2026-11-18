public class AzureFactory implements ProvedorNuvemFactory {
    @Override
    public MaquinaVirtual criarMaquinaVirtual(int sequencial) {
        return new AzureMaquinaVirtual(sequencial);
    }

    @Override
    public Armazenamento criarArmazenamento(int sequencial, double capacidadeGB) {
        return new AzureArmazenamento(sequencial, capacidadeGB);
    }

    @Override
    public Fila criarFila(int sequencial) {
        return new AzureFila(sequencial);
    }

    @Override
    public String getNomeProvedor() {
        return "Azure";
    }

    @Override
    public double calcularCustoEstimado(int qtdMaquinas, double gbArmazenamento) {
        return (qtdMaquinas * 0.12 * 730.0) + (gbArmazenamento * 0.02) + 0.50;
    }
}
