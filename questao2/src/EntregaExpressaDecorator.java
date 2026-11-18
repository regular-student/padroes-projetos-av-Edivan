public class EntregaExpressaDecorator extends ServicoDecorator {
    public EntregaExpressaDecorator(ItemFatura itemDecorado) {
        super(itemDecorado);
    }

    @Override
    public String getDescricao() {
        return "Entrega Expressa";
    }

    @Override
    public double getCusto() {
        return 450.0;
    }
}
