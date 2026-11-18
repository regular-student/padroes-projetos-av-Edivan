public class AwsArmazenamento implements Armazenamento {
    private String id;
    private double capacidadeGB;
    private double custoPorGB;

    public AwsArmazenamento(int sequencial, double capacidadeGB) {
        this.id = "s3://" + sequencial;
        this.capacidadeGB = capacidadeGB;
        this.custoPorGB = 0.023;
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
