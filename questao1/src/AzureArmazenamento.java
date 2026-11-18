public class AzureArmazenamento implements Armazenamento {
    private String id;
    private double capacidadeGB;
    private double custoPorGB;

    public AzureArmazenamento(int sequencial, double capacidadeGB) {
        this.id = "blob://" + sequencial;
        this.capacidadeGB = capacidadeGB;
        this.custoPorGB = 0.02;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getCapacidadeGB() {
        return capacidadeGB;
    }

    @Override
    public double getCustoPorGB() {
        return custoPorGB;
    }
}
