public class AwsMaquinaVirtual implements MaquinaVirtual {
    private String id;
    private double custoPorHora;

    public AwsMaquinaVirtual(int sequencial) {
        this.id = "i-" + sequencial;
        this.custoPorHora = 0.10;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getCustoPorHora() {
        return custoPorHora;
    }
}
