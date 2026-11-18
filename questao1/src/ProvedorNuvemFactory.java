public interface ProvedorNuvemFactory {
    MaquinaVirtual criarMaquinaVirtual(int sequencial);
    Armazenamento criarArmazenamento(int sequencial, double capacidadeGB);
    Fila criarFila(int sequencial);
    String getNomeProvedor();
    double calcularCustoEstimado(int qtdMaquinas, double gbArmazenamento);
}
