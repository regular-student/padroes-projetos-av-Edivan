public class ComissaoArte implements RegraComissao {
    @Override
    public double calcularComissao(double valorVenda) {
        return valorVenda * 0.20;
    }

    @Override
    public String getNomeRegra() {
        return "Arte (20%)";
    }
}
