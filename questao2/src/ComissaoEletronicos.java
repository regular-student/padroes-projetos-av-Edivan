public class ComissaoEletronicos implements RegraComissao {
    @Override
    public double calcularComissao(double valorVenda) {
        return Math.max(valorVenda * 0.12, 50.0);
    }

    @Override
    public String getNomeRegra() {
        return "Eletrônicos (12% min R$ 50)";
    }
}
