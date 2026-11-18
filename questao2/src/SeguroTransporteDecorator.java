public class SeguroTransporteDecorator extends ServicoDecorator {
    private double valorVenda;

    public SeguroTransporteDecorator(ItemFatura itemDecorado, double valorVenda) {
        super(itemDecorado);
        this.valorVenda = valorVenda;
    }

    @Override
    public String getDescricao() {
        return "Seguro de Transporte (1.5%)";
    }

    @Override
    public double getCusto() {
        return valorVenda * 0.015;
    }
}
