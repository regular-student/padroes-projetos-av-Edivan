public class EmbalagemEspecialDecorator extends ServicoDecorator {
    public EmbalagemEspecialDecorator(ItemFatura itemDecorado) {
        super(itemDecorado);
    }

    @Override
    public String getDescricao() {
        return "Embalagem Especial";
    }

    @Override
    public double getCusto() {
        return 180.0;
    }
}
