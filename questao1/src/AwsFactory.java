public class AwsFactory implements ProvedorNuvemFactory {
    @Override
    public MaquinaVirtual criarMaquinaVirtual(int sequencial) {
        return new AwsMaquinaVirtual(sequencial);
    }

    @Override
    public Armazenamento criarArmazenamento(int sequencial, double capacidadeGB) {
        return new AwsArmazenamento(sequencial, capacidadeGB);
    }

    @Override
    public Fila criarFila(int sequencial) {
        return new AwsFila(sequencial);
    }

    @Override
    public String getNomeProvedor() {
        return "Aws";
    }

    @Override
    public double calcularCustoEstimado(int qtdMaquinas, double gbArmazenamento) {
        // 730 horas no mes
        return (qtdMaquinas * 0.10 * 730.0) + (gbArmazenamento * 0.023) + 0.40;
    }
}
