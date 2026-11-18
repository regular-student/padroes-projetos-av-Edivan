public class AwsFila implements Fila {
    private String id;
    private double custoFixo;

    public AwsFila(int sequencial) {
        this.id = "sqs-" + sequencial;
        this.custoFixo = 0.40;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getCustoFixo() {
        return custoFixo;
    }
}
