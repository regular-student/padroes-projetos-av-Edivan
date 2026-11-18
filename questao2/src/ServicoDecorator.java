public abstract class ServicoDecorator implements ItemFatura {
    protected ItemFatura itemDecorado;

    public ServicoDecorator(ItemFatura itemDecorado) {
        this.itemDecorado = itemDecorado;
    }

    @Override
    public double getValorTotal() {
        return itemDecorado.getValorTotal() + getCusto();
    }

    @Override
    public void imprimirLinhas() {
        itemDecorado.imprimirLinhas();
        System.out.printf("- %s: R$ %.2f\n", getDescricao(), getCusto());
    }

    @Override
    public void imprimirFatura() {
        System.out.println("\n--- Fatura do Comprador ---");
        imprimirLinhas();
        System.out.println("----------------------------------------");
        System.out.printf("Total a Pagar: R$ %.2f\n", getValorTotal());
    }
}
