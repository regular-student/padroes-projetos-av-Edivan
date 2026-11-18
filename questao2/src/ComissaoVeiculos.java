public class ComissaoVeiculos implements RegraComissao {
    @Override
    public double calcularComissao(double valorVenda) {
        return Math.min(valorVenda * 0.08, 5000.0);
    }

    @Override
    public String getNomeRegra() {
        return "Veículos (8% max R$ 5.000)";
    }
}
