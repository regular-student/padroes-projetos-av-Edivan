public class AzureFila implements Fila {
    private String id;
    private double custoFixo;

    public AzureFila(int sequencial) {
        this.id = "sb-" + sequencial;
        this.custoFixo = 0.50;
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
