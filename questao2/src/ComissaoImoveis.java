public class ComissaoImoveis implements RegraComissao {
    @Override
    public double calcularComissao(double valorVenda) {
        return (valorVenda * 0.03) + 1500.0;
    }

    @Override
    public String getNomeRegra() {
        return "Imóveis (3% + R$ 1.500)";
    }
}
