public class AzureMaquinaVirtual implements MaquinaVirtual {
    private String id;
    private double custoPorHora;

    public AzureMaquinaVirtual(int sequencial) {
        this.id = "vm-" + sequencial;
        this.custoPorHora = 0.12;
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
