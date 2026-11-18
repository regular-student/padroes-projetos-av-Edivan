public class VendaLote implements ItemFatura {
    private String nomeLote;
    private double valorVenda;

    public VendaLote(String nomeLote, double valorVenda) {
        this.nomeLote = nomeLote;
        this.valorVenda = valorVenda;
    }

    @Override
    public String getDescricao() {
        return "Venda do Lote: " + nomeLote;
    }

    @Override
    public double getCusto() {
        return valorVenda;
    }

    @Override
    public double getValorTotal() {
        return valorVenda;
    }

    @Override
    public void imprimirLinhas() {
        System.out.printf("- Venda do Lote '%s': R$ %.2f\n", nomeLote, valorVenda);
    }

    @Override
    public void imprimirFatura() {
        System.out.println("\n--- Fatura do Comprador ---");
        imprimirLinhas();
        System.out.println("----------------------------------------");
        System.out.printf("Total a Pagar: R$ %.2f\n", getValorTotal());
    }
}
